package br.com.bankaccountmanager.infra.repositories;

import br.com.bankaccountmanager.domain.entities.Person;
import br.com.bankaccountmanager.domain.repositories.IPersonRepository;
import br.com.bankaccountmanager.domain.shared.utils.FindWhereCallback;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

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
    public void save(Person person) throws Exception {
        Predicate<Person> hasAlreadyId = p -> p.getId() == person.getId();
        Predicate<Person> hasAlreadyDocument = p -> p.getDocument().equals(person.getDocument());

        if(this.findWhere((p) -> hasAlreadyId.or(hasAlreadyDocument).test(p)) == null) {
            this.personList.add(person);
        } else {
            throw new Exception("Pessoa já cadastrada com essa informação");
        }
    }

    @Override
    public void remove(Person person) {
        this.personList.remove(person);
    }
}
