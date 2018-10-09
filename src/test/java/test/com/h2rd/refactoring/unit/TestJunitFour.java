package test.com.h2rd.refactoring.unit;

import com.h2rd.refactoring.usermanagement.User;
import com.h2rd.refactoring.usermanagement.UserDao;
import junit.framework.Assert;
import org.junit.Test;

/**
 * Created by Mahdiye on 10/8/2018.
 */
public class TestJunitFour {

    UserDao userDao;

    //What happened if a user without any role be inserted
    @Test
    public void saveUserWithoutRoleTest() {
        userDao = UserDao.getUserDao();

        User user = new User();
        user.setName("UserWithoutRoleName");
        user.setEmail("UserWithoutRole@email.com");

        Assert.assertNull(userDao.saveUser(user));

    }

}
