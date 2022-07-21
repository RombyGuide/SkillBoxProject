package practice.reverseArray;

public class Main {
    public static void main(String[] args) {
        String line = "Каждый охотник желает знать, где сидит фазан";
        ReverseArray reverseArray = new ReverseArray();
        String[] arr = line.split(",?\\s+");
        reverseArray.reverse(arr);
    }
}
