
import java.io.IOException;
import java.util.Random;
import java.util.concurrent.*;

public class CallableFuture {

    public static void main(String[] args) {
        ExecutorService executor = Executors.newCachedThreadPool();

        Future<Integer> future = executor.submit(new Callable<Integer>() {

            @Override
            public Integer call() throws Exception {
                Random random = new Random();
                int duration = random.nextInt(4000);

                if(duration > 2000) {
                    throw new IOException("\nSleeping for too long.");
                }

                System.out.println("\nStarting ...");

                try {
                    Thread.sleep(duration);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                System.out.println("Finished.");

                return duration;
            }

        });

        executor.shutdown();

        try {
            System.out.println("Result is: " + future.get()+ "\n");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {

            System.out.println(e.getMessage());
        }
    }

}