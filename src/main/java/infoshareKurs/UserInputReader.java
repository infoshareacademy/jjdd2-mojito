package infoshareKurs;

import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

//klasa skanera
public class UserInputReader {
    protected final Logger logger = Logger.getLogger(getClass().getName());

    private final Scanner scanner;

    protected UserInputReader() {
        logger.log(Level.FINE,"Zaimpletowanie skanera");
        scanner = new Scanner(System.in);
    }

    protected Double readLineDouble() {
        logger.log(Level.FINE,"Użytkownik wpisal Double w konsole/strone");
        return scanner.nextDouble();
    }

    protected Integer readlineInteager() {
        logger.log(Level.FINE,"Użytkownik wpisal Int w konsole/strone");
        return scanner.nextInt();
    }

    protected String readlineString() {
        logger.log(Level.FINE,"Użytkownik wpisal cos w konsole/strone");
        return scanner.nextLine();
    }
}