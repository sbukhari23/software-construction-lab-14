public class BankSimulation {

    private static final int NUM_CLIENTS = 5;
    private static final double INITIAL_BALANCE = 500.00;

    public static void main(String[] args) {

        BankAccount sharedAccount = new BankAccount(INITIAL_BALANCE);

        System.out.println("--- Bank Transaction Simulation Started ---");
        System.out.println("Initial Account Balance: " + String.format("%.2f", INITIAL_BALANCE));
        System.out.println("Number of Client Threads: " + NUM_CLIENTS);
        System.out.println("Each client performs " + 10 + " transactions.");
        System.out.println("-------------------------------------------");

        Thread[] clientThreads = new Thread[NUM_CLIENTS];

        for (int i = 0; i < NUM_CLIENTS; i++) {
            Runnable clientTask = new ClientTransaction(sharedAccount);
            clientThreads[i] = new Thread(clientTask, "Client-" + (i + 1));
        }

        for (Thread t : clientThreads) {
            t.start();
        }

        try {
            for (Thread t : clientThreads) {
                t.join();
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        System.out.println("\n-------------------------------------------");
        System.out.println("All client transactions completed.");
        System.out.println("Final Account Balance: " + String.format("%.2f", sharedAccount.getBalance()));
        System.out.println("--- Simulation Ended ---");
    }
}