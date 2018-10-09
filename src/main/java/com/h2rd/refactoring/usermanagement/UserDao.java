package com.h2rd.refactoring.usermanagement;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class UserDao {


    //CopyOnWriteArrayList is synchronized so it is safe it to use in multithreaded environment
    private CopyOnWriteArrayList<User> users;

    //Lazy initialization method to implement Singleton pattern, some people name it anti-pattern though
    private static UserDao userDao;


    public static UserDao getUserDao() {
        if (userDao == null) {
            userDao = new UserDao();
        }
        return userDao;
    }

    public User saveUser(User user) {
        if (users == null) {
            users = new CopyOnWriteArrayList<User>();
        }


        //validate to check having at least one role
        if (user.getRoles() == null || user.getRoles().isEmpty()) {
            System.out.println("User with name " + user.getName() + " must own at least one role!");
            return null;
        }

        //validate Email uniquness
        for (User userEl : users) {
            if (userEl.getEmail().equals(user.getEmail())) {
                System.out.println("User with email " + user.getEmail() + " does already exist!");
                return null;
            }
        }
        users.add(user);
        return user;
    }

    public List<User> getUsers() {
        //write maintainable codes
        if (users == null) {
            users = new CopyOnWriteArrayList<User>();
        }
        return users;
    }

    public boolean deleteUser(User userToDelete) {
        for (User user : users) {
            //Each user needs to be removed only by one thread at a time
            synchronized (this) {
                if (user.getName().equals(userToDelete.getName())) {
                    users.remove(user);
                    return true;
                }
            }
        }
        return false;
    }

    public User updateUser(User userToUpdate) {
        //validate to check having at least one role
        if (userToUpdate.getRoles() == null || userToUpdate.getRoles().isEmpty()) {
            System.out.println("User with name " + userToUpdate.getName() + " must own at least one role!");
            return null;
        }

        //validate Email uniquness
        for (User userEl : users) {
            if (userEl.getEmail().equals(userToUpdate.getEmail())) {
                System.out.println("User with email " + userToUpdate.getEmail() + " does already exist!");
                return null;
            }
        }
        for (User user : users) {
            //this block needs to be done only by one thread at a time
            synchronized (this) {
                if (user.getName().equals(userToUpdate.getName())) {
                    user.setEmail(userToUpdate.getEmail());
                    user.setRoles(userToUpdate.getRoles());
                }
            }
        }
        return userToUpdate;
    }

    public List<User> findUser(String name) {
        List<User> userList = new CopyOnWriteArrayList<User>();
        for (User user : users) {
            if (user.getName().equals(name)) {
                userList.add(user);
            }
        }

        if (!userList.isEmpty()) {
            return userList;
        } else
            return null;
    }
}
