package async;

import java.util.concurrent.*;

/**
 * @author Alexander Naumov
 * @version 1.0
 * @date 21.07.18
 */

public class FutureTutorial {
    public static void main(String[] args) throws ExecutionException, InterruptedException {

        // Executor service which include 4(cpu cores in my computer) threads for handling tasks.
        ExecutorService service = Executors.newFixedThreadPool(4);

        // Simple task that returns String object after 2 seconds.
        Callable<String> task = () -> {
            Thread.sleep(5000);
            return "Hello World. I learning asynchronous computations.";
        };

        // Entity that contains result which maybe don't computed yet.
        Future<String> future = service.submit(task);
        // if computations in future object are done, than return TRUE.
        int counter = 5;
        // while task inside executor service don't ready, don't ready, loop will perform.
        while (!future.isDone()) {
            System.out.println("Future object will be compute after "+ counter + " seconds.");
            Thread.sleep(1000);
            counter--;
        }
        // get() method blocks until the task is completed.
        System.out.println(future.get());
        service.shutdown();
    }
}
