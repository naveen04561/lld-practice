package service;

import model.Transaction;
import model.TransactionType;
import repository.TransactionRepository;

public class TransactionService {
    TransactionRepository transactionRepository;

    public TransactionService(TransactionRepository transactionRepository) {
        this.transactionRepository = transactionRepository;
    }

    public void addTransaction(String senderId, String receiverId, double amount, TransactionType transactionType) {
        transactionRepository.addTransaction(senderId, new Transaction(transactionType, senderId, receiverId, amount));
    }
}
