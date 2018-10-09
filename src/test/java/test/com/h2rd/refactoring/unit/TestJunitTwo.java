package test.com.h2rd.refactoring.unit;

import com.h2rd.refactoring.usermanagement.User;
import com.h2rd.refactoring.usermanagement.UserDao;
import junit.framework.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

/**
 * Created by Mahdiye on 10/8/2018.
 */
public class TestJunitTwo {

    UserDao userDao;

    @Test
    public void FindUserTest() {
        userDao = UserDao.getUserDao();

        User user = new User();
        user.setName("Fake Name");
        user.setEmail("fake@email.com");
        user.setRoles(Arrays.asList("admin", "master"));

        List<User> foundUsers = userDao.findUser("Fake Name");

        User foundUser = new User();
        for (User currentUser : foundUsers) {
            if (currentUser.getName().equals("Fake Name") && currentUser.getEmail().equals("fake@email.com")) {
                foundUser = currentUser;
            }
        }

        Assert.assertEquals(foundUser, user);

    }

}
