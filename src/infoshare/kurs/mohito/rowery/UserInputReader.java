package infoshare.kurs.mohito.rowery;

import java.util.Scanner;

//klasa skanera
public class UserInputReader {

    private final Scanner scanner;

    protected UserInputReader() {
        scanner = new Scanner(System.in);
    }

    protected Double readLineDouble() {
        return scanner.nextDouble();
    }

    protected Integer readlineInteager() {
        return scanner.nextInt();
    }

    protected String readlineString() {
        return scanner.nextLine();
    }
}