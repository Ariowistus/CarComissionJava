import java.util.ArrayList;
import java.util.List;

public class CarComis {

    private double budget;
    private List<Car> purchasedCars;


    public CarComis(Integer budget) {
        if (budget < 0) {
            throw new IllegalArgumentException("Wartość budżetu nie może być ujemna");
        }
        this.budget = budget;
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
    } // metoda generująca losowe samochody


    public void addPurchasedCar(Car car, List<Car> randomCars) {
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
        if (budget >= car.getPrice()) {
            int wash = 200;
            double tax = 0.02;
            budget = budget - (car.getPrice()) - ((car.getPrice() * tax)) - (wash);
            purchasedCars.add(car);
            randomCars.remove(car);
            randomCars.add(new Car(randomModel,
                    randomColor, randomPrice, randomMileage,
                    randomSegment, randomBrokenEngine, randomBrokenWheels,
                    randomBrokenLights, randomBrokenBrakes, randomBrokenTransmission));
            System.out.println("Cena samochodu: " + car.getPrice());
            System.out.println("Podatek " + (car.getPrice() * tax));
            System.out.println("Myjnia " + wash);
            System.out.println("Pozostało Ci " + budget + " zł");

        } else {
            System.out.println("Nie masz wystarczająco pieniędzy");
        }


    } // metoda dodająca kupiony samochód do listy kupionych samochodów


    public Integer getBudget() {
        return (int) Math.max(0, budget);
    } // metoda zwracająca budżet

    public List<Car> getPurchasedCars() {
        if (purchasedCars.isEmpty()) {
            System.out.println("Nie kupiłeś jeszcze żadnego samochodu");
            return purchasedCars;
        }
        return purchasedCars;
    }// metoda zwracająca listę kupionych samochodów


    public void showBrokenParts(Car car) {
        if (car.isBrokenEngine()) {
            System.out.println("Engine is broken");
        }
        if (car.isBrokenWheels()) {
            System.out.println("Wheels are broken");
        }
        if (car.isBrokenLights()) {
            System.out.println("Lights are broken");
        }
        if (car.isBrokenBrakes()) {
            System.out.println("Brakes are broken");
        }
        if (car.isBrokenTransmission()) {
            System.out.println("Transmission is broken");
        }
    }// metoda pokazująca uszkodzone części samochodu


    public void sellCar(Car car) {
        double wash = 200;
        double tax = 0.02;
        budget = budget + (car.getPrice()) - ((car.getPrice() * tax)) - (wash);
        this.purchasedCars.remove(car);
        System.out.println("Podatek wyniósł: " + (car.getPrice() * tax));
        System.out.println("Myjnia kosztowała: " + wash);
        System.out.println("Pozostało Ci: " + budget + " zł");
    }// metoda sprzedająca samochód




    public void repairCarByMechanicMarian(Car car, String partToRepair) {
        if (partToRepair.equals("Engine")) {
            if (car.isBrokenEngine()) {
                if (Math.random() < 0.1) {
                    System.out.println("Marianowi nie udało mu się naprawić silnika");
                    car.setBrokenEngine(true);
                    System.out.println("Interweniował mechaniczny Janusz xD");
                    repairCarByMechanicJanusz(car, partToRepair);
                } else {
                    if (Math.random() < 0.01) {
                        car.setBrokenEngine(true);
                        System.out.println("Mechanic Marian zepsuł silnik");
                    } else {
                        switch (car.getModel()) {
                            case "Mercedes", "Audi", "BMW" -> {
                                budget -= car.getPrice() * (0.1 + 0.11);
                                car.setPrice((int) (car.getPrice() * 2.5));
                                car.setBrokenEngine(false);
                            }
                            case "Volvo", "Ford", "Volkswagen" -> {
                                budget -= car.getPrice() * (0.1 + 0.09);
                                car.setPrice((int) (car.getPrice() * 2.5));
                                car.setBrokenEngine(false);
                            }
                            case "Toyota", "Honda", "Kia", "Mazda", "Suzuki" -> {
                                budget -= car.getPrice() * (0.1 + 0.08);
                                car.setPrice((int) (car.getPrice() * 2.5));
                                car.setBrokenEngine(false);
                            }
                            case "Skoda", "Hyundai", "Nissan" -> {
                                budget -= car.getPrice() * (0.1 + 0.07);
                                car.setPrice((int) (car.getPrice() * 2.5));
                                car.setBrokenEngine(false);
                            }
                            case "Fiat", "Opel", "Dacia" -> {
                                budget -= car.getPrice() * (0.1 + 0.06);
                                car.setPrice((int) (car.getPrice() * 2.5));
                                car.setBrokenEngine(false);
                            }
                            case "Peugeot", "Renault", "Citroen" -> {
                                budget -= car.getPrice() * (0.1 + 0.05);
                                car.setPrice((int) (car.getPrice() * 2.5));
                                car.setBrokenEngine(false);
                            }
                        }
                    }
                }
            }

        }

        if (partToRepair.equals("Brakes")) {

            if (car.isBrokenBrakes()) {
                if (Math.random() < 0.1) {
                    System.out.println("Marianowi nie udało mu się naprawić hamulców");
                    System.out.println("Interweniował mechaniczny Janusz xD");
                    car.setBrokenBrakes(true);
                    repairCarByMechanicJanusz(car, partToRepair);
                } else {
                    if (Math.random() < 0.01) {
                        car.setBrokenBrakes(true);
                        System.out.println("Mechanic Marian zepsuł hamulce");
                    } else {
                        switch (car.getModel()) {
                            case "Mercedes", "Audi", "BMW" -> {
                                budget -= car.getPrice() * (0.03 + 0.07);
                                car.setPrice((int) (car.getPrice() * 1.4));
                                car.setBrokenBrakes(false);
                            }
                            case "Volvo", "Ford", "Volkswagen" -> {
                                budget -= car.getPrice() * (0.03 + 0.06);
                                car.setPrice((int) (car.getPrice() * 1.4));
                                car.setBrokenBrakes(false);
                            }
                            case "Toyota", "Honda", "Kia", "Mazda", "Suzuki" -> {
                                budget -= car.getPrice() * (0.03 + 0.05);
                                car.setPrice((int) (car.getPrice() * 1.4));
                                car.setBrokenBrakes(false);
                            }
                            case "Skoda", "Hyundai", "Nissan" -> {
                                budget -= car.getPrice() * (0.03 + 0.04);
                                car.setPrice((int) (car.getPrice() * 1.4));
                                car.setBrokenBrakes(false);
                            }
                            case "Fiat", "Opel", "Dacia" -> {
                                budget -= car.getPrice() * (0.03 + 0.03);
                                car.setPrice((int) (car.getPrice() * 1.4));
                                car.setBrokenBrakes(false);
                            }
                            case "Peugeot", "Renault", "Citroen" -> {
                                budget -= car.getPrice() * (0.03 + 0.02);
                                car.setPrice((int) (car.getPrice() * 1.4));
                                car.setBrokenBrakes(false);
                            }
                        }
                    }
                }
            }


        }

        if (partToRepair.equals("Transmission")) {
            if (car.isBrokenTransmission()) {
                if (Math.random() < 0.1) {
                    System.out.println("Marianowi nie udało mu się naprawić skrzyni biegów");
                    System.out.println("Interweniował mechaniczny Janusz xD");
                    car.setBrokenTransmission(true);
                    repairCarByMechanicJanusz(car, partToRepair);
                } else {
                    if (Math.random() < 0.01) {
                        car.setBrokenTransmission(true);
                        System.out.println("Marianowi zepsuł skrzynię biegów");
                    } else {
                        switch (car.getModel()) {
                            case "Mercedes", "Audi", "BMW" -> {
                                budget -= car.getPrice() * (0.1 + 0.1);
                                car.setPrice((int) (car.getPrice() * 1.9));
                                car.setBrokenTransmission(false);
                            }
                            case "Volvo", "Ford", "Volkswagen" -> {
                                budget -= car.getPrice() * (0.1 + 0.09);
                                car.setPrice((int) (car.getPrice() * 1.9));
                                car.setBrokenTransmission(false);
                            }
                            case "Toyota", "Honda", "Kia", "Mazda", "Suzuki" -> {
                                budget -= car.getPrice() * (0.1 + 0.08);
                                car.setPrice((int) (car.getPrice() * 1.9));
                                car.setBrokenTransmission(false);
                            }
                            case "Skoda", "Hyundai", "Nissan" -> {
                                budget -= car.getPrice() * (0.1 + 0.07);
                                car.setPrice((int) (car.getPrice() * 1.9));
                                car.setBrokenTransmission(false);
                            }
                            case "Fiat", "Opel", "Dacia" -> {
                                budget -= car.getPrice() * (0.1 + 0.06);
                                car.setPrice((int) (car.getPrice() * 1.9));
                                car.setBrokenTransmission(false);
                            }
                            case "Peugeot", "Renault", "Citroen" -> {
                                budget -= car.getPrice() * (0.1 + 0.05);
                                car.setPrice((int) (car.getPrice() * 1.9));
                                car.setBrokenTransmission(false);
                            }
                        }
                    }
                }

            }

        }

        if (partToRepair.equals("Lights")) {
            if (car.isBrokenLights()) {
                if (Math.random() < 0.1) {
                    System.out.println("Marianowi nie udało mu się naprawić świateł");
                    System.out.println("Interweniował mechaniczny Janusz xD");
                    car.setBrokenLights(true);
                    repairCarByMechanicJanusz(car, partToRepair);
                } else {
                    if (Math.random() < 0.01) {
                        car.setBrokenLights(true);
                        System.out.println("Mechanic Marian zepsuł światła");
                    } else {
                        switch (car.getModel()) {
                            case "Mercedes", "Audi", "BMW" -> {
                                budget -= car.getPrice() * (0.05 + 0.1);
                                car.setPrice((int) (car.getPrice() * 1.4));
                                car.setBrokenLights(false);
                            }
                            case "Volvo", "Ford", "Volkswagen" -> {
                                budget -= car.getPrice() * (0.05 + 0.09);
                                car.setPrice((int) (car.getPrice() * 1.4));
                                car.setBrokenLights(false);
                            }
                            case "Toyota", "Honda", "Kia", "Mazda", "Suzuki" -> {
                                budget -= car.getPrice() * (0.05 + 0.08);
                                car.setPrice((int) (car.getPrice() * 1.4));
                                car.setBrokenLights(false);
                            }
                            case "Skoda", "Hyundai", "Nissan" -> {
                                budget -= car.getPrice() * (0.05 + 0.07);
                                car.setPrice((int) (car.getPrice() * 1.4));
                                car.setBrokenLights(false);
                            }
                            case "Fiat", "Opel", "Dacia" -> {
                                budget -= car.getPrice() * (0.05 + 0.06);
                                car.setPrice((int) (car.getPrice() * 1.4));
                                car.setBrokenLights(false);
                            }
                            case "Peugeot", "Renault", "Citroen" -> {
                                budget -= car.getPrice() * (0.05 + 0.05);
                                car.setPrice((int) (car.getPrice() * 1.4));
                                car.setBrokenLights(false);
                            }
                        }
                    }
                }
            }


        }

        if (partToRepair.equals("Wheels")) {
            if (car.isBrokenWheels()) {
                if (Math.random() < 0.1) {
                    System.out.println(" Marianowi nie udało mu się naprawić opon");
                    System.out.println("Interweniował mechaniczny Janusz xD");
                    car.setBrokenWheels(true);
                    repairCarByMechanicJanusz(car, partToRepair);
                } else {
                    if (Math.random() < 0.01) {
                        car.setBrokenWheels(true);
                        System.out.println("Mechanic Marian zepsuł opony");
                    } else {
                        switch (car.getModel()) {
                            case "Mercedes", "Audi", "BMW" -> {
                                budget -= car.getPrice() * (0.03 + 0.1);
                                car.setPrice((int) (car.getPrice() * 1.4));
                                car.setBrokenWheels(false);
                            }
                            case "Volvo", "Ford", "Volkswagen" -> {
                                budget -= car.getPrice() * (0.03 + 0.09);
                                car.setPrice((int) (car.getPrice() * 1.4));
                                car.setBrokenWheels(false);
                            }
                            case "Toyota", "Honda", "Kia", "Mazda", "Suzuki" -> {
                                budget -= car.getPrice() * (0.03 + 0.08);
                                car.setPrice((int) (car.getPrice() * 1.4));
                                car.setBrokenWheels(false);
                            }
                            case "Skoda", "Hyundai", "Nissan" -> {
                                budget -= car.getPrice() * (0.03 + 0.07);
                                car.setPrice((int) (car.getPrice() * 1.4));
                                car.setBrokenWheels(false);
                            }
                            case "Fiat", "Opel", "Dacia" -> {
                                budget -= car.getPrice() * (0.03 + 0.06);
                                car.setPrice((int) (car.getPrice() * 1.4));
                                car.setBrokenWheels(false);
                            }
                            case "Peugeot", "Renault", "Citroen" -> {
                                budget -= car.getPrice() * (0.03 + 0.05);
                                car.setPrice((int) (car.getPrice() * 1.4));
                                car.setBrokenWheels(false);
                            }
                        }
                    }
                }
            }


        }


    }

    public void repairCarByMechanicJanusz(Car car, String partToRepair) {
        if (partToRepair.equals("Engine")) {
            if (car.isBrokenEngine()) {
                if (Math.random() < 0.001) {
                    System.out.println("Mechanic Janusz nie udało mu się naprawić silnika");
                    car.setBrokenEngine(true);
                } else {
                    if (Math.random() < 0.0001) {
                        car.setBrokenEngine(true);
                        System.out.println("Mechanic Janusz zepsuł silnik");
                    } else {
                        switch (car.getModel()) {
                            case "Mercedes", "Audi", "BMW" -> {
                                budget -= car.getPrice() * (0.15 + 0.11);
                                car.setPrice((int) (car.getPrice() * 2.5));
                                car.setBrokenEngine(false);
                            }
                            case "Volvo", "Ford", "Volkswagen" -> {
                                budget -= car.getPrice() * (0.15 + 0.09);
                                car.setPrice((int) (car.getPrice() * 2.5));
                                car.setBrokenEngine(false);
                            }
                            case "Toyota", "Honda", "Kia", "Mazda", "Suzuki" -> {
                                budget -= car.getPrice() * (0.15 + 0.08);
                                car.setPrice((int) (car.getPrice() * 2.5));
                                car.setBrokenEngine(false);
                            }
                            case "Skoda", "Hyundai", "Nissan" -> {
                                budget -= car.getPrice() * (0.15 + 0.07);
                                car.setPrice((int) (car.getPrice() * 2.5));
                                car.setBrokenEngine(false);
                            }
                            case "Fiat", "Opel", "Dacia" -> {
                                budget -= car.getPrice() * (0.15 + 0.06);
                                car.setPrice((int) (car.getPrice() * 2.5));
                                car.setBrokenEngine(false);
                            }
                            case "Peugeot", "Renault", "Citroen" -> {
                                budget -= car.getPrice() * (0.15 + 0.05);
                                car.setPrice((int) (car.getPrice() * 2.5));
                                car.setBrokenEngine(false);
                            }
                        }
                    }
                }
            }

        }

        if (partToRepair.equals("Brakes")) {
            if (car.isBrokenBrakes()) {
                if (Math.random() < 0.001) {
                    System.out.println("Mechanic Janusz nie udało mu się naprawić hamulców");
                    car.setBrokenBrakes(true);
                } else {
                    if (Math.random() < 0.0001) {
                        car.setBrokenBrakes(true);
                        System.out.println("Mechanic Janusz zepsuł hamulce");
                    } else {
                        switch (car.getModel()) {
                            case "Mercedes", "Audi", "BMW" -> {
                                budget -= car.getPrice() * (0.05 + 0.07);
                                car.setPrice((int) (car.getPrice() * 1.4));
                                car.setBrokenBrakes(false);
                            }
                            case "Volvo", "Ford", "Volkswagen" -> {
                                budget -= car.getPrice() * (0.05 + 0.06);
                                car.setPrice((int) (car.getPrice() * 1.4));
                                car.setBrokenBrakes(false);
                            }
                            case "Toyota", "Honda", "Kia", "Mazda", "Suzuki" -> {
                                budget -= car.getPrice() * (0.05 + 0.05);
                                car.setPrice((int) (car.getPrice() * 1.4));
                                car.setBrokenBrakes(false);
                            }
                            case "Skoda", "Hyundai", "Nissan" -> {
                                budget -= car.getPrice() * (0.05 + 0.04);
                                car.setPrice((int) (car.getPrice() * 1.4));
                                car.setBrokenBrakes(false);
                            }
                            case "Fiat", "Opel", "Dacia" -> {
                                budget -= car.getPrice() * (0.05 + 0.03);
                                car.setPrice((int) (car.getPrice() * 1.4));
                                car.setBrokenBrakes(false);
                            }
                            case "Peugeot", "Renault", "Citroen" -> {
                                budget -= car.getPrice() * (0.05 + 0.02);
                                car.setPrice((int) (car.getPrice() * 1.4));
                                car.setBrokenBrakes(false);
                            }
                        }
                    }
                }
            }

        }

        if (partToRepair.equals("Transmission")) {
            if (car.isBrokenTransmission()) {
                if (Math.random() < 0.001) {
                    System.out.println("Mechanic Janusz nie udało mu się naprawić skrzyni biegów");
                    car.setBrokenTransmission(true);
                } else {
                    if (Math.random() < 0.0001) {
                        car.setBrokenTransmission(true);
                        System.out.println("Mechanic Janusz zepsuł skrzynię biegów");
                    } else {
                        switch (car.getModel()) {
                            case "Mercedes", "Audi", "BMW" -> {
                                budget -= car.getPrice() * (0.15 + 0.1);
                                car.setPrice((int) (car.getPrice() * 1.9));
                                car.setBrokenTransmission(false);
                            }
                            case "Volvo", "Ford", "Volkswagen" -> {
                                budget -= car.getPrice() * (0.15 + 0.09);
                                car.setPrice((int) (car.getPrice() * 1.9));
                                car.setBrokenTransmission(false);
                            }
                            case "Toyota", "Honda", "Kia", "Mazda", "Suzuki" -> {
                                budget -= car.getPrice() * (0.15 + 0.08);
                                car.setPrice((int) (car.getPrice() * 1.9));
                                car.setBrokenTransmission(false);
                            }
                            case "Skoda", "Hyundai", "Nissan" -> {
                                budget -= car.getPrice() * (0.15 + 0.07);
                                car.setPrice((int) (car.getPrice() * 1.9));
                                car.setBrokenTransmission(false);
                            }
                            case "Fiat", "Opel", "Dacia" -> {
                                budget -= car.getPrice() * (0.15 + 0.06);
                                car.setPrice((int) (car.getPrice() * 1.9));
                                car.setBrokenTransmission(false);
                            }
                            case "Peugeot", "Renault", "Citroen" -> {
                                budget -= car.getPrice() * (0.15 + 0.05);
                                car.setPrice((int) (car.getPrice() * 1.9));
                                car.setBrokenTransmission(false);
                            }
                        }
                    }
                }

            }

        }

        if (partToRepair.equals("Lights")) {
            if (car.isBrokenLights()) {
                if (Math.random() < 0.001) {
                    System.out.println("Mechanic Janusz nie udało mu się naprawić świateł");
                    car.setBrokenLights(true);
                } else {
                    if (Math.random() < 0.0001) {
                        car.setBrokenLights(true);
                        System.out.println("Mechanic Janusz zepsuł światła");
                    } else {
                        switch (car.getModel()) {
                            case "Mercedes", "Audi", "BMW" -> {
                                budget -= car.getPrice() * (0.07 + 0.1);
                                car.setPrice((int) (car.getPrice() * 1.4));
                                car.setBrokenLights(false);
                            }
                            case "Volvo", "Ford", "Volkswagen" -> {
                                budget -= car.getPrice() * (0.07 + 0.09);
                                car.setPrice((int) (car.getPrice() * 1.4));
                                car.setBrokenLights(false);
                            }
                            case "Toyota", "Honda", "Kia", "Mazda", "Suzuki" -> {
                                budget -= car.getPrice() * (0.07 + 0.08);
                                car.setPrice((int) (car.getPrice() * 1.4));
                                car.setBrokenLights(false);
                            }
                            case "Skoda", "Hyundai", "Nissan" -> {
                                budget -= car.getPrice() * (0.07 + 0.07);
                                car.setPrice((int) (car.getPrice() * 1.4));
                                car.setBrokenLights(false);
                            }
                            case "Fiat", "Opel", "Dacia" -> {
                                budget -= car.getPrice() * (0.07 + 0.06);
                                car.setPrice((int) (car.getPrice() * 1.4));
                                car.setBrokenLights(false);
                            }
                            case "Peugeot", "Renault", "Citroen" -> {
                                budget -= car.getPrice() * (0.07 + 0.05);
                                car.setPrice((int) (car.getPrice() * 1.4));
                                car.setBrokenLights(false);
                            }
                        }
                    }
                }
            }

        }
        if (partToRepair.equals("Wheels")) {
            if (car.isBrokenWheels()) {
                if (Math.random() < 0.001) {
                    System.out.println("Mechanic Janusz nie udało mu się naprawić opon");
                    car.setBrokenWheels(true);
                } else {
                    if (Math.random() < 0.0001) {
                        car.setBrokenWheels(true);
                        System.out.println("Mechanic Janusz zepsuł opony");
                    } else {
                        switch (car.getModel()) {
                            case "Mercedes", "Audi", "BMW" -> {
                                budget -= car.getPrice() * (0.05 + 0.1);
                                car.setPrice((int) (car.getPrice() * 1.4));
                                car.setBrokenWheels(false);
                            }
                            case "Volvo", "Ford", "Volkswagen" -> {
                                budget -= car.getPrice() * (0.05 + 0.09);
                                car.setPrice((int) (car.getPrice() * 1.4));
                                car.setBrokenWheels(false);
                            }
                            case "Toyota", "Honda", "Kia", "Mazda", "Suzuki" -> {
                                budget -= car.getPrice() * (0.05 + 0.08);
                                car.setPrice((int) (car.getPrice() * 1.4));
                                car.setBrokenWheels(false);
                            }
                            case "Skoda", "Hyundai", "Nissan" -> {
                                budget -= car.getPrice() * (0.05 + 0.07);
                                car.setPrice((int) (car.getPrice() * 1.4));
                                car.setBrokenWheels(false);
                            }
                            case "Fiat", "Opel", "Dacia" -> {
                                budget -= car.getPrice() * (0.05 + 0.06);
                                car.setPrice((int) (car.getPrice() * 1.4));
                                car.setBrokenWheels(false);
                            }
                            case "Peugeot", "Renault", "Citroen" -> {
                                budget -= car.getPrice() * (0.05 + 0.05);
                                car.setPrice((int) (car.getPrice() * 1.4));
                                car.setBrokenWheels(false);
                            }
                        }
                    }
                }
            }


        }


    }

    public void repairCarByMechanicAdrian(Car car, String partToRepair) {
        if (partToRepair.equals("Engine")) {
            if (car.isBrokenEngine()) {
                if (Math.random() < 0.25) {
                    System.out.println("Mechanic Adrian nie udało mu się naprawić silnika");
                    car.setBrokenEngine(true);
                } else {
                    if (Math.random() < 0.1) {
                        car.setBrokenEngine(true);
                        System.out.println("Mechanic Adrian zepsuł silnik");
                    } else {
                        switch (car.getModel()) {
                            case "Mercedes", "Audi", "BMW" -> {
                                budget -= car.getPrice() * (0.05 + 0.11);
                                car.setPrice((int) (car.getPrice() * 2.5));
                                car.setBrokenEngine(false);
                            }
                            case "Volvo", "Ford", "Volkswagen" -> {
                                budget -= car.getPrice() * (0.05 + 0.09);
                                car.setPrice((int) (car.getPrice() * 2.5));
                                car.setBrokenEngine(false);
                            }
                            case "Toyota", "Honda", "Kia", "Mazda", "Suzuki" -> {
                                budget -= car.getPrice() * (0.05 + 0.08);
                                car.setPrice((int) (car.getPrice() * 2.5));
                                car.setBrokenEngine(false);
                            }
                            case "Skoda", "Hyundai", "Nissan" -> {
                                budget -= car.getPrice() * (0.05 + 0.07);
                                car.setPrice((int) (car.getPrice() * 2.5));
                                car.setBrokenEngine(false);
                            }
                            case "Fiat", "Opel", "Dacia" -> {
                                budget -= car.getPrice() * (0.05 + 0.06);
                                car.setPrice((int) (car.getPrice() * 2.5));
                                car.setBrokenEngine(false);
                            }
                            case "Peugeot", "Renault", "Citroen" -> {
                                budget -= car.getPrice() * (0.05 + 0.05);
                                car.setPrice((int) (car.getPrice() * 2.5));
                                car.setBrokenEngine(false);
                            }
                        }
                    }
                }
            }

        }

        if (partToRepair.equals("Brakes")) {
            if (car.isBrokenBrakes()) {
                if (Math.random() < 0.2) {
                    System.out.println("Mechanic Adrian nie udało mu się naprawić hamulców");
                    car.setBrokenBrakes(true);
                } else {
                    if (Math.random() < 0.1) {
                        car.setBrokenBrakes(true);
                        System.out.println("Mechanic Adrian zepsuł hamulce");
                    } else {
                        switch (car.getModel()) {
                            case "Mercedes", "Audi", "BMW" -> {
                                budget -= car.getPrice() * (0.02 + 0.07);
                                car.setPrice((int) (car.getPrice() * 1.4));
                                car.setBrokenBrakes(false);
                            }
                            case "Volvo", "Ford", "Volkswagen" -> {
                                budget -= car.getPrice() * (0.02 + 0.6);
                                car.setPrice((int) (car.getPrice() * 1.4));
                                car.setBrokenBrakes(false);
                            }
                            case "Toyota", "Honda", "Kia", "Mazda", "Suzuki" -> {
                                budget -= car.getPrice() * (0.02 + 0.05);
                                car.setPrice((int) (car.getPrice() * 1.4));
                                car.setBrokenBrakes(false);
                            }
                            case "Skoda", "Hyundai", "Nissan" -> {
                                budget -= car.getPrice() * (0.02 + 0.04);
                                car.setPrice((int) (car.getPrice() * 1.4));
                                car.setBrokenBrakes(false);
                            }
                            case "Fiat", "Opel", "Dacia" -> {
                                budget -= car.getPrice() * (0.02 + 0.03);
                                car.setPrice((int) (car.getPrice() * 1.4));
                                car.setBrokenBrakes(false);
                            }
                            case "Peugeot", "Renault", "Citroen" -> {
                                budget -= car.getPrice() * (0.02 + 0.02);
                                car.setPrice((int) (car.getPrice() * 1.4));
                                car.setBrokenBrakes(false);
                            }
                        }
                    }
                }
            }


        }
        if (partToRepair.equals("Transmission")) {
            if (car.isBrokenTransmission()) {
                if (Math.random() < 0.2) {
                    System.out.println("Mechanic Adrian nie udało mu się naprawić skrzyni biegów");
                    car.setBrokenTransmission(true);
                } else {
                    if (Math.random() < 0.1) {
                        car.setBrokenTransmission(true);
                        System.out.println("Mechanic Adrian zepsuł skrzynię biegów");
                    } else {
                        switch (car.getModel()) {
                            case "Mercedes", "Audi", "BMW" -> {
                                budget -= car.getPrice() * (0.05 + 0.1);
                                car.setPrice((int) (car.getPrice() * 1.9));
                                car.setBrokenTransmission(false);
                            }
                            case "Volvo", "Ford", "Volkswagen" -> {
                                budget -= car.getPrice() * (0.05 + 0.09);
                                car.setPrice((int) (car.getPrice() * 1.9));
                                car.setBrokenTransmission(false);
                            }
                            case "Toyota", "Honda", "Kia", "Mazda", "Suzuki" -> {
                                budget -= car.getPrice() * (0.05 + 0.08);
                                car.setPrice((int) (car.getPrice() * 1.9));
                                car.setBrokenTransmission(false);
                            }
                            case "Skoda", "Hyundai", "Nissan" -> {
                                budget -= car.getPrice() * (0.05 + 0.07);
                                car.setPrice((int) (car.getPrice() * 1.9));
                                car.setBrokenTransmission(false);
                            }
                            case "Fiat", "Opel", "Dacia" -> {
                                budget -= car.getPrice() * (0.05 + 0.06);
                                car.setPrice((int) (car.getPrice() * 1.9));
                                car.setBrokenTransmission(false);
                            }
                            case "Peugeot", "Renault", "Citroen" -> {
                                budget -= car.getPrice() * (0.05 + 0.05);
                                car.setPrice((int) (car.getPrice() * 1.9));
                                car.setBrokenTransmission(false);
                            }
                        }
                    }
                }

            }


        }

        if (partToRepair.equals("Lights")) {
            if (car.isBrokenLights()) {
                if (Math.random() < 0.2) {
                    System.out.println("Mechanic Adrian nie udało mu się naprawić świateł");
                    car.setBrokenLights(true);
                } else {
                    if (Math.random() < 0.1) {
                        car.setBrokenLights(true);
                        System.out.println("Mechanic Adrian zepsuł światła");
                    } else {
                        switch (car.getModel()) {
                            case "Mercedes", "Audi", "BMW" -> {
                                budget -= car.getPrice() * (0.02 + 0.1);
                                car.setPrice((int) (car.getPrice() * 1.4));
                                car.setBrokenLights(false);
                            }
                            case "Volvo", "Ford", "Volkswagen" -> {
                                budget -= car.getPrice() * (0.02 + 0.09);
                                car.setPrice((int) (car.getPrice() * 1.4));
                                car.setBrokenLights(false);
                            }
                            case "Toyota", "Honda", "Kia", "Mazda", "Suzuki" -> {
                                budget -= car.getPrice() * (0.02 + 0.08);
                                car.setPrice((int) (car.getPrice() * 1.4));
                                car.setBrokenLights(false);
                            }
                            case "Skoda", "Hyundai", "Nissan" -> {
                                budget -= car.getPrice() * (0.02 + 0.07);
                                car.setPrice((int) (car.getPrice() * 1.4));
                                car.setBrokenLights(false);
                            }
                            case "Fiat", "Opel", "Dacia" -> {
                                budget -= car.getPrice() * (0.02 + 0.06);
                                car.setPrice((int) (car.getPrice() * 1.4));
                                car.setBrokenLights(false);
                            }
                            case "Peugeot", "Renault", "Citroen" -> {
                                budget -= car.getPrice() * (0.02 + 0.05);
                                car.setPrice((int) (car.getPrice() * 1.4));
                                car.setBrokenLights(false);
                            }
                        }
                    }
                }
            }

        }


        if (partToRepair.equals("Wheels")) {
            if (car.isBrokenWheels()) {
                if (Math.random() < 0.2) {
                    System.out.println("Mechanic Adrian nie udało mu się naprawić opon");
                    car.setBrokenWheels(true);
                } else {
                    if (Math.random() < 0.1) {
                        car.setBrokenWheels(true);
                        System.out.println("Mechanic Adrian zepsuł opony");
                    } else {
                        switch (car.getModel()) {
                            case "Mercedes", "Audi", "BMW" -> {
                                budget -= car.getPrice() * (0.02 + 0.1);
                                car.setPrice((int) (car.getPrice() * 1.4));
                                car.setBrokenWheels(false);
                            }
                            case "Volvo", "Ford", "Volkswagen" -> {
                                budget -= car.getPrice() * (0.02 + 0.09);
                                car.setPrice((int) (car.getPrice() * 1.4));
                                car.setBrokenWheels(false);
                            }
                            case "Toyota", "Honda", "Kia", "Mazda", "Suzuki" -> {
                                budget -= car.getPrice() * (0.02 + 0.08);
                                car.setPrice((int) (car.getPrice() * 1.4));
                                car.setBrokenWheels(false);
                            }
                            case "Skoda", "Hyundai", "Nissan" -> {
                                budget -= car.getPrice() * (0.02 + 0.07);
                                car.setPrice((int) (car.getPrice() * 1.4));
                                car.setBrokenWheels(false);
                            }
                            case "Fiat", "Opel", "Dacia" -> {
                                budget -= car.getPrice() * (0.02 + 0.06);
                                car.setPrice((int) (car.getPrice() * 1.4));
                                car.setBrokenWheels(false);
                            }
                            case "Peugeot", "Renault", "Citroen" -> {
                                budget -= car.getPrice() * (0.02 + 0.05);
                                car.setPrice((int) (car.getPrice() * 1.4));
                                car.setBrokenWheels(false);
                            }
                        }
                    }
                }
            }

        }


    }

    public int repairCostAdrian(Car carToRepair, String partToRepair) {
        int repairCost = 0;
        switch (partToRepair) {
            case "engine" -> {
                if (carToRepair.isBrokenEngine()) {
                    switch (carToRepair.getModel()) {
                        case "Mercedes", "Audi", "BMW" -> {
                            repairCost = (int) (carToRepair.getPrice() * (0.05 + 0.11));
                        }
                        case "Volvo", "Ford", "Volkswagen" -> {
                            repairCost = (int) (carToRepair.getPrice() * (0.05 + 0.09));
                        }
                        case "Toyota", "Honda", "Kia", "Mazda", "Suzuki" -> {
                            repairCost = (int) (carToRepair.getPrice() * (0.05 + 0.08));
                        }
                        case "Skoda", "Hyundai", "Nissan" -> {
                            repairCost = (int) (carToRepair.getPrice() * (0.05 + 0.07));
                        }
                        case "Fiat", "Opel", "Dacia" -> {
                            repairCost = (int) (carToRepair.getPrice() * (0.05 + 0.06));
                        }
                        case "Peugeot", "Renault", "Citroen" -> {
                            repairCost = (int) (carToRepair.getPrice() * (0.05 + 0.05));
                        }
                    }
                }
            }
            case "transmission" -> {
                if (carToRepair.isBrokenTransmission()) {
                    switch (carToRepair.getModel()) {
                        case "Mercedes", "Audi", "BMW" -> {
                            repairCost = (int) (carToRepair.getPrice() * (0.05 + 0.1));
                        }
                        case "Volvo", "Ford", "Volkswagen" -> {
                            repairCost = (int) (carToRepair.getPrice() * (0.05 + 0.09));
                        }
                        case "Toyota", "Honda", "Kia", "Mazda", "Suzuki" -> {
                            repairCost = (int) (carToRepair.getPrice() * (0.05+ 0.08));
                        }
                        case "Skoda", "Hyundai", "Nissan" -> {
                            repairCost = (int) (carToRepair.getPrice() * (0.05+ 0.07));
                        }
                        case "Fiat", "Opel", "Dacia" -> {
                            repairCost = (int) (carToRepair.getPrice() * (0.05+ 0.06));
                        }
                        case "Peugeot", "Renault", "Citroen" -> {
                            repairCost = (int) (carToRepair.getPrice() * (0.05+ 0.05));
                        }
                    }
                }
            }
            case "wheels" -> {
                if (carToRepair.isBrokenWheels()) {
                    switch (carToRepair.getModel()) {
                        case "Mercedes", "Audi", "BMW" -> {
                            repairCost = (int) (carToRepair.getPrice() * (0.02 + 0.1));
                        }
                        case "Volvo", "Ford", "Volkswagen" -> {
                            repairCost = (int) (carToRepair.getPrice() * (0.02 + 0.09));
                        }
                        case "Toyota", "Honda", "Kia", "Mazda", "Suzuki" -> {
                            repairCost = (int) (carToRepair.getPrice() * (0.02 + 0.08));
                        }
                        case "Skoda", "Hyundai", "Nissan" -> {
                            repairCost = (int) (carToRepair.getPrice() * (0.02 + 0.07));
                        }
                        case "Fiat", "Opel", "Dacia" -> {
                            repairCost = (int) (carToRepair.getPrice() * (0.02 + 0.06));
                        }
                        case "Peugeot", "Renault", "Citroen" -> {
                            repairCost = (int) (carToRepair.getPrice() * (0.02 + 0.05));
                        }
                    }
                }
            }
            case "brakes" -> {
                if (carToRepair.isBrokenBrakes()) {
                    switch (carToRepair.getModel()) {
                        case "Mercedes", "Audi", "BMW" -> {
                            repairCost = (int) (carToRepair.getPrice() * (0.02 + 0.07));
                        }
                        case "Volvo", "Ford", "Volkswagen" -> {
                            repairCost = (int) (carToRepair.getPrice() * (0.02 + 0.06));
                        }
                        case "Toyota", "Honda", "Kia", "Mazda", "Suzuki" -> {
                            repairCost = (int) (carToRepair.getPrice() * (0.02 + 0.05));
                        }
                        case "Skoda", "Hyundai", "Nissan" -> {
                            repairCost = (int) (carToRepair.getPrice() * (0.02 + 0.04));
                        }
                        case "Fiat", "Opel", "Dacia" -> {
                            repairCost = (int) (carToRepair.getPrice() * (0.02 + 0.03));
                        }
                        case "Peugeot", "Renault", "Citroen" -> {
                            repairCost = (int) (carToRepair.getPrice() * (0.02 + 0.02));
                        }
                    }
                }
            }
            case "lights" -> {
                if (carToRepair.isBrokenLights()) {
                    switch (carToRepair.getModel()) {
                        case "Mercedes", "Audi", "BMW" -> {
                            repairCost = (int) (carToRepair.getPrice() * (0.02 + 0.1));
                        }
                        case "Volvo", "Ford", "Volkswagen" -> {
                            repairCost = (int) (carToRepair.getPrice() * (0.02 + 0.09));
                        }
                        case "Toyota", "Honda", "Kia", "Mazda", "Suzuki" -> {
                            repairCost = (int) (carToRepair.getPrice() * (0.02 + 0.08));
                        }
                        case "Skoda", "Hyundai", "Nissan" -> {
                            repairCost = (int) (carToRepair.getPrice() * (0.02 + 0.07));
                        }
                        case "Fiat", "Opel", "Dacia" -> {
                            repairCost = (int) (carToRepair.getPrice() * (0.02 + 0.06));
                        }
                        case "Peugeot", "Renault", "Citroen" -> {
                            repairCost = (int) (carToRepair.getPrice() * (0.02 + 0.05));
                        }
                    }
                }
            }
        }
        return repairCost;
    }

    public int repairCostMarian(Car carToRepair, String partToRepair) {
        int repairCost = 0;
        switch (partToRepair) {
            case "engine" -> {
                if (carToRepair.isBrokenEngine()) {
                    switch (carToRepair.getModel()) {
                        case "Mercedes", "Audi", "BMW" -> {
                            repairCost = (int) (carToRepair.getPrice() * (0.1 + 0.11));
                        }
                        case "Volvo", "Ford", "Volkswagen" -> {
                            repairCost = (int) (carToRepair.getPrice() * (0.1 + 0.09));
                        }
                        case "Toyota", "Honda", "Kia", "Mazda", "Suzuki" -> {
                            repairCost = (int) (carToRepair.getPrice() * (0.1 + 0.08));
                        }
                        case "Skoda", "Hyundai", "Nissan" -> {
                            repairCost = (int) (carToRepair.getPrice() * (0.1 + 0.07));
                        }
                        case "Fiat", "Opel", "Dacia" -> {
                            repairCost = (int) (carToRepair.getPrice() * (0.1 + 0.06));
                        }
                        case "Peugeot", "Renault", "Citroen" -> {
                            repairCost = (int) (carToRepair.getPrice() * (0.1 + 0.05));
                        }
                    }
                }
            }
            case "transmission" -> {
                if (carToRepair.isBrokenTransmission()) {
                    switch (carToRepair.getModel()) {
                        case "Mercedes", "Audi", "BMW" -> {
                            repairCost = (int) (carToRepair.getPrice() * (0.1 + 0.1));
                        }
                        case "Volvo", "Ford", "Volkswagen" -> {
                            repairCost = (int) (carToRepair.getPrice() * (0.1 + 0.09));
                        }
                        case "Toyota", "Honda", "Kia", "Mazda", "Suzuki" -> {
                            repairCost = (int) (carToRepair.getPrice() * (0.1 + 0.08));
                        }
                        case "Skoda", "Hyundai", "Nissan" -> {
                            repairCost = (int) (carToRepair.getPrice() * (0.1 + 0.07));
                        }
                        case "Fiat", "Opel", "Dacia" -> {
                            repairCost = (int) (carToRepair.getPrice() * (0.1 + 0.06));
                        }
                        case "Peugeot", "Renault", "Citroen" -> {
                            repairCost = (int) (carToRepair.getPrice() * (0.1 + 0.05));
                        }
                    }
                }
            }
            case "brakes" -> {
                if (carToRepair.isBrokenBrakes()) {
                    switch (carToRepair.getModel()) {
                        case "Mercedes", "Audi", "BMW" -> {
                            repairCost = (int) (carToRepair.getPrice() * (0.03 + 0.07));
                        }
                        case "Volvo", "Ford", "Volkswagen" -> {
                            repairCost = (int) (carToRepair.getPrice() * (0.03 + 0.06));
                        }
                        case "Toyota", "Honda", "Kia", "Mazda", "Suzuki" -> {
                            repairCost = (int) (carToRepair.getPrice() * (0.03 + 0.05));
                        }
                        case "Skoda", "Hyundai", "Nissan" -> {
                            repairCost = (int) (carToRepair.getPrice() * (0.03 + 0.04));
                        }
                        case "Fiat", "Opel", "Dacia" -> {
                            repairCost = (int) (carToRepair.getPrice() * (0.03 + 0.03));
                        }
                        case "Peugeot", "Renault", "Citroen" -> {
                            repairCost = (int) (carToRepair.getPrice() * (0.03 + 0.02));
                        }
                    }
                }
            }
            case "lights" -> {
                if (carToRepair.isBrokenLights()) {
                    switch (carToRepair.getModel()) {
                        case "Mercedes", "Audi", "BMW" -> {
                            repairCost = (int) (carToRepair.getPrice() * (0.05 + 0.1));
                        }
                        case "Volvo", "Ford", "Volkswagen" -> {
                            repairCost = (int) (carToRepair.getPrice() * (0.05 + 0.09));
                        }
                        case "Toyota", "Honda", "Kia", "Mazda", "Suzuki" -> {
                            repairCost = (int) (carToRepair.getPrice() * (0.05 + 0.08));
                        }
                        case "Skoda", "Hyundai", "Nissan" -> {
                            repairCost = (int) (carToRepair.getPrice() * (0.05 + 0.07));
                        }
                        case "Fiat", "Opel", "Dacia" -> {
                            repairCost = (int) (carToRepair.getPrice() * (0.05 + 0.06));
                        }
                        case "Peugeot", "Renault", "Citroen" -> {
                            repairCost = (int) (carToRepair.getPrice() * (0.05 + 0.05));
                        }
                    }
                }
            }
            case "wheels" -> {
                if (carToRepair.isBrokenWheels()) {
                    switch (carToRepair.getModel()) {
                        case "Mercedes", "Audi", "BMW" -> {
                            repairCost = (int) (carToRepair.getPrice() * (0.03 + 0.1));
                        }
                        case "Volvo", "Ford", "Volkswagen" -> {
                            repairCost = (int) (carToRepair.getPrice() * (0.03 + 0.09));
                        }
                        case "Toyota", "Honda", "Kia", "Mazda", "Suzuki" -> {
                            repairCost = (int) (carToRepair.getPrice() * (0.03 + 0.08));
                        }
                        case "Skoda", "Hyundai", "Nissan" -> {
                            repairCost = (int) (carToRepair.getPrice() * (0.03 + 0.07));
                        }
                        case "Fiat", "Opel", "Dacia" -> {
                            repairCost = (int) (carToRepair.getPrice() * (0.03 + 0.06));
                        }
                        case "Peugeot", "Renault", "Citroen" -> {
                            repairCost = (int) (carToRepair.getPrice() * (0.03 + 0.05));
                        }
                    }
                }
            }
        }
        return repairCost;
    }


    public int repairCostJanusz(Car carToRepair, String partToRepair) {
        int repairCost = 0;
        switch (partToRepair) {
            case "engine" -> {
                if (carToRepair.isBrokenEngine()) {
                    switch (carToRepair.getModel()) {
                        case "Mercedes", "Audi", "BMW" -> {
                            repairCost = (int) (carToRepair.getPrice() * (0.15 + 0.11));
                        }
                        case "Volvo", "Ford", "Volkswagen" -> {
                            repairCost = (int) (carToRepair.getPrice() * (0.15 + 0.09));
                        }
                        case "Toyota", "Honda", "Kia", "Mazda", "Suzuki" -> {
                            repairCost = (int) (carToRepair.getPrice() * (0.15 + 0.08));
                        }
                        case "Skoda", "Hyundai", "Nissan" -> {
                            repairCost = (int) (carToRepair.getPrice() * (0.15 + 0.07));
                        }
                        case "Fiat", "Opel", "Dacia" -> {
                            repairCost = (int) (carToRepair.getPrice() * (0.15 + 0.06));
                        }
                        case "Peugeot", "Renault", "Citroen" -> {
                            repairCost = (int) (carToRepair.getPrice() * (0.15 + 0.05));
                        }
                    }
                }
            }
            case "transmission" -> {
                if (carToRepair.isBrokenTransmission()) {
                    switch (carToRepair.getModel()) {
                        case "Mercedes", "Audi", "BMW" -> {
                            repairCost = (int) (carToRepair.getPrice() * (0.15 + 0.1));
                        }
                        case "Volvo", "Ford", "Volkswagen" -> {
                            repairCost = (int) (carToRepair.getPrice() * (0.15 + 0.09));
                        }
                        case "Toyota", "Honda", "Kia", "Mazda", "Suzuki" -> {
                            repairCost = (int) (carToRepair.getPrice() * (0.15 + 0.08));
                        }
                        case "Skoda", "Hyundai", "Nissan" -> {
                            repairCost = (int) (carToRepair.getPrice() * (0.15 + 0.07));
                        }
                        case "Fiat", "Opel", "Dacia" -> {
                            repairCost = (int) (carToRepair.getPrice() * (0.15 + 0.06));
                        }
                        case "Peugeot", "Renault", "Citroen" -> {
                            repairCost = (int) (carToRepair.getPrice() * (0.15 + 0.05));
                        }
                    }
                }
            }
            case "lights" -> {
                if (carToRepair.isBrokenLights()) {
                    switch (carToRepair.getModel()) {
                        case "Mercedes", "Audi", "BMW" -> {
                            repairCost = (int) (carToRepair.getPrice() * (0.07 + 0.1));
                        }
                        case "Volvo", "Ford", "Volkswagen" -> {
                            repairCost = (int) (carToRepair.getPrice() * (0.07 + 0.09));
                        }
                        case "Toyota", "Honda", "Kia", "Mazda", "Suzuki" -> {
                            repairCost = (int) (carToRepair.getPrice() * (0.07 + 0.08));
                        }
                        case "Skoda", "Hyundai", "Nissan" -> {
                            repairCost = (int) (carToRepair.getPrice() * (0.07 + 0.07));
                        }
                        case "Fiat", "Opel", "Dacia" -> {
                            repairCost = (int) (carToRepair.getPrice() * (0.07 + 0.06));
                        }
                        case "Peugeot", "Renault", "Citroen" -> {
                            repairCost = (int) (carToRepair.getPrice() * (0.07 + 0.05));
                        }
                    }
                }
            }
            case "wheels" -> {
                if (carToRepair.isBrokenWheels()) {
                    switch (carToRepair.getModel()) {
                        case "Mercedes", "Audi", "BMW" -> {
                            repairCost = (int) (carToRepair.getPrice() * (0.05 + 0.1));
                        }
                        case "Volvo", "Ford", "Volkswagen" -> {
                            repairCost = (int) (carToRepair.getPrice() * (0.05 + 0.09));
                        }
                        case "Toyota", "Honda", "Kia", "Mazda", "Suzuki" -> {
                            repairCost = (int) (carToRepair.getPrice() * (0.05 + 0.08));
                        }
                        case "Skoda", "Hyundai", "Nissan" -> {
                            repairCost = (int) (carToRepair.getPrice() * (0.05 + 0.07));
                        }
                        case "Fiat", "Opel", "Dacia" -> {
                            repairCost = (int) (carToRepair.getPrice() * (0.05 + 0.06));
                        }
                        case "Peugeot", "Renault", "Citroen" -> {
                            repairCost = (int) (carToRepair.getPrice() * (0.05 + 0.05));
                        }
                    }
                }
            }
            case "brakes" -> {
                if (carToRepair.isBrokenBrakes()) {
                    switch (carToRepair.getModel()) {
                        case "Mercedes", "Audi", "BMW" -> {
                            repairCost = (int) (carToRepair.getPrice() * (0.05 + 0.07));
                        }
                        case "Volvo", "Ford", "Volkswagen" -> {
                            repairCost = (int) (carToRepair.getPrice() * (0.05 + 0.06));
                        }
                        case "Toyota", "Honda", "Kia", "Mazda", "Suzuki" -> {
                            repairCost = (int) (carToRepair.getPrice() * (0.05 + 0.05));
                        }
                        case "Skoda", "Hyundai", "Nissan" -> {
                            repairCost = (int) (carToRepair.getPrice() * (0.05 + 0.04));
                        }
                        case "Fiat", "Opel", "Dacia" -> {
                            repairCost = (int) (carToRepair.getPrice() * (0.05 + 0.03));
                        }
                        case "Peugeot", "Renault", "Citroen" -> {
                            repairCost = (int) (carToRepair.getPrice() * (0.05 + 0.02));
                        }
                    }
                }
            }
        }
        return repairCost;
    }




}