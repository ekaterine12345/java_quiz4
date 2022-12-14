import org.w3c.dom.ls.LSOutput;

import java.sql.SQLException;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws SQLException, RuntimeException {
        ProductUtil.createTable();
        ProductUtil.insertProduct(new Product("Sugar", "Mexico",15, 709, 3 ));
        ProductUtil.insertProduct(new Product("Car", "BMW", 40000, 2022, 2));
        ProductUtil.insertProduct(new Product("Car", "Mercedes-Benz", 10000, 2009, 5));
        ProductUtil.insertProduct(new Product("Sugar", "Georgia", 10, 2021, 10));
        ProductUtil.insertProduct(new Product("Water", "Borjomi", 5, 2020, 100));
        ProductUtil.insertProduct(new Product("Coffee", "Brazil", 10, 2021, 5));

        ProductUtil.getNameAmount()
                .forEach(System.out::println);

        System.out.println();
        ProductUtil.getNameQuantity()
                .forEach(System.out::println);

        System.out.println();

        Map<String, Integer> ansMap = ProductUtil.selectNameQuantities();
        System.out.println(ansMap);

        ProductUtil.updateProductCreator(3L, "Porsche");
        ProductUtil.updateProduct(5L, "New Sugar", "Georgia!", 30, 2022, 12);
        ProductUtil.deleteProduct(8L);

        //ProductUtil.deleteAll();
    }
}