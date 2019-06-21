package pl.ewqa.kurs.java.kobietydokodu;

import java.util.ArrayList;
import java.util.List;

public class KotDAO {
    List<Kot> cats = new ArrayList<Kot>();

    public void addCatToList(Kot kot){
        cats.add(kot);
        System.out.println("Dziękuję, dodałem kota do kolekcji!");
    }
}
