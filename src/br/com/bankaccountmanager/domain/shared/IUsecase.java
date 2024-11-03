package br.com.bankaccountmanager.domain.shared;

public interface IUsecase<Input, Output> {
    Output execute(Input data) throws Exception;
}
