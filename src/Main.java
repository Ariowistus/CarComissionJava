import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        CarComis carComis = new CarComis(100000);

        List<Car> randomCars = carComis.generateRandomCars();
        //printCars(randomCars);


        List<Car> carsInBudget = carComis.carsInBudget(randomCars);
        printCars(carsInBudget);

//        Car carChosen = carComis.chooseRandomCar(randomCars);
//        System.out.println(carChosen);



    }

    private static void printCars(List<Car> carsInBudget) {
        for (Car car : carsInBudget) {
            System.out.println(car);
        }
    }


}


