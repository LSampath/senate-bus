public class Assignment {

    private void startProgram() {
        System.out.println("Program started.");

        SharedResources resources = new SharedResources();

        Thread busScheduler = new Thread(new BusScheduler(resources));
        Thread riderScheduler = new Thread(new RiderScheduler(resources));

        busScheduler.start();
        riderScheduler.start();

        try {
            busScheduler.join();
            riderScheduler.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Program terminated");
    }

    public static void main(String[] args) {
        new Assignment().startProgram();
    }
}
