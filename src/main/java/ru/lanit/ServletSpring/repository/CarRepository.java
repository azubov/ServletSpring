package ru.lanit.ServletSpring.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.lanit.ServletSpring.model.Car;

@Repository
public interface CarRepository extends CrudRepository<Car, Long> {
}
