package br.com.bankaccountmanager.application.usecases;

import br.com.bankaccountmanager.domain.dtos.ResponseDto;
import br.com.bankaccountmanager.domain.entities.Account;
import br.com.bankaccountmanager.domain.repositories.IAccountRepository;
import br.com.bankaccountmanager.domain.shared.IUsecase;

public class CreateAccountUsecase implements IUsecase<Account, ResponseDto> {
    private final IAccountRepository repository;

    public CreateAccountUsecase(IAccountRepository repository) {
        this.repository = repository;
    }

    @Override
    public ResponseDto execute(Account account) throws Exception {
        try {
            this.repository.save(account);
        } catch (Exception e) {
            return new ResponseDto(e.getMessage(), true);
        }
        return new ResponseDto("Conta adicionada com sucesso!");
    }
}
