import com.example.practice.dao.UserDao;
import com.example.practice.dao.impl.UserDaoImpl;
import com.example.practice.exception.DaoException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.assertEquals;

public class UserDaoTests {
    private final UserDao userDao = UserDaoImpl.getInstance();

    @Test
    public void testSingletonPattern() {
        UserDao userDao1 = UserDaoImpl.getInstance();
        assertEquals(userDao, userDao1);
    }
    @Test
    public void testAuthenticationByUsernameAndPassword() throws DaoException {
        boolean authenticate = userDao.authenticate("user", "user");
        Assertions.assertTrue(authenticate);
    }
    @Test
    public void testAuthenticationByWrongUsernameAndPassword() throws DaoException {
        boolean authenticate = userDao.authenticate("user", "wrongPassword");
        Assertions.assertFalse(authenticate);
    }
}
