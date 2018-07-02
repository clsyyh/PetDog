package org.PetDog.dao;

import org.PetDog.entity.Dog;
import org.PetDog.entity.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import javax.jws.soap.SOAPBinding;

import java.util.List;

import static org.junit.Assert.*;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring/spring-dao.xml"})
public class DogDaoTest {
    @Resource
    private DogDao dogDao;
    @Resource
    private UserDao userDao;
    @Test
    public void findAllDogs() throws Exception {
    }

    @Test
    public void fingDogById() throws Exception {
        Dog dog=dogDao.findDogById(1);
        System.out.println(dog.getName());
        User seller=dog.getSeller();
        System.out.println(seller.getName());
    }

    @Test
    public void addDog() throws Exception {
        User user=userDao.findUserById(1);
        Dog dog=new Dog();
        dog.setAge(1);
        dog.setArea("上海");
        dog.setHeight(30);
        dog.setKind("柯基");
        dog.setBloodline("纯种");
        dog.setName("匆匆");
        dog.setSex(0);
        dog.setVaccine("已打一针疫苗");
        dog.setWeight(20);
        dog.setSeller(user);
        dogDao.addDog(dog);
    }

    @Test
    public void deleteDogById() throws Exception {
    }

    @Test
    public void updateDog() throws Exception {
        Dog dog=dogDao.findDogById(3);
        dog.setName("淙淙");
        dogDao.updateDog(dog);
    }

    @Test
    public void findDogsByKind() throws Exception {

        List<Dog> dog = dogDao.findDogsByKindOrAreaOrPrice("哈士奇", "河北", 2500);
        System.out.println(dog.get(0).getName());
    }

}