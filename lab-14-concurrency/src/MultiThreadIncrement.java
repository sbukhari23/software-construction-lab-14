public class MultiThreadIncrement {

    public static void main(String[] args){

        SharedCounter sharedResource = new SharedCounter();

        Runnable r1 = new CounterIncrementer(sharedResource);
        Runnable r2 = new CounterIncrementer(sharedResource);
        Runnable r3 = new CounterIncrementer(sharedResource);

        Thread t1 = new Thread(r1, "Thread-1");
        Thread t2 = new Thread(r2, "Thread-2");
        Thread t3 = new Thread(r3, "Thread-3");

        System.out.println("Starting threads... Expected Final Count: 300");

        t1.start();
        t2.start();
        t3.start();


        try {
            t1.join();
            t2.join();
            t3.join();
        } catch (InterruptedException e) {

            Thread.currentThread().interrupt();
        }

        System.out.println("\nAll threads finished execution.");
        System.out.println("Final Count (Must be 300 due to synchronization): " + sharedResource.getCount());
    }
}
