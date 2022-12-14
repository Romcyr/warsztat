package hibernate.warsztat.komendy;

import hibernate.warsztat.DataAccessObject;
import hibernate.warsztat.model.Pojazd;
import hibernate.warsztat.model.SerwisPojazdu;

import java.util.List;

public class KomendaListaSerwisPojazdu implements Komenda{
    private DataAccessObject <SerwisPojazdu> dataAccessObject;

    public KomendaListaSerwisPojazdu(){
        this.dataAccessObject = new DataAccessObject<>();
    }

    @Override
    public String getKomenda(){
        return "lista serwis pojazdu";
    }
    @Override
    public void obsluga(){
        List<SerwisPojazdu> serwisPojazdu = dataAccessObject.findAll(SerwisPojazdu.class);
        serwisPojazdu.forEach(System.out::println);
    }
}
