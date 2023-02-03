import java.util.Arrays;

public class Car {


    private String marka;

    private String color;
    private int price;
    private double mileage;
    private String segment;
    boolean brokenengine;
    boolean brokenWheels;
    boolean brokenLights;
    boolean brokenBrakes;
    boolean brokenTransmission;

    public Car(String model, String color, int price, double mileage, String segment, boolean brokenengine, boolean brokenWheels, boolean brokenLights, boolean brokenBrakes, boolean brokenTransmission) {
        this.marka = model;
        this.color = color;
        this.price = price;
        this.mileage = mileage;
        this.segment = segment;
        this.brokenengine = brokenengine;
        this.brokenWheels = brokenWheels;
        this.brokenLights = brokenLights;
        this.brokenBrakes = brokenBrakes;
        this.brokenTransmission = brokenTransmission;
    }

    @Override
    public String toString() {
        return "Car{" +
                "marka='" + marka + '\'' +
                ", color='" + color + '\'' +
                ", price=" + price +
                ", mileage=" + mileage +
                ", segment='" + segment + '\'' +
                '}';
    }

    public String getModel() {
        return marka;
    }

    public void setModel(String model) {
        this.marka = model;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public double getMileage() {
        return mileage;
    }

    public void setMileage(double mileage) {
        this.mileage = mileage;
    }

    public String getSegment() {
        return segment;
    }

    public void setSegment(String segment) {
        this.segment = segment;
    }

    public boolean isBrokenengine() {
        return brokenengine;
    }

    public void setBrokenengine(boolean brokenengine) {
        this.brokenengine = brokenengine;
    }

    public boolean isBrokenWheels() {
        return brokenWheels;
    }

    public void setBrokenWheels(boolean brokenWheels) {
        this.brokenWheels = brokenWheels;
    }

    public boolean isBrokenLights() {
        return brokenLights;
    }

    public void setBrokenLights(boolean brokenLights) {
        this.brokenLights = brokenLights;
    }

    public boolean isBrokenBrakes() {
        return brokenBrakes;
    }

    public void setBrokenBrakes(boolean brokenBrakes) {
        this.brokenBrakes = brokenBrakes;
    }

    public boolean isBrokenTransmission() {
        return brokenTransmission;
    }

    public void setBrokenTransmission(boolean brokenTransmission) {
        this.brokenTransmission = brokenTransmission;
    }

    public boolean isBrokenEngine() {
        return brokenengine;
    }

    public void setBrokenEngine(boolean b) {
        this.brokenengine = b;
    }
}
