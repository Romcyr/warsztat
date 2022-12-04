package hibernate.warsztat.komendy;

import hibernate.warsztat.DataAccessObject;
import hibernate.warsztat.model.Mechanik;
import hibernate.warsztat.model.Pojazd;

public class KomendaAktualizujPojazd implements Komenda {

    public KomendaAktualizujPojazd() {

        this.dataAccessObject = new DataAccessObject<>();
    }

    private DataAccessObject<Pojazd> dataAccessObject;


    @Override
    public String getKomenda() {
        return "aktualizuj pojazd";
    }

    @Override
    public void obsluga() {
        System.out.println("Podaj id pojazdu");
        String idString = Komenda.scanner.nextLine();
        Long id = Long.parseLong(idString);

        //TODO: sprawdz czy rekord istnieje zanim podasz X dodatkowych danych
        if (dataAccessObject.exists(Pojazd.class, id)){
            System.err.println("Błąd, pojazd o takim id nie istnieje");
            return;
        }

        System.out.println("Podaj markę pojazdu");
        String marka = Komenda.scanner.nextLine();

        System.out.println("Podaj model pojazdu");
        String model = Komenda.scanner.nextLine();

        System.out.println("Podaj vin pojazdu");
        String vin = Komenda.scanner.nextLine();

        System.out.println("Podaj nr rejestracyjny pojazdu");
        String nrRej = Komenda.scanner.nextLine();

       Pojazd pojazd = Pojazd.builder()
               .marka(marka)
               .model(model)
               .vin(vin)
               .nrRej(nrRej)
               .id(id)// dopisujemy Id poniewaz do aktualizacji musimy poidac id aktualizowanego rekordu
               .build();

       dataAccessObject.update(Pojazd.class, id, pojazd);
    }
}
