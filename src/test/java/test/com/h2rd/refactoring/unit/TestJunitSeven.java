package test.com.h2rd.refactoring.unit;

import com.h2rd.refactoring.usermanagement.User;
import com.h2rd.refactoring.usermanagement.UserDao;
import junit.framework.Assert;
import org.junit.Test;

import java.util.Arrays;

/**
 * Created by Mahdiye on 10/8/2018.
 */
public class TestJunitSeven {

    UserDao userDao;

    @Test
    public void UpdateUserTest() {
        userDao = UserDao.getUserDao();

        User user = new User();
        user.setName("FakeName");
        user.setEmail("FakeName@email.com");
        user.setRoles(Arrays.asList("adminChanged", "masterChanged"));

        User updatedUser = userDao.updateUser(user);

        Assert.assertEquals(updatedUser, user);
    }

}
