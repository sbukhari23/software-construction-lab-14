import java.util.List;
import java.util.Iterator;

public class ListReader implements Runnable {

    private final List<String> list;
    private final String name;

    public ListReader(List<String> list, String name) {
        this.list = list;
        this.name = name;
    }

    @Override
    public void run() {
        for (int i = 0; i < 3; i++) {
            System.out.print(Thread.currentThread().getName() + " reading snapshot: ");

            // The iterator on CopyOnWriteArrayList is safe from modifications
            // by other threads while this thread iterates.
            for (String s : list) {
                System.out.print(s + " ");
            }
            System.out.println();

            try {
                Thread.sleep(150);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }
}