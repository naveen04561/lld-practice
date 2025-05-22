package service;

import model.PaymentMode;
import model.TransactionType;
import model.User;
import repository.UserRepository;

public class UserService {
    UserRepository userRepository;
    WalletService walletService;
    TransactionService transactionService;

    public UserService(UserRepository userRepository, WalletService walletService, TransactionService transactionService) {
        this.userRepository = userRepository;
        this.walletService = walletService;
        this.transactionService = transactionService;
    }

    public void registerUser(User user) {
        userRepository.addUser(user);
        walletService.addWallet(user.getUserId());
    }

    public double fetchBalance(String userId) {
        return walletService.fetchBalance(userId);
    }

    public void topUpWallet(String userId, double amount, PaymentMode paymentMode) {
        walletService.topUpWallet(userId, amount, paymentMode);
    }

    public void sendMoney(String senderId, String receiverId, double amount) {
        double senderBalance = walletService.fetchBalance(senderId);

        if (senderBalance < amount) {
            System.out.println("Transaction not possible..");
        } else {
            walletService.updateWallet(senderId, -amount);
            walletService.updateWallet(receiverId, amount);

            transactionService.addTransaction(senderId, receiverId, -amount, TransactionType.SEND);
            transactionService.addTransaction(senderId, receiverId, amount, TransactionType.RECEIVE);
        }
    }
}
