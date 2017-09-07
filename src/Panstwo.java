import java.util.ArrayList;
import java.util.List;

public class Panstwo {
    private String nazwa ;
    private List<Miasto> listaMiast = new ArrayList<>();

    public String getNazwa() {
        return nazwa;
    }

    public void setNazwa(String nazwa) {
        this.nazwa = nazwa;
    }

    public List<Miasto> getListaMiast() {
        return listaMiast;
    }

    public void setListaMiast(List<Miasto> listaMiast) {
        this.listaMiast = listaMiast;
    }
}
