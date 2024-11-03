import br.com.bankaccountmanager.application.usecases.*;
import br.com.bankaccountmanager.domain.entities.*;
import br.com.bankaccountmanager.infra.injection.Injection;
import java.time.LocalDate;

public class Main {
    public static void main(String[] args) throws Exception {
        Injection injection = new Injection();
        CreateBalanceUsecase createBalanceUsecase = injection.getInstanceOf(CreateBalanceUsecase.class);
        CreatePersonUsecase createPersonUsecase = injection.getInstanceOf(CreatePersonUsecase.class);
        CreateClientUsecase createClientUsecase = injection.getInstanceOf(CreateClientUsecase.class);
        CreateAccountUsecase createAccountUsecase = injection.getInstanceOf(CreateAccountUsecase.class);
        GetBalanceWhere getBalanceWhere = injection.getInstanceOf(GetBalanceWhere.class);

        Person person = new Person(1, "John", "Doe", "09357212343", LocalDate.parse("2003-11-26"));
        Client client = new Client(person);
        Account account = new Account(1, client, "12345324-00");
        Balance balance = new Balance(1, account, 200);
        account.setBalance(balance);

        createPersonUsecase.execute(person);
        createClientUsecase.execute(client);
        createAccountUsecase.execute(account);
        createBalanceUsecase.execute(balance);

        Balance b = getBalanceWhere.execute(
                (_balance) -> account.getNumber().equals(_balance.getAccount().getNumber()));
        System.out.println(b.toString());
        System.out.format("Saldo: R$ %.2f", b.getValue());
    }
}