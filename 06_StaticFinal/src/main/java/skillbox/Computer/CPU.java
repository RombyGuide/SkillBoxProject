package skillbox.Computer;

public class CPU {
    private final double frequency;
    private final int numberOfCores;
    private final String manufacturer;
    private final double weight;

    public CPU() {
        this.frequency = 2.2;
        this.numberOfCores = 4;
        this.manufacturer = "USA";
        this.weight = 1.6;
    }

    public CPU(double frequency, int numberOfCores, String manufacturer, double weight) {
        this.frequency = frequency;
        this.numberOfCores = numberOfCores;
        this.manufacturer = manufacturer;
        this.weight = weight;
    }

    public CPU setFrequency(double frequency) {
        return new CPU(frequency, numberOfCores, manufacturer, weight);
    }

    public CPU setNumberOfCores(int numberOfCores) {
        return new CPU(frequency, numberOfCores, manufacturer, weight);
    }

    public CPU setManufacturer(String manufacturer) {
        return new CPU(frequency, numberOfCores, manufacturer, weight);
    }

    public CPU setWeight(double weight) {
        return new CPU(frequency, numberOfCores, manufacturer, weight);
    }

    public double getFrequency() {
        return frequency;
    }

    public int getNumberOfCores() {
        return numberOfCores;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public double getWeight() {
        return weight;
    }

    public String toString() {
        return "\n" + "Частота процессора - " + frequency + "\n" +
                "Количество ядер процессора - " + numberOfCores + "\n" +
                "Производитель процессора - " + manufacturer + "\n" +
                "Вес процессора - " + weight;
    }
}
