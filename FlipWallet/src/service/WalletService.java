package service;

import model.PaymentMode;
import repository.WalletRepository;

public class WalletService {
    WalletRepository walletRepository;

    public WalletService(WalletRepository walletRepository) {
        this.walletRepository = walletRepository;
    }

    public void addWallet(String userId) {
        walletRepository.addUserWallet(userId);
    }

    public double fetchBalance(String userId) {
        return walletRepository.getUserBalance(userId);
    }

    public void topUpWallet(String userId, double amount, PaymentMode paymentMode) {
        walletRepository.topUpWallet(userId, amount, paymentMode);
    }

    public void updateWallet(String userId, double amount) {
        walletRepository.updateWalletAmount(userId, amount);
    }
}
