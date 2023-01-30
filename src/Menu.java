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
            System.out.println("1. Wyświetl wszystkie samochody");
            System.out.println("2. Wyświetl samochody w budżecie");
            System.out.println("3. Exit");
            System.out.println("4. kup samochód");
            System.out.println("5 Twój budżet");
            System.out.println("6. Wyświetl kupione samochody");
            switch (scanner.nextInt()) {
                case 1 -> {
                    System.out.println("Wyświetlam wszystkie samochody");
                    printCars(randomCars);
                    break;
                }
                case 2 -> {
                    System.out.println("Wyświetlam samochody w budżecie");
                    printCars(carsInBudget);
                    break;
                }
                case 3 -> {
                    isRunning = false;
                    break;
                }
                case 4 -> {
                    System.out.println("Kup samochód");
                    purchaseCar(scanner, carComis, carsInBudget);
                    break;
                }
                case 5 -> {
                    System.out.println("Twój budżet to: " + carComis.getBudget());
                    break;
                }
                case 6 -> {
                    System.out.println("Kupione samochody");
                    printCars(carComis.getPurchasedCars());
                    break;
                }

                default -> System.out.println("Nie ma takiej opcji");

            }

        }
    }

    private void purchaseCar(Scanner scanner, CarComis carComis, List<Car> carsInBudget) {
        System.out.println("Wybierz samochód do zakupu (podaj numer samochodu):");
        printCars(carsInBudget);
        int carIndex = scanner.nextInt();
        Car carToPurchase = carsInBudget.get(carIndex - 1);
        carComis.addPurchasedCar(carToPurchase,carsInBudget);
        System.out.println("Samochód zakupiony: " + carToPurchase);
    }

    public void printCars(List<Car> carsInBudget) {
        for (Car car : carsInBudget) {
            System.out.println(car);
        }
    }
}
