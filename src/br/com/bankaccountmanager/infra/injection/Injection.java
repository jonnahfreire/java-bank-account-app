package br.com.bankaccountmanager.infra.injection;

import br.com.bankaccountmanager.application.usecases.*;
import br.com.bankaccountmanager.domain.repositories.IAccountRepository;
import br.com.bankaccountmanager.domain.repositories.IBalanceRepository;
import br.com.bankaccountmanager.domain.repositories.IClientRepository;
import br.com.bankaccountmanager.domain.repositories.IPersonRepository;
import br.com.bankaccountmanager.domain.shared.IRepository;
import br.com.bankaccountmanager.domain.shared.IUsecase;
import br.com.bankaccountmanager.infra.repositories.AccountRepository;
import br.com.bankaccountmanager.infra.repositories.BalanceRepository;
import br.com.bankaccountmanager.infra.repositories.ClientRepository;
import br.com.bankaccountmanager.infra.repositories.PersonRepository;

public class Injection {
    Injector<IRepository> repositoryInjector = new Injector<>();
    Injector<IUsecase> usecaseInjector = new Injector<>();

    public Injection() {
        // Repositories
        repositoryInjector.inject(new PersonRepository());
        repositoryInjector.inject(new ClientRepository());
        repositoryInjector.inject(new AccountRepository());
        repositoryInjector.inject(new BalanceRepository());

        // Use cases
        usecaseInjector.inject(new CreatePersonUsecase((IPersonRepository) repositoryInjector.getInstance("PersonRepository")));
        usecaseInjector.inject(new CreateClientUsecase((IClientRepository) repositoryInjector.getInstance("ClientRepository")));
        usecaseInjector.inject(new CreateAccountUsecase((IAccountRepository) repositoryInjector.getInstance("AccountRepository")));
        usecaseInjector.inject(new CreateBalanceUsecase((IBalanceRepository) repositoryInjector.getInstance("BalanceRepository")));
        usecaseInjector.inject(new GetBalanceById((IBalanceRepository) repositoryInjector.getInstance("BalanceRepository")));
        usecaseInjector.inject(new GetBalanceWhere((IBalanceRepository) repositoryInjector.getInstance("BalanceRepository")));
    }

    public Injector<IRepository> getRepositoryInjector() {
        return repositoryInjector;
    }

    public Injector<IUsecase> getUsecaseInjector() {
        return usecaseInjector;
    }
}
