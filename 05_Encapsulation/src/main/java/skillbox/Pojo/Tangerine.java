package skillbox.Pojo;

public class Tangerine {
    private String shape;
    private double size;
    private boolean freshness;

    public Tangerine(String shape, double size) {
        this.shape = shape;
        this.size = size;
    }

    public String getShape() {
        return shape;
    }

    public double getSize() {
        return size;
    }

    public boolean isFreshness() {
        return freshness;
    }

    public void setShape(String shape) {
        this.shape = shape;
    }

    public void setSize(double size) {
        this.size = size;
    }

    public void setFreshness(boolean freshness) {
        this.freshness = freshness;
    }
}
