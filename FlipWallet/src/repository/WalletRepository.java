package repository;

import model.PaymentMode;
import model.Wallet;

import java.util.HashMap;

public class WalletRepository {
    HashMap<String, Wallet> walletMap;

    public WalletRepository() {
        walletMap = new HashMap<>();
    }

    public void topUpWallet(String userId, double amount, PaymentMode paymentMode) {
        Wallet senderWallet = walletMap.get(userId);
        walletMap.remove(userId);

        senderWallet.setBalance(senderWallet.getBalance() + amount);
        walletMap.put(userId, senderWallet);
    }

    public double getUserBalance(String userId) {
        return walletMap.get(userId).getBalance();
    }

    public void addUserWallet(String userId) {
        walletMap.put(userId, new Wallet());
    }

    public void updateWalletAmount(String userId, double amount) {
        Wallet userWallet = walletMap.get(userId);
        walletMap.remove(userId);

        userWallet.setBalance(userWallet.getBalance() + amount);
        walletMap.put(userId, userWallet);
    }
}
