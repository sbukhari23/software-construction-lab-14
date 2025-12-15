import java.util.Random;

public class ClientTransaction implements Runnable {

    private final BankAccount account;
    private final int transactionCount = 10;

    public ClientTransaction(BankAccount account) {
        this.account = account;
    }

    @Override
    public void run() {
        Random random = new Random();

        for (int i = 0; i < transactionCount; i++) {
            double amount = 1 + (100 - 1) * random.nextDouble();

            if (random.nextDouble() < 0.7) {
                account.deposit(amount);
            } else {
                account.withdraw(amount);
            }

            try {
                Thread.sleep(random.nextInt(100));
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }
}