package ru.lanit.ServletSpring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.lanit.ServletSpring.base.ErrorType;
import ru.lanit.ServletSpring.exception.CustomException;
import ru.lanit.ServletSpring.model.Car;
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

    @PostMapping
    public ResponseEntity<Car> save(@Valid @RequestBody Car car) {
        return service.save(car).map(p -> new ResponseEntity<>(p, HttpStatus.OK))
                .orElseThrow(() -> new CustomException(
                        String.format(ErrorType.ENTITY_NOT_SAVED.getDescription(), car)
                ));
    }

    @GetMapping
    public ResponseEntity<Car> get(@RequestParam Long id) {
        return service.get(id).map(p -> new ResponseEntity<>(p, HttpStatus.OK))
                .orElseThrow(() -> new CustomException(
                        String.format(ErrorType.ENTITY_NOT_FOUND.getDescription(), id)
                ));
    }

}
