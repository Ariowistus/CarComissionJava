import java.util.Arrays;
import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Car car = (Car) o;

        if (price != car.price) return false;
        if (Double.compare(car.mileage, mileage) != 0) return false;
        if (brokenengine != car.brokenengine) return false;
        if (brokenWheels != car.brokenWheels) return false;
        if (brokenLights != car.brokenLights) return false;
        if (brokenBrakes != car.brokenBrakes) return false;
        if (brokenTransmission != car.brokenTransmission) return false;
        if (!Objects.equals(marka, car.marka)) return false;
        if (!Objects.equals(color, car.color)) return false;
        return Objects.equals(segment, car.segment);
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = marka != null ? marka.hashCode() : 0;
        result = 31 * result + (color != null ? color.hashCode() : 0);
        result = 31 * result + price;
        temp = Double.doubleToLongBits(mileage);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + (segment != null ? segment.hashCode() : 0);
        result = 31 * result + (brokenengine ? 1 : 0);
        result = 31 * result + (brokenWheels ? 1 : 0);
        result = 31 * result + (brokenLights ? 1 : 0);
        result = 31 * result + (brokenBrakes ? 1 : 0);
        result = 31 * result + (brokenTransmission ? 1 : 0);
        return result;
    }
}
