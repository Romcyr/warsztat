package hibernate.warsztat.komendy;

import hibernate.warsztat.DataAccessObject;
import hibernate.warsztat.HibernateUtil;
import hibernate.warsztat.model.Mechanik;
import hibernate.warsztat.model.Pojazd;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class KomendaUsunMechanik implements Komenda{
    private DataAccessObject<Mechanik> dataAccessObject;

    public KomendaUsunMechanik(){
        this.dataAccessObject = new DataAccessObject<>();}


    @Override
    public String getKomenda() {
        return "usun mechanik";
    }

    @Override
    public void obsluga() {
        System.out.println("Podaj id usuwanego mechanika");
        String idString = Komenda.scanner.nextLine();
        Long id = Long.parseLong(idString);


            if (dataAccessObject.delete(Mechanik.class, id)) {
                System.out.println("Usunięto mechanika");
            }else {
                System.err.println("Nie udało się usunąć mechanika");
            }


    }
}
