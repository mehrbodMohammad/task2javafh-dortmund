import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws IOException {
        Car[] cars = new Car[5];

        cars[0] = new Car();
        cars[0].setModel("BMW");
        cars[0].setPrice(150d);
        cars[0].setYearOfManufacture(2015);
        cars[0].setColor("White");
        cars[0].setRegistrationNumber("3426523463245");
        cars[0].setMake("");
        cars[0].setId(1);

        cars[1] = new Car();
        cars[1].setModel("BMW");
        cars[1].setPrice(250d);
        cars[1].setYearOfManufacture(1995);
        cars[1].setColor("Black");
        cars[1].setRegistrationNumber("534745245");
        cars[1].setMake("");
        cars[1].setId(2);

        cars[2] = new Car();
        cars[2].setModel("Porsche");
        cars[2].setPrice(550d);
        cars[2].setYearOfManufacture(2020);
        cars[2].setColor("Blue");
        cars[2].setRegistrationNumber("9567");
        cars[2].setMake("");
        cars[2].setId(3);

        cars[3] = new Car();
        cars[3].setModel("Porsche");
        cars[3].setPrice(1550d);
        cars[3].setYearOfManufacture(2015);
        cars[3].setColor("Blue");
        cars[3].setRegistrationNumber("955432567");
        cars[3].setMake("");
        cars[3].setId(4);

        cars[4] = new Car();
        cars[4].setModel("Porsche");
        cars[4].setPrice(1250d);
        cars[4].setYearOfManufacture(2012);
        cars[4].setColor("Blue");
        cars[4].setRegistrationNumber("955432567");
        cars[4].setMake("");
        cars[4].setId(5);

        ////

        // list of cars of a given brand
        {
            String model = "Porsche";
            ArrayList<Car> selectedCars = new ArrayList<>();
            for(Car car : cars)
            {
                if(model.equals(car.getModel()))
                {
                    selectedCars.add(car);
                }
            }

            writeToFile("D:\\carsWithGivenBrand.txt", selectedCars);
        }

        // a list of cars of a given model that have been in use for more than n years
        {
            String model = "Porsche";
            Integer fromYear = 2016;

            ArrayList<Car> selectedCars = new ArrayList<>();
            for(Car car : cars)
            {
                if(model.equals(car.getModel()) && car.getYearOfManufacture() > fromYear)
                {
                    selectedCars.add(car);
                }
            }

            writeToFile("D:\\carsWithGivenModelAndMoreThanNYears.txt", selectedCars);
        }

        // a list of cars of a given year of manufacture, the price of which is higher than the specified one
        {
            Integer year = 2015;
            Double fromPrice = 1000d;

            ArrayList<Car> selectedCars = new ArrayList<>();
            for(Car car : cars)
            {
                if(year.equals(car.getYearOfManufacture()) && car.getPrice() > fromPrice)
                {
                    selectedCars.add(car);
                }
            }

            writeToFile("D:\\carsWithYearAndHigherPrice.txt", selectedCars);
        }

    }

    public static void writeToFile(String path, ArrayList<Car> selectedCars) throws IOException {
        String content = "";
        for(Car car : selectedCars)
        {
            content+= "Id: "+car.getId()
                    +", Make: "+car.getMake()
                    +", Model: "+car.getModel()
                    +", YearOfManufacture: "+car.getYearOfManufacture()
                    +", RegistrationNumber: "+car.getRegistrationNumber()
                    +", Price: "+car.getPrice()
                    +", Color: "+car.getColor()
            +"\r\n";
        }

        Files.writeString(Path.of(path), content);
    }

}