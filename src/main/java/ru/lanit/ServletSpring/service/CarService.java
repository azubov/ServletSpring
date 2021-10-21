package ru.lanit.ServletSpring.service;

import ru.lanit.ServletSpring.dto.CarDto;
import ru.lanit.ServletSpring.entity.Car;

import java.util.Optional;

public interface CarService {

    Optional<Car> save(Car car);

    Optional<Car> get(Long id);

    Long countVendors();

    void deleteAll();

    Optional<CarDto> getDto(Car car);

}
