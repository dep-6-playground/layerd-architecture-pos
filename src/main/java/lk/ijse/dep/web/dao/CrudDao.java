package lk.ijse.dep.web.dao;

import lk.ijse.dep.web.entity.SuperEntity;

import java.util.List;

/**
 * @author : Deshan Charuka <d.c.0729439631@gmail.com>
 * @since : 2021-01-15
 **/
public interface CrudDao<T extends SuperEntity,K> extends SuperDAO {
    public void save(T entity) throws Exception;

    public void update(T entity) throws Exception;

    public void delete(K key) throws Exception;

    public List<T> getAll() throws Exception;

    public T get(K key) throws Exception;
}
