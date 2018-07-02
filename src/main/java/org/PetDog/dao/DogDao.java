package org.PetDog.dao;

import org.PetDog.entity.Dog;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface DogDao {
    public List<Dog> findAllDogs();
    public Dog findDogById(Integer id);
    public int addDog(Dog dog);
    public int deleteDogById(Integer id);
    public int updateDog(Dog dog);
    public List<Dog> findDogsByKindOrAreaOrPrice(@Param("kind") String kind, @Param("area") String area,@Param("price") Integer price);
}
