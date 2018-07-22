package async;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

/**
 * @author Alexander Naumov
 * @version 1.0
 * @date 22.07.18
 */

public class CompletableFutureTutorial5 {
    public static void main(String[] args) throws ExecutionException, InterruptedException {


        //In earlier examples, the Supplier function passed to thenApply() callback
        // would return a simple value but in this case, it is returning a CompletableFuture.
        CompletableFuture<Double> future = getUserDetails(7).thenCompose(user -> getCreditRating(user));
        System.out.println(future.get());
    }

    private static CompletableFuture<User> getUserDetails (int id) {
        return CompletableFuture.supplyAsync(() -> UserService.getById(id));
    }

    private static CompletableFuture<Double> getCreditRating (User user) {
        return CompletableFuture.supplyAsync(() -> CreditRatingService.getRating(user));
    }

    /*
       If your callback function returns a CompletableFuture,
       and you want a flattened result from the CompletableFuture chain
       (which in most cases you would), then use thenCompose().
    */
}
