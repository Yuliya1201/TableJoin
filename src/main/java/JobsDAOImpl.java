import org.hibernate.Session;
import org.hibernate.Transaction;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class JobsDAOImpl implements JobsDAO {


    @Override

    public void create(Jobs jobs) {

        try (Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();) {
            Transaction transaction = session.beginTransaction();

            session.save(jobs);
            transaction.commit();
        }
    }

    @Override
    public Jobs readById(int id) {

        return HibernateSessionFactoryUtil.getSessionFactory().openSession().get(Jobs.class, id);
    }
    @Override
    public void delete(Jobs jobs) {
        try (Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.delete(jobs);
            transaction.commit();

        }

}


         @Override
    public List<Jobs> getAllJobs() {
        try (Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession()) {
            return session.createQuery( "FROM Employee").list();
        }
    }



        @Override
        public void updateAgeById (Jobs jobs) {

            try (Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession()) {
                Transaction transaction = session.beginTransaction();
                session.update(jobs);
                transaction.commit();

            }
        }

}


