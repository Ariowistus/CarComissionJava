import java.util.ArrayList;
import java.util.List;

public class CarBase {


    List<Car> cars = new ArrayList<>();


    public List<Car> getCars() {
        this.cars = new ArrayList<>();
        this.cars.add(new Car("Audi", "Black", 10000, 100000, "B", new boolean[]{false, false, false, false, false}));
        this.cars.add(new Car("BMW", "White", 20000, 200000, "C", new boolean[]{false, false, false, false, false}));
        this.cars.add(new Car("Mercedes", "Red", 30000, 300000, "D", new boolean[]{false, false, false, false, false}));
        this.cars.add(new Car("Opel", "Blue", 40000, 400000, "E", new boolean[]{false, false, false, false, false}));
        this.cars.add(new Car("Volkswagen", "Green", 50000, 500000, "F", new boolean[]{false, false, false, false, false}));
        return this.cars;
    }
}
