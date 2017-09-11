public class UserCordinates{

    protected static String[] cordinates() {
        String[] wspolrzedne = new String[2];
        System.out.println("Prosze podaj swoje wspolrzedne geograficzne.");
        System.out.println("podaj pierwsza wspolrzedna ");
        String pierwsza = new UserInputReader().readLine();
        System.out.println("podaj druga wspolrzedna ");
        String druga = new UserInputReader().readLine();
        wspolrzedne[0] = pierwsza;
        wspolrzedne[1] = druga;
        return wspolrzedne;


    }

}
