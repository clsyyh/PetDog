package org.PetDog.dao;

import org.PetDog.entity.Login;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring/spring-dao.xml"})
public class LoginDaoTest {
    @Resource
    private LoginDao loginDao;
    @Test
    public void findByLoginnameAndPassword() throws Exception {
        Login login=loginDao.findByLoginnameAndPassword("亮亮","123456");
        System.out.println(login.getLoginname()+"==="+login.getPassword());
    }
    @Test
    public void  addLogin() throws Exception{
        Login login=new Login();
        login.setLoginname("张静");
        login .setPassword("zhangjing");
        loginDao.addLogin(login);
    }
}