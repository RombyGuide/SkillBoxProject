package skillbox;

public class Container {
    private Integer count;

    public void addCount(int value) {
        count = value;
        count = count + value;
    }

    public int getCount() {
        return count;
    }
}
