package com.campus.SpringBootApiRest.controller;
import com.campus.SpringBootApiRest.dao.CarDao;
import com.campus.SpringBootApiRest.model.Car;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MainController {

    @Autowired
    private CarDao carDao;

    @RequestMapping(value= "/car",method = RequestMethod.GET)
    public List<Car> listCars(){
        return carDao.findAll();
    }

    @RequestMapping(value = "/car/{id}", method = RequestMethod.GET)
    public Car displayCarById(@PathVariable int id){
        return carDao.findById(id);
    }

    @PostMapping(value = "/car")
    public Car addCar(@RequestBody Car car){
        return carDao.save(car);
    }

    @RequestMapping(value="/car/{id}", method = RequestMethod.DELETE)
    public Car deleteCar(@PathVariable int id){
       return carDao.delete(id);
    }

    @RequestMapping(value="/car/{id}", method = RequestMethod.PUT)
    public Car modifyCar(@RequestBody Car car) {
        return carDao.update(car);
    }


}
