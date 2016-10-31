/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dekorator3;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.util.Random;

/**
 *
 * @author Dominik
 */
public class Dekorator3 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        UzytkownikDrogi s1 = new Pieszy();
        UzytkownikDrogi s2 = new Rower();
        UzytkownikDrogi s3 = new Samochod();
        
        /*
        System.out.println("predkosc");
        System.out.println(s1.about() + " " + s1.predkosc());
        System.out.println(s2.about() + " " + s2.predkosc());
        System.out.println(s3.about() + " " + s3.predkosc());

       

        s1 = new Opony(s1);
        s2 = new Opony(s2);
        s3 = new Opony(s3);
        System.out.println("Z oponami");
        System.out.println(s1.about() + " " + s1.predkosc());
        System.out.println(s2.about() + " " + s2.predkosc());
        System.out.println(s3.about() + " " + s3.predkosc());

        

        s1 = new Masa(s1);
        s2 = new Masa(s2);
        s3 = new Masa(s3);
        System.out.println("Z Masa");
        System.out.println(s1.about() + " " + s1.predkosc());
        System.out.println(s2.about() + " " + s2.predkosc());
        System.out.println(s3.about() + " " + s3.predkosc());

        System.out.println("Opony i masa");
        UzytkownikDrogi s4 = new Masa(new Opony(new Samochod()));
        System.out.println(s4.about() + " " + s4.predkosc());
        
        */
        int x, y;
        Random rand = new Random();
        
        x=rand.nextInt(27)+1; 
        y=rand.nextInt(7)+1;
        s1.pozycja(x, y);
        s1.wyswietl_pozycje();
        
        x=rand.nextInt(27)+1; 
        y=rand.nextInt(7)+1;
        s2.pozycja(x, y);
        s2.wyswietl_pozycje();
        
        x=rand.nextInt(27)+1; 
        y=rand.nextInt(7)+1;
        s3.pozycja(x, y);
        s3.wyswietl_pozycje();
        
        //int tabelaX[] = new int[5];
        //tabelaX[0]=s1.pozycjaX;
        
        
        //s1.ruch();      
        //s1.wyswietl_pozycje();
 
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 30; j++) {
                if (i == 0 || i == 9 || j == 0 || j == 29) System.out.print("X");
                else System.out.print("c");
            }
            System.out.println();
        }
                
    }
}


abstract class UzytkownikDrogi {
    protected String uzytkownik = "Uzytkownik Drogi";
    public abstract int predkosc();
    public int pozycjaX=0, pozycjaY=0;
    
    public String about(){
        return uzytkownik;
    }
    
    public void pozycja(int pozycjaX, int pozycjaY) {
        this.pozycjaX=pozycjaX;
        this.pozycjaY=pozycjaY;
    }
    
    public void wyswietl_pozycje () {
        System.out.print(pozycjaX +" ");
        System.out.println(pozycjaY);
    }
    
    public void ruch() {
        int x;
        Random rand = new Random();
        
        x=rand.nextInt(4);          
        
        switch (x) {
            case 0: pozycjaX+=1;
                break;
            case 1: pozycjaX-=1;
                break;
            case 2: pozycjaY+=1;
                break;
            case 3: pozycjaY-=1;
                break;
            default: System.out.println("Wystąpił problem przy losowaniu");
                break;
        }
        
    }
 
    
}
 

abstract class Dekorator extends UzytkownikDrogi {
    public abstract String about();
}
 


 
class Pieszy extends UzytkownikDrogi {
    
    public Pieszy(){
        uzytkownik = "Pieszy";
    }

    public int predkosc(){
        return 1;
    }
    
}
    
   

class Rower extends UzytkownikDrogi {

    public Rower(){
        uzytkownik = "Rower";
    }

    public int predkosc(){
        return 2;
    }
    
    
}

class Samochod extends UzytkownikDrogi {
    
    public Samochod(){
        uzytkownik = "Samochod";
    }

    public int predkosc(){
        return 3;
    }
    
    
}
 

class Opony extends Dekorator {
    UzytkownikDrogi uzytkownik;

    public Opony(UzytkownikDrogi uzytkownik){
        this.uzytkownik = uzytkownik;
    }

    public String about(){
        return uzytkownik.about() + " + Opony";
    }

    public int predkosc(){
    if(uzytkownik instanceof Samochod){
        return uzytkownik.predkosc()+2;
    }
    if(uzytkownik instanceof Rower){
        return uzytkownik.predkosc()+1;
    }
    
    return 1;
    }
}
 
class Masa extends Dekorator {
    UzytkownikDrogi uzytkownik;
 
    public Masa(UzytkownikDrogi uzytkownik){
    this.uzytkownik = uzytkownik;
    }

    public String about(){
        return uzytkownik.about() + " + Masa";
    }

    
    public int predkosc(){
        return uzytkownik.predkosc()+1;
    }
}
