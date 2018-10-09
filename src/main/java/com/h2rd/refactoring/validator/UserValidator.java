package com.h2rd.refactoring.validator;

import com.h2rd.refactoring.usermanagement.User;
import com.h2rd.refactoring.usermanagement.UserDao;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

/**
 * Created by Mahdiye on 10/8/2018.
 */

@Component
public class UserValidator implements Validator {
    public boolean supports(Class<?> aClass) {
        return User.class.equals(aClass);
    }

    public void validate(Object userObj, Errors errors) {

        UserDao userDao = UserDao.getUserDao();

        User user = (User) userObj;

        if (user.getRoles() == null || user.getRoles().isEmpty()) {
            errors.reject("User with name " + user.getName() + " must own at least one role!");
        }

        for (User userEl : userDao.getUsers()) {
            if (userEl.getEmail().equals(user.getEmail())) {
                errors.reject("User with email " + user.getEmail() + " does already exist!");
            }
        }
    }

}
