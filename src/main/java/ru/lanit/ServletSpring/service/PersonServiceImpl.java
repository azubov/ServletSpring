package ru.lanit.ServletSpring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.lanit.ServletSpring.model.Person;
import ru.lanit.ServletSpring.repository.PersonRepository;

import java.util.Optional;

@Service
public class PersonServiceImpl implements PersonService {

    private final PersonRepository personRepository;

    @Autowired
    public PersonServiceImpl(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @Override
    public Optional<Person> save(Person person) {
        if (!alreadyExists(person)) {
            return Optional.of(personRepository.save(person));
        }
        return Optional.empty();
    }

    @Override
    public Optional<Person> get(Long id) {
        return personRepository.findById(id);
    }

    private boolean alreadyExists(Person person) {
        return personRepository.existsById(person.getId());
    }
}
