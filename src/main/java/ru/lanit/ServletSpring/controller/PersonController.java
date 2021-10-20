package ru.lanit.ServletSpring.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.lanit.ServletSpring.exception.CustomException;
import ru.lanit.ServletSpring.model.Person;
import ru.lanit.ServletSpring.service.PersonService;
import ru.lanit.ServletSpring.base.ErrorType;

import javax.validation.Valid;

@RestController
@RequestMapping(value = "/person")
public class PersonController {

    private static final Logger logger = LoggerFactory.getLogger(PersonController.class);
    private final PersonService service;

    @Autowired
    public PersonController(PersonService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<Person> save(@Valid @RequestBody Person person) {
        logger.info("hello from save");
        logger.info("Received new person \n" +
                "id: " + person.getId() + " name: " + person.getName() + " birthdate: " + person.getBirthdate());

        return service.save(person).map(p -> new ResponseEntity<>(p, HttpStatus.OK))
                .orElseThrow(() -> new CustomException(
                        String.format(ErrorType.ENTITY_NOT_SAVED.getDescription(), person)
                ));
    }

    @GetMapping
    public ResponseEntity<Person> get(@RequestParam Long id) {
        logger.info("hello from get");
        return service.get(id).map(p -> new ResponseEntity<>(p, HttpStatus.OK))
                .orElseThrow(() -> new CustomException(
                        String.format(ErrorType.ENTITY_NOT_FOUND.getDescription(), id)
                ));
    }

}
