package ru.skillbox;

public class CargoStorage {
    private final Dimensions dimensions;
    private final double weight;
    private final String deliveryAddress;
    private final boolean property;
    private final String registrationNumber;
    private final boolean fragileCargo;

    public CargoStorage(Dimensions dimensions) {
        this.dimensions = dimensions;
        this.weight = 1.5;
        this.deliveryAddress = "Moscow";
        this.property = false;
        this.registrationNumber = "№718";
        this.fragileCargo = true;
    }

    public CargoStorage(Dimensions dimensions, double weight, String deliveryAddress,
                        boolean property, String registrationNumber, boolean fragileCargo) {
        this.dimensions = dimensions;
        this.weight = weight;
        this.deliveryAddress = deliveryAddress;
        this.property = property;
        this.registrationNumber = registrationNumber;
        this.fragileCargo = fragileCargo;
    }

    public CargoStorage setDimensions(Dimensions dimensions) {
        return new CargoStorage(dimensions, weight, deliveryAddress, property, registrationNumber, fragileCargo);
    }

    public CargoStorage setWeight(double weight) {
        return new CargoStorage(dimensions, weight, deliveryAddress, property, registrationNumber, fragileCargo);
    }

    public CargoStorage setDeliveryAddress(String deliveryAddress) {
        return new CargoStorage(dimensions, weight, deliveryAddress, property, registrationNumber, fragileCargo);
    }

    public CargoStorage setProperty(boolean property) {
        return new CargoStorage(dimensions, weight, deliveryAddress, property, registrationNumber, fragileCargo);
    }

    public CargoStorage setRegistrationNumber(String registrationNumber) {
        return new CargoStorage(dimensions, weight, deliveryAddress, property, registrationNumber, fragileCargo);
    }

    public CargoStorage setFragileCargo(boolean fragileCargo) {
        return new CargoStorage(dimensions, weight, deliveryAddress, property, registrationNumber, fragileCargo);
    }

    public Dimensions getDimensions() {
        return dimensions;
    }

    public double getWeight() {
        return weight;
    }

    public String getDeliveryAddress() {
        return deliveryAddress;
    }

    public boolean isProperty() {
        return property;
    }

    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public boolean isFragileCargo() {
        return fragileCargo;
    }

    public String toString() {
        return "Габариты: " + dimensions + "\n" +
                "масса: " + weight + "\n" +
                "Адрес доставки: " + deliveryAddress + "\n" +
                "Регистрационный номер: " + registrationNumber + "\n";
    }
}
