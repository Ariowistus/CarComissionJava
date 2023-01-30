import java.util.ArrayList;
import java.util.List;

public class CarComis {

    private Integer budget;
    private List<Car> purchasedCars;



    public CarComis(Integer budget) {
        this.budget = budget;
        purchasedCars = new ArrayList<>();
    }



    public List<Car> generateRandomCars() { // metoda generująca losowe samochody
        List<Car> randomCars = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            int random = (int) (Math.random() * 9);
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
            //ustaw losowy segment
            String[] segments = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J"};
            String randomSegment = segments[(int) (Math.random() * segments.length)];
            //ustaw losowy model
            String[] models = {"Audi", "BMW", "Mercedes", "Fiat", "Opel", "Ford", "Toyota", "Honda", "Hyundai", "Kia", "Mazda", "Nissan", "Peugeot", "Renault", "Skoda", "Suzuki", "Volkswagen", "Volvo", "Citroen", "Dacia"};
            String randomModel = models[(int) (Math.random() * models.length)];


            switch (random) {
                case 0, 4, 1, 2, 3, 5, 6, 7, 8, 9 -> {
                    randomCars.add(new Car(randomModel,
                            randomColor, randomPrice, randomMileage,
                            randomSegment, randomBrokenEngine, randomBrokenWheels,
                            randomBrokenLights, randomBrokenBrakes, randomBrokenTransmission));
                    break;
                }


            }
        }
        return randomCars;
    }


    public void addPurchasedCar(Car car,List<Car> randomCars) {
        if (budget >= car.getPrice()) {
            budget -= car.getPrice();
            purchasedCars.add(car);
            randomCars.remove(car);

        } else {
            System.out.println("Nie masz wystarczająco pieniędzy");
        }
        //randomCars.addAll(randomCars.indexOf(randomCars.size()-1),randomCars);
        //wstaw jeden nowy samochód do listy propontowanych samochodów
//        List<Car> randomCars2 = new ArrayList<>();
//        randomCars2.addAll(randomCars.indexOf(randomCars.size()-1),randomCars);




    }

    public List<Car> carsInBudget(List<Car> cars) {//       metoda zwracająca samochody w budżecie
        List<Car> carsInBudget = new ArrayList<>();
        for (Car car : cars) {
            if (car.getPrice() < this.budget) {
                carsInBudget.add(car);
            }
        }
        return carsInBudget;
    }




    public Integer getBudget() {
        if (budget < 0) {
            System.out.println("You are in debt");
        }
        return budget;
    }

    public List<Car> getPurchasedCars() {
        if (purchasedCars.isEmpty()) {
            System.out.println("Nie kupiłeś jeszcze żadnego samochodu");
            return purchasedCars;
        }
        return purchasedCars;
    }
}
