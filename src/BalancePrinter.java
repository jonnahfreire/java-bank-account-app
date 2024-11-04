import br.com.bankaccountmanager.application.usecases.GetBalanceWhere;
import br.com.bankaccountmanager.domain.entities.Account;
import br.com.bankaccountmanager.domain.entities.Balance;
import br.com.bankaccountmanager.infra.injection.Injection;
import br.com.bankaccountmanager.infra.injection.exception.InjectionInstanceException;

public class BalancePrinter {
    private final Injection injection = Injection.getInstance();

    public void print(Account account) throws InjectionInstanceException {
        GetBalanceWhere getBalanceWhere = injection.getInstanceOf(GetBalanceWhere.class);
        Balance balance = getBalanceWhere
                .execute((_balance) -> _balance.getAccount().getNumber().equals(account.getNumber()));
        System.out.println(balance.toString());
    }
}
