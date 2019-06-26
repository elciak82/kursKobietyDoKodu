package pl.ewqa.kurs.java.kobietydokodu;

import java.io.FileNotFoundException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.regex.Pattern;

public class Interface {
    private static KotDAO kotDAO = new KotDAO();

    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws FileNotFoundException {
        String userInput;
        do {
            System.out.println();
            System.out.println("Wybierz, co chcesz zrobić, a następnie zatwierdź enterem:");
            System.out.println("[1] Dodaj nowego kota");
            System.out.println("[2] Pokaż wszystkie koty");
            System.out.println("[x] Zakończ");
            userInput = getUserInput();
            if (userInput.equals("1")){
                addCat();
            } else if (userInput.equals("2")){
                showCatsList();
            }
        }while(userInput.equalsIgnoreCase("x"));
    }

    private static String getUserInput() {
        return scanner.nextLine();
    } //pobieranie wartości, którą wpisze user

    private static void addCat() throws FileNotFoundException {
        System.out.println();
        System.out.println("#########################################################");
        System.out.println("######                 DODAJ  KOTA                 ######");
        System.out.println("#########################################################");
        Kot kot = new Kot();
        System.out.println("Podaj imię Kotka.");
        kot.setName(getUserInput());

        System.out.println("Podaj imię opiekuna.");
        kot.setKeeperName(getUserInput());

        Pattern datePattern = Pattern.compile("^((?:19|20)\\d\\d)[- /.](0[1-9]|1[012])[- /.](0[1-9]|[12][0-9]|3[01])$");
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd");
        String bornDateAsString;
        do {
            System.out.println("Podaj datę urodzin Kotka w formacie RRRR.MM.DD.");
            bornDateAsString = getUserInput();
            if (datePattern.matcher(bornDateAsString).matches()) {
                try {
                    kot.setBornDate(sdf.parse(bornDateAsString));
                } catch (ParseException e) {
                    System.out.println("Format daty jest nieprawidłowy. Przykładowy format daty: '2019.04.17'.");
                }
            }
        } while (kot.getBornDate() == null);

        Pattern weightPattern = Pattern.compile("[0-9]+(\\.[0-9]+)?");
        String weightAsString;
        do {
            System.out.print("Podaj wagę kota: ");
            weightAsString = getUserInput();

            if (weightPattern.matcher(weightAsString).matches()) {
                kot.setWeight(Float.valueOf(weightAsString));
            }
        } while (kot.getWeight() == null);

        kotDAO.addCatToList(kot);
        kotDAO.printWriter(kot);
        System.out.println("Dziękuję, teraz wiem o kocie naprawdę wszystko! Dodałem go do naszego zbioru.");
    }

    private static void showCatsList() {
        System.out.println();
        System.out.println("#########################################################");
        System.out.println("######                 LISTA KOTÓW                 ######");
        System.out.println("#########################################################");

        Kot kot;
        for (int i = 0; i < kotDAO.cats.size(); i++) {
            kot = kotDAO.getCat(i);
            System.out.println(i + ":" + kot.getName());
        }
        System.out.println();
        Pattern countCat = Pattern.compile("[0-9]+");
        String userChoice;
        do {
            System.out.print("Którego kota chcesz poznać bliżej? ");
            userChoice = getUserInput();
        } while (!countCat.matcher(userChoice).matches());

        int catNumber = Integer.parseInt(userChoice);
        if (catNumber < kotDAO.cats.size()) {
            Kot catFromList = kotDAO.getCat(catNumber);
            System.out.println("Wybrany kot ma na imie " + catFromList.getName() + ", waży " + catFromList.getWeight() + ", urodził się " + catFromList.getBornDate().toString() + ", a opiekuje się nim " + catFromList.getKeeperName());
        } else {
            System.out.println("Niestety, nie znalazłem kota o wybranym numerze :( Sprobój ponownie lub go dodaj!");
        }
    }
}
