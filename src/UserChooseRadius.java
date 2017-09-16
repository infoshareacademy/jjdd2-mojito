import java.util.Scanner;

public class UserChooseRadius {
    protected  void Radius() {

        UserInputReader scanner = new UserInputReader();
        System.out.println("Prosze wybierz promien poszukiwan w km .");
        System.out.println("1.szukaj w odleg1osci 5 km");
        System.out.println("2.szukaj w odleg1osci 10 km");
        System.out.println("3.szukaj w odleg1osci 15 km");
        System.out.println("4.Wróc do Menu .");

        int input = 0;
        while (input <= 0) {
            try {
                input = scanner.readlineInteager();
            } catch (NumberFormatException e) {
                System.out.println("Wybierz jedna z opcji Menu wpisujac liczby od 1-4 ");
                continue;
            }catch (NullPointerException e){
                System.out.println("Wybierz jedna z opcji Menu wpisujac liczby od 1-4 ");
            }
            switch (input) {
                case 1:
                    //wyszukanie staci w odleglosci 5km.
                    break;
                case 2:
                    //wyszukanie staci w odleglosci 10km.
                    break;
                case 3:
                    //wyszukanie staci w odleglosci 15km.
                    break;
                case 4:
                    // Wyszukanie stacji rowerowerej na danym obszarze
                    break;
                default:


            }
        }
    }
}