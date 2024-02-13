package me.shockyng.library.api.daos;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Persistence;
import jakarta.persistence.PersistenceException;
import jakarta.persistence.RollbackException;
import me.shockyng.library.api.exceptions.NoDataAtTheDataBaseException;
import me.shockyng.library.api.services.PeopleService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.Objects;

public abstract class BaseDAO<E, ID> {

    private static final Logger LOGGER = LoggerFactory.getLogger(PeopleService.class);

    protected final EntityManager entityManager;
    protected Class<E> entityClass;

    public BaseDAO(Class<E> entityClass) {
        this.entityClass = entityClass;
        this.entityManager = Persistence.createEntityManagerFactory("libraryapi-pu").createEntityManager();
    }

    public E findOneById(ID id) {
        LOGGER.info("Fetch at the database a {} with id: {}", entityClass.getName(), id);
        E entity = entityManager.find(entityClass, id);
        verifyIfEntityNull(entity, id);
        return entity;
    }

    public List<E> findAll() {
        LOGGER.info("Fetch at the database all {}", entityClass.getName());
        return entityManager
                .createQuery(String.format("select e from %s e", entityClass.getName()), entityClass)
                .getResultList();
    }

    public E save(E entity) {
        beginTransaction();
        LOGGER.info("Save/update {} at the database", entityClass.getName());
        entityManager.merge(entity);
        commitTransaction();
        return entity;
    }

    public void delete(ID id) {
        E entity = findOneById(id);
        verifyIfEntityNull(entity, id);
        beginTransaction();
        LOGGER.info("Delete {} at the database with id: {}", entityClass.getName(), id);
        entityManager.remove(entity);
        commitTransaction();
    }

    private void beginTransaction() {
        try {
            LOGGER.info("Begin transaction");
            entityManager.getTransaction().begin();
        } catch (IllegalStateException e) {
            rollBackTransaction();
        }
    }

    private void commitTransaction() {
        try {
            LOGGER.info("Commit transaction");
            entityManager.getTransaction().commit();
        } catch (IllegalStateException | RollbackException e) {
            rollBackTransaction();
        }
    }

    private void rollBackTransaction() {
        try {
            LOGGER.info("Rollback transaction");
            entityManager.getTransaction().rollback();
        } catch (IllegalStateException | PersistenceException e) {
            e.printStackTrace();
        }
    }

    private void verifyIfEntityNull(E entity, ID id) {
        LOGGER.info("Verifying if {} with id: {} is null", entityClass.getName(), id);
        if (Objects.isNull(entity)) throw new NoDataAtTheDataBaseException(entityClass, id);
    }

    public List<E> searchByName(String name) {
        return entityManager
                .createQuery(
                        String.format(
                                "select e from %s e where e.name like :name",
                                entityClass.getName()),
                        entityClass
                )
                .setParameter("name", "%" + name + "%")
                .getResultList();
    }
}
