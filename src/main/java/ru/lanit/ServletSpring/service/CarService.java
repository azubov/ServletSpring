package ru.lanit.ServletSpring.service;

import ru.lanit.ServletSpring.model.Car;

import java.util.Optional;

public interface CarService {

    Optional<Car> save(Car car);

    Optional<Car> get(Long id);

    Long countVendors();

}
