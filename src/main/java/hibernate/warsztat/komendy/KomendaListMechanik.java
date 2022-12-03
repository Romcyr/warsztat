package hibernate.warsztat.komendy;

import hibernate.warsztat.HibernateUtil;
import hibernate.warsztat.model.Mechanik;
import hibernate.warsztat.model.Pojazd;
import jakarta.persistence.TypedQuery;
import org.hibernate.Session;

import java.util.List;

public class KomendaListMechanik implements Komenda{
    @Override
    public String getKomenda() {
        return "lista mechanik";
    }

    @Override
    public void obsluga() {
        try (Session session = HibernateUtil.INSTANCE.getSessionFactory().openSession()){
            TypedQuery<Mechanik> zapytanie = session.createQuery("FROM", Mechanik.class);
            List<Mechanik> lista = zapytanie.getResultList();

            lista.forEach(System.out::println);
        }catch (Exception e){
            System.err.println("Błąd: " + e);
        }
    }
}
