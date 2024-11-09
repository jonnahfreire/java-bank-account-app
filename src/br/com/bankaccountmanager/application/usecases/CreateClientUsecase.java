package br.com.bankaccountmanager.application.usecases;

import br.com.bankaccountmanager.domain.entities.Client;
import br.com.bankaccountmanager.domain.exceptions.DomainException;
import br.com.bankaccountmanager.domain.repositories.IClientRepository;
import br.com.bankaccountmanager.domain.shared.IUsecase;
import br.com.bankaccountmanager.domain.shared.utils.Return;

import java.util.function.Predicate;

public class CreateClientUsecase implements IUsecase<Client, Return<Void>> {
    private final IClientRepository repository;

    public CreateClientUsecase(IClientRepository repository) {
        this.repository = repository;
    }

    @Override
    public Return<Void> execute(Client client) throws DomainException {
        Predicate<Client> hasAlreadyId = c -> c.getId() == client.getId();
        Predicate<Client> hasAlreadyDocument = c -> c.getDocument().equals(client.getDocument());

        if(this.repository.findWhere((c) -> hasAlreadyId.or(hasAlreadyDocument).test(c)) != null) {
            throw new DomainException("Cliente já cadastrado com essa informação");
        }
        return this.repository.save(client);
    }
}
