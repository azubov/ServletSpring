package ru.lanit.ServletSpring.model;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import java.time.LocalDate;

@Entity
public class Person extends AbstractEntity {

    @NotNull
    @Column
    private String name;

    @JsonFormat(pattern = "dd.MM.yyyy")
    @Past
    @NotNull
    @Column
    private LocalDate birthdate;

    public Person() {
    }

    public Person(Long id, String name, LocalDate birthdate) {
        super.setId(id);
        this.name = name;
        this.birthdate = birthdate;
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

    @Override
    public String toString() {
        return "Person{" +
                "id=" + super.getId() +
                ", name='" + name + '\'' +
                ", birthdate=" + birthdate +
                '}';
    }
}
