package pl.ewqa.kurs.java.kobietydokodu;

import java.sql.SQLOutput;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

public class Interface {
    public static void main(String[] args) {
        System.out.println("Podaj imię Kotka.");
        String catName = getUserInput();
        System.out.println("Podaj imię opiekuna.");
        String keeperName = getUserInput();
        String dateFormat = "yyyy.MM.dd";
        Date bornDateAsDate;

        do {
            System.out.println("Podaj datę urodzin Kotka w formacie " + dateFormat + ".");
            String bornDateAsString = getUserInput();
            bornDateAsDate = parseStringToDate(dateFormat, bornDateAsString);
        } while (bornDateAsDate == null);

        Float weightAsFloat;
        do {
            System.out.println("Podaj wagę Kotka w kilogranach (np 5.45).");
            String weightAsString = getUserInput();
            weightAsFloat = parseStringToFloat(weightAsString);
        } while (weightAsFloat == null);

        Kot kot = new Kot();
        kot.setName(catName);
        kot.setKeeperName(keeperName);
        kot.setBornDate(bornDateAsDate);
        kot.setWeight(weightAsFloat);
        kot.presentYourself();
    }

        static Scanner scanner = new Scanner(System.in);

        public static String getUserInput(){
            return scanner.nextLine();
        } //pobieranie wartości, którą wpisze user

        public static Date parseStringToDate(String dateFormat, String dateAsString){
            SimpleDateFormat sdf = new SimpleDateFormat(dateFormat);
            Date date = null;
            try{
                date = sdf.parse(dateAsString);
            } catch (ParseException e) {
                System.out.println("Nieprawidłowy format daty!");
            }
            return date;
        }
        
        public static Float parseStringToFloat(String weightAsString) {
            Float weight = null;
            try {
                weight = Float.parseFloat(weightAsString);
            }catch (NumberFormatException e) {
                System.out.println("Nieprawidłowy format! Wpisz liczbę!");
            }
            return weight;
        }   
//
//    Date today = Calendar.getInstance().getTime();
//            if(bornDateAsDate.compareTo(today) > 0){
//        System.out.println("Kotek sie jeszcze nie urodził?");
}
