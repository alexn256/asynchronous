import java.util.concurrent.TimeUnit;

/**
 * @author Alexander Naumov
 * @version 1.0
 * @date 22.07.18
 */

public class LogicTask {

    private static int num = 0; // page number of book.
    private static int sum = 0; // sum of numbers.

    private static int getPageAmount(int N) {
        while (sum != N) {
            num++;
            if (num < 10) {
                sum += 1;
            }
            if (num >= 10 && num < 100) {
                sum +=2;
            }
            if (num >= 100 && num < 1000) {
                sum += 3;
            }
        }
        return num;
    }

    public static void main(String[] args) {
        final int N = 1095;
        System.out.println("the page - " + getPageAmount(N) + " has sum - " + N);
    }
}
