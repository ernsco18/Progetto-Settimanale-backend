package ClassiConcrete;

import ClassiAstratte.ElementoRiproducibile;
import Interfacce.VolumeRegolabile;

public class Video extends ElementoRiproducibile implements VolumeRegolabile {

    private int volume;
    private int luminosita;

    public Video(String titolo, int durata, int volume, int luminosita){
        super(titolo, durata);
        this.volume = volume;
        this.luminosita = luminosita;
    }

    @Override
    public void mostra(){
        System.out.println("Mostra Titolo Video: " + titolo);
    }

    @Override
    public void play(){
        System.out.println("Riproduzione video di: " + titolo + " di durata [" + durata + " minuti]");
        System.out.println("Volume a: " + volume);
        System.out.println("Luminosita' : " + luminosita);
    }

    @Override
    public int getVolume() {
        return volume;
    }

    @Override
    public void abbassaVolume(){
        if (volume > 0){
            volume--;
            System.out.println("Volume abbassato a: " + volume);
        }else {
            System.out.println("Il volume e' gia al minimo.");
        }
    }

    @Override
    public void alzaVolume(){
        if (volume < 10){
            volume++;
            System.out.println("Volume abbassato a: " + volume);
        }else {
            System.out.println("Il volume e' gia al massimo.");
        }
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
            System.out.println("Luminosita' abbassato a: " + luminosita);
        }else {
            System.out.println("La luminosita' e' gia al massimo.");
        }
    }


}
