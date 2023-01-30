import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        CarBase carBase = new CarBase();
        CarCommission carCommission = new CarCommission(100000, carBase.getCars());
        carBase.getCars();
        printCars(carBase.getCars(), carCommission.Capital);




    }


    public static void printCars(List<Car> cars, Integer capital){
        System.out.println("Capitał zakładowy to: "+capital);
        System.out.println("Lista samochodów:");
        for (Car car : cars) {
            System.out.println(car);
        }
    }

}