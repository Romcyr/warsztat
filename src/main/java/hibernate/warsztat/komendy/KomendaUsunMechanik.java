package hibernate.warsztat.komendy;

import hibernate.warsztat.DataAccessObject;
import hibernate.warsztat.HibernateUtil;
import hibernate.warsztat.model.Mechanik;
import hibernate.warsztat.model.Pojazd;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class KomendaUsunMechanik implements Komenda{
    private DataAccessObject<Pojazd> dataAccessObject;

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

        try (Session session = HibernateUtil.INSTANCE.getSessionFactory().openSession()){
            Transaction transaction = session.beginTransaction();

            Mechanik mechanik = session.get(Mechanik.class, id);
            if (mechanik != null) {
                session.remove(mechanik);
                System.out.println("Usunięto mechanika");
            }else {
                System.err.println("Nie znaleziono mechanika w bazie");
            }

            transaction.commit();
        }catch (Exception ioe){
            System.err.println("Błąd bazy: " + ioe);
        }

    }
}
