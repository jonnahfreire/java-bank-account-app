package br.com.bankaccountmanager.domain.shared;

import br.com.bankaccountmanager.domain.exceptions.DomainException;

public interface IUsecase<Input, Output> {
    Output execute(Input data) throws DomainException;
}
