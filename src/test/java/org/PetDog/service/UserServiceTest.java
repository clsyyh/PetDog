package org.PetDog.service;

import org.PetDog.entity.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

import static org.junit.Assert.*;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({
        "classpath:spring/spring-dao.xml",
        "classpath:spring/spring-service.xml"})
public class UserServiceTest {
    @Resource
    private UserService userService;
    @Test
    public void findUserByLoginnameAndPassword() throws Exception {
    }

    @Test
    public void findAllUsers() throws Exception {
    }

    @Test
    public void findUserById() throws Exception {
        User user=userService.findUserById(1);
        System.out.println(user.getName());
    }

    @Test
    public void addUser() throws Exception {
    }

    @Test
    public void updateUser() throws Exception {
    }

    @Test
    public void deleteUserById() throws Exception {
    }

}