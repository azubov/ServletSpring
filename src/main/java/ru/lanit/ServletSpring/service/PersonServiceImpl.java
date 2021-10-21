package ru.lanit.ServletSpring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.lanit.ServletSpring.dto.PersonWithCarsDto;
import ru.lanit.ServletSpring.model.Car;
import ru.lanit.ServletSpring.model.Person;
import ru.lanit.ServletSpring.repository.CarRepository;
import ru.lanit.ServletSpring.repository.PersonRepository;

import java.util.List;
import java.util.Optional;

@Service
public class PersonServiceImpl implements PersonService {

    private final PersonRepository personRepository;
    private final CarRepository carRepository;

    @Autowired
    public PersonServiceImpl(PersonRepository personRepository, CarRepository carRepository) {
        this.personRepository = personRepository;
        this.carRepository = carRepository;
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

    @Override
    public PersonWithCarsDto getPersonWithCars(Long id) {
        Person person = null;
        List<Car> cars = null;

        if (getPerson(id).isPresent()) {
            person = getPerson(id).get();
        } else {
            return null;
        }
        if (getCarList(id).isPresent()) {
            cars = getCarList(id).get();
            System.out.println(cars);
        } else {
            return null;
        }

        return new PersonWithCarsDto(person, cars);
    }

    private boolean alreadyExists(Person person) {
        return personRepository.existsById(person.getId());
    }

    private Optional<Person> getPerson(Long id) {
        return get(id);
    }

    private Optional<List<Car>> getCarList(Long id) {
        return carRepository.findAllCarsByOwnerId(id);
    }

}
