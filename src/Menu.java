import java.util.InputMismatchException;
import java.util.Scanner;


public class Menu {


    public static void main(String[] args) {

        MenuText menuText= new MenuText();
        menuText.text();
        UserChooseFromMenu choose = new UserChooseFromMenu();
        choose.userChooseFromMenu();
    }
}