import java.util.Scanner;
//asci art rowery
public class Menu {
        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Witaj w Wyszukiwarce rowerowej");
            System.out.println("czym jestes zainteresowany ?");
            System.out.println("1.Wyszukanie najblizszej stacji rowerowej.");
            System.out.println("2.Wyszukanie stacji w danym kraju.");
            System.out.println("3.Wyszukanie stacji w danym miescie.");
            System.out.println("4.Wyszukanie stacji rowerowerej na danym obszarze.");
            System.out.println("5.Statystyki ilosci stacji rowerowych w danym panstwie.");
            System.out.println("6.Statystyki ilosci stacji rowerowych w danym miescie");
            int input = scanner.nextInt();
            switch(input){
                case 1:
                   // wyszukiwanieNajStacji;
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
                default:
                    //prosze wybrac komende


            }
        }
}