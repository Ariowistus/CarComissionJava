import java.util.List;

public class CarCommission {

    Integer Capital;
    List<Car> cars;

    public CarCommission(Integer capital, List<Car> cars) {
        Capital = capital;
        this.cars = cars;
    }


    @Override
    public String toString() {
        return "CarCommission{" +
                "Capital=" + Capital +
                ", cars=" + cars +
                '}';
    }
}
