package ru.lanit.ServletSpring.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.sun.istack.NotNull;

import java.time.LocalDate;

public class PersonDto {

    @NotNull
    private Long id;

    @NotNull
    private String name;

    @JsonFormat(pattern = "dd.MM.yyyy")
    private LocalDate birthdate;

    public PersonDto() {
    }

    public PersonDto(Long personid, String name, LocalDate birthdate) {
        this.id = personid;
        this.name = name;
        this.birthdate = birthdate;
    }

    public Long getPersonid() {
        return id;
    }

    public String getName() {
        return name;
    }

    public LocalDate getBirthdate() {
        return birthdate;
    }

    @Override
    public String toString() {
        return "PersonDto{" +
                "personid=" + id +
                ", name='" + name + '\'' +
                ", birthdate=" + birthdate +
                '}';
    }
}
