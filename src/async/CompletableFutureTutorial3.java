package async;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

/**
 * @author Alexander Naumov
 * @version 1.0
 * @date 22.07.18
 */

public class CompletableFutureTutorial3 {
    public static void main(String[] args) throws ExecutionException, InterruptedException {

        // construct Future object, doing some computation and print these into console.
        CompletableFuture<Void> completableFuture = CompletableFuture.supplyAsync(() ->{
            return ProductService.getProductDetails(7);
        }).thenAccept(info -> {
            System.out.println(info);
        });

        completableFuture.get();

        // construct Future object, without access to result of the Future object after attaching.
        CompletableFuture<Void> voidCompletableFuture = CompletableFuture.supplyAsync(() -> {
            try {
                TimeUnit.SECONDS.sleep(5);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return "RESULT";
        }).thenRun(() -> System.out.println("computation is compete."));

        voidCompletableFuture.get();

        /* in all above cases, task is executed in same thread where supplyAsync() is executed,
           or in the main thread if the task completes immediately. */
    }
}
