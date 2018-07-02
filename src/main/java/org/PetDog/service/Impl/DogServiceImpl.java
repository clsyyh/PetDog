package org.PetDog.service.Impl;

import org.PetDog.dao.DogDao;
import org.PetDog.entity.Dog;
import org.PetDog.service.DogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Transactional(propagation = Propagation.REQUIRED,isolation = Isolation.DEFAULT)
@Service("dogService")
public class DogServiceImpl implements DogService{
    @Autowired
    private DogDao dogDao;
    @Transactional(readOnly = true)
    public List<Dog> findAllDogs() {
        return dogDao.findAllDogs();
    }
    @Transactional(readOnly = true)
    public Dog findDogById(Integer id) {
        return dogDao.findDogById(id);
    }

    public int addDog(Dog dog) {
        return dogDao.addDog(dog);
    }

    public int deleteDogById(Integer id) {
        return dogDao.deleteDogById(id);
    }

    public int updateDog(Dog dog) {
        return dogDao.updateDog(dog);
    }

    @Transactional(readOnly = true)
    public List<Dog> findDogsByKindOrAreaOrPrice(String kind,String area,Integer price) {
        return dogDao.findDogsByKindOrAreaOrPrice(kind,area,price);
    }
}
