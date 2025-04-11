package Services;

import Entities.Account;
import Entities.Customer;
import Entities.Transaction;

import java.util.List;

public class BankServiceImplementation implements BankService{
    private CustomerService customerService;
    private AccountService accountService;
    private TransactionService transactionService;


    public void setCustomerService(CustomerService customerService) {
        this.customerService = customerService;
    }

    public void setAccountService(AccountService accountService) {
        this.accountService = accountService;
    }

    public void setTransactionService(TransactionService transactionService) {
        this.transactionService = transactionService;
    }

    @Override
    public void addCustomer(Customer customer){
        customerService.addCustomer(customer);
    }

    @Override
    public Customer getCustomerById(String customerId){
        return customerService.getCustomerById(customerId);
    }

    @Override
    public boolean removeCustomer(String customerId) {
        return customerService.removeCustomer(customerId);
    }

    @Override
    public void createAccount(Account account){
        accountService.createAccount(account);
    }
    @Override
    public Account getAccountByNumber(String accountNumber){
        return accountService.getAccountByNumber(accountNumber);
    }

    @Override
    public boolean deposit(String accountNumber, double amount){
        return accountService.deposit(accountNumber, amount);
    }

    @Override
    public boolean withdraw(String accountNumber, double amount){
        return accountService.withdraw(accountNumber, amount);
    }

    @Override
    public boolean transfer(String fromAccountNumber, String toAccountNumber, double amount){
        return accountService.transfer(fromAccountNumber, toAccountNumber, amount);
    }

    @Override
    public boolean closeAccount(String accountNumber){
        return accountService.closeAccount(accountNumber);
    }


    @Override
    public List<Transaction> getAllTransactions(){
        return transactionService.getAllTransaction();
    }

    @Override
    public List<Transaction> getTransactionsByAccountNumber(String accountNumber){
        return transactionService.getTransactionsByAccountNumber(accountNumber);
    }

}
