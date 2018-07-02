package org.PetDog.dao;

import org.PetDog.entity.User;

import java.util.List;

public interface UserDao {
    public List<User> findAllUsers();
    public User findUserById(Integer id);
    public User findUserByLoginname(String loginname);
    public int addUser(User user);
    public int updateUser(User user);
    public int deleteUserById(Integer id);
}
