package skillbox.Computer;

public class RAM {
    private final String typeRAM;
    private final int volumeRAM;
    private final double weightRAM;

    public RAM(String typeRAM, int volumeRAM, double weightRAM) {
        this.typeRAM = typeRAM;
        this.volumeRAM = volumeRAM;
        this.weightRAM = weightRAM;
    }

    public String getTypeRAM() {
        return typeRAM;
    }

    public int getVolumeRAM() {
        return volumeRAM;
    }

    public double getWeightRAM() {
        return weightRAM;
    }

    public RAM setTypeRAM(String typeRAM) {
        return new RAM(typeRAM, volumeRAM, weightRAM);
    }

    public RAM setVolumeRAM(int volumeRAM) {
        return new RAM(typeRAM, volumeRAM, weightRAM);
    }

    public RAM setWeightRAM(double weightRAM) {
        return new RAM(typeRAM, volumeRAM, weightRAM);
    }

    public String toString() {
        return "\n" + "Тип оперативной памяти - " + typeRAM + "\n" +
                "Объём оперативной памяти - " + volumeRAM + "\n" +
                "Вес оперативной памяти - " + weightRAM;
    }
}
