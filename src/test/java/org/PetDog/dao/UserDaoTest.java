package org.PetDog.dao;

import org.PetDog.entity.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

import java.util.Date;

import static org.junit.Assert.*;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring/spring-dao.xml"})
public class UserDaoTest {
    @Resource
    private UserDao userDao;
    @Test
    public void findAllUsers() throws Exception {
    }

    @Test
    public void findUserById() throws Exception {
        User user=userDao.findUserById(1);
        String name=user.getName();
        System.out.println(name);
    }

    @Test
    public void addUser() throws Exception {
        User user=new User();
        user.setName("Cairo");
        user.setSex(1);
        user.setBirthday(new Date());
        user.setEmail("48687653@qq.com");
        user.setTel("18145039164");
        user.setWeChat("456201983");
        userDao.addUser(user);
    }

    @Test
    public void updateUser() throws Exception {
        User user=userDao.findUserById(2);
        user.setName("潇潇");
        userDao.updateUser(user);
    }

    @Test
    public void deleteUserById() throws Exception {
    }
    @Test
    public void findUserByLoginname() throws Exception{
        if(userDao.findUserByLoginname("黎明")==null) {
            System.out.println("fghfgk");
        }
    }
}