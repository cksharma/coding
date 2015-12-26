import java.text.DecimalFormat;
import java.util.*;

public class MainEntry {
    public static void main(String[] args) {

        if (args == null || args.length != 3) {
            throw new InvalidInputException(Constants.INVALID_ARGUMENTS);
        }
        try {
            double userY = Double.parseDouble(args[0]);
            double userX = Double.parseDouble(args[1]);
            String fileName = args[2];

            List<CoffeeShop> coffeeShopList = FileUtils.parseCoffeeListFromFile(fileName);

            CoffeePriorityQueue coffeeQueue = new CoffeePriorityQueue();
            Queue<CoffeeShop> coffeeShopsQueue = coffeeQueue.getClosestCoffeeShops(userY, userX, coffeeShopList);
            List<CoffeeShop> coffeeShops = new ArrayList<CoffeeShop>();

            while (!coffeeShopsQueue.isEmpty()) {
                CoffeeShop coffeeShop = coffeeShopsQueue.poll();
                coffeeShops.add(coffeeShop);
            }

            Collections.sort(coffeeShops, new CoffeeShopsComparator(userY, userX));
            Collections.reverse(coffeeShops);
            for (CoffeeShop coffeeShop : coffeeShops) {
                double distance = Utils.getDistance(userY, userX, coffeeShop.getY(), coffeeShop.getX());
                String distanceStr = new DecimalFormat("#.####").format(distance);
                System.out.println(coffeeShop.getName() + "," + distanceStr);
            }
        } catch (Exception e) {
            System.out.println(Constants.MALFORMED_INPUT);
        }
    }
}
