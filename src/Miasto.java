import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;

public class Miasto {
    private String nazwa;
    private Double szerokosc;
    private Double dlugosc;

    public String getNazwa() {
        return nazwa;
    }

    public void setNazwa(String nazwa) {
        this.nazwa = nazwa;
    }

    public Double getSzerokosc() {
        return szerokosc;
    }

    public void setSzerokosc(Double szerokosc) {
        this.szerokosc = szerokosc;
    }

    public Double getDlugosc() {
        return dlugosc;
    }

    public void setDlugosc(Double dlugosc) {
        this.dlugosc = dlugosc;
    }


}

