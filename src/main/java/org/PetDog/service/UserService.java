package org.PetDog.service;

import org.PetDog.entity.Login;
import org.PetDog.entity.User;

import java.util.List;

public interface UserService {
    public Login findUserByLoginnameAndPassword(String loginname,String password);
    public int addLogin(Login login);
    public int updatePwd(Login login);
    public List<User> findAllUsers();
    public User findUserById(Integer id);
    public User findUserByLoginname(String loginname);
    public int addUser(User user);
    public int updateUser(User user);
    public int deleteUserById(Integer id);
}
