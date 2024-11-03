package br.com.bankaccountmanager.application.usecases;

import br.com.bankaccountmanager.application.usecases.AbstractImpl.GetBalanceAbstract;
import br.com.bankaccountmanager.domain.entities.Balance;
import br.com.bankaccountmanager.domain.repositories.IBalanceRepository;

public class GetBalanceById extends GetBalanceAbstract<Integer> {
    private final IBalanceRepository repository;

    public GetBalanceById(IBalanceRepository repository) {
        this.repository = repository;
    }

    @Override
    public Balance execute(Integer id) {
        return this.repository.findWhere((balance) -> balance.getId() == id);
    }
}
