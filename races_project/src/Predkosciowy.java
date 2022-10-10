
public class Predkosciowy extends Wyscig {

    String lokalizacja = "tor";
    String rodzajWyscigu = "prędkościowy";

    public Predkosciowy()
    {

    }

    public Predkosciowy(String nazwa, String data, String kraj)
    {
        this.nazwa = nazwa;
        this.data = data;
        this.kraj = kraj;
        this.sponsorzy = sponsor();
    }
}
