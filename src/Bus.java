public class Bus implements Runnable {
    private SharedResources resources;

    public Bus(SharedResources resources) {
        this.resources = resources;
    }

    private void depart(int riders, int left) {
        System.out.println("    BUS : departed with " + riders + " riders, and " + left + " are left.");
    }

    @Override
    public void run() {
        int riders;
        int left;
        System.out.println("BUS : start running");

        synchronized (resources.lock) {
            riders = Math.min(resources.waiting, 50);

            for (int i=0; i<riders; i++) {
                try {
                    resources.bus.release();
                    resources.boarded.acquire();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            left = Math.max(resources.waiting-50, 0);
            resources.waiting = left;
        }

        depart(riders, left);
    }
}
