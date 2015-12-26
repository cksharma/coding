import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class FileUtils {
    public static List<CoffeeShop> parseCoffeeListFromFile(String filePath) throws Exception {
        List<CoffeeShop> coffeeShopList = new ArrayList<>();

        BufferedReader reader = new BufferedReader(new FileReader(new File(filePath)));
        String str;
        while ((str = reader.readLine()) != null) {
            String[] coffeeArr = str.split(",");
            String name = coffeeArr[0];
            double y = Double.parseDouble(coffeeArr[1]);
            double x = Double.parseDouble(coffeeArr[2]);
            coffeeShopList.add(new CoffeeShop(name, y, x));
        }

        return coffeeShopList;
    }
}
