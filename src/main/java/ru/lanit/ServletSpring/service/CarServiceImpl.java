package ru.lanit.ServletSpring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.lanit.ServletSpring.model.Car;
import ru.lanit.ServletSpring.model.Person;
import ru.lanit.ServletSpring.repository.CarRepository;
import ru.lanit.ServletSpring.repository.PersonRepository;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Optional;

@Service
public class CarServiceImpl implements CarService {

    private final CarRepository carRepository;
    private final PersonRepository repository;

    @Autowired
    public CarServiceImpl(CarRepository carRepository, PersonRepository repository) {
        this.carRepository = carRepository;
        this.repository = repository;
    }

    @Override
    public Optional<Car> save(Car car) {
        if (!alreadyExists(car) && ownerIsValid(car.getOwnerId())) {
            return Optional.of(carRepository.save(car));
        }
        return Optional.empty();
    }

    @Override
    public Optional<Car> get(Long id) {
        return carRepository.findById(id);
    }

    private boolean alreadyExists(Car car) {
        return carRepository.existsById(car.getId());
    }

    private boolean ownerIsValid(Long ownerId) {
        if (repository.existsById(ownerId)) {
            Optional<Person> optionalPerson = repository.findById(ownerId);
            Person person = optionalPerson.get();
            LocalDate currentDate = LocalDate.now();
            return ChronoUnit.YEARS.between(person.getBirthdate(),currentDate) >= 18;
        }
        return false;
    }

}
