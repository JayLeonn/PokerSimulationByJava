
package simulaatioprojekti;
import java.util.ArrayList;

public class Poyta {
    private ArrayList<Kortti> kortit;
    
    Poyta() 
    {
        kortit = new ArrayList();
    }
    
    public void lisaaKortti(Kortti kortti)
    {
        kortit.add(kortti);
    }
    
    public Kortti poistaKortti(int indeksi)
    {
        return kortit.remove(indeksi);
    }
    
    public void poista()
    {
        kortit.clear();
    }
}
