import java.sql.*;

public class Main {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/skillbox";
        String user = "root";
        String pass = "sHterBen44";

        try {
            Connection connection = DriverManager.getConnection(url, user, pass);

            Statement statement = connection.createStatement();

            ResultSet resultSet = statement.executeQuery(
                    "SELECT \n" +
                            "\tpl.course_name, \n" +
                            "\tROUND(COUNT(pl.course_name) / (MAX(MONTH(pl.subscription_date)) - MIN(MONTH(pl.subscription_date)) + 1), 2) countSubscriptions\n" +
                            "FROM purchaselist pl\n" +
                            "WHERE YEAR(pl.subscription_date) = 2018\n" +
                            "GROUP BY course_name;");

            System.out.println("Среднее количество покупок в месяц для каждого курса за 2018 год:".concat("\n"));

            while (resultSet.next()) {
                String courseName = resultSet.getString("course_name");
                String countSubscriptions = resultSet.getString("countSubscriptions");
                System.out.println(courseName.concat(" -> ") + countSubscriptions);
            }

            resultSet.close();
            statement.close();
            connection.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
