package br.com.bankaccountmanager.application.usecases;

import br.com.bankaccountmanager.domain.entities.Balance;
import br.com.bankaccountmanager.domain.exceptions.DomainException;
import br.com.bankaccountmanager.domain.repositories.IBalanceRepository;
import br.com.bankaccountmanager.domain.shared.IUsecase;
import br.com.bankaccountmanager.domain.shared.utils.Return;

public class CreateBalanceUsecase implements IUsecase<Balance, Return<Void>> {
    private final IBalanceRepository repository;

    public CreateBalanceUsecase(IBalanceRepository repository) {
        this.repository = repository;
    }

    @Override
    public Return<Void> execute(Balance balance) throws DomainException {
        try {
            this.repository.save(balance);
        } catch (DomainException e) {
            throw  new DomainException(e.getMessage(), e.getCause());
        }
        return Return.Empty();
    }
}
