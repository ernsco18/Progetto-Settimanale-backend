package ClassiConcrete;

import ClassiAstratte.ElementoRiproducibile;
import Interfacce.VolumeRegolabile;

public class RegistrazioneAudio extends ElementoRiproducibile implements VolumeRegolabile {
    private int volume;

    public RegistrazioneAudio(String titolo, int volume, int durata){
        super(titolo,durata);
        this.volume = volume;
    }

    @Override
    public void play(){
        System.out.println("Riproduzione audio di: " + titolo + " di durata [" + durata + " minuti]");
        System.out.println("Volume a: " + volume);
    }

    @Override
    public void mostra(){
        System.out.println("Mostra Titolo Registrazione Audio: " + titolo);
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
}
