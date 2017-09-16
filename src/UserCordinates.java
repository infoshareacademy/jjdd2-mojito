public class UserCordinates {


        protected  double[] cordinates() {
            double[] wspolrzedne = new double[2];
            System.out.println("Prosze podaj swoje wspolrzedne geograficzne.");
            System.out.println("podaj pierwsza wspolrzedna ");
            Double pierwsza = new UserInputReader().readLine();
            System.out.println("podaj druga wspolrzedna ");
            double druga = new UserInputReader().readLine();
            wspolrzedne[0] = pierwsza;
            wspolrzedne[1] = druga;
            return wspolrzedne;
            

    }

}
