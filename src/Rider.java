public class Rider implements Runnable {
    private SharedResources resources;

    public Rider(SharedResources resources) {
        this.resources = resources;
    }

    private void board() {
        //System.out.println("    RIDER : board to bus.");
    }

    @Override
    public void run() {
        synchronized (resources.lock) {
            resources.waiting += 1;
        }
        try {
            resources.bus.acquire();
            board();
            resources.boarded.release();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
