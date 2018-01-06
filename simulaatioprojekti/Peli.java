package simulaatioprojekti;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import static jdk.nashorn.internal.objects.NativeMath.round;

public class Peli {
    static Scanner lukija = new Scanner(System.in);
    static int pelaaja =0;
    static int pelikone =0;
    static int pelit = 0;
    static int[] kädet = {0,0,0,0,0,0,0,0,0};
    public static void main(String[] args) {

        int x = 0;
        
        do {
            if (pelaaja ==0) {
                lisääRahaa();
            }
            switch(pelivalikko()) {
                case "1":
                    pelaaPokeria();
                    break;
                case "2":
                    lisääRahaa();
                    break;
                case "3":
                    tilastot();
                    break;
                case "0":
                    x=1;
                    break;
                default:
                    System.out.println("Virheellinen syöttö");
                    break;
                    
            }
            
            
        } while (x == 0);

    }
    
    public static String pelivalikko() {
        System.out.println("1 Pelaa Pokeria");
        System.out.println("2 Lisää rahaa (Rahaa " + pelaaja/100 +","+ pelaaja%100 + " €)");
        System.out.println("3 näytä tilastot");
        System.out.println("0 Lopeta");
        return lukija.nextLine();
        
    }
    
    public static void lisääRahaa() {
        System.out.print("Anna rahamäärä: ");
        int rahamäärä = lukija.nextInt()*100;
        pelaaja = pelaaja + rahamäärä;
        lukija.nextLine();

    }

    public static void pelaaPokeria() {
        int panos = 20;
        int y=1;
        do {
            System.out.println("Rahat: "+ pelaaja/100 +","+ pelaaja%100 + " €         Panos: " + panos/100 + ","+ panos%100 + " €");
            System.out.println("ENTER. Jaa kortit");
            System.out.println("1. Muuta panosta (+0.20)");
            System.out.println("2. Lisää rahaa");
            System.out.println("0. Palaa päävalikkoon");
            switch(lukija.nextLine()) {
                case "":
                    if (pelaaja < panos) {
                        System.out.println("Liian vähän rahaa.");
                    } else {
                        Pokeri pokeri = new Pokeri();
                        pelaaja -= panos;
                        pelikone += panos;
                        int kerroin = pokeri.pelaa();
                        pelaaja += panos*kerroin;
                        pelikone -= panos*kerroin;
                        pelit++;
                        switch(kerroin){
                            case 0:
                                kädet[0]++;
                                break;
                            case 1:
                                kädet[1]++;
                                break;
                            case 2:
                                kädet[3]++;
                                break;
                            case 3:
                                kädet[4]++;
                                break;
                            case 6:
                                kädet[5]++;
                                break;
                            case 8:
                                kädet[6]++;
                                break;
                            case 10:
                                kädet[7]++;
                                break;
                            case 20:
                                kädet[8]++;
                                break;
                            case 50:
                                kädet[9]++;
                                break;
                            default:
                                break;
                                
                        }
                        
                        if (kerroin != 0) {
                            System.out.println("Voitit " + (panos*kerroin)/100 + "," + (panos*kerroin)%100 + " €");
                            
                        }
                        lukija.nextLine();
                        
                    }
                    break;
                case "1":
                    if (panos < 100) {
                        panos += 20;
                        
                        
                    } else {
                        panos = 20;
                    }
                    break;
                case "2":
                    lisääRahaa();
                    break;
                case "0":
                    y=0;
                    break;
                default:
                    System.out.println("Virheellinen syöttö");
                    break;
                    
            }
        } while (y==1);
        
    }
    
    
    public static void tilastot() {
        String[] nimet = {"Ei mitään", "Ässä pari", "2 paria", "Kolmoset", "Suora", "Väri", "Täyskäsi", "Neloset", "Värisuora"};
        System.out.println("");
        System.out.println("Tilastot:");
        System.out.println("Pelejä pelattu: " + pelit);
        String merkki;
        for (int i=0; i < kädet.length; i++){
            System.out.println(nimet[i] + ": " + kädet[i]);
        }
        if (pelikone < 0){
            merkki = "-";
        } else {
            merkki = "+";
        }
        System.out.println("Pelikoneen voitot/tappiot: "+ merkki + Math.abs(pelikone/100) + "," + Math.abs(pelikone%100) + "€");
        lukija.nextLine();
        System.out.println("");
    }
}

