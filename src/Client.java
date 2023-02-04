import java.util.List;
import java.util.Objects;

public class Client {
    public List<Car> purchasedCars ;
    private String name;
    private double money;
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
        this.money = cash;
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



    public void setMoney(double money) {
        this.money = money;
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
                ", cash=" + money ;

    }

    public double getMoney() { //
        return money ;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Client client = (Client) o;

        if (Double.compare(client.money, money) != 0) return false;
        if (acceptDamageEngine != client.acceptDamageEngine) return false;
        if (acceptDamageWheels != client.acceptDamageWheels) return false;
        if (acceptDamageLights != client.acceptDamageLights) return false;
        if (acceptDamageBrakes != client.acceptDamageBrakes) return false;
        if (acceptDamageTransmission != client.acceptDamageTransmission) return false;
        if (!Objects.equals(purchasedCars, client.purchasedCars))
            return false;
        if (!Objects.equals(name, client.name)) return false;
        if (!Objects.equals(brand1, client.brand1)) return false;
        return Objects.equals(brand2, client.brand2);
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = purchasedCars != null ? purchasedCars.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        temp = Double.doubleToLongBits(money);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + (brand1 != null ? brand1.hashCode() : 0);
        result = 31 * result + (brand2 != null ? brand2.hashCode() : 0);
        result = 31 * result + (acceptDamageEngine ? 1 : 0);
        result = 31 * result + (acceptDamageWheels ? 1 : 0);
        result = 31 * result + (acceptDamageLights ? 1 : 0);
        result = 31 * result + (acceptDamageBrakes ? 1 : 0);
        result = 31 * result + (acceptDamageTransmission ? 1 : 0);
        return result;
    }
}
