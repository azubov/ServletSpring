package ru.lanit.ServletSpring.dto;

import ru.lanit.ServletSpring.entity.Car;
import ru.lanit.ServletSpring.validator.ModelVendorFormat;

import javax.persistence.Id;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class CarDto {

    @Id
    @NotNull
    Long id;

    @NotNull
    @NotEmpty
    @ModelVendorFormat
    private String model;

    @NotNull
    @Min(1)
    private Integer horsepower;

    @NotNull
    private Long ownerId;

    public CarDto() {
    }

    public CarDto(Long id, String model, Integer horsepower, Long ownerId) {
        this.id = id;
        this.model = model;
        this.horsepower = horsepower;
        this.ownerId = ownerId;
    }

    public CarDto(Car car) {
        this.id = car.getId();
        this.model = car.getVendor() + "-" + car.getModel();
        this.horsepower = car.getHorsepower();
        this.ownerId = car.getOwnerId();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Integer getHorsepower() {
        return horsepower;
    }

    public void setHorsepower(Integer horsepower) {
        this.horsepower = horsepower;
    }

    public Long getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(Long ownerId) {
        this.ownerId = ownerId;
    }

    @Override
    public String toString() {
        return "Car{" +
                "id=" + id +
                ", model='" + model + '\'' +
                ", horsepower=" + horsepower +
                ", ownerId=" + ownerId +
                '}';
    }
}