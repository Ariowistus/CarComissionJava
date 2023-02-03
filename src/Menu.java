import java.util.List;
import java.util.Scanner;

public class Menu {

    public void menu() {
        CarComis carComis = new CarComis(2000000);
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
            System.out.println("6 Pokaz mi listę klientów");
            System.out.println("7 Sprzedaj samochod klientowi");
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
                case "6" ->{
                    purchaseClient(scanner, carComis,carComis.generateRandomClients());

                    System.out.println("moja lista klientów");
                    printClients(carComis.getPurchasedClients());

                }
                case "7" -> {
                    purchaseClient(scanner, carComis, carComis.generateRandomClients());
                    System.out.println("Wybierz klienta któremu chcesz sprzedać samochód");
                    printClients(carComis.getPurchasedClients());
                    if(scanner.hasNextInt()) {
                        int clientIndex = scanner.nextInt();
                        if (clientIndex <= 0 || clientIndex > carComis.getPurchasedClients().size()) {
                            System.out.println("Nie ma takiego klienta");
                            continue;
                        }
                        System.out.println("Wybierz samochód który chcesz sprzedać");
                        printCars(carComis.getPurchasedCars());
                        if(scanner.hasNextInt()) {
                            int carIndex = scanner.nextInt();
                            if (carIndex <= 0 || carIndex > carComis.getPurchasedCars().size()) {
                                System.out.println("Nie ma takiego samochodu");
                                continue;
                            }
                            carComis.sellCarToClient(carComis.getPurchasedCars().get(carIndex - 1), carComis.getPurchasedClients().get(clientIndex - 1));

                            System.out.println("Twój budżet to: " + carComis.getBudget());
                            break;
                        } else {
                            System.out.println("Wprowadzono nieprawidłowe dane, proszę wprowadzić liczbę");
                            scanner.next();
                            continue;
                        }
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
    public void printClients(List<Client> randomClients) {
        for (int i = 0; i < randomClients.size(); i++) {
            System.out.println((i + 1) + ". " + randomClients.get(i));
        }
    }

    public void printCars(List<Car> randomCars) {
        for (int i = 0; i < randomCars.size(); i++) {
            System.out.println((i + 1) + ". " + randomCars.get(i));

        }
    }//wypisz samochody

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

    private void purchaseClient(Scanner scanner, CarComis carComis, List<Client> randomClients) {
        System.out.println("Wybierz klienta do zakupu (podaj numer klienta):");
        System.out.println("albo wciśnij dowolną literę, aby wrócić do menu");
        printClients(randomClients);
        if (scanner.hasNextInt()) {
            int clientIndex = scanner.nextInt();
            if (clientIndex > 0 && clientIndex <= randomClients.size()) {
                Client clientToPurchase = randomClients.get(clientIndex - 1);
                carComis.addPurchasedClient(clientToPurchase, randomClients);
            } else {
                System.out.println("Nie ma takiego klienta");
            }
        } else {
            System.out.println("Podaj liczbę");
            scanner.next();
        }

    } //kup klienta
}