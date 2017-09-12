import java.util.Scanner;
//klasa skanera
public class UserInputReader {

    private final Scanner scanner;

    protected UserInputReader() {
        scanner = new Scanner(System.in);
    }

    protected Double readLine() {
        return scanner.nextDouble();
        //input uzytkownika jest typem Double
    }
}