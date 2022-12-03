package hibernate.warsztat;

import hibernate.warsztat.model.Mechanik;
import hibernate.warsztat.model.Pojazd;
import jakarta.persistence.TypedQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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

    public Optional<T> find (Class<T> tClass, Long id){

        try (Session session = HibernateUtil.INSTANCE.getSessionFactory().openSession()){
           T encja = session.get(tClass, id);
            return Optional.ofNullable(encja);
        }catch (Exception ioe){
            System.err.println("Błąd bazy: " + ioe);
        }
        return Optional.empty();
    }
    public boolean delete(Class<T> tClass, Long id){

        try (Session session = HibernateUtil.INSTANCE.getSessionFactory().openSession()){
            Transaction transaction = session.beginTransaction();

            // sprawdz czy istnieje, pobierz z bazy i sprawcz czy nbie jest null
            T encja = session.get(tClass, id);
            if (encja == null){
                return false; // nie ma encji z takim id
            }

            session.remove(encja);
            transaction.commit();
            return true; //znajdz encje i ja usun, zrob commit
        }catch (Exception ioe){
            System.err.println("Błąd bazy: " + ioe);
        }
        return false;// wystąpił błąd, rekord nie został usuniety
    }


}
