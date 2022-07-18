package ru.skillbox;

public class Elevator {
    private int currentFloor = 1;
    private int minFloor = 0;
    private int maxFloor = 0;

    public Elevator(int minFloor, int maxFloor) {
        this.minFloor = minFloor;
        this.maxFloor = maxFloor;
    }

    public int getCurrentFloor() {
        return currentFloor;
    }

    public void moveDown() {
        currentFloor--;
    }

    public void moveUp() {
        currentFloor++;
    }

    public void printOne() {
        System.out.println("Неверный этаж");
    }

    public void printTwo() {
        System.out.println("Текущий этаж: " + currentFloor);
    }

    public void move(int floor) {
       while (currentFloor != floor) {
           if (floor < minFloor) {
               printOne();
               return;
           } else if (floor > maxFloor) {
               printOne();
               return;
           } else if (currentFloor < floor) {
               printTwo();
               moveUp();
           } else if (currentFloor > floor) {
               printTwo();
               moveDown();
           }
       }
    }
}
