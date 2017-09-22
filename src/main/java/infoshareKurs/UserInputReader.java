package infoshareKurs;


import java.util.Scanner;
import java.util.logging.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class UserInputReader {
    private final Logger logger = LogManager.getLogger();

    private final Scanner scanner;

    protected UserInputReader() {
        logger.info("Zaimpletowanie skanera");
        scanner = new Scanner(System.in);
    }

    protected Double readLineDouble() {
        logger.info("Użytkownik wpisal Double w konsole/strone");
        return scanner.nextDouble();
    }

    protected Integer readlineInteager() {
        logger.info("Użytkownik wpisal Int w konsole/strone");
        return scanner.nextInt();
    }

    protected String readlineString() {
        logger.info("Użytkownik wpisal cos w konsole/strone");
        return scanner.nextLine();
    }
}