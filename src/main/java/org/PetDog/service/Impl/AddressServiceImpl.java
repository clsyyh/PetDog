package org.PetDog.service.Impl;

import org.PetDog.dao.AddressDao;
import org.PetDog.entity.Address;
import org.PetDog.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service("addressService")
@Transactional(propagation = Propagation.REQUIRED,isolation = Isolation.DEFAULT)
public class AddressServiceImpl implements AddressService{
    @Autowired
    private AddressDao addressDao;
    @Transactional(readOnly = true)
    public Address findByBuyerId(Integer buyerId) {
        return addressDao.findByBuyerId(buyerId);
    }

    public int addAddress(Address address) {
        return addressDao.addAddress(address);
    }
}
