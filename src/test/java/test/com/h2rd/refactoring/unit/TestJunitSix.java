package test.com.h2rd.refactoring.unit;

import com.h2rd.refactoring.usermanagement.UserDao;
import junit.framework.Assert;
import org.junit.Test;

/**
 * Created by Mahdiye on 10/8/2018.
 */
public class TestJunitSix {

    UserDao userDao;

    //What happened if the user does not exist
    @Test
    public void findNotExistedUserTest() {
        userDao = UserDao.getUserDao();
        Assert.assertNull(userDao.findUser("Fake Name"));
    }

}
