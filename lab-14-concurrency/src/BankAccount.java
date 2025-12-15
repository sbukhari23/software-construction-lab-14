public class BankAccount {

    private double balance;

    public BankAccount(double initialBalance) {
        this.balance = initialBalance;
    }

    public synchronized void deposit(double amount) {
        System.out.println(Thread.currentThread().getName() + " is depositing: " + String.format("%.2f", amount));
        balance += amount;
        System.out.println("Current Balance after deposit: " + String.format("%.2f", balance));
    }

    public synchronized boolean withdraw(double amount) {
        if (balance >= amount) {
            System.out.println(Thread.currentThread().getName() + " is withdrawing: " + String.format("%.2f", amount));
            balance -= amount;
            System.out.println("Current Balance after withdrawal: " + String.format("%.2f", balance));
            return true;
        } else {
            System.out.println(Thread.currentThread().getName() + " FAILED to withdraw " + String.format("%.2f", amount) + " (Insufficient Funds)");
            return false;
        }
    }

    public double getBalance() {
        return balance;
    }
}