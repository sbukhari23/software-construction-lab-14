public class MultiThreading {

    public static void main(String[] args){
        Runnable task1 = new PrintNumber();
        Runnable task2 = new PrintSquare();

        Thread t1 = new Thread(task1);
        Thread t2 = new Thread(task2);

        System.out.println("Starting both threads...");
        t1.start();
        t2.start();

        System.out.println("Main thread has finished starting all worker threads.");


    }
}
