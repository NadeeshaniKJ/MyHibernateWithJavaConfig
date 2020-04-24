package com.kanchi.main;

import com.kanchi.dao.UserDaoImpl;
import com.kanchi.dto.User;

import java.util.List;

public class Main {
    public static void main(String[] args) {

        UserDaoImpl userDao = new UserDaoImpl();

        User user = new User(5, "nadeet");
        userDao.saveStudent(user);

        List<User> users = userDao.getUsers();
        for (User u : users) {
            System.out.println("user "+u);

        }
    }
}
