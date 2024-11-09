package br.com.bankaccountmanager.infra.repositories;

import br.com.bankaccountmanager.domain.entities.Account;
import br.com.bankaccountmanager.domain.repositories.IAccountRepository;
import br.com.bankaccountmanager.domain.shared.utils.FindWhereCallback;
import br.com.bankaccountmanager.domain.shared.utils.Return;

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
    public Return<Void> save(Account account) {
        this.accounts.add(account);
        return Return.Empty();
    }

    @Override
    public Return<Void> remove(Account account) {
        this.accounts.remove(account);
        return Return.Empty();
    }
}
