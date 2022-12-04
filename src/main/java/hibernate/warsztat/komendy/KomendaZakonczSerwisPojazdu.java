package hibernate.warsztat.komendy;

import hibernate.warsztat.DataAccessObject;
import hibernate.warsztat.model.Pojazd;
import hibernate.warsztat.model.SerwisPojazdu;

import java.time.LocalDateTime;
import java.util.Optional;

public class KomendaZakonczSerwisPojazdu implements Komenda {

    public KomendaZakonczSerwisPojazdu() {

        this.dataAccessObject = new DataAccessObject<>();
    }

    private DataAccessObject<SerwisPojazdu> dataAccessObject;


    @Override
    public String getKomenda() {
        return "zakoncz serwis";
    }

    @Override
    public void obsluga() {
        System.out.println("Podaj id serwisu");
        String idString = Komenda.scanner.nextLine();
        Long id = Long.parseLong(idString);

        //TODO: sprawdz czy rekord istnieje zanim podasz X dodatkowych danych
        Optional<SerwisPojazdu> serwisPojazduOptional = dataAccessObject.find(SerwisPojazdu.class, id);
        if (serwisPojazduOptional.isEmpty()){
            System.err.println("Zlecenie serwisowe o takim id nie istnieje");
            return;
        }
        SerwisPojazdu oryginalnySerwisPojazdu = serwisPojazduOptional.get();

            System.out.println("Podaj zrealizowane czynności");
            String czynnosci = Komenda.scanner.nextLine();

            System.out.println("Podaj koszt serwisu");
            String kosztString = Komenda.scanner.nextLine();
            Double koszt = Double.parseDouble(kosztString);


        SerwisPojazdu.builder()
                .czasDodania(oryginalnySerwisPojazdu.getCzasDodania())
                .opis(oryginalnySerwisPojazdu.getOpis())
                .czasZrealizowania(LocalDateTime.now())
                //powyzej są dwa pola które biorą z oryginalnego tzn aktualizowanegor ekordu bazy
                .zrealizowaneCzynnosci(czynnosci)
                .koszt(String.valueOf(koszt))
                .id(id)// dopisujemy id poniewaz do aktualizacji musimy podac ID aktualizowanego rekordu,
                // jeśli go nie podam tp zpstanie dodany zerowy rekord

                .build();




    }
}
