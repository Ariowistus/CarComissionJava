import java.util.ArrayList;
import java.util.List;

public class CarComis {

    private Integer Budget;


    public CarComis(Integer budget) {
        Budget = budget;
    }


    public List<Car> carsInBudget(List<Car> cars) {
        List<Car> carsInBudget = new ArrayList<>();
        for (Car car : cars) {
            if (car.getPrice() < Budget) {
                carsInBudget.add(car);
            }
        }
        return carsInBudget;
    }


    public List<Car> generateRandomCars() {
        List<Car> randomCars = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            int random = (int) (Math.random() * 20);
            //ustaw losową cene
            int randomPrice = (int) (Math.random() * 100000);
            //ustaw losowy przebieg
            double randomMileage = (int) (Math.random() * 100000);
            // ustaw losowe uszkodzenia
            boolean randomBrokenEngine = (int) (Math.random() * 2) == 1;
            boolean randomBrokenWheels = (int) (Math.random() * 2) == 1;
            boolean randomBrokenLights = (int) (Math.random() * 2) == 1;
            boolean randomBrokenBrakes = (int) (Math.random() * 2) == 1;
            boolean randomBrokenTransmission = (int) (Math.random() * 2) == 1;
            //ustaw losowy kolor
            String[] colors = {"red", "blue", "green", "yellow", "black", "white", "pink", "orange", "purple", "brown"};
            String randomColor = colors[(int) (Math.random() * colors.length)];


            switch (random) {
                case 0:
                    randomCars.add(new Car("Audi", randomColor, randomPrice, randomMileage, "A", randomBrokenEngine, randomBrokenWheels, randomBrokenLights, randomBrokenBrakes, randomBrokenTransmission));
                    break;
                case 1:
                    randomCars.add(new Car("BMW", randomColor, randomPrice, randomMileage, "B", randomBrokenEngine, randomBrokenWheels, randomBrokenLights, randomBrokenBrakes, randomBrokenTransmission));
                    break;
                case 2:
                    randomCars.add(new Car("Mercedes", randomColor, randomPrice, randomMileage, "C", randomBrokenEngine, randomBrokenWheels, randomBrokenLights, randomBrokenBrakes, randomBrokenTransmission));
                    break;
                case 3:
                    randomCars.add(new Car("Opel", randomColor, randomPrice, randomMileage, "D", randomBrokenEngine, randomBrokenWheels, randomBrokenLights, randomBrokenBrakes, randomBrokenTransmission));
                    break;
                case 4:
                    randomCars.add(new Car("Fiat", randomColor, randomPrice, randomMileage, "E", randomBrokenEngine, randomBrokenWheels, randomBrokenLights, randomBrokenBrakes, randomBrokenTransmission));
                    break;
                case 5:
                    randomCars.add(new Car("Ford", "green", randomPrice, randomMileage, "F", randomBrokenEngine, randomBrokenWheels, randomBrokenLights, randomBrokenBrakes, randomBrokenTransmission));
                    break;
                case 6:
                    randomCars.add(new Car("Honda", "orange", randomPrice, randomMileage, "G", randomBrokenEngine, randomBrokenWheels, randomBrokenLights, randomBrokenBrakes, randomBrokenTransmission));
                    break;
                case 7:
                    randomCars.add(new Car("Hyundai", "purple", randomPrice, randomMileage, "H", randomBrokenEngine, randomBrokenWheels, randomBrokenLights, randomBrokenBrakes, randomBrokenTransmission));
                    break;
                case 8:
                    randomCars.add(new Car("Kia", "brown", randomPrice, randomMileage, "I", randomBrokenEngine, randomBrokenWheels, randomBrokenLights, randomBrokenBrakes, randomBrokenTransmission));
                    break;
                case 9:
                    randomCars.add(new Car("Mazda", "grey", randomPrice, randomMileage, "J", randomBrokenEngine, randomBrokenWheels, randomBrokenLights, randomBrokenBrakes, randomBrokenTransmission));
                    break;

            }
        }
        return randomCars;
    }



    public Car chooseRandomCar(List<Car> cars) {
        List<Car> carsInBudget = carsInBudget(cars);
        int random = (int) (Math.random() * carsInBudget.size());
        return carsInBudget.get(random);
    }












    public Integer getBudget() {
        return Budget;
    }
}
