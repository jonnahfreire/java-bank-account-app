package br.com.bankaccountmanager.application.usecases;

import br.com.bankaccountmanager.domain.dtos.ResponseDto;
import br.com.bankaccountmanager.domain.entities.Balance;
import br.com.bankaccountmanager.domain.repositories.IBalanceRepository;
import br.com.bankaccountmanager.domain.shared.IUsecase;

public class CreateBalanceUsecase implements IUsecase<Balance, ResponseDto> {
    private final IBalanceRepository repository;

    public CreateBalanceUsecase(IBalanceRepository repository) {
        this.repository = repository;
    }

    @Override
    public ResponseDto execute(Balance balance) throws Exception {
        try {
            this.repository.save(balance);
        } catch (Exception e) {
            return new ResponseDto(e.getMessage(), true);
        }
        return new ResponseDto("Saldo adicionado com sucesso!");
    }
}
