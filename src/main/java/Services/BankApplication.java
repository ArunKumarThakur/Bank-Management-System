package Services;

import Entities.Account;
import Entities.Customer;
import Entities.Transaction;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.UUID;

public class BankApplication {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("bean.xml");
        BankService bankService = context.getBean("bankService", BankService.class);
        TransactionService transactionService = context.getBean("transactionService", TransactionService.class);
        CustomerService customerService = context.getBean("customerService", CustomerService.class);
        AccountService accountService = context.getBean("accountService", AccountService.class);
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n==== BANK MENU ====");
            System.out.println("1. Add Customer");
            System.out.println("2. Create Account");
            System.out.println("3. View Account");
            System.out.println("4. Deposit");
            System.out.println("5. Withdraw");
            System.out.println("6. Transfer");
            System.out.println("7. View All Transactions");
            System.out.println("8. View Transactions by Account");
            System.out.println("9. View all customers");
            System.out.println("10. Exit");
            System.out.print("Choose: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    System.out.println("Enter customer id");
                    String id = scanner.nextLine();
                    System.out.print("Enter Name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter Email: ");
                    String email = scanner.nextLine();

                    Customer customer = new Customer(id, name, email);
                    bankService.addCustomer(customer);
                    System.out.println("Customer added successfully!");
                    break;

                case 2:
                    System.out.println("Enter customer id");
                    String custId = scanner.next();

                    System.out.print("Enter Account Number: ");
                    String accNum = scanner.next();

                    Customer foundCustomer = bankService.getCustomerById(custId);
                    if (foundCustomer == null) {
                        System.out.println("Customer not found.");
                        break;
                    }

                    System.out.print("Enter Initial Balance: ");
                    double balance = scanner.nextDouble();
                    scanner.nextLine(); // consume newline

                    Account account = new Account(foundCustomer, accNum, balance);
                    bankService.createAccount(account);

                    Transaction txn = new Transaction(UUID.randomUUID().toString(), accNum, balance, "deposit",
                            LocalDateTime.now(), "Account Created with initial balance");
                    transactionService.recordTransaction(txn);
                    break;
                case 3:
                    for(Account accounts : accountService.getAllAccounts()) {
                        System.out.println(accounts);
                    }
                    break;

                case 4:
                    System.out.print("Enter Account Number: ");
                    String depositAcc = scanner.nextLine();
                    System.out.print("Enter Amount: ");
                    double depositAmount = scanner.nextDouble();
                    scanner.nextLine();

                    boolean depositSuccess = bankService.deposit(depositAcc, depositAmount);
                    if (depositSuccess) {
                        System.out.println("Deposited Successfully!");

                        Transaction depositTxn = new Transaction(UUID.randomUUID().toString(), depositAcc, depositAmount, "deposit",
                                LocalDateTime.now(), "Deposited amount");
                        transactionService.recordTransaction(depositTxn);
                    } else {
                        System.out.println("Deposit Failed!");
                    }
                    break;

                case 5:
                    System.out.print("Enter Account Number: ");
                    String withdrawAcc = scanner.nextLine();
                    System.out.print("Enter Amount: ");
                    double withdrawAmount = scanner.nextDouble();
                    scanner.nextLine();

                    boolean withdrawSuccess = bankService.withdraw(withdrawAcc, withdrawAmount);
                    if (withdrawSuccess) {
                        System.out.println("Withdrawn Successfully!");

                        Transaction withdrawTxn = new Transaction(UUID.randomUUID().toString(), withdrawAcc, withdrawAmount, "withdraw",
                                LocalDateTime.now(), "Withdrawn amount");
                        transactionService.recordTransaction(withdrawTxn);
                    } else {
                        System.out.println("Withdraw Failed!");
                    }
                    break;

                case 6:
                    System.out.print("From Account: ");
                    String fromAcc = scanner.nextLine();
                    System.out.print("To Account: ");
                    String toAcc = scanner.nextLine();
                    System.out.print("Amount: ");
                    double transferAmount = scanner.nextDouble();
                    scanner.nextLine();

                    boolean transferSuccess = bankService.transfer(fromAcc, toAcc, transferAmount);
                    if (transferSuccess) {
                        System.out.println("Transfer Successful!");

                        transactionService.recordTransaction(new Transaction(UUID.randomUUID().toString(), fromAcc, transferAmount, "transfer-out",
                                LocalDateTime.now(), "Transferred to " + toAcc));

                        transactionService.recordTransaction(new Transaction(UUID.randomUUID().toString(), toAcc, transferAmount, "transfer-in",
                                LocalDateTime.now(), "Received from " + fromAcc));
                    } else {
                        System.out.println("Transfer Failed!");
                    }
                    break;

                case 7:
                    List<Transaction> allTxns = bankService.getAllTransactions();
                    System.out.println("All Transactions:");
                    for (Transaction t : allTxns) {
                        System.out.println(t);
                    }
                    break;

                case 8:
                    System.out.print("Enter Account Number: ");
                    String txnAcc = scanner.nextLine();
                    List<Transaction> accTxns = bankService.getTransactionsByAccountNumber(txnAcc);
                    if (accTxns == null || accTxns.isEmpty()) {
                        System.out.println("No transactions found for this account.");
                    } else {
                        for (Transaction t : accTxns) {
                            System.out.println(t);
                        }
                    }
                    break;

                case 9:
                    Set<Customer> customerList = customerService.getAllCustomer();

                    for(Customer customers : customerList) {
                        System.out.println(customers);
                    }
                    break;
                case 10:
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Invalid choice!");
                    break;
            }
        }
    }
}
