package hibernate.warsztat.komendy;

import hibernate.warsztat.DataAccessObject;
import hibernate.warsztat.HibernateUtil;
import hibernate.warsztat.model.Pojazd;
import jakarta.persistence.TypedQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class KomendaListPojazd implements Komenda{
    private DataAccessObject<Pojazd> dataAccessObject;

    public KomendaListPojazd() {
        this.dataAccessObject = new DataAccessObject<>();
    }




    @Override
    public String getKomenda() {

        return "lista pojazd";
    }

    @Override
    public void obsluga() {
        List<Pojazd> pojazd = dataAccessObject.findAll(Pojazd.class);
        pojazd.forEach(System.out::println);

    }
}
