package br.com.bankaccountmanager.domain.entities;

public class Client extends Person {
    private Account account;

    public Client(Person person) {
        super(person.getId(),
                person.getFirstName(),
                person.getLastName(),
                person.getDocument(),
                person.getBirthDate()
        );
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public Account getAccount() {
        return this.account;
    }
}
