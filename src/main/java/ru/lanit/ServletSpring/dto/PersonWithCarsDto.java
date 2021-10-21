package ru.lanit.ServletSpring.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.sun.istack.NotNull;
import ru.lanit.ServletSpring.entity.Car;
import ru.lanit.ServletSpring.entity.Person;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class PersonWithCarsDto {

    @NotNull
    private Long id;

    @NotNull
    private String name;

    @JsonFormat(pattern = "dd.MM.yyyy")
    private LocalDate birthdate;

    private List<Car> cars;

    public PersonWithCarsDto() {
    }

    public PersonWithCarsDto(Person person, List<Car> cars) {
        this.id = person.getId();
        this.name = person.getName();
        this.birthdate = person.getBirthdate();
        if (cars == null) {
            this.cars = new ArrayList<>();
        } else {
            this.cars = cars;
        }
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(LocalDate birthdate) {
        this.birthdate = birthdate;
    }

    public List<Car> getCars() {
        return cars;
    }

    public void setCars(List<Car> cars) {
        this.cars = cars;
    }

    @Override
    public String toString() {
        return "PersonWithCarsDto{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", birthdate=" + birthdate +
                ", cars=" + cars +
                '}';
    }
}
