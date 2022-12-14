import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLTimeoutException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ProductUtil {
    private ProductUtil() {
    }

    public static void createTable() throws SQLException, RuntimeException {
        String createSql = "CREATE TABLE IF NOT EXISTS PRODUCTS_TB" +
                "(ID INTEGER not NULL AUTO_INCREMENT, " +
                " Name VARCHAR(255), " +
                " Creator VARCHAR(255), " +
                " Price INTEGER NOT NULL, " +
                " Year INTEGER NOT NULL, " +
                " Quantity INTEGER NOT NULL, " +
                " PRIMARY KEY ( ID ))";

      //  String createSql = "DROP TABLE PRODUCTS_TB";

        JDBCUtil.getStatement().executeUpdate(createSql);

        System.out.println("Created Table in given database if it is not exists");
    }

    public static void insertProduct(Product product) throws SQLException, RuntimeException {
        String insertSql = "INSERT INTO PRODUCTS_TB(Name, Creator, Price, Year, Quantity) VALUES( "
                +"'"+product.getName()+"', "
                +"'"+product.getCreator()+"', "
                +"'"+product.getPrice()+"', "
                +"'"+product.getYear()+"', "
                +"'"+product.getQuantity()+"' )";

        JDBCUtil.getStatement().executeUpdate(insertSql);

        System.out.println("Inserted product "+product.getName()+" into table Successfully!");
    }

    public static List<MyProduct> getNameQuantity() throws SQLException {
        String selectNames = "SELECT Name,SUM(Quantity) as SM FROM PRODUCTS_TB GROUP BY Name";
        List<MyProduct> myProducts = new ArrayList<>();

        ResultSet resultSet = JDBCUtil.getStatement().executeQuery(selectNames);
        while (resultSet.next()){
            myProducts.add(new MyProduct(
                    resultSet.getString("Name"),
                    resultSet.getLong("SM")
            ));
        }
      return myProducts;
    }


    public static List<MyProduct> getNameAmount() throws SQLException {
        String selectNames = "SELECT Name,Count(ID) FROM PRODUCTS_TB GROUP BY Name";
        List<MyProduct> myProducts = new ArrayList<>();

        ResultSet resultSet = JDBCUtil.getStatement().executeQuery(selectNames);
        while (resultSet.next()){
            myProducts.add(new MyProduct(
                    resultSet.getString("Name"),
                    resultSet.getLong("Count(ID)")
            ));
        }
        return myProducts;
    }

    public static Map<String, Integer> selectNameQuantities() throws SQLException {
        String selectProducts = "SELECT * FROM PRODUCTS_TB";
        List<Product> products = new ArrayList<>();

        ResultSet resultSet = JDBCUtil.getStatement().executeQuery(selectProducts);
        while (resultSet.next()){
            products.add(new Product(
                    resultSet.getString("Name"),
                    resultSet.getString("Creator"),
                    resultSet.getInt("Price"),
                    resultSet.getInt("Year"),
                    resultSet.getInt("Quantity")
            ));

        }

        // System.out.println(products);
        /* Map<String, Long> myMap = products.stream().
       collect(Collectors.groupingBy(p -> p.getName(), Collectors.counting())); */

        Map<String, Integer> myMap = products.stream()
                .collect(Collectors.groupingBy(Product::getName, Collectors.summingInt(Product::getQuantity)));
        return myMap;
    }


    public static void updateProductCreator(Long id, String creator) throws SQLException, RuntimeException {
        String updateSql = "UPDATE PRODUCTS_TB SET Creator = '"+creator+"' WHERE ID = "+id;
        JDBCUtil.getStatement().executeUpdate(updateSql);
        System.out.println("UPDATE has Successfully completed!");
    }

    public static void updateProduct(Long id, String name, String creator, Integer price, Integer year, Integer quantity) throws SQLException, RuntimeException {
        String updateSql = "UPDATE PRODUCTS_TB SET Name = '"+name
                +"', Creator = '"+creator
                +"', Price = "+price
                +", Year = "+year
                +", Quantity = "+quantity
                +"  WHERE ID = "+id;
        JDBCUtil.getStatement().executeUpdate(updateSql);
        System.out.println("UPDATE has Successfully completed!");
    }


    public static void deleteProduct(Long id) throws SQLException, RuntimeException {
        String deleteProductSQL = "DELETE FROM PRODUCTS_TB WHERE ID = "+id;
        JDBCUtil.getStatement().executeUpdate(deleteProductSQL);
        System.out.println("Successfully deleted product ID="+id);
    }

    public static void deleteAll() throws SQLException,RuntimeException {
        String deleteAll = "DELETE FROM PRODUCTS_TB";
        JDBCUtil.getStatement().executeUpdate(deleteAll);
        System.out.println("Successfully deleted all products!");
    }
}
