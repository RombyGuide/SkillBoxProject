package skillbox.Computer;

public class Main {
    public static void main(String[] args) {
        Computer computer = new Computer("Taiwan", "Asus BK201",
                new CPU(2.2, 4, "Taiwan", 0.15),
                new RAM("DDR4", 8, 0.4),
                new InformationStorage("SSD", 256, 1.2),
                new Screen(21, "IPS", 4.4),
                new Keyboard("Classic", true, 0.6));

        System.out.println(computer.toString());
    }
}
