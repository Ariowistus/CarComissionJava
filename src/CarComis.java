import java.util.ArrayList;
import java.util.List;

public class CarComis {

    private double budget;
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
            budget -= car.getPrice();
            purchasedCars.add(car);
            randomCars.remove(car);
            randomCars.add(new Car(randomModel,
                    randomColor, randomPrice, randomMileage,
                    randomSegment, randomBrokenEngine, randomBrokenWheels,
                    randomBrokenLights, randomBrokenBrakes, randomBrokenTransmission));

        } else {
            System.out.println("Nie masz wystarczająco pieniędzy");
        }


    } // metoda dodająca kupiony samochód do listy kupionych samochodów




    public Integer getBudget() {
        if (budget < 0) {
            System.out.println("Wziełeś małą pożyczke ale bd się opłacać");
        }
        return (int) budget;
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
        budget += car.getPrice();
        purchasedCars.remove(car);
    }// metoda sprzedająca samochód

    public void repairCarByMechanicAdrian(Car car) {
        if (car.isBrokenEngine()) {
            if (Math.random() < 0.2) {
                System.out.println("Mechanic Adrian nie udało mu się naprawić silnika");
            } else {
                if (Math.random() < 0.02) {
                    car.setBrokenEngine(true);
                    System.out.println("Mechanic Adrian zepsuł silnik");
                } else {
                    budget -= car.getPrice() * 0.3;
                    car.setPrice(car.getPrice() * 2);
                    car.setBrokenEngine(false);
                }
            }
        }
        if (car.isBrokenWheels()) {
            if (Math.random() < 0.2) {
                System.out.println("Mechanic Adrian nie udało mu się naprawić kół");
            } else {
                if (Math.random() < 0.02) {
                    car.setBrokenWheels(true);
                    System.out.println("Mechanic Adrian zepsuł kółka");
                } else {
                    budget -= car.getPrice() * 0.1;
                    car.setPrice((int) (car.getPrice() * 1.5));
                    car.setBrokenWheels(false);
                }
            }
        }
        if (car.isBrokenLights()) {
            if (Math.random() < 0.2) {
                System.out.println("Mechanic Adrian nie udało mu się naprawić świateł");
            } else {
                if (Math.random() < 0.02) {
                    car.setBrokenLights(true);
                    System.out.println("Mechanic Adrian zepsuł światła");
                } else {
                    budget -= car.getPrice() * 0.05;
                    car.setPrice((int) (car.getPrice() * 1.2));
                    car.setBrokenLights(false);
                }
            }
        }
        if (car.isBrokenBrakes()) {
            if (Math.random() < 0.2) {
                System.out.println("Mechanic Adrian nie udało mu się naprawić hamulców");
            } else {
                if (Math.random() < 0.02) {
                    car.setBrokenBrakes(true);
                    System.out.println("Mechanic Adrian zepsuł hamulce");
                } else {
                    budget -= car.getPrice() * 0.05;
                    car.setPrice((int) (car.getPrice() * 1.2));
                    car.setBrokenBrakes(false);
                }
            }
        }
    }// metoda naprawiająca samochód mechanicznym Adrianem

    public void repairCarByMechanicJanusz(Car car) {
        if (car.isBrokenEngine()) {
            if (Math.random() < 0.05) {
                car.setBrokenEngine(true);
                System.out.println("Mechanic Janusz zepsuł silnik");
            } else {
                budget -= car.getPrice() * 0.3;
                car.setPrice(car.getPrice() * 2);
                car.setBrokenEngine(false);
            }
        }
        if (car.isBrokenWheels()) {
            if (Math.random() < 0.05) {
                car.setBrokenWheels(true);
                System.out.println("Mechanic Janusz zepsuł kółka");
            } else {
                budget -= car.getPrice() * 0.1;
                car.setPrice((int) (car.getPrice() * 1.5));
                car.setBrokenWheels(false);
            }
        }
        if (car.isBrokenLights()) {
            if (Math.random() < 0.05) {
                car.setBrokenLights(true);
                System.out.println("Mechanic Janusz zepsuł światła");
            } else {
                budget -= car.getPrice() * 0.05;
                car.setPrice((int) (car.getPrice() * 1.2));
                car.setBrokenLights(false);
            }
        }
        if (car.isBrokenBrakes()) {
            if (Math.random() < 0.05) {
                car.setBrokenBrakes(true);
                System.out.println("Mechanic Janusz zepsuł hamulce");
            } else {
                budget -= car.getPrice() * 0.05;
                car.setPrice((int) (car.getPrice() * 1.2));
                car.setBrokenBrakes(false);
            }
        }
    }// metoda naprawiająca samochód mechanicznym Januszem

    public void repairCarByMechanicMarian(Car car) {
        if (car.isBrokenEngine()) {
            if (Math.random() < 0.1) {
                System.out.println("Mechanic Marian nie udało mu się naprawić silnika");
                repairCarByMechanicJanusz(car);
            } else {
                budget -= car.getPrice() * 0.3;
                car.setPrice(car.getPrice() * 2);
                car.setBrokenEngine(false);
            }
        }
        if (car.isBrokenWheels()) {
            if (Math.random() < 0.1) {
                System.out.println("Mechanic Marian nie udało mu się naprawić kół");
                repairCarByMechanicJanusz(car);
            } else {
                budget -= car.getPrice() * 0.1;
                car.setPrice((int) (car.getPrice() * 1.5));
                car.setBrokenWheels(false);
            }
        }
        if (car.isBrokenLights()) {
            if (Math.random() < 0.1) {
                System.out.println("Mechanic Marian nie udało mu się naprawić świateł");
                repairCarByMechanicJanusz(car);
            } else {
                budget -= car.getPrice() * 0.05;
                car.setPrice((int) (car.getPrice() * 1.2));
                car.setBrokenLights(false);
            }
        }
        if (car.isBrokenBrakes()) {
            if (Math.random() < 0.1) {
                System.out.println("Mechanic Marian nie udało mu się naprawić hamulców");
                repairCarByMechanicJanusz(car);
            } else {
                budget -= car.getPrice() * 0.05;
                car.setPrice((int) (car.getPrice() * 1.2));
                car.setBrokenBrakes(false);
            }
        }
    }// metoda naprawiająca samochód mechanicznym Marianem





}