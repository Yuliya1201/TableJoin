import java.util.List;

public interface CityDAO {


    // Добавление объекта
    void createCity(City city);

    // Получение объекта по id
    City getByIdCity(int id);

    // Получение всех объектов
    List<City> getAllCities();

    // Изменение объекта
    void updateCity(City city);

    // Удаление объекта
    void deleteCity(City city);
}

