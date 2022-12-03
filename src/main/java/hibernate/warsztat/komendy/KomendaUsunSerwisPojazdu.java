package hibernate.warsztat.komendy;

import hibernate.warsztat.DataAccessObject;
import hibernate.warsztat.model.Pojazd;

public class KomendaUsunSerwisPojazdu implements Komenda{
    private DataAccessObject<KomendaUsunSerwisPojazdu> dataAccessObject;

    public KomendaUsunSerwisPojazdu(){
        this.dataAccessObject = new DataAccessObject<>();}


    @Override
    public String getKomenda() {
        return "usun serwis pojazdu";
    }

    @Override
    public void obsluga() {
        System.out.println("Podaj id usuwanego serwisu pojazdu");
        String idString = Komenda.scanner.nextLine();
        Long id = Long.parseLong(idString);


            if (dataAccessObject.delete(KomendaUsunSerwisPojazdu.class, id)) {
                System.out.println("Usunięto serwis pojazdu");
            }else {
                System.err.println("Nie znaleziono pojazdu w bazie");
            }



    }
}
