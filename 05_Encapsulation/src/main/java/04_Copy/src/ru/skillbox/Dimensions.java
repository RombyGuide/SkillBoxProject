package ru.skillbox;

public class Dimensions {
    private final double wight;
    private final double height;
    private final double length;

    public Dimensions(double wight, double height, double length) {
        this.wight = wight;
        this.height = height;
        this.length = length;
    }

    public String cargoVolume() {
        return "Объём груза: " + (wight * height * length);
    }

    public double getWight() {
        return wight;
    }

    public double getHeight() {
        return height;
    }

    public double getLength() {
        return length;
    }

    public Dimensions setWight(double wight) {
        return new Dimensions(wight, height, length);
    }

    public Dimensions setHeight(double height) {
        return new Dimensions(wight, height, length);
    }

    public Dimensions setLength(double length) {
        return new Dimensions(wight, height, length);
    }

    public String toString() {
        return "\n" + "Ширина: " +
                wight + "\n" + "Высота: " +
                height + "\n" + "Длина: " + length;
    }
}
