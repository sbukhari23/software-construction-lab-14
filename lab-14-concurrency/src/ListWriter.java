import java.util.List;

public class ListWriter implements Runnable {

    private final List<String> list;
    private final String name;

    public ListWriter(List<String> list, String name) {
        this.list = list;
        this.name = name;
    }

    @Override
    public void run() {
        for (int i = 1; i <= 5; i++) {
            String element = name + "-" + i;
            list.add(element);
            System.out.println(Thread.currentThread().getName() + " added: " + element + " (Current size: " + list.size() + ")");
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }
}