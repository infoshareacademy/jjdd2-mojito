import java.util.Scanner;

public class UserInputReader {

    private final Scanner scanner;

    protected UserInputReader() {
        scanner = new Scanner(System.in);
    }

    protected int readLine() {
        return scanner.nextInt();
    }
}