package ClassiConcrete;

import ClassiAstratte.ElementoMultimediale;
import Interfacce.LuminositaRegolabile;

public class Immagine extends ElementoMultimediale implements LuminositaRegolabile {
    private int luminosita;

    public Immagine(String titolo, int luminosita) {
        super(titolo);
        this.luminosita = luminosita;
    }

    public int getLuminosita() {
        return luminosita;
    }

    public void abbassaLuminosita(){
        if (luminosita > 0){
            luminosita--;
            System.out.println("Luminosita' abbassata a: " + luminosita);
        }else {System.out.println("La luminosita' e' gia al minimo.");
        }
    }

    public void alzaLuminosita(){
        if (luminosita < 10){
            luminosita++;
            System.out.println("Luminosita' aumentata a: " + luminosita);
        }else {
            System.out.println("La luminosita' e' gia al massimo.");
        }
    }

    @Override
    public void mostra(){
        System.out.println("Mostra Titolo Immagine: " + titolo);
    }

    @Override
    public void play(){
        System.out.println("Mostra Titolo Immagine: " + titolo  + ", di luminosita': " + luminosita);
    }
}
