package Services;

import Entities.Account;
import Entities.Customer;

import java.util.Set;

public interface AccountService {

    void createAccount(Account account);

    Account getAccountByNumber(String accountNumber);

    Set<Account> getAllAccounts();

    boolean deposit(String accountNumber, double amount);

    boolean withdraw(String accountNumber, double amount);

    boolean transfer(String fromAccountNumber, String toAccountNumber, double amount);

    boolean closeAccount(String accountNumber);

    double getAmount(String accountNumber);

    boolean validateBankAccount(String accountNumber);
}
