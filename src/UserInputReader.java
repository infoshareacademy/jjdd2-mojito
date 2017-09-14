import java.util.Scanner;
//klasa skanera
public class UserInputReader {

    private final Scanner scanner;

    protected UserInputReader() {
        scanner = new Scanner(System.in);
    }

    protected String readLine() {
        return scanner.nextLine();

    }
}