import com.mysql.jdbc.UpdatableResultSet;

import java.sql.*;
import java.util.Scanner;

public class SelectCatalog {
    public static void main(String[] args) {
        String name = "root";
        String password = "Root";
        String URL = "jdbc:mysql://localhost:3306/mysql?useSSL=false";
        try (Connection connection = DriverManager.getConnection(URL, name, password)) {

            Scanner scanner = new Scanner(System.in);
            String catStr = scanner.nextLine();
            Statement statement = connection.createStatement();

            ResultSet resultSet = statement.executeQuery("SELECT name FROM catalog WHERE id = '" + catStr + "'");
            if (resultSet.next() == true) {
                String str = resultSet.getString("name");
                System.out.println(str);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
