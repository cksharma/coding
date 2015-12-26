import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class CoffeePriorityQueue {

    public Queue<CoffeeShop> getClosestCoffeeShops(double userY, double userX, List<CoffeeShop> coffeeShopList) {
        Queue<CoffeeShop> queue = new PriorityQueue<>(new CoffeeShopsComparator(userY, userX));
        int k = Math.min(coffeeShopList.size(), Constants.PRIORITY_QUEUE_SIZE);

        for (int i = 0; i < k; i++) {
            CoffeeShop coffeeShop = coffeeShopList.get(i);
            queue.add(coffeeShop);
        }
        for (int i = k; i < coffeeShopList.size(); i++) {
            CoffeeShop coffeeShop = coffeeShopList.get(i);
            CoffeeShop top = queue.peek();

            double distanceNew = Utils.getDistance(userY, userX, coffeeShop.getY(), coffeeShop.getX());
            double distanceTop = Utils.getDistance(userY, userX, top.getY(), top.getX());

            if (distanceNew < distanceTop) {
                queue.poll();
                queue.add(coffeeShop);
            }
        }
        return queue;
    }
}
