package br.com.bankaccountmanager.domain.entities;

public class Account {
    private final int id;
    private final Client client;
    private Balance balance;
    private final String number;

    public Account(int id, Client client, String number) {
        this.id = id;
        this.client = client;
        this.number = number;
    }

    public void setBalance(Balance balance) {
        this.balance = balance;
    }

    public Balance getBalance() {
        return this.balance;
    }

    public String getNumber() {
        return this.number;
    }

    public int getId() {
        return id;
    }

    public Client getClient() {
        return client;
    }

    @Override
    public String toString() {
        return "Account{" +
                "id=" + id +
                ", number='" + number + '\'' +
                '}';
    }
}
