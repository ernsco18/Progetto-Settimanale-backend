package ClassiAstratte;

import Interfacce.Riproducibile;

public abstract class ElementoRiproducibile extends ElementoMultimediale implements Riproducibile {

    protected int durata;

    public ElementoRiproducibile(String titolo, int durata) {
        super(titolo);
        this.durata = durata;
    }

    @Override
    public void play(){
        System.out.println("Riproduzione di: " + titolo + " di durata [" + durata + " minuti]");
    }
}
