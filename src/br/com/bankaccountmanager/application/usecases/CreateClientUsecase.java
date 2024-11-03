package br.com.bankaccountmanager.application.usecases;

import br.com.bankaccountmanager.domain.dtos.ResponseDto;
import br.com.bankaccountmanager.domain.entities.Client;
import br.com.bankaccountmanager.domain.repositories.IClientRepository;
import br.com.bankaccountmanager.domain.shared.IUsecase;

public class CreateClientUsecase implements IUsecase<Client, ResponseDto> {
    private final IClientRepository repository;

    public CreateClientUsecase(IClientRepository repository) {
        this.repository = repository;
    }

    @Override
    public ResponseDto execute(Client client) throws Exception {
        try {
            this.repository.save(client);
        } catch (Exception e) {
            return new ResponseDto(e.getMessage(), true);
        }
        return new ResponseDto("Cliente adicionado com sucesso!");
    }
}
