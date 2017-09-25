package infoshareKurs;


import java.util.Scanner;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class UserInputReader {
    private final Logger logger = LogManager.getLogger(UserInputReader.class);

    private final Scanner scanner;

    protected UserInputReader() {
        logger.debug("Zaimpletowanie skanera");
        scanner = new Scanner(System.in);
    }

    protected Double readLineDouble() {
        logger.debug("Użytkownik wpisal Double w konsole/strone");
        return scanner.nextDouble();
    }

    protected Integer readlineInteager() {
        logger.debug("Użytkownik wpisal Int w konsole/strone");
        return scanner.nextInt();
    }

    protected String readlineString() {
        logger.debug("Użytkownik wpisal cos w konsole/strone");
        return scanner.nextLine();
    }
}