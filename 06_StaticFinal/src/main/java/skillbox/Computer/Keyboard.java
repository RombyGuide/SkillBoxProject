package skillbox.Computer;

public class Keyboard {
    private final String typeKeyboard;
    private final boolean backlightKeyboard;
    private final double weightKeyboard;

    public Keyboard(String typeKeyboard, boolean backlightKeyboard, double weightKeyboard) {
        this.typeKeyboard = typeKeyboard;
        this.backlightKeyboard = backlightKeyboard;
        this.weightKeyboard = weightKeyboard;
    }

    public String getTypeKeyboard() {
        return typeKeyboard;
    }

    public boolean isBacklightKeyboard() {
        return backlightKeyboard;
    }

    public double getWeightKeyboard() {
        return weightKeyboard;
    }

    public Keyboard setTypeKeyboard(String typeKeyboard) {
        return new Keyboard(typeKeyboard, backlightKeyboard, weightKeyboard);
    }

    public Keyboard setBacklightKeyboard(boolean backlightKeyboard) {
        return new Keyboard(typeKeyboard, backlightKeyboard, weightKeyboard);
    }

    public Keyboard setWeightKeyboard(double weightKeyboard) {
        return new Keyboard(typeKeyboard, backlightKeyboard, weightKeyboard);
    }

    public String toString() {
        return "\n" + "Тип клавиатуры - " + typeKeyboard + "\n" +
                "Наличие подсветки - " + backlightKeyboard + "\n" +
                "Вес клавиатуры - " + weightKeyboard;
    }
}
