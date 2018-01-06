
package simulaatioprojekti;
import java.util.ArrayList;
import java.util.Collections;


public class Tarkistus {
    
    private ArrayList<Kortti> kortit;

    public void setKortit(ArrayList<Kortti> kortit) {
        this.kortit = kortit;
    }
    
    public int tarkasta(ArrayList<Kortti> cards)
    {
        setKortit(cards);
        Collections.sort(kortit);
        
//        System.out.println("Järjestetään");
//        for (Kortti kortti : kortit)
//        {
//            System.out.println(kortti.toString());
//        }
        
        if (onkoPari()) {
            if(onko4Samaa()){
                System.out.println("Sait neloset!");
                return 20;
            } else {
                if(onko3Samaa()){
                    if(onkoPari()){
                        System.out.println("Sait täyskäden!");
                        return 10;
                    } else {
                        System.out.println("Sait kolmoset!");
                        return 3;
                    }
                } if(onkoÄssäPari()){
                    if (onko2Paria()){
                        System.out.println("Sait kaksi paria!");
                        return 2;
                    } else {
                        System.out.println("Sait ässäparin!");
                        return 1;
                    }
                } else {
                    if (onko2Paria()) {
                        System.out.println("Sait kaksi paria!");
                        return 2;
                    } else {
                        System.out.println("Ei voittoa.");
                        return 0;
                    }
                }
            }
        } else {
            if(onkoSuora()){
                if(onkoVäri()){
                    System.out.println("Sait värisuoran!");
                    return 50;
                } else {
                    System.out.println("Sait suoran!");
                    return 6;
                }
            } else {
                if(onkoVäri()){
                    System.out.println("Sait värin!");
                    return 8;
                } else {
                    System.out.println("Ei voittoa.");
                    return 0;
                }
            }
        }
        
    }
    
    public boolean onkoPari() {
        for (int i = 0; i < kortit.size()-1; i++) {
            
            if (kortit.get(i).getArvo() == kortit.get(i+1).getArvo()) {
                return true;
            }
                
        }
        return false;
    }
    
    public boolean onko3Samaa() {
        for (int i = 0; i < kortit.size()-2; i++) {
            
            if (kortit.get(i).getArvo() == kortit.get(i+1).getArvo() && kortit.get(i).getArvo() == kortit.get(i+2).getArvo()) {
                kortit.remove(i);
                kortit.remove(i);
                kortit.remove(i);
                return true;
            }   
        }
        return false;
    }
    
    public boolean onko4Samaa() {
        for (int i = 0; i < kortit.size()-3; i++) {
            
            if (kortit.get(i).getArvo() == kortit.get(i+1).getArvo() && kortit.get(i).getArvo() == kortit.get(i+2).getArvo() && kortit.get(i).getArvo() == kortit.get(i+3).getArvo()) {
                return true;
            }   
        }
        return false;
    }
    
    public boolean onkoÄssäPari() {
        int ässät = 0;
        for (int i = 0; i < kortit.size()-1; i++) {
            if (kortit.get(i).getArvo() == 1) {
                ässät++;
                if (ässät == 2) {
                    return true;
                }
            }
        }
        return false;
    }
    
    public boolean onko2Paria() {
        for (int i = 0; i < kortit.size()-1; i++) {
            
            if (kortit.get(i).getArvo() == kortit.get(i+1).getArvo()) {
                kortit.remove(i);
                kortit.remove(i);
                break;
            }   
        }
        for (int j = 0; j < kortit.size()-1; j++) {
            
            if (kortit.get(j).getArvo() == kortit.get(j+1).getArvo()) {
                return true;
            }
        }
        return false;
    }
    
    public boolean onkoSuora() {
        if (kortit.get(0).getArvo() == 1) {
            short a = 4;
            short b = 14;
            kortit.add(new Kortti(a, b));
            
            
        }
        for (int i = 0; i <= kortit.size()-5; i++) {
            int suora = 0;
            for (int j=i; j<=i+3; j++) {
                if ( kortit.get(j).getArvo() == kortit.get(j+1).getArvo()-1) {
                    suora++;
                    if (suora==4) {
                        if (kortit.get(kortit.size()-1).getArvo()==14){
                            kortit.remove(kortit.size()-1);
                        }
                        return true;
                    }
                } else {
                    break;
                }
                
            }
            
        }
        
        return false;
    }
    
    public boolean onkoVäri() {
        int padat=0;
        int hertat=0;
        int ruudut=0;
        int ristit=0;
        
        for (int i=0; i <= kortit.size()-1; i++) {
            switch(kortit.get(i).getMaa()) {
                case 0:
                    padat++;
                    break;
                case 1:
                    hertat++;
                    break;
                case 2:
                    ruudut++;
                    break;
                case 3:
                    ristit++;
                    break;
                default:
                    break;
            }
        }
        
        if (padat >= 5 || hertat >= 5 || ruudut >= 5 || ristit >= 5) {
            return true;
        }
        return false;
    }
}
