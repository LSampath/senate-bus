import java.util.concurrent.Semaphore;

public class SharedResources {
    public int waiting;
    public Object lock;
    public Semaphore bus;
    public Semaphore boarded;

    public SharedResources() {
        this.waiting = 0;
        this.bus = new Semaphore(0);
        this.boarded = new Semaphore(0);
        this.lock = new Object();
    }
}
