package hibernate.warsztat.komendy;

import hibernate.warsztat.DataAccessObject;
import hibernate.warsztat.model.Mechanik;
import hibernate.warsztat.model.SerwisPojazdu;

import java.util.Optional;

public class KomendaZnajdzSerwisPojazdu implements Komenda {
    private DataAccessObject<KomendaZnajdzSerwisPojazdu> dataAccessObject;

    public KomendaZnajdzSerwisPojazdu() {
        this.dataAccessObject = new DataAccessObject<>();
    }

    @Override
    public String getKomenda() {
        return "znajdz serwis";
    }

    @Override
    public void obsluga() {
        System.out.println("Podaj id szukanego mechanika");
        String idString = Komenda.scanner.nextLine();
        Long id = Long.parseLong(idString);
        Optional<KomendaZnajdzSerwisPojazdu> znajdzSerwisPojazduOptional = dataAccessObject.find(KomendaZnajdzSerwisPojazdu.class, id);
        if (znajdzSerwisPojazduOptional.isPresent()){
            System.out.println(znajdzSerwisPojazduOptional.get());
        }else {
            System.err.println("Nie znaleziono mechanika");
        }

    }
}






