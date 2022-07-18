package skillbox.Computer;

public class InformationStorage {
    private final String aTypeMemory;
    private final int volumeMemory;
    private final double weightMemory;

    public InformationStorage(String aTypeMemory, int volumeMemory, double weightMemory) {
        this.aTypeMemory = aTypeMemory;
        this.volumeMemory = volumeMemory;
        this.weightMemory = weightMemory;
    }

    public String getATypeMemory() {
        return aTypeMemory;
    }

    public int getVolumeMemory() {
        return volumeMemory;
    }

    public double getWeightMemory() {
        return weightMemory;
    }

    public InformationStorage setAtypeMemory(String aTypeMemory) {
        return new InformationStorage(aTypeMemory, volumeMemory, weightMemory);
    }

    public InformationStorage setVolumeMemory(int volumeMemory) {
        return new InformationStorage(aTypeMemory, volumeMemory, weightMemory);
    }

    public InformationStorage setWeightMemory(double weightMemory) {
        return new InformationStorage(aTypeMemory, volumeMemory, weightMemory);
    }

    public String toString() {
        return "\n" + "Тип накопителя информации - " + aTypeMemory + "\n" +
                "Объём накопителя информации - " + volumeMemory +"\n" +
                "Вес накопителя информации - " + weightMemory;
    }
}
