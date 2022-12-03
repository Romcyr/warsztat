package hibernate.warsztat.komendy;

import hibernate.warsztat.DataAccessObject;
import hibernate.warsztat.HibernateUtil;
import hibernate.warsztat.model.Pojazd;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class KomendaUsunPojazd implements Komenda{
    private DataAccessObject<Pojazd> dataAccessObject;

    public KomendaUsunPojazd(){
        this.dataAccessObject = new DataAccessObject<>();}


    @Override
    public String getKomenda() {
        return "usun pojazd";
    }

    @Override
    public void obsluga() {
        System.out.println("Podaj id usuwanego pojazdu");
        String idString = Komenda.scanner.nextLine();
        Long id = Long.parseLong(idString);


            if (dataAccessObject.delete(Pojazd.class, id)) {
                System.out.println("Usunięto pojazd");
            }else {
                System.err.println("Nie znaleziono pojazdu w bazie");
            }



    }
}
