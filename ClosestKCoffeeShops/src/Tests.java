import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Queue;

/**
 * This is the unit test class which validates the output of the program.
 * The application entry file is MainEntry.java..
 */

public class Tests {
    public static void main(String[] args) {

        double userY = 47.6;
        double userX = -122.4;

        List<CoffeeShop> coffeeShopList = new ArrayList<>();
        coffeeShopList.add(new CoffeeShop("StarbucksSeattle", 47.5809, -122.3160));
        coffeeShopList.add(new CoffeeShop("StarbucksSF",37.5209,-122.3340));
        coffeeShopList.add(new CoffeeShop("StarbucksMoscow", 55.752047, 37.595242));
        coffeeShopList.add(new CoffeeShop("StarbucksSeattle2", 47.5869, -122.3368));
        coffeeShopList.add(new CoffeeShop("StarbucksRioDeJaneiro", -22.923489, -43.234418));
        coffeeShopList.add(new CoffeeShop("StarbucksSydney", -33.871843, 151.206767));

        CoffeePriorityQueue coffeePriorityQueue = new CoffeePriorityQueue();
        Queue<CoffeeShop> queue = coffeePriorityQueue.getClosestCoffeeShops(userY, userX, coffeeShopList);
        List<CoffeeShop> result = new ArrayList<>();

        while (queue.size() > 0) {
            result.add(queue.poll());
        }

        Collections.sort(result, new CoffeeShopsComparator(userY, userX));
        Collections.reverse(result);

        boolean firstMatch = matchClosest(result.get(0), userY, userX, "StarbucksSeattle2", 0.0645);
        boolean secondMatch = matchClosest(result.get(1), userY, userX, "StarbucksSeattle", 0.0861);
        boolean thirdMatch = matchClosest(result.get(2), userY, userX, "StarbucksSF", 10.0793);
        System.out.println("First results : " + firstMatch);
        System.out.println("Second results : " + secondMatch);
        System.out.println("Third results : " + thirdMatch);
    }

    private static boolean matchClosest(CoffeeShop top, double userY, double userX, String name, double distance) {
        String distanceTop = new DecimalFormat("#.####").format(Utils.getDistance(userY, userX, top.getY(), top.getX()));
        return (top.getName().equals(name) && distanceTop.equals(distance + ""));
    }
}
