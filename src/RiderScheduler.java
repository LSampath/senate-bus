import java.util.Random;

public class RiderScheduler implements Runnable {
    private SharedResources resources;
    private float ArrivalMeanTime = 30f * 1000;
    public static Random random;

    public RiderScheduler(SharedResources resources) {
        this.resources = resources;
        random = new Random();
    }

    @Override
    public void run() {
        System.out.println("Rider scheduler start generating riders..");

        while (true) {
            new Thread(new Rider(resources)).start();
            try {
                float lambda = 1 / ArrivalMeanTime;
                Thread.sleep(Math.round(-Math.log(1 - random.nextFloat()) / lambda));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
