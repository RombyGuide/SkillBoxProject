package csvParser;

public class Stations {
    public String name;
    public String date;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Stations{" +
                "name='" + name + '\'' +
                ", date='" + date + '\'' +
                '}';
    }
}