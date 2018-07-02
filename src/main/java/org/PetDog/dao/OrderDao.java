package org.PetDog.dao;

import org.PetDog.entity.DogOrder;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface OrderDao {
    public int addOrder(DogOrder dogOrder);
    public List<DogOrder> findAllOrders();
    public List<DogOrder> findOrdersByBuyerId(Integer buyerId);
    public List<DogOrder> findOrdersBySellerId(Integer sellerId);
    public  List<DogOrder> findOrderByBuyerIdAndStatus(Integer buyerId,Integer Status);
    public  List<DogOrder> findOrderBySellerIdAndStatus(Integer sellerId,Integer Status);
    public  int updateStatusById(Integer id);
}
