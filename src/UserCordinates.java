public class UserCordinates{

    protected static Double[] cordinates() {
        Double[] wspolrzedne = new Double[2];
        System.out.println("Prosze podaj swoje wspolrzedne geograficzne.");
        System.out.println("podaj pierwsza wspolrzedna ");
        Double pierwsza = new UserInputReader().readLine();
        System.out.println("podaj druga wspolrzedna ");
        Double druga = new UserInputReader().readLine();
        wspolrzedne[0] = pierwsza;
        wspolrzedne[1] = druga;
        return wspolrzedne;


    }

}
