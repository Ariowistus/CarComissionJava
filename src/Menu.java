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
                    System.out.println("Wybierz numer samochodu do przeglądu");

                    int carIndex;
                    if (scanner.hasNextInt()) {
                        carIndex = scanner.nextInt();
                    } else {
                        System.out.println("To nie jest liczba");
                        scanner.next();
                        continue;
                    }

                    if (carIndex <= 0 || carIndex > carComis.getPurchasedCars().size()) {
                        System.out.println("Nie ma takiego samochodu");
                        continue;
                    }
                    carComis.showBrokenParts(carComis.getPurchasedCars().get(carIndex - 1));
                    System.out.println("Wybierz, którą część chcesz naprawić:");
                    String partIndex = scanner.next();
                    switch (partIndex) {
                        case "Engine" -> {
                            //sprawdz if czy jest uszkodzony
                            if (!carComis.getPurchasedCars().get(carIndex - 1).isBrokenengine()) {
                                System.out.println("Ten silnik nie jest uszkodzony");
                                continue;
                            } else {
                                System.out.println("Chcesz naprawić tą część (t/n)");
                            }


                        }
                        case "Wheels" -> {
                            if (!carComis.getPurchasedCars().get(carIndex - 1).isBrokenWheels()) {
                                System.out.println("Te koła nie są uszkodzone");
                                continue;
                            } else {
                                System.out.println("Chcesz naprawić tą część (t/n)");
                            }
                        }
                        case "Lights" -> {
                            if (!carComis.getPurchasedCars().get(carIndex - 1).isBrokenLights()) {
                                System.out.println("Te światła nie są uszkodzone");
                                continue;
                            } else {
                                System.out.println("Chcesz naprawić tą część (t/n)");
                            }
                        }
                        case "Brakes" -> {
                            if (!carComis.getPurchasedCars().get(carIndex - 1).isBrokenBrakes()) {
                                System.out.println("Te hamulce nie są uszkodzone");
                                continue;
                            } else {
                                System.out.println("Chcesz naprawić tą część (t/n)");
                            }
                        }
                        case "Transmission" -> {
                            if (!carComis.getPurchasedCars().get(carIndex - 1).isBrokenTransmission()) {
                                System.out.println("Skrzynia biegów nie jest uszkodzona");
                                continue;
                            } else {
                                System.out.println("Chcesz naprawić tą część (t/n)");
                            }
                        }
                        default -> {
                            System.out.println("Nie ma takiej opcji,sprawdzi czy dobrze napisales");
                            continue;
                        }
                    }


                    String answer = scanner.next();
                    if (answer.equals("t")) {
                        System.out.println("Jakiego mechanika chcesz wybrać?(podaj numer)");
                        System.out.println("1 Janusz");
                        System.out.println("2 Adrian");
                        System.out.println("3 Marian");
                        String mechanicIndex = scanner.next();
                        Car carToRepair = carComis.getPurchasedCars().get(carIndex - 1);

                        switch (mechanicIndex) {
                            case "1" -> {
                                int repairCost1 = carComis.repairCostJanusz(carToRepair, partIndex);
                                System.out.println("Cena naprawy: " + repairCost1);
                                if (carComis.getBudget() < repairCost1) {
                                    System.out.println("Nie masz wystarczająco pieniędzy");
                                    continue;
                                }
                            }
                            case "2" -> {
                                int repairCost2 = carComis.repairCostAdrian(carToRepair, partIndex);
                                System.out.println("Cena naprawy: " + repairCost2);
                                if (carComis.getBudget() < repairCost2) {
                                    System.out.println("Nie masz wystarczająco pieniędzy");
                                    continue;
                                }
                            }
                            case "3" -> {
                                int repairCost3 = carComis.repairCostMarian(carToRepair, partIndex);

                                System.out.println("Cena naprawy: " + repairCost3);
                                if (carComis.getBudget() < repairCost3) {
                                    System.out.println("Nie masz wystarczająco pieniędzy");
                                    continue;
                                }
                            }
                            default -> {System.out.println("Nie ma takiego mechanika");
                                continue;
                            }
                        }

                        System.out.println("Czy chcesz naprawić tą część (t/n)");
                        String answer2 = scanner.next();
                        if (answer2.equals("t")) {
                            switch (mechanicIndex) {
                                case "1" -> {
                                    carComis.repairCarByMechanicJanusz(carToRepair, partIndex);
                                    System.out.println("Naprawiono");
                                }
                                case "2" -> {
                                    carComis.repairCarByMechanicAdrian(carToRepair, partIndex);
                                    System.out.println("Naprawiono");
                                }
                                case "3" -> {
                                    carComis.repairCarByMechanicMarian(carToRepair, partIndex);
                                    System.out.println("Naprawiono");
                                }
                                default -> System.out.println("Nie ma takiego mechanika");
                            }
                        } else {
                            System.out.println("Nie naprawiono");
                        }

                            System.out.println("Twój budżet: " + carComis.getBudget());
                            System.out.println("Cena samochodu po naprawie: " + carToRepair.getPrice());

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

                    if(scanner.hasNextInt()) {
                        int carIndex1 = scanner.nextInt();
                        if (carIndex1 <= 0 || carIndex1 > carComis.getPurchasedCars().size()) {
                            System.out.println("Nie ma takiego samochodu");
                            continue;
                        }
                        carComis.sellCar(carComis.getPurchasedCars().get(carIndex1 - 1));
                        System.out.println("Samochód został sprzedany");
                        System.out.println("Twój budżet to: " + carComis.getBudget());
                        break;
                    } else {
                        System.out.println("Wprowadzono nieprawidłowe dane, proszę wprowadzić liczbę");
                        scanner.next();
                        continue;
                    }


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