
package simulaatioprojekti;


public class Kortti implements Comparable<Kortti>
{
    private short maa, arvo;
    
    private static String[] maat = { "Pata", "Hertta", "Ruutu", "Risti" };
    private static String[] arvot = { null, "Ässä", "2", "3", "4", "5", "6", "7", "8", "9", "10", "Jätkä", "Rouva", "Kuningas" };
    
    public static String maaAsString(int __maa) 
    {
        return maat[__maa];
    }
    
    public static String arvoAsString(int __arvo)
    {
        return arvot[__arvo];
    }

    public Kortti(short maa, short arvo) {
        this.maa = maa;
        this.arvo = arvo;
    }

    public short getMaa() {
        return maa;
    }

    public short getArvo() {
        return arvo;
    }
    
    @Override
    public String toString() {
        return maat[maa] + " " + arvot[arvo];
    }


    @Override
    public int compareTo(Kortti t) {
        if (getArvo() > t.getArvo())
        {
            return 1;
        } else if (getArvo() < t.getArvo()){
            return -1;
        } else {
            return 0;
        }
    }
    
    
}
