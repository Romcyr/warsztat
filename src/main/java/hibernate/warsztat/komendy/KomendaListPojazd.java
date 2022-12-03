package hibernate.warsztat.komendy;

import hibernate.warsztat.HibernateUtil;
import hibernate.warsztat.model.Pojazd;
import jakarta.persistence.TypedQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class KomendaListPojazd implements Komenda{


    @Override
    public String getKomenda() {
        return "lista pojazd";
    }

    @Override
    public void obsluga() {
        try (Session session = HibernateUtil.INSTANCE.getSessionFactory().openSession()){
             TypedQuery<Pojazd> zapytanie = session.createQuery("FROM", Pojazd.class);
             List<Pojazd> lista = zapytanie.getResultList();

             lista.forEach(System.out::println);
             }catch (Exception e){
        System.err.println("Błąd: " + e);
        }
    }
}
