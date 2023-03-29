
public class ToyotaCorolla extends Rajdowy {

    String zawieszenie = "zależne";
    String rodzajAuta = "Toyota Corolla";

    public ToyotaCorolla()
    {

    }

    public ToyotaCorolla(String nazwa, String data, String kraj)
    {
        this.nazwa = nazwa;
        this.data = data;
        this.kraj = kraj;
        this.sponsorzy = sponsor();
        list.add(this);
    }

    @Override
    public String toString()
    {
        return " Nazwa: " + this.nazwa + "\t" + "Data: " + this.data + "\t" + "Kraj: " + this.kraj + "\t\t" + "Lokalizacja: " + this.lokalizacja + "\t" + "Rodzaj wyscigu: " + this.rodzajWyscigu
                + "\t\t" + "rodzaj auta: " + this.rodzajAuta + "\t\t" + "zawieszenie: " + "\t" + this.zawieszenie + "\t" + "Sponsorzy : " + this.sponsorzy + "\t" + "\n";
    }
}
