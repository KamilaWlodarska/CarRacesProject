
public class Rajdowy extends Wyscig {

    String lokalizacja = "pustynia";
    String rodzajWyscigu = "rajdowy";

    public Rajdowy()
    {

    }

    public Rajdowy(String nazwa, String data, String kraj)
    {
        this.nazwa = nazwa;
        this.data = data;
        this.kraj = kraj;
        this.sponsorzy = sponsor();
    }
}
