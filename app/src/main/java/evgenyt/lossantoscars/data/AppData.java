package evgenyt.lossantoscars.data;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import evgenyt.lossantoscars.utils.ResourcesLoader;

public class AppData {

    private static AppData appData;
    private List<Car> carList = new ArrayList<>();

    private AppData() {
        List<String> carItems = ResourcesLoader.getInstance().getStringArray("car_list");
        carList.clear();
        for (String carItem : carItems) {
            String[] itemArray = carItem.split(",");
            carList.add(new Car(itemArray[0], itemArray[1]));
        }
        Collections.sort(carList);
    }

    public static AppData getInstance() {
        if (appData == null) {
            appData = new AppData();
        }
        return appData;
    }

    public List<Car> getCarList() {
        return carList;
    }

    public Car getCarByName(String name) {
        for (Car car : carList)
            if (car.getName().equals(name))
                return car;
        return null;
    }

}
