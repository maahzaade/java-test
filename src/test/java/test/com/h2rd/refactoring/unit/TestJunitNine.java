package test.com.h2rd.refactoring.unit;

import com.h2rd.refactoring.usermanagement.User;
import com.h2rd.refactoring.usermanagement.UserDao;
import org.junit.Test;

/**
 * Created by Mahdiye on 10/8/2018.
 */
public class TestJunitNine {

    UserDao userDao;

    @Test
    public void UpdateToViolateTheRoleRuleTest() {
        userDao = UserDao.getUserDao();

        User user = new User();
        user.setName("FakeName");
        user.setEmail("fake@email.com");

        userDao.updateUser(user);
    }

}
