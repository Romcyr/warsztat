package hibernate.warsztat;

import hibernate.warsztat.komendy.Komenda;
import hibernate.warsztat.komendy.KomendaDodajMechanik;
import hibernate.warsztat.komendy.KomendaDodajPojazd;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        List<Komenda> listaKomend = new ArrayList<>(
                List.of(
                        new KomendaDodajPojazd(),
                        new KomendaDodajMechanik()

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
