import java.util.Comparator;

public class CoffeeShopsComparator implements Comparator<CoffeeShop> {

    private double userY;
    private double userX;

    public CoffeeShopsComparator(double userY, double userX) {
        this.userY = userY;
        this.userX = userX;
    }

    @Override
    public int compare(CoffeeShop o1, CoffeeShop o2) {
        double distance1 = Utils.getDistance(userY, userX, o1.getY(), o1.getX());
        double distance2 = Utils.getDistance(userY, userX, o2.getY(), o2.getX());

        if (distance1 > distance2) return -1;
        if (distance2 < distance1) return 1;
        return 0;
    }
}
