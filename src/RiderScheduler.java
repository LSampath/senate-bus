public class RiderScheduler implements Runnable {
    private SharedResources resources;

    public RiderScheduler(SharedResources resources) {
        this.resources = resources;
    }

    @Override
    public void run() {
        System.out.println("Rider scheduler start generating riders..");

        while (true) {
            new Thread(new Rider(resources)).start();
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
