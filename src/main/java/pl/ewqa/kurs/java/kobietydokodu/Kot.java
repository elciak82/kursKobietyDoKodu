package pl.ewqa.kurs.java.kobietydokodu;

import java.util.Date;

public class Kot {

    String name;
    Date bornDate;
    Float weight;
    String keeperName;


    public Date getBornDate() {
        return bornDate;
    }

    public Float getWeight() {
        return weight;
    }

    public String getKeeperName() {
        return keeperName;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setBornDate(Date bornDate) {
        this.bornDate = bornDate;
    }

    public void setWeight(Float weight) {
        this.weight = weight;
    }

    public void setKeeperName(String keeperName) {
        this.keeperName = keeperName;
    }

    public void presentYourself(){
        System.out.println(String.format("Nazywam się %s, a moim opiekunem jest %s.", name, keeperName));
    }
}
