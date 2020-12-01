import com.mysql.jdbc.UpdatableResultSet;

import java.sql.*;
import java.util.Scanner;
public class InsertCatalog {
    public static void main(String[] args) {
        String name = "root";
        String password = "Root";
        String URL = "jdbc:mysql://localhost:3306/mysql?useSSL=false";
        try (Connection connection = DriverManager.getConnection(URL, name, password)) {

            Scanner scanner = new Scanner(System.in);
            String catStr = scanner.nextLine();
            Statement statement = connection.createStatement();
            statement.execute("INSERT INTO catalog VALUE (id, '" + catStr + "')");

            /* Заполнение из консоли mysql, для удобста вытаскивания присвоил id
            CREATE TABLE catalog (id int auto_increment, name char (100), primary key (id));
            INSERT INTO catalog VALUE (id, 'Золотая Обертка');
            INSERT INTO catalog VALUE (id, 'Бардовая Обертка');
            INSERT INTO catalog VALUE (id, 'Астра');
            INSERT INTO catalog VALUE (id, 'КорзинкаТип1');
            INSERT INTO catalog VALUE (id, 'КорзинкаТип2');
            INSERT INTO catalog VALUE (id, 'КорзинкаТип3');
            INSERT INTO catalog VALUE (id, 'открыткаНовыйгод');
            INSERT INTO catalog VALUE (id, 'открыткаАпельсин');
            INSERT INTO catalog VALUE (id, 'открыткаВалентин');
            INSERT INTO catalog VALUE (id, 'Амариллис');
            INSERT INTO catalog VALUE (id, 'Агапантус');
            INSERT INTO catalog VALUE (id, 'Астра');
            */

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}