import model.PaymentMode;
import model.User;
import repository.TransactionRepository;
import repository.UserRepository;
import repository.WalletRepository;
import service.TransactionService;
import service.UserService;
import service.WalletService;

public class Main {
    public static void main(String[] args) {
        System.out.println("Flip Mini Wallet");

        UserRepository userRepository = new UserRepository();
        WalletRepository walletRepository = new WalletRepository();
        TransactionRepository transactionRepository = new TransactionRepository();

        TransactionService transactionService = new TransactionService(transactionRepository);
        WalletService walletService = new WalletService(walletRepository);
        UserService userService = new UserService(userRepository, walletService, transactionService);

        userService.registerUser(new User("1", "Bob"));
        userService.registerUser(new User("2", "Alice"));

        userService.topUpWallet("1", 100, PaymentMode.UPI);
        userService.topUpWallet("2", 200, PaymentMode.CC);

        System.out.println("User 1 has " + userService.fetchBalance("1"));
        System.out.println("User 2 has " + userService.fetchBalance("2"));

        userService.sendMoney("1", "2", 90);

        System.out.println("User 1 has " + userService.fetchBalance("1"));
        System.out.println("User 2 has " + userService.fetchBalance("2"));
    }
}
