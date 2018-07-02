package org.PetDog.service;

import org.PetDog.entity.Address;

public interface AddressService {
    public Address findByBuyerId(Integer buyerId);
    public int addAddress(Address address);
}
