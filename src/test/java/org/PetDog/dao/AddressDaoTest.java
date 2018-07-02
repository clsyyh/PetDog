package org.PetDog.dao;

import org.PetDog.entity.Address;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

import static org.junit.Assert.*;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring/spring-dao.xml"})
public class AddressDaoTest {
    @Resource
    private AddressDao addressDao;
    @Test
    public void findByBuyerId() throws Exception {
    }

    @Test
    public void addAddress() throws Exception {
        Address address=new Address();
        address.setBuyerId(2);
        address.setArea("河北省石家庄市");
        address.setDetail("新华区学府路57街道");
        address.setTel("15124893250");
        addressDao.addAddress(address);
    }

}