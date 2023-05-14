import java.awt.print.Book;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) throws SQLException {
        final String user = "postgres";
        final String password = "1201";
        final String url = "jdbc:postgresql://localhost:5432/skypro";

        try (final Connection connection = DriverManager.getConnection(url, password, user)) {
            try (PreparedStatement statement = connection.prepareStatement("SELECT * FROM jobs WHERE id = (?)")) {
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


                    try (Connection connection = DriverManager.getConnection(url, user, password)) {

                        // Создаем объект класса JobsDAOImpl
                        JobsDAO jobsDAO = new JobsDAOImpl(connection);

                        City city = new City("Volgogdar", 1);
                        Jobs jobs = new Jobs("Anna Ivanovna", "girl", 56);

                        // Вызываем метод добавления объекта
                        jobsDAO.create(jobs);

                        // Создаем список наполняя его объектами, которые получаем
                        // путем вызова метода для получения всех элементов таблицы
                        List<Jobs> list = new ArrayList<>(jobsDAO.readAll());

                        // Выведем список в консоль
                        for (Jobs jobs1 : list) {
                            System.out.println(jobs);
                        }

                    }


                }
            }
        }
    }
}
