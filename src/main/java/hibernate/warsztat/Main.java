package hibernate.warsztat;

import hibernate.warsztat.komendy.*;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        List<Komenda> listaKomend = new ArrayList<>(
                List.of(
                        new KomendaDodajPojazd(),
                        new KomendaDodajMechanik(),
                        new KomendaListPojazd(),
                        new KomendaListMechanik(),
                        new KomendaZnajdzPojazd(),
                        new KomendaZnajdzMechanik(),
                        new KomendaUsunPojazd(),
                        new KomendaUsunMechanik(),
                        new KomendaDodajSerwisPojazdu(),
                        new KomendaZnajdzSerwisPojazdu(),
                        new KomendaUsunSerwisPojazdu(),
                        new KomendaAktualizujMechanik(),
                        new KomendaAktualizujPojazd(),
                        new KomendaZakonczSerwisPojazdu()

                )
        );

        System.out.println("Lista dostępnych komend");
        listaKomend.forEach(komenda -> System.out.println(komenda.getKomenda()));

        System.out.println("Podaj komende:");
        String komenda = Komenda.scanner.nextLine();

        for (Komenda dostepnaKomenda : listaKomend){
            if (dostepnaKomenda.getKomenda().equalsIgnoreCase(komenda)){
                dostepnaKomenda.obsluga();
            }
        }

    }
}
