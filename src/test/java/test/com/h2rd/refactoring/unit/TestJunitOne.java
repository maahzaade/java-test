package test.com.h2rd.refactoring.unit;

import com.h2rd.refactoring.usermanagement.User;
import com.h2rd.refactoring.usermanagement.UserDao;
import junit.framework.Assert;
import org.junit.Test;

import java.util.Arrays;

/**
 * Created by Mahdiye on 10/8/2018.
 */
public class TestJunitOne {

    UserDao userDao;

    @Test
    public void saveUserTest() {
        userDao = UserDao.getUserDao();

        User user = new User();
        user.setName("Fake Name");
        user.setEmail("fake@email.com");
        user.setRoles(Arrays.asList("admin", "master"));

        Assert.assertNotNull(userDao.saveUser(user));


        User foundUser = new User();
        for (User currentUser : userDao.getUsers()) {
            if (user.getName().equals("Fake Name")) {
                foundUser = currentUser;
            }
        }

        Assert.assertEquals(foundUser, user);

    }
}
