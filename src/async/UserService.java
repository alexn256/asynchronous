package async;

/**
 * @author Alexander Naumov
 * @version 1.0
 * @date 22.07.18
 */

public class UserService {
    public static User getById(int id){
        return new User(id, "Alex");
    }
}
