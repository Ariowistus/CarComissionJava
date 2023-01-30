import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        CarComis carComis = new CarComis(400000);

        List<Car> randomCars = carComis.generateRandomCars();



        List<Car> carsInBudget = carComis.carsInBudget(randomCars);
        //printCars(carsInBudget);

        Scanner scanner = new Scanner(System.in);
        System.out.println("twój budżet to: " + carComis.getBudget());
        System.out.println("Wybierz opcje: ");
        System.out.println("1. Wyświetl wszystkie samochody");
        System.out.println("2. Wyświetl samochody w budżecie");
        switch (scanner.nextInt()){
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
        }





    }

    private static void printCars(List<Car> carsInBudget) {
        for (Car car : carsInBudget) {
            System.out.println(car);
        }
    }

    //stwórz metode menu ze swtichem i Scannerem
    //stwórz metode do wyboru opcji


}


