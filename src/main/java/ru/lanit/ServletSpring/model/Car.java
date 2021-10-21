package ru.lanit.ServletSpring.model;

import ru.lanit.ServletSpring.validator.ModelVendorFormat;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Entity
public class Car extends AbstractEntity {

    @NotNull
    @Column
    @ModelVendorFormat
    private String model;

    @NotNull
    @Column
    @Min(1)
    private Integer horsepower;

    @NotNull
    @Column
    private Long ownerId;

    public Car() {
    }

    public Car(Long id, String model, Integer horsepower, Long ownerId) {
        super.setId(id);
        this.model = model;
        this.horsepower = horsepower;
        this.ownerId = ownerId;
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
                "id=" + super.getId() +
                ", model='" + model + '\'' +
                ", horsepower=" + horsepower +
                ", ownerId=" + ownerId +
                '}';
    }
}
