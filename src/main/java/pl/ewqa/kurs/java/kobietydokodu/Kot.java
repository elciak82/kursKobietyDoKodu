package pl.ewqa.kurs.java.kobietydokodu;

import java.util.Date;

public class Kot {

    private String name;
    private Date bornDate;
    private Float weight;
    private String keeperName;


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
        System.out.println(String.format("Nazywam się %s, moim opiekunem jest %s, urodziłam się %s, ważę %s.", name, keeperName, bornDate, weight));
    }
}
