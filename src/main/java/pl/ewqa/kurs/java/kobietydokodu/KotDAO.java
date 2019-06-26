package pl.ewqa.kurs.java.kobietydokodu;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

class KotDAO {
    List<Kot> cats = new ArrayList<Kot>();

    void addCatToList(Kot kot) throws FileNotFoundException {
        cats.add(kot);
        System.out.println("Dziękuję, dodałem kota do kolekcji!");
    }

    Kot getCat(int index){
        return cats.get(index);
    }


    void printWriter(Kot kot) throws FileNotFoundException {
        PrintWriter saveData = new PrintWriter("Cats.txt");
        saveData.println(kot);
        saveData.close();
    }


}
