package hibernate.warsztat.komendy;

import hibernate.warsztat.DataAccessObject;
import hibernate.warsztat.HibernateUtil;
import hibernate.warsztat.model.Mechanik;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class KomendaAktualizujMechanik implements Komenda {

    public KomendaAktualizujMechanik() {

        this.dataAccessObject = new DataAccessObject<>();
    }

    private DataAccessObject<Mechanik> dataAccessObject;


    @Override
    public String getKomenda() {
        return "aktualizuj mechanik";
    }

    @Override
    public void obsluga() {
        System.out.println("Podaj id mechanika");
        String idString = Komenda.scanner.nextLine();
        Long id = Long.parseLong(idString);

        //TODO: sprawdz czy rekord istnieje zanim podasz X dodatkowych danych
        if (dataAccessObject.exists(Mechanik.class, id)){
            System.err.println("Błąd, mechanik o takim id nie istnieje");
            return;
        }

        System.out.println("Podaj imie");
        String imie = Komenda.scanner.nextLine();

        System.out.println("Podaj kwalifikacje");
        String kwalifikacje = Komenda.scanner.nextLine();

        System.out.println("Podaj specjalizacje");
        String specjalizacje = Komenda.scanner.nextLine();

        Mechanik mechanik = Mechanik.builder()
                .specjalizacja(specjalizacje)
                .kwalifikacja(kwalifikacje)
                .imie(imie)
                .id(id)// dopisujemy Id poniewaz do aktualizacji musimy poidac id aktualizowanego rekordu
                .build();

       dataAccessObject.update(Mechanik.class, id, mechanik);
    }
}
