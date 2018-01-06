
package simulaatioprojekti;
import java.util.ArrayList;
import java.util.Collections;

public class Kasi {
    private ArrayList<Kortti> kortit;
    
    Kasi() {
        kortit = new ArrayList();
    }
    
    public void lisaaKortti(Kortti kortti)
    {
        kortit.add(kortti);
    }
    
    public void vaihdaKortti(int indeksi, Kortti kortti)
    {
        kortit.set(indeksi, kortti);
    }
    
    public void naytaKortit()
    {
        Collections.sort(kortit);
        for (Kortti kortti : kortit)
        {
            System.out.println(kortti.toString());
        }
    }
    
    public ArrayList<Kortti> annaKasi()
    {
        return kortit;
    }
    
    public void poista()
    {
        kortit.clear();
    }
}
