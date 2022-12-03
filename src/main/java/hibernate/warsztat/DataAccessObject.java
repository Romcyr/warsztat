package hibernate.warsztat;

import hibernate.warsztat.model.Pojazd;
import jakarta.persistence.TypedQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.List;

public class DataAccessObject <T>{

    public void insert(T obiektDoWstawieniaDoBazy) {
        try (Session session = HibernateUtil.INSTANCE.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();

            session.persist(obiektDoWstawieniaDoBazy);

            transaction.commit();
        } catch (Exception e) {
            System.err.println("Błąd: " + e);
        }


    }

    public List<T> findAll(Class<T> tClass) {
        List<T> list = new ArrayList<>();
        try (Session session = HibernateUtil.INSTANCE.getSessionFactory().openSession()){
            TypedQuery<T> zapytanie = session.createQuery("FROM " + tClass.getName(), tClass);
            List<T> lista = zapytanie.getResultList();
            list.addAll(zapytanie.getResultList());

            lista.forEach(System.out::println);
        }catch (Exception e){
            System.err.println("Błąd: " + e);
        }
        return list;
    }

}
