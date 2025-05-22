package repository;

import model.Transaction;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class TransactionRepository {
    HashMap<String, List<Transaction>> transactionMap;

    public TransactionRepository() {
        transactionMap = new HashMap<>();
    }

    public void addTransaction(String userId, Transaction transaction) {
        List<Transaction> transactions = transactionMap.computeIfAbsent(userId, k -> new ArrayList<>());
        transactions.add(transaction);
    }
}
