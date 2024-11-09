package br.com.bankaccountmanager.infra.repositories;

import br.com.bankaccountmanager.domain.entities.Person;
import br.com.bankaccountmanager.domain.exceptions.DomainException;
import br.com.bankaccountmanager.domain.repositories.IPersonRepository;
import br.com.bankaccountmanager.domain.shared.utils.FindWhereCallback;
import br.com.bankaccountmanager.domain.shared.utils.Return;

import java.util.ArrayList;
import java.util.List;

public class PersonRepository implements IPersonRepository {
    List<Person> personList = new ArrayList<>();

    @Override
    public List<Person> getAll() {
        return personList;
    }

    @Override
    public Person findWhere(FindWhereCallback<Person> callback) {
        for (Person person : personList) {
            if(callback.test(person)) {
                return person;
            }
        }
        return null;
    }

    @Override
    public Return<Void> save(Person person) throws DomainException {
        this.personList.add(person);
        return Return.Empty();
    }

    @Override
    public Return<Void> remove(Person person) {
        this.personList.remove(person);
        return Return.Empty();
    }
}
