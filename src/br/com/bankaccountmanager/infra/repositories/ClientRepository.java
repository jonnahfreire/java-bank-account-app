package br.com.bankaccountmanager.infra.repositories;

import br.com.bankaccountmanager.domain.entities.Client;
import br.com.bankaccountmanager.domain.repositories.IClientRepository;
import br.com.bankaccountmanager.domain.shared.utils.FindWhereCallback;

import java.util.ArrayList;
import java.util.List;

public class ClientRepository implements IClientRepository {
    List<Client> clients = new ArrayList<>();

    @Override
    public List<Client> getAll() {
        return this.clients;
    }

    @Override
    public Client findWhere(FindWhereCallback<Client> callback) {
        for (Client client : clients) {
            if(callback.test(client)) {
                return client;
            }
        }
        return null;
    }

    @Override
    public void save(Client client) {
        this.clients.add(client);
    }

    @Override
    public void remove(Client client) {
        this.clients.remove(client);
    }
}
