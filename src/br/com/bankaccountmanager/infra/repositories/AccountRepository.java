package br.com.bankaccountmanager.infra.repositories;

import br.com.bankaccountmanager.domain.entities.Account;
import br.com.bankaccountmanager.domain.repositories.IAccountRepository;
import br.com.bankaccountmanager.domain.shared.utils.FindWhereCallback;

import java.util.ArrayList;
import java.util.List;

public class AccountRepository implements IAccountRepository {
    List<Account> accounts = new ArrayList<>();

    @Override
    public List<Account> getAll() {
        return this.accounts;
    }

    @Override
    public Account findWhere(FindWhereCallback<Account> callback) {
        for (Account account : accounts) {
            if(callback.test(account)) {
                return account;
            }
        }
        return null;
    }

    @Override
    public void save(Account account) {
        this.accounts.add(account);
    }

    @Override
    public void remove(Account account) {
        this.accounts.remove(account);
    }
}
