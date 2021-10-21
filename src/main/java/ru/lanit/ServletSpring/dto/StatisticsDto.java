package ru.lanit.ServletSpring.dto;

public class StatisticsDto {

    private Long personCount;
    private Long carCount;
    private Long uniqueVendorCount;

    public StatisticsDto() {
    }

    public StatisticsDto(Long personCount, Long carCount, Long uniqueVendorCount) {
        this.personCount = personCount;
        this.carCount = carCount;
        this.uniqueVendorCount = uniqueVendorCount;
    }

    public Long getPersonCount() {
        return personCount;
    }

    public void setPersonCount(Long personCount) {
        this.personCount = personCount;
    }

    public Long getCarCount() {
        return carCount;
    }

    public void setCarCount(Long carCount) {
        this.carCount = carCount;
    }

    public Long getUniqueVendorCount() {
        return uniqueVendorCount;
    }

    public void setUniqueVendorCount(Long uniqueVendorCount) {
        this.uniqueVendorCount = uniqueVendorCount;
    }

    @Override
    public String toString() {
        return "StatisticsDto{" +
                "personcount=" + personCount +
                ", carcount=" + carCount +
                ", uniquevendorcount=" + uniqueVendorCount +
                '}';
    }
}
