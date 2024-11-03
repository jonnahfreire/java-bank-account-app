package br.com.bankaccountmanager.infra.repositories;

import br.com.bankaccountmanager.domain.entities.Balance;
import br.com.bankaccountmanager.domain.repositories.IBalanceRepository;
import br.com.bankaccountmanager.domain.shared.utils.FindWhereCallback;

import java.util.ArrayList;
import java.util.List;

public class BalanceRepository implements IBalanceRepository {
    List<Balance> balanceList = new ArrayList<>();

    @Override
    public List<Balance> getAll() {
        return this.balanceList;
    }

    @Override
    public Balance findWhere(FindWhereCallback<Balance> callback) {
        for (Balance balance : balanceList) {
            if(callback.test(balance)) {
                return balance;
            }
        }
        return null;
    }

    @Override
    public void save(Balance balance) {
        this.balanceList.add(balance);
    }

    @Override
    public void remove(Balance balance) {
        this.balanceList.remove(balance);
    }
}
