import java.util.Arrays;
import java.util.List;

public class Client {
    public List<Car> purchasedCars ;
    private String name;
    private double cash;
    private String brand1;
    private String brand2;
    private boolean acceptDamageEngine;
    private boolean acceptDamageWheels;
    private boolean acceptDamageLights;
    private boolean acceptDamageBrakes;
    private boolean acceptDamageTransmission;

    public Client(List<Car> purchasedCars, String name, double cash, String brand1, String brand2, boolean acceptDamageEngine, boolean acceptDamageWheels, boolean acceptDamageLights, boolean acceptDamageBrakes, boolean acceptDamageTransmission) {
        this.purchasedCars = purchasedCars;
        this.name = name;
        this.cash = cash;
        this.brand1 = brand1;
        this.brand2 = brand2;
        this.acceptDamageEngine = acceptDamageEngine;
        this.acceptDamageWheels = acceptDamageWheels;
        this.acceptDamageLights = acceptDamageLights;
        this.acceptDamageBrakes = acceptDamageBrakes;
        this.acceptDamageTransmission = acceptDamageTransmission;
    }

    public List<Car> getPurchasedCars() {
        return purchasedCars;
    }

    public void setPurchasedCars(List<Car> purchasedCars) {
        this.purchasedCars = purchasedCars;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getCash() {
        return cash;
    }

    public void setCash(double cash) {
        this.cash = cash;
    }

    public String getBrand1() {
        return brand1;
    }

    public void setBrand1(String brand1) {
        this.brand1 = brand1;
    }

    public String getBrand2() {
        return brand2;
    }

    public void setBrand2(String brand2) {
        this.brand2 = brand2;
    }

    public boolean isAcceptDamageEngine() {
        return acceptDamageEngine;
    }

    public void setAcceptDamageEngine(boolean acceptDamageEngine) {
        this.acceptDamageEngine = acceptDamageEngine;
    }

    public boolean isAcceptDamageWheels() {
        return acceptDamageWheels;
    }

    public void setAcceptDamageWheels(boolean acceptDamageWheels) {
        this.acceptDamageWheels = acceptDamageWheels;
    }

    public boolean isAcceptDamageLights() {
        return acceptDamageLights;
    }

    public void setAcceptDamageLights(boolean acceptDamageLights) {
        this.acceptDamageLights = acceptDamageLights;
    }

    public boolean isAcceptDamageBrakes() {
        return acceptDamageBrakes;
    }

    public void setAcceptDamageBrakes(boolean acceptDamageBrakes) {
        this.acceptDamageBrakes = acceptDamageBrakes;
    }

    public boolean isAcceptDamageTransmission() {
        return acceptDamageTransmission;
    }

    public void setAcceptDamageTransmission(boolean acceptDamageTransmission) {
        this.acceptDamageTransmission = acceptDamageTransmission;
    }

    @Override
    public String toString() {
        return "Client{" + ", name='" + name + '\'' +
                ", cash=" + cash +
                ", brand1='" + brand1 + '\'' +
                ", brand2='" + brand2 + '\'' +
                ", acceptDamageEngine=" + acceptDamageEngine +
                ", acceptDamageWheels=" + acceptDamageWheels +
                ", acceptDamageLights=" + acceptDamageLights +
                ", acceptDamageBrakes=" + acceptDamageBrakes +
                ", acceptDamageTransmission=" + acceptDamageTransmission +
                '}';
    }
}
