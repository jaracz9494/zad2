/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dekorator3;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.io.IOException;
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
        
        UzytkownikDrogi[] uzytkownik = new UzytkownikDrogi[9];
        uzytkownik[0] = new Pieszy();;
        uzytkownik[1] = new Rower();
        uzytkownik[2] = new Rower();
        uzytkownik[3] = new Samochod();
        uzytkownik[4] = new Samochod();
        uzytkownik[5] = new Samochod();
        uzytkownik[6] = new Samochod();
        uzytkownik[7] = new Samochod();
        uzytkownik[8] = new Samochod();
        
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
        Random rand = new Random();
        
        for (int i=0; i<uzytkownik.length; i++) {
            uzytkownik[i].pozycjaX=rand.nextInt(27)+1;
            uzytkownik[i].pozycjaY=rand.nextInt(7)+1;
        }

        System.out.println("P - pieszy");
        System.out.println("R - rower");
        System.out.println("S - Samochod");
        System.out.println("W - WYPADEK");
        
        System.out.println("Wciśnij Enter aby kontynuowac");
        try {
            System.in.read();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }     
        

        boolean warunek=false, kraksa=false;
        int X=0,Y=0;
        
        while (!kraksa) {
            
            for (int i=0; i<uzytkownik.length-1; i++) {
                for (int j=i+1; j<uzytkownik.length; j++) {
                    if (uzytkownik[i].pozycjaX==uzytkownik[j].pozycjaX && uzytkownik[i].pozycjaY==uzytkownik[j].pozycjaY) {
                        kraksa=true;
                        X=uzytkownik[i].pozycjaX;
                        Y=uzytkownik[i].pozycjaY;
                    }
                }
            }
            
            for (int i = 0; i < 10; i++) {
                for (int j = 0; j < 30; j++) {
                    if (i == 0 || i == 9 || j == 0 || j == 29) {
                        System.out.print("O");
                    } else {
                        for (int z=0; z<uzytkownik.length; z++) {
                            
                            if (uzytkownik[z].pozycjaX==j && uzytkownik[z].pozycjaY==i && uzytkownik[z].pozycjaX==X && uzytkownik[z].pozycjaY==Y) {
                                System.out.print("W"); 
                                X=0;
                                Y=0;
                            } else {
                            
                            if (uzytkownik[z].pozycjaX==j && uzytkownik[z].pozycjaY==i) {
                                System.out.print(uzytkownik[z].znak());
                                warunek=true;
                            } }
                        }
                        if (warunek==false) System.out.print("-");
                        warunek=false;

                    }
                }
                System.out.println();
            }
            
            
            System.out.println("Wciśnij Enter aby kontynuowac");
            try {
                System.in.read();
            } catch (IOException ioe) {
                ioe.printStackTrace();
            }
            for (int i=0; i<uzytkownik.length; i++) {
                uzytkownik[i].porusz+=1;
                if (uzytkownik[i].porusz==uzytkownik[i].predkosc()){
                    uzytkownik[i].ruch();
                    uzytkownik[i].porusz=0;
                }
                
            }
            
        }      
        System.out.println("DOSZLO DO ZDERZENIA!");
                
    }
}



abstract class UzytkownikDrogi {
    protected String uzytkownik = "Uzytkownik Drogi";
    public abstract int predkosc();
    public abstract char znak();
    public int pozycjaX=0, pozycjaY=0, porusz=0;
    
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
                    if (pozycjaX==29) {
                        pozycjaX-=2;
                    }
                    break;
                
            case 1: pozycjaX-=1;
                    if (pozycjaX==0) {
                        pozycjaX+=2;
                    }
                    break;
                
            case 2: pozycjaY+=1;
                    if (pozycjaY==9) {
                        pozycjaY-=2;
                    }
                    break;
                
            case 3: pozycjaY-=1;
                    if (pozycjaY==0) {
                        pozycjaY+=2;
                    }
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
        return 3;
    }
    
    public char znak(){
        return 'P';
    }
    
}
    
   

class Rower extends UzytkownikDrogi {

    public Rower(){
        uzytkownik = "Rower";
    }

    public int predkosc(){
        return 2;
    }
    
    public char znak(){
        return 'R';
    }
    
    
}

class Samochod extends UzytkownikDrogi {
    
    public Samochod(){
        uzytkownik = "Samochod";
    }

    public int predkosc(){
        return 1;
    }
    
    public char znak(){
        return 'S';
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
    
    public char znak(){
        return uzytkownik.znak();
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
    
    public char znak(){
        return uzytkownik.znak();
    }
}
