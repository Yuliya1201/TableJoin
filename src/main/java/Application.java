import java.awt.print.Book;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) throws SQLException {
       		// Создаем объект класса ДАО
        JobsDAO jobsDAO = new JobsDAOImpl();

        Jobs jobs1 = new Jobs("Ivan Redov", "men", 22);
				// Создаем объект
        jobsDAO.create(jobs1);

				// Получаем объект по id
        System.out.println(jobsDAO.readById(1));

				// Получаем полный список объектов
        List<Jobs> list = jobsDAO.readAll();

        for (Jobs jobs : list) {
            System.out.println(jobs);
        }

        Jobs jobs2 = new Jobs(5, "Fedor Ivanovich", "men", 56);

				// Изменяем объект
        jobsDAO.updateAgeById(jobs2);

				// Удаляем объект
        jobsDAO.delete(jobs2);

    }
}

