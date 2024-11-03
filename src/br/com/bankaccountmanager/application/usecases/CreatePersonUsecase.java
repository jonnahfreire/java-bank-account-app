package br.com.bankaccountmanager.application.usecases;

import br.com.bankaccountmanager.domain.dtos.ResponseDto;
import br.com.bankaccountmanager.domain.entities.Person;
import br.com.bankaccountmanager.domain.repositories.IPersonRepository;
import br.com.bankaccountmanager.domain.shared.IUsecase;

public class CreatePersonUsecase implements IUsecase<Person, ResponseDto> {
    private final IPersonRepository repository;
    public CreatePersonUsecase(IPersonRepository repository) {
        this.repository = repository;
    }

    @Override
    public ResponseDto execute(Person person) {
        try {
            this.repository.save(person);
        } catch (Exception e) {
            return new ResponseDto(e.getMessage(), true);
        }
        return new ResponseDto("Pessoa adicionada com sucesso!");
    }
}
