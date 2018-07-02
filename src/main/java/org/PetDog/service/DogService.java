package org.PetDog.service;

import org.PetDog.entity.Dog;

import java.util.List;

public interface DogService {
    public List<Dog> findAllDogs();
    public Dog findDogById(Integer id);
    public int addDog(Dog dog);
    public int deleteDogById(Integer id);
    public int updateDog(Dog dog);
    public List<Dog> findDogsByKindOrAreaOrPrice(String kind,String area,Integer price);

}
