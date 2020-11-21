import java.sql.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String name = "root";
        String password = "Root";
        String URL = "jdbc:mysql://localhost:3306/mysql?useSSL=false";
        try (Connection connection = DriverManager.getConnection(URL, name, password)) {
            System.out.println("Вводится id пользователя по его getChatId");
            Scanner scanner = new Scanner(System.in);
            String getChatId = "basket" + scanner.nextLine(); //вместо сканера берется getChatId (-‿‿-)
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM chatid WHERE id = '" + getChatId + "'");
            boolean inDataBase = resultSet.next();
            if (inDataBase == false) {
                String str = getChatId;
                statement.execute("CREATE TABLE " + str + "(product char (100), price double)");
                statement.execute("INSERT INTO chatid VALUE ('" + getChatId + "')");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
//CREATE TABLE orderList (id int, price double, qty int, status char (30));
//CREATE TABLE catalog (name char (100))