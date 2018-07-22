package async;

/**
 * @author Alexander Naumov
 * @version 1.0
 * @date 22.07.18
 */

public class CreditRatingService {
    public static double getRating (User user) {
        if (user.getId() == 4) {
            return 5000.0;
        } else {
            return -2750.50;
        }
    }
}
