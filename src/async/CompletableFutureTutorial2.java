package async;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

/**
 * @author Alexander Naumov
 * @version 1.0
 * @date 22.07.18
 */

public class CompletableFutureTutorial2 {
    public static void main(String[] args) throws ExecutionException, InterruptedException {

        CompletableFuture<String> whatsYrNameFuture = CompletableFuture.supplyAsync(() -> {
            try {
                TimeUnit.SECONDS.sleep(3);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return "Alex";
        });

        // attach callback to the Future
        CompletableFuture<String> future = whatsYrNameFuture.thenApply(name -> "Hello " + name);

        // black and get result of the future.
        System.out.println(future.get());


        // attaching series of callback methods.
        CompletableFuture<String> welcomeText = CompletableFuture.supplyAsync(() -> {
            try {
                TimeUnit.SECONDS.sleep(5);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return "Alex";
        }).thenApply(name -> "Hello " + name)
                .thenApply(greeting -> greeting + ". Welcome to the world of asynchronous computations!");

        System.out.println(welcomeText.get());
    }
}
