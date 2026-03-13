package LettoreMultimediale;
import java.util.Scanner;
import ClassiConcrete.*;
import ClassiAstratte.*;
import Interfacce.*;

public class LettoreMultimediale {
    private ElementoMultimediale[] elementi;
    private Scanner scanner;

    public LettoreMultimediale() {
        this.elementi = new ElementoMultimediale[5];
        this.scanner = new Scanner(System.in);
    }

    public void avvia(){
        System.out.print("Inserisci 5 elementi multimediali: ");

        for (int i = 0; i < this.elementi.length; i++) {
            elementi[i] = creaElemento(i+1);
        }

        int scelta;
        do {
            mostraScelta();
            scelta = scanner.nextInt();
            scanner.nextLine(); // Consuma newline

            if (scelta >= 1 && scelta <= 5) {
                eseguiElemento(scelta - 1);
            } else if (scelta == 0) {
                System.out.println("Arrivederci!");
            } else {
                System.out.println("Scelta non valida. Riprova.");
            }
        } while (scelta != 0);
    }

    private ElementoMultimediale creaElemento(int numero){
        System.out.println("\nElemento " + numero + ":");
        System.out.println("Scegli il tipo:");
        System.out.println("1. Immagine");
        System.out.println("2. Registrazione Audio");
        System.out.println("3. Video");

        int tipoElemento = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Inserisci il titolo: ");
        String titoloElemento = scanner.nextLine();

        switch (tipoElemento) {
            case 1:
                System.out.print("Inserisci la luminosita' (0-10): ");
                int luminositaImmagine   = scanner.nextInt();
                return new Immagine(titoloElemento, luminositaImmagine);
            case 2:
                System.out.print("Inserisci la durata : ");
                int durataAudio = scanner.nextInt();
                System.out.print("Inserisci il volume (0-10): ");
                int volumeAudio = scanner.nextInt();
                scanner.nextLine();
                return new RegistrazioneAudio(titoloElemento, durataAudio, volumeAudio);
            case 3:
                System.out.print("Inserisci la durata : ");
                int durataVideo = scanner.nextInt();
                System.out.print("Inserisci il volume (0-10): ");
                int volumeVideo = scanner.nextInt();
                System.out.print("Inserisci la luminosit' (0-10): ");
                int luminositaVideo = scanner.nextInt();
                scanner.nextLine();
                return new Video(titoloElemento, durataVideo, volumeVideo, luminositaVideo);
            default:
                return null;
        }
    }

    private void mostraScelta(){
        System.out.println("\nScegli un elemento da eseguire (1-5) o 0 per uscire:");
        for (int i = 0; i < 5; i++) {
            System.out.println((i + 1) + ". " + elementi[i].getTitolo());
        }
    }

    private void eseguiElemento(int indice) {
        ElementoMultimediale elemento = elementi[indice];

        if (elemento instanceof Riproducibile) {
            ((Riproducibile) elemento).play();
        } else if (elemento instanceof Immagine) {
            elemento.mostra();
        }

        if (elemento instanceof VolumeRegolabile) {
            gestisciVolume((VolumeRegolabile) elemento);
        }

        if (elemento instanceof Video) {
            gestisciLuminosita((Video) elemento);
        }
    }

    private void gestisciVolume(VolumeRegolabile elemento) {
        System.out.println("\nGestione volume:");
        System.out.println("1. Alza volume");
        System.out.println("2. Abbassa volume");

        int scelta = scanner.nextInt();
        scanner.nextLine();

        switch (scelta) {
            case 1:
                elemento.alzaVolume();
                break;
            case 2:
                elemento.abbassaVolume();
                break;
            default:
                System.out.println("Errore!");
        }
    }

    private void gestisciLuminosita(Video video) {
        System.out.println("\nGestione luminosità:");
        System.out.println("1. Aumenta luminosità");
        System.out.println("2. Diminuisci luminosità");

        int scelta = scanner.nextInt();
        scanner.nextLine();

        switch (scelta) {
            case 1:
                video.alzaLuminosita();
                break;
            case 2:
                video.abbassaLuminosita();
                break;
            default:
                System.out.println("Errore!");
        }
    }
    }
