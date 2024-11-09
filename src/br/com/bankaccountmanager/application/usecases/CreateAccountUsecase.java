package br.com.bankaccountmanager.application.usecases;

import br.com.bankaccountmanager.domain.entities.Account;
import br.com.bankaccountmanager.domain.exceptions.DomainException;
import br.com.bankaccountmanager.domain.repositories.IAccountRepository;
import br.com.bankaccountmanager.domain.shared.IUsecase;
import br.com.bankaccountmanager.domain.shared.utils.Return;

import java.util.function.Predicate;

public class CreateAccountUsecase implements IUsecase<Account, Return<Void>> {
    private final IAccountRepository repository;

    public CreateAccountUsecase(IAccountRepository repository) {
        this.repository = repository;
    }

    @Override
    public Return<Void> execute(Account account) throws DomainException {
        Predicate<Account> hasAlreadyId = ac -> ac.getId() == account.getId();
        Predicate<Account> hasAlreadyNumber = ac -> ac.getNumber().equals(account.getNumber());

        if(this.repository.findWhere((ac) -> hasAlreadyId.or(hasAlreadyNumber).test(ac)) != null) {
            throw new DomainException("Já existe uma conta com este Id, ou número");
        }

        return this.repository.save(account);
    }
}
