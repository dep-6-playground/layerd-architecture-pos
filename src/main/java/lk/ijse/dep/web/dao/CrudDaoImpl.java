package lk.ijse.dep.web.dao;

import lk.ijse.dep.web.entity.SuperEntity;
import org.hibernate.Session;

import javax.persistence.EntityManager;
import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;

/**
 * @author : Deshan Charuka <d.c.0729439631@gmail.com>
 * @since : 2021-01-30
 **/
public class CrudDaoImpl<T extends SuperEntity,K extends Serializable> implements CrudDao<T,K> {
    private EntityManager entityManager;
    private Class<T> entityClass;

    @Override
    public void setEntityManager(EntityManager entityManager) throws Exception {
        this.entityManager=entityManager;
    }

    protected EntityManager getEntityManager() {
        return this.entityManager;
    }

    public CrudDaoImpl() {
        entityClass = (Class<T>) (((ParameterizedType) (this.getClass().getGenericSuperclass())).getActualTypeArguments()[0]);
    }

    @Override
    public void save(T entity) throws Exception {
        entityManager.persist(entity);
    }

    @Override
    public void update(T entity) throws Exception {
        entityManager.merge(entity);

    }

    @Override
    public void delete(K key) throws Exception {
        entityManager.remove(entityManager.getReference(entityClass,key));
    }

    @Override
    public List<T> getAll() throws Exception {
        return entityManager.createQuery("SELECT x FROM "+ entityClass.getName()+ " x").getResultList();
    }

    @Override
    public T get(K key) throws Exception {
        return entityManager.find(entityClass, key);
    }
}
