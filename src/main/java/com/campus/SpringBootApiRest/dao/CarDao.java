package com.campus.SpringBootApiRest.dao;
import com.campus.SpringBootApiRest.model.Car;
import java.util.List;


public interface CarDao {
    public List<Car> findAll();
    public Car findById(int id);
    public Car save(Car car);
    public Car delete(int id);
    public Car update(Car car);
}
