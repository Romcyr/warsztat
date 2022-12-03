package hibernate.warsztat.komendy;

import hibernate.warsztat.DataAccessObject;
import hibernate.warsztat.HibernateUtil;
import hibernate.warsztat.model.Mechanik;
import hibernate.warsztat.model.Pojazd;
import jakarta.persistence.TypedQuery;
import org.hibernate.Session;

import java.util.List;

public class KomendaListMechanik implements Komenda{

    private DataAccessObject<Mechanik> dataAccessObject;

    public KomendaListMechanik() {
        this.dataAccessObject = new DataAccessObject<>();
    }


    @Override
    public String getKomenda() {
        return "lista mechanik";
    }

    @Override
    public void obsluga() {
        List<Mechanik> mechanik = dataAccessObject.findAll(Mechanik.class);
        mechanik.forEach(System.out::println);
    }
}
