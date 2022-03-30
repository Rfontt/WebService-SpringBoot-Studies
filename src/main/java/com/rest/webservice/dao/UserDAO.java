package com.rest.webservice.dao;

import com.rest.webservice.bean.UserBean;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Component
public class UserDAO {
    private static List<UserBean> users = new ArrayList<>();
    private static int usersCount = 3;

    static {
        users.add(new UserBean(1, "Adam", new Date()));
        users.add(new UserBean(2, "Baron", new Date()));
        users.add(new UserBean(3, "Jada", new Date()));
    }

    public List<UserBean> findAll() {
        return users;
    }

    public UserBean save(UserBean user) {
        if (user.getId() == null) {
            user.setId(++usersCount);
        }

        users.add(user);

        return user;
    }

    public UserBean findOne(int id) {
        for (UserBean user : users) {
            if (user.getId() == id) {
                return user;
            }
        }

        return null;
    }
}
