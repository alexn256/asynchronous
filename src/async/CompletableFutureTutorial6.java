package async;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

/**
 * @author Alexander Naumov
 * @version 1.0
 * @date 22.07.18
 */

public class CompletableFutureTutorial6 {
    public static void main(String[] args) throws ExecutionException, InterruptedException {

        System.out.println("Retrieving weight...");
        // retrieving weight.
        CompletableFuture<Double> weightInKgFuture = CompletableFuture.supplyAsync(() -> {
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return 94.5;
        });

        System.out.println("Retrieving height...");
        // retrieving height...
        CompletableFuture<Double> heightInCmFuture = CompletableFuture.supplyAsync(() -> {
           try {
               TimeUnit.SECONDS.sleep(2);
           } catch (InterruptedException e) {
               e.printStackTrace();
           }
           return 192.8;
        });

        System.out.println("Calculating BMI...");
        // calculating BMI...
        CompletableFuture<Double> combineFuture = weightInKgFuture.thenCombine(heightInCmFuture, (weightInKg, heightInCm) -> {
            Double heightInMeter = heightInCm / 100;
            return weightInKg / (heightInMeter * heightInMeter);
        });

        System.out.println("Your BMI is - " + combineFuture.get());
    }
}
