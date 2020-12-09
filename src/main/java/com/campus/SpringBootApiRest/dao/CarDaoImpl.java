package com.campus.SpringBootApiRest.dao;
import com.campus.SpringBootApiRest.model.Car;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.ArrayList;

@Repository
public class CarDaoImpl implements CarDao{

    public static List<Car> cars = new ArrayList<>();

    static {
        cars.add(new Car(1, "Fiesta", "Ford", "noire"));
        cars.add(new Car(2, "Mondeo", "Ford", "gris"));
        cars.add(new Car(3, "A7", "Audi", "noire"));
    }

    @Override
    public List <Car> findAll() {
        return cars;
    }

    @Override
    public Car findById(int id) {
        for (Car car : cars){
            if(car.getId() == id){
                return car;
            }
        }
        return null;
    }

    @Override
    public Car save(Car car) {
        cars.add(car);
        return car;
    }

    @Override
    public Car delete(int id) {
        cars.removeIf(car -> car.getId() == id);
        return null;
    }

    @Override
    public Car update(Car wanted_car) {
        for (Car car : cars){
            if(car.getId() == wanted_car.getId()){
                int index = cars.indexOf(car);
                cars.set(index, wanted_car);
                return wanted_car;
            }
        }
        return null;
    }
}
