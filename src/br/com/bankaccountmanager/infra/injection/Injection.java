package br.com.bankaccountmanager.infra.injection;

import br.com.bankaccountmanager.application.usecases.*;
import br.com.bankaccountmanager.domain.repositories.*;
import br.com.bankaccountmanager.infra.injection.exception.InjectionInstanceException;
import br.com.bankaccountmanager.infra.injection.exception.InjectionRegisterException;
import br.com.bankaccountmanager.infra.repositories.*;

public class Injection {
    private final Injector injector = new Injector();

    private Injection() {
        try {
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
        } catch (InjectionRegisterException | InjectionInstanceException e) {
            System.err.println("Injection Error: " + e);
        }
    }

    private static class Holder {
        private static final Injection INSTANCE = new Injection();
    }

    public static Injection getInstance() {
        return Holder.INSTANCE;
    }

    public <T> T getInstanceOf(Class<T> type) throws InjectionInstanceException {
        return this.injector.getInstance(type);
    }
}
