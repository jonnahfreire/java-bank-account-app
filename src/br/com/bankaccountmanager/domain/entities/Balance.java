package br.com.bankaccountmanager.domain.entities;

public class Balance {
    private final int id;
    private final Account account;
    private double value;

    public int getId() {
        return id;
    }

    public Account getAccount() {
        return account;
    }

    public double getValue() {
        return value;
    }
    public void setValue(double value) {
        this.value = value;
    }

    public Balance(int id, Account account, double value) {
        this.id = id;
        this.account = account;
        this.value = value;
    }

    @Override
    public String toString() {
        return "Balance{" +
                "id=" + id +
                ", account=" + account.toString() +
                ", value=" + value +
                '}';
    }
}
