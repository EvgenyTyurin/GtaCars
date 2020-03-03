package evgenyt.gtacars.data;

import java.util.Objects;

public class GtaCar implements Comparable{
    private final String name;
    private final String statImage;

    public GtaCar(String name, String statImage) {
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
        GtaCar gtaCar = (GtaCar) o;
        return Objects.equals(name, gtaCar.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public int compareTo(Object o) {
        GtaCar anotherCar = (GtaCar) o;
        return name.compareTo(anotherCar.name);
    }
}
