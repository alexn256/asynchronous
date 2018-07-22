package async;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

/**
 * @author Alexander Naumov
 * @version 1.0
 * @date 22.07.18
 */

public class CompletableFutureTutorial4 {
    public static void main(String[] args) throws ExecutionException, InterruptedException {

        // thenApplyAsync() will be executed in different thread, obtained from ForkJoinPool.
        CompletableFuture<String> future = CompletableFuture.supplyAsync(() -> "RESULT");

        future.thenApplyAsync(result -> {
            System.out.println(Thread.currentThread().getName());
            return result + " additional information.";
        });

        TimeUnit.SECONDS.sleep(3);

        System.out.println(future.get() + " " + Thread.currentThread().getName());
    }
}
