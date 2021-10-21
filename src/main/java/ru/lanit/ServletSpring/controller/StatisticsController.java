package ru.lanit.ServletSpring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ru.lanit.ServletSpring.dto.StatisticsDto;
import ru.lanit.ServletSpring.repository.CarRepository;
import ru.lanit.ServletSpring.repository.PersonRepository;
import ru.lanit.ServletSpring.service.CarService;

@RestController
@RequestMapping("/statistics")
public class StatisticsController {

    PersonRepository personRepository;
    CarRepository carRepository;
    CarService carService;

    @Autowired
    public StatisticsController(PersonRepository personRepository, CarRepository carRepository, CarService carService) {
        this.personRepository = personRepository;
        this.carRepository = carRepository;
        this.carService = carService;
    }

    @GetMapping
    public ResponseEntity<StatisticsDto> get() {
        System.out.println("Hello from statistics");

        Long personCount = personRepository.count();
        System.out.println(personCount);

        Long carCount = carRepository.count();
        System.out.println(carCount);

        Long uniqueVendorCount = carService.countVendors();
        System.out.println(uniqueVendorCount);

        StatisticsDto statistics = new StatisticsDto(personCount, carCount, uniqueVendorCount);
        System.out.println(statistics);

        return new ResponseEntity<StatisticsDto>(statistics, HttpStatus.OK);
    }

}
