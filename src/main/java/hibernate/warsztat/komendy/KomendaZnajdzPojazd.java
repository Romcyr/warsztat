package hibernate.warsztat.komendy;

import hibernate.warsztat.DataAccessObject;
import hibernate.warsztat.HibernateUtil;
import hibernate.warsztat.model.Pojazd;
import org.hibernate.Session;

import java.util.List;

public class KomendaZnajdzPojazd implements Komenda{
    private DataAccessObject<Pojazd> dataAccessObject;

    public KomendaZnajdzPojazd() {
        this.dataAccessObject = new DataAccessObject<>();
    }

    @Override
    public String getKomenda() {

        return "znajdz pojazd";
    }

    @Override
    public void obsluga() {
        System.out.println("Podaj id szukanego pojazdu");
        String idString = Komenda.scanner.nextLine();
        Long id = Long.parseLong(idString);


        try (Session session = HibernateUtil.INSTANCE.getSessionFactory().openSession()){
            Pojazd pojazd = session.get(Pojazd.class, id);
            if (pojazd != null){
                System.out.println(pojazd);
            }else {
                System.err.println("Nie znaleziono auta");
            }
    }catch (Exception ioe){
            System.err.println("Błąd bazy: " + ioe);
        }
}
}
