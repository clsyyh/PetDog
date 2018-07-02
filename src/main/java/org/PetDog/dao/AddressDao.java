package org.PetDog.dao;

import org.PetDog.entity.Address;

public interface AddressDao {
    public Address findByBuyerId(Integer buyerId);
    public int addAddress(Address address);
}
