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
                    printCars(randomCars);
                    System.out.println("chcesz kupic samochod? (t/n)");
                    String answer = scanner.next();
                    if (answer.equals("t")) {
                        purchaseCar(scanner, carComis, randomCars);
                    } else if (answer.equals("n")) {
                        continue;
                    } else {
                        System.out.println("Nie ma takiej opcji");
                    }


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
                        switch (mechanicIndex) {
                            case 1 -> {
                                carComis.repairCarByMechanicJanusz(carComis.getPurchasedCars().get(carIndex - 1));
                                System.out.println("twoj budzet: " + carComis.getBudget());
                                System.out.println("cena samochodu po naprawie: " + carComis.getPurchasedCars().get(carIndex - 1).getPrice());
                                break;
                            }
                            case 2 -> {
                                carComis.repairCarByMechanicAdrian(carComis.getPurchasedCars().get(carIndex - 1));
                                System.out.println("twoj budzet: " + carComis.getBudget());
                                System.out.println("cena samochodu po naprawie: " + carComis.getPurchasedCars().get(carIndex - 1).getPrice());
                                break;
                            }
                            case 3 -> {
                                carComis.repairCarByMechanicMarian(carComis.getPurchasedCars().get(carIndex - 1));
                                System.out.println("twoj budzet: " + carComis.getBudget());
                                System.out.println("cena samochodu po naprawie: " + carComis.getPurchasedCars().get(carIndex - 1).getPrice());
                                break;
                            }
                            default -> System.out.println("Nie ma takiego mechanika");
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
        printCars(randomCars);
        int carIndex = scanner.nextInt();
        Car carToPurchase = randomCars.get(carIndex - 1);
        carComis.addPurchasedCar(carToPurchase, randomCars);

    } //kup samochod

    public void printCars(List<Car> randomCars) {
        for (int i = 0; i < randomCars.size(); i++) {
            System.out.println((i + 1) + ". " + randomCars.get(i));

        }
    }//wypisz samochody
}