package ru.lanit.ServletSpring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.lanit.ServletSpring.errors.ErrorType;
import ru.lanit.ServletSpring.dto.CarDto;
import ru.lanit.ServletSpring.exception.BadRequestException;
import ru.lanit.ServletSpring.entity.Car;
import ru.lanit.ServletSpring.service.CarService;

import javax.validation.Valid;

@RestController
@RequestMapping(value = "/car")
public class CarController {

    private final CarService service;

    @Autowired
    public CarController(CarService service) {
        this.service = service;
    }

    // get dto
    // save car with vendor-model
    // return dto of that car

    @PostMapping
    public ResponseEntity<CarDto> save(@Valid @RequestBody CarDto dto) {
        Car car = new Car(dto);
        service.save(car);
        if (service.save(car).isPresent()) {
            return (ResponseEntity<CarDto>) new ResponseEntity(service.getDto(car), HttpStatus.OK);
        } else {
            throw new BadRequestException(String.format(ErrorType.ENTITY_NOT_SAVED.getDescription(), car));
        }
    }

    @GetMapping
    public ResponseEntity<Car> get(@RequestParam Long id) {
        return service.get(id).map(p -> new ResponseEntity<>(p, HttpStatus.OK))
                .orElseThrow(() -> new BadRequestException(
                        String.format(ErrorType.ENTITY_NOT_FOUND.getDescription(), id)
                ));
    }

}
