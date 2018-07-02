package org.PetDog.service.Impl;

import org.PetDog.dao.OrderDao;
import org.PetDog.entity.DogOrder;
import org.PetDog.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("orderService")
@Transactional(propagation = Propagation.REQUIRED,isolation = Isolation.DEFAULT)
public class OrderServiceImpl implements OrderService{
    @Autowired
    private OrderDao orderDao;

    public int addOrder(DogOrder dogOrder) {
        return orderDao.addOrder(dogOrder);
    }

    public List<DogOrder> findAllOrders() {
        return orderDao.findAllOrders();
    }

    public List<DogOrder> findOrdersByBuyerId(Integer buyerId) {
        return orderDao.findOrdersByBuyerId(buyerId);
    }

    public List<DogOrder> findOrdersBySellerId(Integer sellerId) {
        return orderDao.findOrdersBySellerId(sellerId);
    }

    public List<DogOrder> findOrderByBuyerIdAndStatus(Integer buyerId, Integer Status) {
        return orderDao.findOrderByBuyerIdAndStatus(buyerId,Status);
    }

    public List<DogOrder> findOrderBySellerIdAndStatus(Integer sellerId, Integer Status) {
        return orderDao.findOrderBySellerIdAndStatus(sellerId,Status);
    }

    public int updateStatusById(Integer id) {
        return orderDao.updateStatusById(id);
    }
}
