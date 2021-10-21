package ru.lanit.ServletSpring.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ru.lanit.ServletSpring.model.Car;

import java.util.List;
import java.util.Optional;

@Repository
public interface CarRepository extends CrudRepository<Car, Long> {

    @Query("FROM Car WHERE ownerId=:id")
    Optional<List<Car>> findAllCarsByOwnerId(@Param("id") Long id);
}
