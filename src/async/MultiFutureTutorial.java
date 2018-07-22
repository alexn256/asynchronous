package async;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.*;

/**
 * @author Alexander Naumov
 * @version 1.0
 * @date 21.07.18
 */

public class MultiFutureTutorial {
    public static void main(String[] args) throws InterruptedException, ExecutionException {

        // create simple thread pool of 4(cpu cores in my computer) thread.
        ExecutorService service = Executors.newFixedThreadPool(4);

        // create few(3) different Callable objects that represents tasks.
        Callable<String> task1 = () -> {
            Thread.sleep(1000);
            return "!";
        };

        Callable<String> task2 = () -> {
            Thread.sleep(4000);
            return "World";
        };

        Callable<String> task3 = () -> {
            Thread.sleep(2000);
            return "Hello";
        };

        // in order to construct list from these tasks, used Arrays class.
        List<Callable<String>> tasksList = Arrays.asList(task3, task2, task1);
        // in order to construct list of Future objects, used invokeAll() method of thread pool object.
        List<Future<String>> futuresList = service.invokeAll(tasksList);

        for (Future future: futuresList){
            // print into console obtained result.
            System.out.print(future.get() + " ");
        }

        service.shutdown();
    }
}
