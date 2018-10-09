package test.com.h2rd.refactoring.unit;

import com.h2rd.refactoring.usermanagement.User;
import com.h2rd.refactoring.usermanagement.UserDao;
import junit.framework.Assert;
import org.junit.Test;

import java.util.Arrays;

/**
 * Created by Mahdiye on 10/8/2018.
 */
public class TestJunitFive {

    UserDao userDao;

    @Test
    public void deleteUserTest() {
        userDao = UserDao.getUserDao();

        User user = new User();
        user.setName("Fake Name");
        user.setEmail("fake@email.com");
        user.setRoles(Arrays.asList("admin", "master"));

        Assert.assertTrue(userDao.deleteUser(user));
    }
}
