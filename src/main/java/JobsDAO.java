import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public interface JobsDAO {

    //void create(Jobs jobs);

   // Jobs readById(int id);

   // List<Jobs> readAll();

   // void updateAgeById(int id, int age);

   // void deleteById(int id);



@Override

   public void create(Jobs jobs) {

        // Формируем запрос к базе с помощью PreparedStatement
    try (PreparedStatement statement = connection.prepareStatement(
                "INSERT INTO jobs (name, gender, age) VALUES ((?), (?), (?))")) {

            // Подставляем значение вместо wildcard
            // первым параметром указываем порядковый номер wildcard
            // вторым параметром передаем значение
            statement.setString(1, jobs.getName());
            statement.setString(2, jobs.getGender());
            statement.setInt(3, jobs.getAge());

            // С помощью метода executeQuery отправляем запрос к базе
            statement.executeQuery();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    @Override
public Jobs readById(int id) {

    Jobs jobs = new Jobs(resultSet.getString("name"));
				// Формируем запрос к базе с помощью PreparedStatement
        try (PreparedStatement statement = connection.prepareStatement(
"SELECT * FROM jobs INNER JOIN name ON jobs.id=jobs.id AND jobs_id=(?)")) {

						// Подставляем значение вместо wildcard
            statement.setInt(1, id);

						// Делаем запрос к базе и результат кладем в ResultSet
            ResultSet resultSet = statement.executeQuery();

						// Методом next проверяем есть ли следующий элемент в resultSet
						// и одновременно переходим к нему, если таковой есть
            while(resultSet.next()) {

								// С помощью методов getInt и getString получаем данные из resultSet
								// и присваиваем их полим объекта
                jobs.setId(Integer.parseInt(resultSet.getString("book_id")));
                jobs.setName(resultSet.getString("title"));
                jobs.setGender(new Jobs(resultSet.getString("gender"));
                jobs.setAge(Integer.parseInt(resultSet.getString("age")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return jobs;
    }


    @Override
public List<Jobs> readAll() {

		// Создаем список, в который будем укладывать объекты
    List<Jobs> jobsList = new ArrayList<>();

    try(PreparedStatement statement = connection.prepareStatement(
"SELECT * FROM jobs INNER JOIN city ON jobs.city_id=city.city_id")) {

        ResultSet resultSet = statement.executeQuery();
        while (resultSet.next()) {

            int id = Integer.parseInt(resultSet.getString("city_id"));
            String name = resultSet.getString("name");
            String gender = resultSet.getString("gender");
            City city = new City(resultSet.getString("city_id"),
                        resultSet.getInt("name"));
            int age = Integer.parseInt(resultSet.getString("age"));


						// Создаем объекты на основе полученных данных
						// и укладываем их в итоговый список
            jobsList.add(new Jobs(id,gender, name, age));
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }

    return jobsList;
}


@Override
public void updateAgeById(int id, int age) {

    try(PreparedStatement statement = connection.prepareStatement(
"UPDATE jobs SET age=(?) WHERE city_id=(?)")) {

        statement.setInt(1, age);
        statement.setInt(2, id);

        statement.executeUpdate();
    } catch (SQLException e) {
        e.printStackTrace();
    }
}

@Override
    public void deleteById(int id) {

        try(PreparedStatement statement = connection.prepareStatement(
"DELETE FROM jobs WHERE id=(?)")) {

            statement.setInt(1, id);
            statement.executeQuery();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}