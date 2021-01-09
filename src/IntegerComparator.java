import java.util.Comparator;

public class IntegerComparator implements Comparator<City> {


    @Override
    public int compare(City t1, City t2) {
        return t1.calculateDensity() - t2.calculateDensity();
    }
}
