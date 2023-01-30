import java.util.List;
import java.util.Scanner;

public class Menu {

    public void menu() {//
        CarComis carComis = new CarComis(40000);

        List<Car> randomCars = carComis.generateRandomCars();


        List<Car> carsInBudget = carComis.carsInBudget(randomCars);
        boolean isRunning = true;

        while (isRunning) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Wybierz opcje: ");
            System.out.println("1. Kup samochod");
            System.out.println("2 Twój budzet");
            System.out.println("3. Kupione samochody");
            System.out.println("4. Wyjdz");
            switch (scanner.nextInt()) {

                case 1 -> {
                    System.out.println("Kup samochód");
                    System.out.println("twój budżet: " + carComis.getBudget());

                    purchaseCar(scanner, carComis, randomCars);
                    break;
                }
                case 2 -> {
                    System.out.println("Twój budżet to: " + carComis.getBudget());
                    break;
                }
                case 3 -> {
                    System.out.println("Kupione samochody");
                    printCars(carComis.getPurchasedCars());
                    break;
                }
                case 4 -> {
                    isRunning = false;
                    break;
                }

                default -> System.out.println("Nie ma takiej opcji");

            }

        }
    }

    private void purchaseCar(Scanner scanner, CarComis carComis, List<Car> randomCars) {
        System.out.println("Wybierz samochód do zakupu (podaj numer samochodu):");
        printCars(randomCars);
        int carIndex = scanner.nextInt();
        Car carToPurchase = randomCars.get(carIndex - 1);
        carComis.addPurchasedCar(carToPurchase, randomCars);
    }

    public void printCars(List<Car> randomCars) {
        for (int i = 0; i < randomCars.size(); i++) {
            System.out.println((i + 1) + ". " + randomCars.get(i));

        }
    }
}
