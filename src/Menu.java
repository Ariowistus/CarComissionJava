import java.util.List;
import java.util.Scanner;

public class Menu {

    public void menu() {
        CarComis carComis = new CarComis(120000);
        Scanner scanner = new Scanner(System.in);

        List<Car> randomCars = carComis.generateRandomCars();

        boolean isRunning = true;

        while (isRunning) {
            System.out.println("Wybierz opcje: ");
            System.out.println("1. Kup samochod");
            System.out.println("2 Twój budzet");
            System.out.println("3. Przegląd techniczny");
            System.out.println("4. Wyjdz");
            System.out.println("5 Sprzedaj samochod");
            String option = scanner.next();
            switch (option) {

                case "1" -> {
                    System.out.println("Kup samochód");
                    System.out.println("twój budżet: " + carComis.getBudget());
                    purchaseCar(scanner, carComis, randomCars);


                    break;
                }
                case "2" -> {
                    System.out.println("Twój budżet to: " + carComis.getBudget());
                    break;
                }
                case "3" -> {
                    System.out.println("Kupione samochody");
                    if (carComis.getPurchasedCars().isEmpty()) {
                        continue;
                    } else {
                        printCars(carComis.getPurchasedCars());

                    }
                    System.out.println("Wybierz samochód, aby zobaczyć co jest zepsute");
                    int carIndex = scanner.nextInt();
                    carComis.showBrokenParts(carComis.getPurchasedCars().get(carIndex - 1));
                    System.out.println("Chcesz naprawić samochód? (t/n)");
                    String answer = scanner.next();
                    if (answer.equals("t")) {
                        System.out.println("Jakiego mechanika chcesz użyć?");
                        System.out.println("1 Janusz");
                        System.out.println("2 Adrian");
                        System.out.println("3 Marian");
                        int mechanicIndex = scanner.nextInt();
                        Car carToRepair = carComis.getPurchasedCars().get(carIndex - 1);
                        int repairCost = 0;
                        switch (mechanicIndex) {
                            case 1 -> repairCost = carComis.repairCostJanusz(carToRepair);
                            case 2 -> repairCost = carComis.repairCostAdrian(carToRepair);
                            case 3 -> repairCost = carComis.repairCostMarian(carToRepair);
                            default -> System.out.println("Nie ma takiego mechanika");
                        }
                        if (repairCost > carComis.getBudget()) {
                            System.out.println("Nie masz wystarczających środków na naprawę.");
                        } else {
                            switch (mechanicIndex) {
                                case 1 -> carComis.repairCarByMechanicJanusz(carToRepair);
                                case 2 -> carComis.repairCarByMechanicAdrian(carToRepair);
                                case 3 -> carComis.repairCarByMechanicMarian(carToRepair);
                            }
                            System.out.println("Twój budżet: " + carComis.getBudget());
                            System.out.println("Cena samochodu po naprawie: " + carToRepair.getPrice());
                        }
                    }


                    break;
                }
                case "4" -> {
                    isRunning = false;
                    break;
                }
                case "5" -> {
                    System.out.println("Kupione samochody");
                    printCars(carComis.getPurchasedCars());
                    System.out.println("który samochód chcesz sprzedać?");
                    int carIndex1 = scanner.nextInt();
                    carComis.sellCar(carComis.getPurchasedCars().get(carIndex1 - 1));
                    System.out.println("Samochód został sprzedany");
                    System.out.println("Twój budżet to: " + carComis.getBudget());
                    break;


                }

                default -> System.out.println("Nie ma takiej opcji");

            }

        }
    }

    private void purchaseCar(Scanner scanner, CarComis carComis, List<Car> randomCars) {
        System.out.println("Wybierz samochód do zakupu (podaj numer samochodu):");
        System.out.println("albo wciśnij dowolną literę, aby wrócić do menu");
        printCars(randomCars);
        if (scanner.hasNextInt()) {
            int carIndex = scanner.nextInt();
            if (carIndex > 0 && carIndex <= randomCars.size()) {
                Car carToPurchase = randomCars.get(carIndex - 1);
                carComis.addPurchasedCar(carToPurchase, randomCars);
            } else {
                System.out.println("Nie ma takiego samochodu");
            }
        } else {
            System.out.println("Podaj liczbę");
            scanner.next();
        }

    } //kup samochod

    public void printCars(List<Car> randomCars) {
        for (int i = 0; i < randomCars.size(); i++) {
            System.out.println((i + 1) + ". " + randomCars.get(i));

        }
    }//wypisz samochody
}