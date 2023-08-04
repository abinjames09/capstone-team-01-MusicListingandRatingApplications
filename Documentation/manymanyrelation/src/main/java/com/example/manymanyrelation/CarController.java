package com.example.manymanyrelation;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


class CarAlreadyExistException extends RuntimeException {
    public CarAlreadyExistException(String message) {
        super(message);
    }
}

@RestController
@RequestMapping("/car")
public class CarController {

    @Autowired
    private CarRepository cr;

    @GetMapping
    public ResponseEntity<List<Car>> findAll() {
        List<Car> cars = cr.findAll();
        return ResponseEntity.ok(cars);
    }

    @PostMapping
    public ResponseEntity<Car> addCar(@RequestBody Car c) { 
        if (c.getId() == null) {
            Car savedCar = cr.save(c);
            return ResponseEntity.ok(savedCar); 
        }
        else {
            throw new CarAlreadyExistException("Car with ID: " + c.getId() + " already exists");
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Car> findBBYid(@PathVariable("id") Integer id) {
        Optional<Car> temp = cr.findById(id);
        if (temp.isPresent()) {
            Car c = temp.get();
            return ResponseEntity.ok(c); 
        } else {
            return ResponseEntity.notFound().build(); 
        }
    }

    @PutMapping("/{id}")
public ResponseEntity<Car> updateCar(@PathVariable("id") Integer id, @RequestBody Car updatedCar) {
    Optional<Car> existingCarOptional = cr.findById(id);
    if (existingCarOptional.isPresent()) {
        Car existingCar = existingCarOptional.get();
        existingCar.setName(updatedCar.getName());
        existingCar.setWheels(updatedCar.getWheels());
        cr.save(existingCar);
        return ResponseEntity.ok(existingCar); 
    } else {
        return ResponseEntity.notFound().build(); 
    }
}

    @DeleteMapping("/{id}")
public ResponseEntity<Car> deleteCar(@PathVariable("id") Integer id) {
    Optional<Car> carOptional = cr.findById(id);
    if (carOptional.isPresent()) {
        Car car = carOptional.get();
        cr.delete(car);
        return ResponseEntity.ok(car); 
    } else {
        return ResponseEntity.notFound().build(); 
    }
}
@GetMapping("/car")
public ResponseEntity<List<Car>> findByname(@RequestParam("name") String name)
{
    List<Car> c=cr.findByName(name);
    return ResponseEntity.ok(c);
}
@GetMapping("/wheels")
public ResponseEntity<List<Car>> findByTYre(@RequestParam("wheels") Double wheels)
{
    List<Car> c=cr.findByWheels(wheels);
    return ResponseEntity.ok(c);
}

}

