package br.com.bankaccountmanager.application.usecases;

import br.com.bankaccountmanager.domain.entities.Person;
import br.com.bankaccountmanager.domain.exceptions.DomainException;
import br.com.bankaccountmanager.domain.repositories.IPersonRepository;
import br.com.bankaccountmanager.domain.shared.IUsecase;
import br.com.bankaccountmanager.domain.shared.utils.Return;

import java.util.function.Predicate;

public class CreatePersonUsecase implements IUsecase<Person, Return<Void>> {
    private final IPersonRepository repository;
    public CreatePersonUsecase(IPersonRepository repository) {
        this.repository = repository;
    }

    @Override
    public Return<Void> execute(Person person) throws DomainException {
        Predicate<Person> hasAlreadyId = p -> p.getId() == person.getId();
        Predicate<Person> hasAlreadyDocument = p -> p.getDocument().equals(person.getDocument());

        if(this.repository.findWhere((p) -> hasAlreadyId.or(hasAlreadyDocument).test(p)) != null) {
            throw new DomainException("Pessoa já cadastrada com essa informação");
        }
        return this.repository.save(person);
    }
}
