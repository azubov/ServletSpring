package ru.lanit.ServletSpring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.lanit.ServletSpring.dto.PersonWithCarsDto;
import ru.lanit.ServletSpring.exception.BadRequestException;
import ru.lanit.ServletSpring.exception.NotFoundException;
import ru.lanit.ServletSpring.entity.Person;
import ru.lanit.ServletSpring.service.PersonService;
import ru.lanit.ServletSpring.base.ErrorType;

import javax.validation.Valid;

@RestController
@RequestMapping
public class PersonController {

    private final PersonService service;

    @Autowired
    public PersonController(PersonService service) {
        this.service = service;
    }

    @PostMapping(value = "/person")
    public ResponseEntity<Person> save(@Valid @RequestBody Person person) {
        return service.save(person).map(p -> new ResponseEntity<>(p, HttpStatus.OK))
                .orElseThrow(() -> new BadRequestException(
                        String.format(ErrorType.ENTITY_NOT_SAVED.getDescription(), person)
                ));
    }

    @GetMapping(value = "/person")
    public ResponseEntity<Person> get(@RequestParam Long id) {
        return service.get(id).map(p -> new ResponseEntity<>(p, HttpStatus.OK))
                .orElseThrow(() -> new BadRequestException(
                        String.format(ErrorType.ENTITY_NOT_FOUND.getDescription(), id)
                ));
    }

    @GetMapping(value = "/personwithcars")
    public ResponseEntity<PersonWithCarsDto> getPersonWithCars(@RequestParam(name = "personid") Long id) {
        PersonWithCarsDto personWithCars = service.getPersonWithCars(id);
        if (personWithCars != null) {
            return new ResponseEntity<PersonWithCarsDto>(personWithCars, HttpStatus.OK);
        } else {
            throw new NotFoundException(String.format(ErrorType.ENTITY_NOT_FOUND.getDescription(), id));
        }
    }
}
