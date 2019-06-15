package pl.ewqa.kurs.java.kobietydokodu;

import java.util.Scanner;

public class Interface {
    public static void main(String[] args) {
        System.out.println("Podaj imię kotka!");
        String catName = getUserInput();
        System.out.println("Podaj imię opiekuna!");
        String keeperName = getUserInput();

        Kot kot = new Kot();
        kot.setName(catName);
        kot.setKeeperName(keeperName);
        kot.presentYourself();
    }

        String catName;
        String keeper;

        static Scanner scanner = new Scanner(System.in);

        public static String getUserInput(){
            return scanner.nextLine();
        }
}
