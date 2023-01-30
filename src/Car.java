import java.util.Arrays;

public class Car {

    private String model;
    private String color;
    private int price;
    private double mileage;
    private String segment;
    boolean brokenParts[] = new boolean[5];


    public Car(String model, String color, int price, double mileage, String segment, boolean[] brokenParts) {
        this.model = model;
        this.color = color;
        this.price = price;
        this.mileage = mileage;
        this.segment = segment;
        this.brokenParts = brokenParts;
    }

    @Override
    public String toString() {
        return "Car{" +
                "model='" + model + '\'' +
                ", color='" + color + '\'' +
                ", price=" + price +
                ", mileage=" + mileage +
                ", segment='" + segment + '\'' +
                ", brokenParts=" + Arrays.toString(brokenParts) +
                '}';
    }
}
