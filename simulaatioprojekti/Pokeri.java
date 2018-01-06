
package simulaatioprojekti;
import java.util.Scanner;
import java.util.ArrayList;
import javax.swing.*;

public class Pokeri {
    Scanner lukija = new Scanner(System.in);
    Pakka pakka = new Pakka();
    Kasi käsi = new Kasi();
    Tarkistus tarkistus = new Tarkistus();
    public int pelaa()
    {
        
        for (int i=0; i<=4; i++)
        {
            käsi.lisaaKortti(pakka.nostaPakasta());
        }
        käsi.naytaKortit();
        valitse();
        käsi.naytaKortit();
        System.out.println("");
        return tarkistus.tarkasta(käsi.annaKasi());
        
    }
    
    public void valitse()
    {
        int[] luvut = {0, 0, 1, 2, 3, 4};
        System.out.print("Valitse vaihdettavat kortit: ");
        String mJono = lukija.nextLine();
        System.out.println("");
        mJono = mJono.replaceAll("\\s", "");
        for (int i = 0; i < mJono.length(); i++)
        {
            käsi.vaihdaKortti(Character.getNumericValue(mJono.charAt(i)-1), pakka.nostaPakasta());
        }
        
    }
}
