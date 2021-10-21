package ru.lanit.ServletSpring.service;

import ru.lanit.ServletSpring.dto.PersonWithCarsDto;
import ru.lanit.ServletSpring.entity.Person;

import java.util.Optional;

public interface PersonService {

    Optional<Person> save(Person person);

    Optional<Person> get(Long id);

    Optional<PersonWithCarsDto> getPersonWithCars(Long id);

    void deleteAll();

}
