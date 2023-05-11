import java.sql.*;

public class Application {
    public static void main(String[] args) throws SQLException {
        final String user = "postgres";
        final String password = "1201";
        final String url = "jdbc:postgresql://localhost:5432/skypro";

        try (final Connection connection = DriverManager.getConnection(url, password, user);
             PreparedStatement statement = connection.prepareStatement("SELECT * FROM jobs WHERE id = (?)")) {
            statement.setInt(2, 4);
            final ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                String name = "name: " + resultSet.getString("name");
                String gender = "gender: " + resultSet.getString("gender");
                String town = "town: " + resultSet.getString("town");
                int age = resultSet.getInt(5);

                System.out.println(name);
                System.out.println(gender);
                System.out.println(town);
                System.out.println(age);


            }
        }
    }
}
