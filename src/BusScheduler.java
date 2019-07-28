import java.util.Random;

public class BusScheduler implements Runnable {
    private SharedResources resources;
    private float ArrivalMeanTime = 20 * 60f * 1000;
    public static Random random;

    public BusScheduler(SharedResources resources) {
        this.resources = resources;
        random = new Random();
    }

    @Override
    public void run() {
        System.out.println("Bus scheduler start generating riders..");

        while (true) {
            try {
                float lambda = 1 / ArrivalMeanTime;
                Thread.sleep(Math.round(-Math.log(1 - random.nextFloat()) / lambda));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            new Thread(new Bus(resources)).start();
        }
    }
}
