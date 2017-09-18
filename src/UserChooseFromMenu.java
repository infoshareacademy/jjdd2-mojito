import java.util.Scanner;

public class UserChooseFromMenu {
    protected  void userChooseFromMenu(){
        UserInputReader scanner = new UserInputReader();

        int input = 0;
        while (input <= 7) {
            try {
                input = Integer.valueOf(scanner.readLine());
            } catch (NumberFormatException e) {
                System.out.println("Wybierz jedna z opcji Menu wpisujac liczby od 1-7 ");
                continue;
            }
            switch (input) {
                case 1:
                    // wyszukiwanie najblizszej stacji;
                    break;
                case 2:
                    // Wyszukanie stacji w danym kraju.
                    break;
                case 3:
                    //Wyszukanie stacji w danym miescie.
                    break;
                case 4:
                    // Wyszukanie stacji rowerowerej na danym obszarze
                    break;
                case 5:
                    //Statystyki ilosci stacji rowerowych w danym panstwie.
                    break;
                case 6:
                    // Statystyki ilosci stacji rowerowych w danym miescie
                    break;
                case 7:
                    System.exit(0);
                    //wyjscie z programu
                    break;

                default:
                    System.out.println("niepoprawny numer podaj liczbe od 1-7");
            }
        }
    }
}
