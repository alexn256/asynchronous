package async;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

/**
 * @author Alexander Naumov
 * @version 1.0
 * @date 21.07.18
 */

public class CompletableFutureTutorial {
    public static void main(String[] args) throws ExecutionException, InterruptedException {

        // Run task by Runnable object asynchronously.
        // runAsync() method is useful if you don't want return an result of task.
        CompletableFuture<Void> completableFuture = CompletableFuture.runAsync(() -> {
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("I'll run in a separate thread than the main thread.");
        });

        completableFuture.get();

        CompletableFuture<String> future = CompletableFuture.supplyAsync(() -> {
            try {
                TimeUnit.SECONDS.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return "Result of asynchronous computation.";
        });

        // block and get the result of the future.
        String value = future.get();
        // print the result of the future
        System.out.println(value);
    }
}
