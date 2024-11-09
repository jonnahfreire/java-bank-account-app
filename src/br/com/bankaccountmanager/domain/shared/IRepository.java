package br.com.bankaccountmanager.domain.shared;

import br.com.bankaccountmanager.domain.exceptions.DomainException;
import br.com.bankaccountmanager.domain.shared.utils.FindWhereCallback;
import br.com.bankaccountmanager.domain.shared.utils.Return;

import java.util.List;

public interface IRepository<T> {
    List<T> getAll();
    T findWhere(FindWhereCallback<T> callback);

    Return<Void> save(T entity) throws DomainException;

    Return<Void> remove(T entity);
}
