package br.com.bankaccountmanager.infra.injection;

import br.com.bankaccountmanager.application.usecases.*;
import br.com.bankaccountmanager.domain.repositories.IAccountRepository;
import br.com.bankaccountmanager.domain.repositories.IBalanceRepository;
import br.com.bankaccountmanager.domain.repositories.IClientRepository;
import br.com.bankaccountmanager.domain.repositories.IPersonRepository;
import br.com.bankaccountmanager.infra.repositories.AccountRepository;
import br.com.bankaccountmanager.infra.repositories.BalanceRepository;
import br.com.bankaccountmanager.infra.repositories.ClientRepository;
import br.com.bankaccountmanager.infra.repositories.PersonRepository;

public class Injection {
    private final Injector injector = new Injector();

    public Injection() throws Exception {
        // Repositories
        injector.inject(IPersonRepository.class, new PersonRepository());
        injector.inject(IClientRepository.class, new ClientRepository());
        injector.inject(IAccountRepository.class, new AccountRepository());
        injector.inject(IBalanceRepository.class, new BalanceRepository());

        // Use cases
        injector.inject(CreatePersonUsecase.class,
                new CreatePersonUsecase(injector.getInstance(IPersonRepository.class)));
        injector.inject(CreateClientUsecase.class,
                new CreateClientUsecase(injector.getInstance(IClientRepository.class)));
        injector.inject(CreateAccountUsecase.class,
                new CreateAccountUsecase(injector.getInstance(IAccountRepository.class)));
        injector.inject(CreateBalanceUsecase.class,
                new CreateBalanceUsecase(injector.getInstance(IBalanceRepository.class)));
        injector.inject(GetBalanceById.class,
                new GetBalanceById(injector.getInstance(IBalanceRepository.class)));
        injector.inject(GetBalanceWhere.class,
                new GetBalanceWhere(injector.getInstance(IBalanceRepository.class)));
    }

    public <T> T getInstanceOf(Class<T> type) throws Exception {
        return this.injector.getInstance(type);
    }
}
