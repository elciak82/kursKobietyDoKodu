package pl.ewqa.kurs.java.kobietydokodu;

import java.util.ArrayList;
import java.util.List;

public class KotDAO {
    List<Kot> cats = new ArrayList<Kot>();

    public void addCatToList(Kot kot){
        cats.add(kot);
        System.out.println("Dziękuję, dodałem kota do kolekcji!");
    }
    public List<String> getAllCatsFromList(){
        List<String> allCatsList = new ArrayList<String>();
        for (Kot kot : cats){
//            System.out.println(i);
            allCatsList.add(kot.getName());
            allCatsList.add(kot.getKeeperName());
            allCatsList.add(kot.getWeight().toString());
            allCatsList.add(kot.getBornDate().toString());
        }
        return allCatsList;
    }
}
