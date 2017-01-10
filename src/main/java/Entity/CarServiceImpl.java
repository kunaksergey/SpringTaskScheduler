package Entity;

import com.google.common.collect.Lists;
import org.joda.time.DateTime;
import org.joda.time.Years;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

/**
 * Created by sa on 10.01.17.
 */
@Service("carService")
@Repository
@Transactional
public class CarServiceImpl implements CarService {
    final Logger logger= LoggerFactory.getLogger(CarServiceImpl.class);

    @Autowired
    CarRepository carRepository;

    public List<Car> findAll() {
        return Lists.newArrayList(carRepository.findAll());
    }

    public Car save(Car car) {
        return carRepository.save(car);
    }

    public void updateCarAgeJob() {
        List<Car> cars=findAll();
        DateTime currentDate= DateTime.now();
        logger.info("Car age apdate started");
        for(Car car:cars){
            int age= Years.yearsBetween(car.getManufactureDate(),currentDate).getYears();
            car.setAge(age);
            save(car);
            logger.info("Car age apdate---"+car);
        }
        logger.info("Car age apdate job complete successfully");
    }
}
