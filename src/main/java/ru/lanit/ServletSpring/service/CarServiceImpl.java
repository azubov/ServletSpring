package ru.lanit.ServletSpring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.lanit.ServletSpring.dto.CarDto;
import ru.lanit.ServletSpring.entity.Car;
import ru.lanit.ServletSpring.entity.Person;
import ru.lanit.ServletSpring.repository.CarRepository;
import ru.lanit.ServletSpring.repository.PersonRepository;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Optional;

@Service
public class CarServiceImpl implements CarService {

    private final CarRepository carRepository;
    private final PersonRepository personRepository;

    @Autowired
    public CarServiceImpl(CarRepository carRepository, PersonRepository personRepository) {
        this.carRepository = carRepository;
        this.personRepository = personRepository;
    }

    @Override
    public Optional<Car> save(Car car) {
        if (validation(car)) {
            return Optional.of(carRepository.save(car));
        }
        return Optional.empty();
    }

    @Override
    public Optional<Car> get(Long id) {
        return carRepository.findById(id);
    }

    @Override
    public Long countVendors() {
        Long vendorCount;
        Optional<Long> optionalVendorCount = carRepository.vendorCount();
        if (optionalVendorCount.isPresent()) {
            vendorCount = optionalVendorCount.get();
            return vendorCount;
        } else {
            return 0L;
        }
    }

    @Override
    public void deleteAll() {
        carRepository.deleteAll();
    }

    @Override
    public Optional<CarDto> getDto(Car car) {
        return Optional.of(new CarDto(car));
    }

    private boolean validation(Car car) {
        return !alreadyExists(car) && ownerIsOfAge(car.getOwnerId());
    }

    private boolean alreadyExists(Car car) {
        return carRepository.existsById(car.getId());
    }

    private boolean ownerIsOfAge(Long ownerId) {
        if (ownerExists(ownerId)) {
            Optional<Person> optionalPerson = personRepository.findById(ownerId);
            Person person = optionalPerson.get();
            LocalDate currentDate = LocalDate.now();
            return ChronoUnit.YEARS.between(person.getBirthdate(),currentDate) >= 18;
        }
        return false;
    }

    private boolean ownerExists(Long id) {
        return personRepository.existsById(id);
    }
}
