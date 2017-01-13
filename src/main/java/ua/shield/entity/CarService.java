package ua.shield.entity;

import java.util.List;

/**
 * Created by sa on 10.01.17.
 */
public interface CarService {
    List<Car> findAll();
    Car save(Car car);
    void updateCarAgeJob();

}
