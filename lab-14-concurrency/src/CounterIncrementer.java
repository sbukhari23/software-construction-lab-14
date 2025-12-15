public class CounterIncrementer implements Runnable{

    private final SharedCounter sharedCounter;

    public CounterIncrementer(SharedCounter counterToUse) {
        this.sharedCounter = counterToUse;
    }

    @Override
    public void run(){
        for(int i = 1; i <=100; i++){
            sharedCounter.increment();
        }
        System.out.println(Thread.currentThread().getName() + "finished its incrementing");
    }

}
