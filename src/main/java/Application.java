import java.awt.print.Book;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) throws SQLException {
       		    JobsDAO jobsDAO = new JobsDAOImpl();
        CityDAO cityDao = new CityDAOImpl();

        City city1 = new City("Novgorod",1);
        cityDao.createCity(city1);


        //При запуске приложения обе таблицы - jobs и city - пустые
        // добавляя город, мы не указываем его id - он устанавливается БД самостоятельно
        //Значит, мы можем получить его id, чтобы этот город (как объект) - указать как поле класса Jobs
        City cityForJobs = cityDao.getByIdCity(1);

        //Создаем объект employee
        Jobs jobs = new Jobs(1, "Darya Ivanova", "woman", 25);

        //Заполняем поле city в объекте jobs
        jobs.setId(city1.getId());

        //Добавим jobs в БД
        jobsDAO.create(jobs);

        //Удалим cityForJobs
        cityDao.deleteCity(cityForJobs);
    }
}

