package ru.lanit.ServletSpring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.lanit.ServletSpring.service.CarService;
import ru.lanit.ServletSpring.service.PersonService;

@RestController
@RequestMapping("/clear")
public class ClearController {

    PersonService personService;
    CarService carService;

    @Autowired
    public ClearController(PersonService personService, CarService carService) {
        this.personService = personService;
        this.carService = carService;
    }

    @GetMapping
    public HttpStatus delete() {
        personService.deleteAll();
        carService.deleteAll();
        return HttpStatus.OK;
    }
}
