import java.util.Scanner;

public class AfterTask {
    public void aftertask(){
        String input="0";
        UserInputReader userInputReader=new UserInputReader();
        while (true){
            System.out.println("Wybierz dalsze działanie:");
            System.out.println("1.Powrot do glownego menu.");
            // System.out.printf("2.Wykonaj ponownie.");
            System.out.println("2.Zakończ program.");
            input=userInputReader.readlineString();
            switch (input) { case "1":
                AfterTask afterTask=new AfterTask();
                afterTask.chooseAfterTask();
                UserChooseFromMenu userChooseFromMenu=new UserChooseFromMenu();
                userChooseFromMenu.userChooseFromMenu();
                break;
                case "2":
                    System.exit(0);
                    break;
                    default:
                        System.out.println("Niepoprawny numer, podaj liczbę 1 lub 2.");
            }

        }
    }
    public void chooseAfterTask(){
        System.out.println("1.Wyszukanie najblizszej stacji rowerowej.");
        System.out.println("2.Wyszukanie stacji w danym kraju.");
        System.out.println("3.Wyszukanie stacji w danym miescie.");
        System.out.println("4.Wyszukanie stacji rowerowerej na danym obszarze.");
        System.out.println("5.Statystyki ilosci stacji rowerowych w danym panstwie.");
        System.out.println("6.Statystyki ilosci stacji rowerowych w danym miescie");
        System.out.println("7.Wyjscie z Progarmu");
    };
}
