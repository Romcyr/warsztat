package hibernate.warsztat.komendy;

import hibernate.warsztat.DataAccessObject;
import hibernate.warsztat.HibernateUtil;
import hibernate.warsztat.model.Pojazd;
import hibernate.warsztat.model.SerwisPojazdu;
import jakarta.persistence.TypedQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class KomendaListPojazd implements Komenda{
    private DataAccessObject<SerwisPojazdu> dataAccessObject;

    public KomendaListPojazd() {
        this.dataAccessObject = new DataAccessObject<>();
    }




    @Override
    public String getKomenda() {

        return "lista pojazd";
    }

    @Override
    public void obsluga() {
        List<SerwisPojazdu> serwis = dataAccessObject.findAll(SerwisPojazdu.class);
        serwis.forEach(System.out::println);

    }
}
