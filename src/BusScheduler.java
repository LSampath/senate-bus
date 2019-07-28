public class BusScheduler implements Runnable{
    private SharedResources resources;

    public BusScheduler(SharedResources resources) {
        this.resources = resources;
    }

    @Override
    public void run() {
        System.out.println("Bus scheduler start generating riders..");

        while (true) {
            new Thread(new Bus(resources)).start();
            try {
                Thread.sleep(600);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
