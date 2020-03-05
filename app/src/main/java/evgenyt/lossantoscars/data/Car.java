package evgenyt.lossantoscars.data;

import java.util.Objects;

public class Car implements Comparable{
    private final String name;
    private final String statImage;

    public Car(String name, String statImage) {
        this.name = name;
        this.statImage = statImage;
    }

    public String getName() {
        return name;
    }

    public String getStatImage() {
        return statImage;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return Objects.equals(name, car.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public int compareTo(Object o) {
        Car anotherCar = (Car) o;
        return name.compareTo(anotherCar.name);
    }
}
