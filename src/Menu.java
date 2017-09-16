import java.util.InputMismatchException;
import java.util.Scanner;


public class Menu {


    public static void main(String[] args) {

        MenuText menuText= new MenuText();
        menuText.Text();
        UserChooseFromMenu choose = new UserChooseFromMenu();
        choose.userChooseFromMenu();
    }
}

