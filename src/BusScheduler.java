import java.util.Random;

public class BusScheduler implements Runnable {
    private SharedResources resources;
    private float ArrivalMeanTime = 20 * 60f * 1000;
    public static Random randomBus;

    public BusScheduler(SharedResources resources) {
        this.resources = resources;
        randomBus = new Random();
    }

    @Override
    public void run() {
        System.out.println("Bus scheduler start generating riders..");

        while (true) {

            new Thread(new Bus(resources)).start();
            try {
                float lambda = 1 / ArrivalMeanTime;

               //Sleeping threads to obtain inter-arrival mean time of buses.
                Thread.sleep(Math.round(-Math.log(1 - randomBus.nextFloat()) / lambda));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
