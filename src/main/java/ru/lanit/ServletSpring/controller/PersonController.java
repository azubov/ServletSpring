package ru.lanit.ServletSpring.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;
import ru.lanit.ServletSpring.dto.PersonWithCarsDto;
import ru.lanit.ServletSpring.exception.CustomException;
import ru.lanit.ServletSpring.model.Person;
import ru.lanit.ServletSpring.service.PersonService;
import ru.lanit.ServletSpring.base.ErrorType;

import javax.validation.Valid;

@RestController
@RequestMapping
public class PersonController {

    private static final Logger logger = LoggerFactory.getLogger(PersonController.class);
    private final PersonService service;

    @Autowired
    public PersonController(PersonService service) {
        this.service = service;
    }

    @PostMapping(value = "/person")
    public ResponseEntity<Person> save(@Valid @RequestBody Person person) {
        logger.info("hello from save");
        logger.info("Received new person \n" + person.toString());

        return service.save(person).map(p -> new ResponseEntity<>(p, HttpStatus.OK))
                .orElseThrow(() -> new CustomException(
                        String.format(ErrorType.ENTITY_NOT_SAVED.getDescription(), person)
                ));
    }

    @GetMapping(value = "/person")
    public ResponseEntity<Person> get(@RequestParam Long id) {
        logger.info("hello from get");
        return service.get(id).map(p -> new ResponseEntity<>(p, HttpStatus.OK))
                .orElseThrow(() -> new CustomException(
                        String.format(ErrorType.ENTITY_NOT_FOUND.getDescription(), id)
                ));
    }

    @GetMapping(value = "/personwithcars")
    public ResponseEntity<PersonWithCarsDto> getPersonWithCars(@RequestParam(name = "personid") Long id) {
        logger.info("hello from personwithcars");
        PersonWithCarsDto personWithCars = service.getPersonWithCars(id);
        System.out.println(personWithCars);
        if (personWithCars != null) {
            return new ResponseEntity<PersonWithCarsDto>(personWithCars, HttpStatus.OK);
        } else {
            throw new CustomException(String.format(ErrorType.ENTITY_NOT_FOUND.getDescription(), id));
        }
    }
}
