package test.com.h2rd.refactoring.unit;

import com.h2rd.refactoring.usermanagement.User;
import com.h2rd.refactoring.usermanagement.UserDao;
import junit.framework.Assert;
import org.junit.Test;

import java.util.Arrays;

/**
 * Created by Mahdiye on 10/8/2018.
 */
public class TestJunitEight {

    UserDao userDao;

    @Test
    public void UpdateUserToAnExistingEmailTest() {

        userDao = UserDao.getUserDao();

        User user = new User();
        user.setName("XName");
        user.setEmail("XName@email.com");
        user.setRoles(Arrays.asList("admin", "master"));
        userDao.saveUser(user);

        user.setName("FakeName");
        user.setEmail("fake@email.com");
        user.setRoles(Arrays.asList("admin", "master"));

        Assert.assertNull(userDao.updateUser(user));

    }

}
