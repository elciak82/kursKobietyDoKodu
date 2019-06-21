package pl.ewqa.kurs.java.kobietydokodu;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Interface {
    public static void main(String[] args) {
        KotDAO kotDAO = new KotDAO();
        Kot kot = new Kot();
        System.out.println("Podaj imię Kotka.");
        kot.setName(getUserInput());
        System.out.println("Podaj imię opiekuna.");
        kot.setKeeperName(getUserInput());
        String dateFormat = "YYYY.MM.DD";

        do {
            System.out.println("Podaj datę urodzin Kotka w formacie RRRR.MM.DD.");
            String bornDateAsString = getUserInput();
            kot.setBornDate(parseStringToDate(dateFormat, bornDateAsString));
        } while (kot.getBornDate() == null);

        do {
            System.out.println("Podaj wagę Kotka w kilogramach.");
            String weightAsString = getUserInput();
            kot.setWeight(parseStringToFloat(weightAsString));
        } while (kot.getWeight() == null);

        kotDAO.addCatToList(kot);
    }

        static Scanner scanner = new Scanner(System.in);

        private static String getUserInput(){
            return scanner.nextLine();
        } //pobieranie wartości, którą wpisze user

        private static Date parseStringToDate(String dateFormat, String dateAsString) {
            Pattern pattern = Pattern.compile("^((?:19|20)\\d\\d)[- /.](0[1-9]|1[012])[- /.](0[1-9]|[12][0-9]|3[01])$");
            Matcher matcher = pattern.matcher(dateAsString);
            SimpleDateFormat sdf = new SimpleDateFormat(dateFormat);
            Date date = null;
            if (matcher.matches()) {
                try {
                    date = sdf.parse(dateAsString);
                } catch (ParseException e) {
                    System.out.println("Format daty jest nieprawidłowy. Przykładowy format daty: '2019.04.17'.");
                }
            }
            else
                System.out.println("Jesteż pewny, że to prawidłowa data? Spróbuj jeszcze raz!. Przykładowy format daty: '2019.04.17'.");
            return date;
        }
        
        private static Float parseStringToFloat(String weightAsString) {
            Pattern pattern = Pattern.compile("[0-9]+(\\.[0-9]+)?");
            Matcher matcher = pattern.matcher(weightAsString);
            Float weight = null;
            if (matcher.matches()) {
                try {
                    weight = Float.parseFloat(weightAsString);
                } catch (NumberFormatException e) {
                    System.out.println("Format wagi jest nieprawidłowy. Przykładowy format wagi: 5.6.");
                }
            }
            return weight;
        }   
//
//    Date today = Calendar.getInstance().getTime();
//            if(bornDateAsDate.compareTo(today) > 0){
//        System.out.println("Kotek sie jeszcze nie urodził?");
}
