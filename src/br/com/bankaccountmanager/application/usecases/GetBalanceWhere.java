package br.com.bankaccountmanager.application.usecases;

import br.com.bankaccountmanager.application.usecases.AbstractImpl.GetBalanceAbstract;
import br.com.bankaccountmanager.domain.entities.Balance;
import br.com.bankaccountmanager.domain.repositories.IBalanceRepository;
import br.com.bankaccountmanager.domain.shared.utils.FindWhereCallback;

public class GetBalanceWhere extends GetBalanceAbstract<FindWhereCallback<Balance>> {
    private final IBalanceRepository repository;

    public GetBalanceWhere(IBalanceRepository repository) {
        this.repository = repository;
    }

    @Override
    public Balance execute(FindWhereCallback<Balance> callback) {
        return this.repository.findWhere(callback);
    }
}