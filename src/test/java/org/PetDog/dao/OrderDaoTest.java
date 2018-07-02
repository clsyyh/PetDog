package org.PetDog.dao;

import org.PetDog.entity.Dog;
import org.PetDog.entity.DogOrder;
import org.PetDog.entity.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.omg.Messaging.SYNC_WITH_TRANSPORT;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring/spring-*.xml"})
public class OrderDaoTest {
    @Resource
    private OrderDao orderDao;
    @Resource
    private DogDao dogDao;
    @Test
    public void addOrder() throws Exception {
        Dog dog=dogDao.findDogById(6);
        DogOrder order=new DogOrder();

        order.setNumber("1204305809");
        order.setDeliverWay("自提");
        order.setDeliverPrice(0);
        order.setSumprice(2000);
        order.setPayWay("微信支付");

        order.setDog(dog);
        order.setSellerId(1);
        order.setBuyerId(2);

        order.setShr("");
        order.setShad("河北省石家庄市学府路57号");
        order.setTel("15264569870");

        orderDao.addOrder(order);
    }
    @Test
    public void findAllOrders()throws Exception{
        List<DogOrder> orders=orderDao.findAllOrders();
        for(DogOrder order:orders){
            System.out.println(order.getDeliverWay());
        }
    }
    @Test
    public void findOrdersByBuyerId()throws Exception{
        List<DogOrder> orders=orderDao.findOrdersByBuyerId(4);
        for(DogOrder order:orders){
            System.out.println(order.getShad());
        }
    }
    @Test
    public void findOrdersByBuyerIdAndStatus()throws Exception{
        List<DogOrder> orders=orderDao.findOrderByBuyerIdAndStatus(4,1);
        for(DogOrder order:orders){
            System.out.println(order.getDeliverWay());
        }
    }
    @Test
    public void updateStatusById() throws Exception{
        orderDao.updateStatusById(6);
    }
}