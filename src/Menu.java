public class Menu {
    public static void main(String[] args) {
        String pierwsza;
        String druga;
        System.out.println("Prosze podaj swoje wspolrzedne geograficzne.");
        System.out.println("podaj pierwsza wspolrzedna " );
        pierwsza=new UserInputReader().readLine();
        System.out.println("podaj druga wspolrzedna " );
        druga=new UserInputReader().readLine();
        //System.out.print(String.valueOf(pierwsza+" "+druga));

        // (x1,y1) i (x2,y2) === (lat, lng)

        // odleglosc?

        // x1==x2 && y1==y2



        String[] userCordinates;
        userCordinates = new String[2];
        userCordinates[0]= pierwsza;
        userCordinates[1]= druga;
        for (String s : userCordinates) {
            System.out.println(s);
        }

    }
}
