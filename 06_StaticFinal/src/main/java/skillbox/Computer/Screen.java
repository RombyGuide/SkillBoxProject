package skillbox.Computer;

public class Screen {
    private final double diagonalScreen;
    private final String typeScreen;
    private final double weightScreen;

    public Screen(double diagonalScreen, String typeScreen, double weightScreen) {
        this.diagonalScreen = diagonalScreen;
        this.typeScreen = typeScreen;
        this.weightScreen = weightScreen;
    }

    public double getDiagonalScreen() {
        return diagonalScreen;
    }

    public String getTypeScreen() {
        return typeScreen;
    }

    public double getWeightScreen() {
        return weightScreen;
    }

    public Screen setDiagonalScreen(double diagonalScreen) {
        return new Screen(diagonalScreen, typeScreen, weightScreen);
    }

    public Screen setTypeScreen(String typeScreen) {
        return new Screen(diagonalScreen, typeScreen, weightScreen);
    }

    public Screen setWeightScreen(double weightScreen) {
        return new Screen(diagonalScreen, typeScreen, weightScreen);
    }

    public String toString() {
        return "\n" + "Диагональ экрана - " + diagonalScreen + "\n" +
                "Тип экрана - " + typeScreen + "\n" +
                "Вес экрана - " + weightScreen;
    }
}
