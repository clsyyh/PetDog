package org.PetDog.service.Impl;

import org.PetDog.dao.LoginDao;
import org.PetDog.dao.UserDao;
import org.PetDog.entity.Login;
import org.PetDog.entity.User;
import org.PetDog.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Transactional(propagation = Propagation.REQUIRED,isolation = Isolation.DEFAULT)
@Service("userService")
public class UserServiceImpl implements UserService{
    @Autowired
    private LoginDao loginDao;
    @Autowired
    private UserDao userDao;
    @Transactional(readOnly = true)
    public Login findUserByLoginnameAndPassword(String loginname, String password) {
        return loginDao.findByLoginnameAndPassword(loginname,password);
    }

    public int addLogin(Login login) {
        return loginDao.addLogin(login);
    }

    public int updatePwd(Login login) {
        return loginDao.updatePwd(login);
    }

    @Transactional(readOnly = true)
    public List<User> findAllUsers() {
        return userDao.findAllUsers();
    }
    @Transactional(readOnly = true)
    public User findUserById(Integer id) {
        return userDao.findUserById(id);
    }

    public User findUserByLoginname(String loginname) {
        return userDao.findUserByLoginname(loginname);
    }

    public int addUser(User user) {
        return userDao.addUser(user);
    }

    public int updateUser(User user) {
        return userDao.updateUser(user);
    }

    public int deleteUserById(Integer id) {
        return userDao.deleteUserById(id);
    }
}
