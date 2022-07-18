package ru.skillbox;

import java.awt.*;

public class Main {

    public static void main(String[] args) {
        Dimensions dimensions = new Dimensions(1,2,3);
        System.out.println(dimensions.cargoVolume() + "\n");

        CargoStorage cargoStorage = new CargoStorage(dimensions);
        System.out.println("Оригинал " + "\n" + cargoStorage);

        CargoStorage copy = new CargoStorage(dimensions, 2, "Moscow",
                true, "USB1.1", true);

        System.out.println("Копия " + "\n" + copy);
    }
}
