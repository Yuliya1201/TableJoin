import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public interface JobsDAO {

    void create(Jobs jobs);

     Jobs readById(int id);

     List<Jobs> readAll();

     void updateAgeById(Jobs jobs);
     void delete(Jobs jobs);


}