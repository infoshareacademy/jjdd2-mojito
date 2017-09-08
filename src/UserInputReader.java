import java.util.Scanner;

public class UserInputReader {

    private final Scanner scanner;

    public UserInputReader() {
        scanner = new Scanner(System.in);
    }

    public String readLine() {
        return scanner.nextLine();
    }
}