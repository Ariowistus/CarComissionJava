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
    }


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
            System.out.println("Wziełeś małą pożyczke ale bd się opłacać");
        }
        return (int) budget;
    }

    public List<Car> getPurchasedCars() {
        if (purchasedCars.isEmpty()) {
            System.out.println("Nie kupiłeś jeszcze żadnego samochodu");
            return purchasedCars;
        }
        return purchasedCars;
    }

    //stwórz metode która pokazuje co jest zepsute w zakupionym samochodzie
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
    }

    //stwórz metode która naprawia uszkodzenia w samochodzie i zmniejsza budżet o koszt naprawy i podcene samochodu w zalznosci od uszkodzen
    //naprawa silnika kosztuje 30% wartości  ale zwiększa wartośc auta o 100%
    //naprawa kół kosztuje 10% wartości  ale zwiększa wartośc auta o 50%
    //naprawa świateł kosztuje 5% wartości  ale zwiększa wartośc auta o 20%
    //naprawa hamulców kosztuje 5% wartości  ale zwiększa wartośc auta o 20%
    //naprawa skrzyni biegów kosztuje 10% wartości  ale zwiększa wartośc auta o 50%
    public void repairCar(Car car) {
        if (car.isBrokenEngine()) {
            budget -= car.getPrice() * 0.3;
            car.setPrice(car.getPrice() * 2);
            car.setBrokenEngine(false);
        }
        if (car.isBrokenWheels()) {
            budget -= car.getPrice() * 0.1;
            car.setPrice((int) (car.getPrice() * 1.5));
            car.setBrokenWheels(false);
        }
        if (car.isBrokenLights()) {
            budget -= car.getPrice() * 0.05;
            car.setPrice((int) (car.getPrice() * 1.2));
            car.setBrokenLights(false);
        }
        if (car.isBrokenBrakes()) {
            budget -= car.getPrice() * 0.05;
            car.setPrice((int) (car.getPrice() * 1.2));
            car.setBrokenBrakes(false);
        }
        if (car.isBrokenTransmission()) {
            budget -= car.getPrice() * 0.1;
            car.setPrice((int) (car.getPrice() * 1.5));
            car.setBrokenTransmission(false);
        }
    }


    public void sellCar(Car car) {
        budget += car.getPrice();
        purchasedCars.remove(car);
    }
    //  Mechanik Adrian który jest  najtańszy, ale ma 20% szans, że nie uda mu się naprawić i 2% szans, że zepsuje coś innego podczas naprawy
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
    }
    // Mechanik Janusz który jest najdroższy ale ma 100 % szans, że uda mu się naprawić i 5% szans, że zepsuje coś innego podczas naprawy
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
    }
    //Marian - bierze zdecydowanie mniej niż Janusz, ale masz 10% szans, że nie uda mu się naprawić samochodu i konieczna będzie interwencja Janusza
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
    }





}