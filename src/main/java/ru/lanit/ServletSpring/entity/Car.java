package ru.lanit.ServletSpring.entity;

import ru.lanit.ServletSpring.dto.CarDto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
public class Car extends AbstractEntity {

    @NotNull
    @NotEmpty
    @Column
    private String vendor;

    @NotNull
    @NotEmpty
    @Column
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

    public Car(CarDto dto) {
        super.setId(dto.getId());
        parseVendorModel(dto.getModel());
        this.horsepower = dto.getHorsepower();
        this.ownerId = dto.getOwnerId();
    }

    private void parseVendorModel(String dtoModel) {
        int index = dtoModel.indexOf("-");
        this.vendor = dtoModel.substring(0, index);
        this.model = dtoModel.substring(index + 1);
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

    public String getVendor() {
        return vendor;
    }

    public void setVendor(String vendor) {
        this.vendor = vendor;
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
