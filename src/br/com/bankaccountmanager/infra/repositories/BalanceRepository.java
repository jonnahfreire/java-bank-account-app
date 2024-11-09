package br.com.bankaccountmanager.infra.repositories;

import br.com.bankaccountmanager.domain.entities.Balance;
import br.com.bankaccountmanager.domain.repositories.IBalanceRepository;
import br.com.bankaccountmanager.domain.shared.utils.FindWhereCallback;
import br.com.bankaccountmanager.domain.shared.utils.Return;

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
    public Return<Void> save(Balance balance) {
        this.balanceList.add(balance);
        return Return.Empty();
    }

    @Override
    public Return<Void> remove(Balance balance) {
        this.balanceList.remove(balance);
        return Return.Empty();
    }
}
