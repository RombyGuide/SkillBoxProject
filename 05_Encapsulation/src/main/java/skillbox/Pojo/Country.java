package skillbox.Pojo;

public class Country {
    private String name;
    private int population;
    private double squareKm2;
    private String nameCapital;
    private boolean accessToTheSea;


    public Country(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getPopulation() {
        return population;
    }

    public double getSquareKm2() {
        return squareKm2;
    }

    public String getNameCapital() {
        return nameCapital;
    }

    public boolean isAccessToTheSea() {
        return accessToTheSea;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPopulation(int population) {
        this.population = population;
    }

    public void setSquareKm2(double squareKm2) {
        this.squareKm2 = squareKm2;
    }

    public void setNameCapital(String nameCapital) {
        this.nameCapital = nameCapital;
    }

    public void setAccessToTheSea(boolean accessToTheSea) {
        this.accessToTheSea = accessToTheSea;
    }
}
