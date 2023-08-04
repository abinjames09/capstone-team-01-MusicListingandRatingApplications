package com.example.manymanyrelation;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface CarRepository  extends JpaRepository<Car,Integer>
{
    //  @Query("SELECT c FROM CAR c WHERE c.wheels BETWEEN :minWheels AND :maxWheels")
    //  public List<Car> findByAgeRange(@Param("minWheels") int minWheels, @Param("maxWheels") int maxWheels);

    @Query("SELECT c FROM Car c WHERE c.name= :name")
      List<Car> findByName( @Param("name") String name);

      @Query("SELECT c FROM Car c WHERE c.wheels > :wheels")
      List<Car> findByWheels( @Param("wheels") Double wheels);

}
