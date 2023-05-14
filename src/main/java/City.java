import java.util.Objects;

public class City {
    private String city_name;
    private int id;

    public City (String city_name, Integer id) {
        this.city_name = city_name;
        this.id = id;
    }

    public String getCity_name() {
        return city_name;
    }

    public void setCity_name(String city_name) {
        this.city_name = city_name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (this == null || getClass() != o.getClass()) return false;
        City city = (City) o;
        return id == city.id && Objects.equals(city_name,city.city_name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(city_name,id);
    }

    @Override
    public String toString() {
        return "City{" + "id=" + id + ", name_city'" + city_name + '\'' + '}';
    }
}
