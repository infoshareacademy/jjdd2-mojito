package infoshare.kurs.mohito.rowery;

import infoshareKurs.StatCountry;
import org.junit.Test;

import static org.junit.Assert.*;

public class StatCountryTest {


    StatCountry statCountry = new StatCountry();

    @Test
    public void iloscStacjiFrankfurt() {


        assertTrue(10 == statCountry.getCityStat().get("Stalowa Wola"));
    }

    @Test
    public void iloscStacjiWarszawa() {


        assertTrue(315 == statCountry.getCityStat().get("Warszawa"));

    }

    @Test
    public void iloscStacjiKalovac() {


        assertTrue(3 == statCountry.getCityStat().get("Karlovac"));
    }

    @Test
    public void krajCanada() {

        assertTrue(4 == statCountry.getCountryStat().get("Canada"));

    }

    @Test
    public void krajEstonia() {

        assertTrue(17 == statCountry.getCountryStat().get("Estonia"));

    }

    @Test
    public void krajMalta() {

        assertTrue(50 == statCountry.getCountryStat().get("Malta"));

    }

}