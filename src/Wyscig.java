import java.util.*;

public class Wyscig implements Sponsorzy {

    String nazwa;
    String data;
    String kraj;
    String sponsorzy;

    public int id;

    static ArrayList<Wyscig> list = new ArrayList<Wyscig>();

    public Wyscig()
    {
        this.id = list.size();
        this.nazwa = "";
        this.data = "";
        this.kraj = "";
        this.sponsorzy = "";
    }

    public Wyscig(String nazwa, String data, String kraj)
    {
        this.id = list.size();
        this.nazwa = nazwa;
        this.data = data;
        this.kraj = kraj;
        this.sponsorzy = sponsor();
    }

    public String sponsor()
    {
        Random r = new Random();
        int x = r.nextInt(11);
        return Sponsorzy.tab()[x];
    }

}
