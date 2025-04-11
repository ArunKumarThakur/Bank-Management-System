package Services;

import Entities.Transaction;

import java.util.List;

public interface TransactionService {
    void recordTransaction(Transaction transaction);
    List<Transaction> getAllTransaction();
    List<Transaction> getTransactionsByAccountNumber(String accountNumber);
}
