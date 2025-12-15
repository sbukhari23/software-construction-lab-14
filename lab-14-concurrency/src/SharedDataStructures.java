import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class SharedDataStructures {

    public static void main(String[] args) {

        List<String> sharedList = new CopyOnWriteArrayList<>();

        ListWriter writer1 = new ListWriter(sharedList, "Writer-A");
        ListWriter writer2 = new ListWriter(sharedList, "Writer-B");

        ListReader reader1 = new ListReader(sharedList, "Reader-X");
        ListReader reader2 = new ListReader(sharedList, "Reader-Y");

        Thread t1 = new Thread(writer1, "Thread-W1");
        Thread t2 = new Thread(writer2, "Thread-W2");
        Thread t3 = new Thread(reader1, "Thread-R1");
        Thread t4 = new Thread(reader2, "Thread-R2");

        System.out.println("Starting concurrent read/write simulation with CopyOnWriteArrayList.");

        t1.start();
        t2.start();
        t3.start();
        t4.start();

        try {
            t1.join();
            t2.join();
            t3.join();
            t4.join();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        System.out.println("\nAll threads finished execution.");
        System.out.println("Final list size: " + sharedList.size());
        System.out.println("Final list contents: " + sharedList);
    }
}