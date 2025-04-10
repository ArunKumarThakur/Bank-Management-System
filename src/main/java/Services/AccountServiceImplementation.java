package Services;
import Entities.Account;
import java.util.*;

public class AccountServiceImplementation implements AccountService{

    Set<Account> accountList = new HashSet<>();
    Map<String, Account> idToAccount = new HashMap<>();

    @Override
    public Set<Account> getAllAccounts() {
        return accountList;
    }

    @Override
    public Account getAccountByNumber(String accountNumber) {
        return idToAccount.get(accountNumber);
    }

    @Override
    public void createAccount(Account account) {
        accountList.add(account);
        idToAccount.putIfAbsent(account.getAccountNumber(), account);
    }
}
