package ru.lanit.ServletSpring.service;

import ru.lanit.ServletSpring.model.Person;

import java.util.Optional;

public interface PersonService {

    Optional<Person> save(Person person);

    Optional<Person> get(Long id);

}
