package hibernate.warsztat.komendy;

import hibernate.warsztat.DataAccessObject;
import hibernate.warsztat.HibernateUtil;
import hibernate.warsztat.model.Mechanik;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class KomendaDodajMechanik implements Komenda{

    public KomendaDodajMechanik() {

        this.dataAccessObject = new DataAccessObject<>();
    }

    private DataAccessObject<Mechanik> dataAccessObject;


    @Override
    public String getKomenda(){
        return "dodaj mechanik";
    }

    @Override
    public void obsluga(){
        System.out.println("Podaj imie");
        String imie = Komenda.scanner.nextLine();

        System.out.println("Podaj kwalifikacje");
        String kwalifikacje = Komenda.scanner.nextLine();

        System.out.println("Podaj specjalizacje");
        String specjalizacje = Komenda.scanner.nextLine();

        Mechanik mechanik = Mechanik.builder()
                .imie(imie)
                .kwalifikacja(kwalifikacje)
                .specjalizacja(specjalizacje)
                .build();
        dataAccessObject.insert(mechanik);

    }
}
