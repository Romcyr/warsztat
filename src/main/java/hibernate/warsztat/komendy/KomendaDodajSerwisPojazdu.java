package hibernate.warsztat.komendy;

import hibernate.warsztat.DataAccessObject;
import hibernate.warsztat.model.Mechanik;
import hibernate.warsztat.model.Pojazd;
import hibernate.warsztat.model.SerwisPojazdu;

import java.util.Optional;

public class KomendaDodajSerwisPojazdu implements Komenda {

    public KomendaDodajSerwisPojazdu() {

        this.dataAccessObject = new DataAccessObject<>();
        this.dataAccessObjectPojazd = new DataAccessObject<>();
        this.dataAccessObjectMechanik = new DataAccessObject<>();

    }

    private DataAccessObject<SerwisPojazdu> dataAccessObject;
    private DataAccessObject<Pojazd> dataAccessObjectPojazd;
    private DataAccessObject<Mechanik> dataAccessObjectMechanik;



    @Override
    public String getKomenda(){
        return "dodaj serwis";
    }

    @Override
    public void obsluga(){
        ///////////////// Upewnij się że pojazd istnieje

        System.out.println("Podaj id serwisowanego pojzadu");
        String idString = Komenda.scanner.nextLine();
        Long idPojazd = Long.parseLong(idString);

        Optional<Pojazd> pojazdOptional = dataAccessObjectPojazd.find(Pojazd.class, idPojazd);
        if (pojazdOptional.isEmpty()){
            System.err.println("Pojazd nie istnieje, nie można dodać serwisu");
            return;
        }
        System.out.println("Podaj opis serwisu");
        String opis = Komenda.scanner.nextLine();



        ///////////////// Upewnij się że mechanik istnieje

        System.out.println("Podaj id serwisanta");
        String idMechanikString = Komenda.scanner.nextLine();
        Long idMechanik = Long.parseLong(idString);

        Optional<Mechanik> mechanikOptional = dataAccessObjectMechanik.find(Mechanik.class, idMechanik);
        if (pojazdOptional.isEmpty()){
            System.err.println("Mechanik nie istnieje, nie można dodać serwisu");
            return;
        }
        //////// konstrukcja obiektu SerwisPojazdu
        System.out.println("Podaj opis serwisu");
        String opiss = Komenda.scanner.nextLine();

        SerwisPojazdu serwisPojazdu = SerwisPojazdu.builder()
                .mechanik(mechanikOptional.get())
                .pojazd(pojazdOptional.get())
                .opis(opis)
                .build();

        dataAccessObject.insert(serwisPojazdu);
        System.out.println("Dodano serwis");




}
}
