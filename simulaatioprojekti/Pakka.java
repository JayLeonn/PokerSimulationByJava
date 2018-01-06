
package simulaatioprojekti;
import java.util.ArrayList;
import java.util.Random;


public class Pakka {
    private ArrayList<Kortti> kortit, temp;
    Random generator = new Random();
    
    Pakka()
    {
        kortit = new ArrayList();
        temp= new ArrayList();
        for (short a=0; a<=3; a++)
        {
            for (short b=1; b<=13; b++)
            {
                temp.add(new Kortti(a, b));
            }
        }
        
        int koko = temp.size();
        for (int i=0; i<=50; i++)
        {
            kortit.add(temp.remove(generator.nextInt(koko)));
            koko--;
        }
        kortit.add(temp.remove(0));
        

    }
    
    public Kortti nostaPakasta()
    {
        return kortit.remove(kortit.size()-1);
    }
    
    public void naytaKortit()
    {
        for (Kortti kortti : kortit)
        {
            System.out.println(kortti.toString());
        }
    }
    
    public int koko()
    {
        return kortit.size();
    }
}
