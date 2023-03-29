
public class ToyotaSupra extends Predkosciowy {

    String zawieszenie = "niezależne";
    String rodzajAuta = "Toyota Supra";

    public ToyotaSupra()
    {

    }

    public ToyotaSupra(String nazwa, String data, String kraj)
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
        return " Nazwa: " + this.nazwa + "\t" + "Data: " + this.data + "\t" + "Kraj: " + this.kraj + "\t\t" + "Lokalizacja: " + this.lokalizacja + "\t\t" + "Rodzaj wyscigu: " + this.rodzajWyscigu
                + "\t\t" + "rodzaj auta: " + this.rodzajAuta + "\t\t" + "zawieszenie: " + "\t" + this.zawieszenie + "\t" + "Sponsorzy : " + this.sponsorzy + "\t" + "\n";
    }
}
