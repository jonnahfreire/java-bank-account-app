package br.com.bankaccountmanager.domain.shared.utils;

@FunctionalInterface
public interface FindWhereCallback<T> {
    Boolean test(T prop);
}
