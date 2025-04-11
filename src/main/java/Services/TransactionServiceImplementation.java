package Services;

import Entities.Transaction;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TransactionServiceImplementation implements TransactionService{

    private final List<Transaction> transactionList = new ArrayList<>();
    private final Map<String, List<Transaction>> accountToTransaction = new HashMap<>();

    @Override
    public void recordTransaction(Transaction transaction) {

        transactionList.add(transaction);
        String accountNumber = transaction.getAccountNumber();

        if(!accountToTransaction.containsKey(accountNumber)) {
            List<Transaction> tempList = new ArrayList<>();
            tempList.add(transaction);
            accountToTransaction.put(accountNumber, tempList);
            return ;
        }

        List<Transaction> tempList = accountToTransaction.get(accountNumber);
        tempList.add(transaction);
        accountToTransaction.put(accountNumber, tempList);
    }

    @Override
    public List<Transaction> getAllTransaction() {
        return transactionList;
    }

    @Override
    public List<Transaction> getTransactionsByAccountNumber(String accountNumber){
        return accountToTransaction.getOrDefault(accountNumber, new ArrayList<>());
    }
}
