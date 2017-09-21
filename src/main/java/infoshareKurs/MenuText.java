package infoshareKurs;

import java.util.logging.Logger;

public class MenuText {
    protected final Logger logger = Logger.getLogger(getClass().getName());
    protected void Text() {
        System.out.println("Witaj w wyszukiwarce rowerowej");
        System.out.println("Czym jestes zainteresowany?");
        System.out.println("1.Wyszukanie najbliższej stacji rowerowej.");
        System.out.println("2.Wyszukanie stacji w danym kraju.");
        System.out.println("3.Wyszukanie stacji w danym mieście.");
        System.out.println("4.Wyszukanie stacji rowerowej w konkretnej odległości.");
        System.out.println("5.Statystyki ilości stacji rowerowych w danym państwie.");
        System.out.println("6.Statystyki ilości stacji rowerowych w danym mieście");
        System.out.println("7.Wyjście z progarmu");
    }
}
