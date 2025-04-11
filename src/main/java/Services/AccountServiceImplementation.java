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

        if(idToAccount.containsKey(account.getAccountNumber())) {
            System.out.println("Account already present !");
            return ;
        }
        accountList.add(account);
        idToAccount.put(account.getAccountNumber(), account);
        System.out.println("Account opened successfully");
    }

    @Override
    public boolean deposit(String accountNumber, double amount) {

        Account account = idToAccount.get(accountNumber);

        if(account == null) return false;
        double updateAmount = account.getBalance() + amount;
        account.setBalance(updateAmount);

        return true;
    }

    @Override
    public boolean withdraw(String accountNumber, double amount) {
        Account account = idToAccount.get(accountNumber);

        if(account == null) {
            System.out.println("Account not Found");
            return false;
        }

        if(account.getBalance() < amount) {
            System.out.println("Insufficient Balance");
            return false;
        }


        double depreciation = account.getBalance() - amount;

        account.setBalance(depreciation);

        return true;
    }

    @Override
    public boolean transfer(String fromAccountNumber, String toAccountNumber, double amount) {
        Account account1 = idToAccount.get(fromAccountNumber);
        Account account2 = idToAccount.get(toAccountNumber);

        if(account1 == null) {
            System.out.println("Sender Account not found !");
            return false;
        }

        if(account2 == null) {
            System.out.println("Receive Account not found !");
            return false;
        }

        double senderBalance = account1.getBalance() ;

        if(senderBalance < amount) return false;
        account1.setBalance(senderBalance - amount);

        account2.setBalance(account2.getBalance() + amount);

        return true;
    }

    public boolean closeAccount(String accountNumber) {
        Account account = idToAccount.get(accountNumber);

        if(account == null) return false;
        idToAccount.remove(accountNumber);
        accountList.remove(account);

        System.out.println("Account closed successfully");
        return true;
    }
}
