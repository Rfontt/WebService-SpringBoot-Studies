package com.rest.webservice.service;

import com.rest.webservice.bean.UserBean;
import com.rest.webservice.dao.UserDAO;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Service
public class UserService {
    UserDAO dao = new UserDAO();

    public UserBean save(UserBean user) {
        return dao.save(user);
    }

    public List<UserBean> listAll() {
        return dao.findAll();
    }

    public UserBean findOne(int id) {
        return dao.findOne(id);
    }
}
