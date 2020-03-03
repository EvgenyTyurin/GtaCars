package evgenyt.gtacars.data;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import evgenyt.gtacars.utils.ResourcesLoader;

public class AppData {

    private static AppData appData;
    private List<GtaCar> carList = new ArrayList<>();

    private AppData() {
        List<String> carItems = ResourcesLoader.getInstance().getStringArray("car_list");
        carList.clear();
        for (String carItem : carItems) {
            String[] itemArray = carItem.split(",");
            carList.add(new GtaCar(itemArray[0], itemArray[1]));
        }
        Collections.sort(carList);
    }

    public static AppData getInstance() {
        if (appData == null) {
            appData = new AppData();
        }
        return appData;
    }

    public List<GtaCar> getCarList() {
        return carList;
    }

    public GtaCar getCarByName(String name) {
        for (GtaCar gtaCar : carList)
            if (gtaCar.getName().equals(name))
                return gtaCar;
        return null;
    }

}
