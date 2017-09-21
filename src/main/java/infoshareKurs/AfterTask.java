package infoshareKurs;

import java.util.List;
import java.util.logging.Logger;

public class AfterTask {
    protected final Logger logger = Logger.getLogger(getClass().getName());

    protected void aftertask(List<City> cityList) {
        String input = "0";
        UserInputReader userInputReader = new UserInputReader();
        while (true) {
            System.out.println("Wybierz dalsze działanie:");
            System.out.println("1.Powrót do głównego menu.");
            System.out.println("2.Zakończ program.");
            input = userInputReader.readlineString();
            switch (input) {
                case "1":
                    AfterTask afterTask = new AfterTask();
                    afterTask.chooseAfterTask();
                    UserChooseFromMenu userChooseFromMenu = new UserChooseFromMenu();
                    userChooseFromMenu.userChooseFromMenu(cityList);
                    break;
                case "2":
                    System.exit(0);
                    break;
                default:
                    System.out.println("Niepoprawny numer, podaj liczbę 1 lub 2.");
                    logger.warning("Użytkownik wpisal niepoprawny numer wyboru menu.");
            }
        }
    }

    protected void chooseAfterTask() {
        System.out.println("1.Wyszukanie najbliższej stacji rowerowej.");
        System.out.println("2.Wyszukanie stacji w danym kraju.");
        System.out.println("3.Wyszukanie stacji w danym mieście.");
        System.out.println("4.Wyszukanie stacji rowerowej w konkretnej odległości.");
        System.out.println("5.Statystyki ilości stacji rowerowych w danym państwie.");
        System.out.println("6.Statystyki ilości stacji rowerowych w danym mieście");
        System.out.println("7.Wyjście z programu");
    }
}
