package Services;

import Entities.Customer;
import Entities.Account;
import Entities.Transaction;

import java.util.List;

public interface BankService {

    // Customer operations
    void addCustomer(Customer customer);
    Customer getCustomerById(String customerId);
    boolean removeCustomer(String customerId);

    // Account operations
    void createAccount(Account account);
    Account getAccountByNumber(String accountNumber);
    boolean deposit(String accountNumber, double amount);
    boolean withdraw(String accountNumber, double amount);
    boolean transfer(String fromAccountNumber, String toAccountNumber, double amount);
    boolean closeAccount(String accountNumber);
    double getBalance(String accountNumber);
    boolean validateBankAccount(String accountNumber);
    // Transaction operations
    List<Transaction> getAllTransactions();
    List<Transaction> getTransactionsByAccountNumber(String accountNumber);


}
