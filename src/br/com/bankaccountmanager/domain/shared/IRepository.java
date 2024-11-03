package br.com.bankaccountmanager.domain.shared;

import br.com.bankaccountmanager.domain.shared.utils.FindWhereCallback;

import java.util.List;

public interface IRepository<T> {
    List<T> getAll();
    T findWhere(FindWhereCallback<T> callback);

    void save(T entity) throws Exception;

    void remove(T entity);
}
