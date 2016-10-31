/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dekorator3;

/**
 *
 * @author Dominik
 */
public class Dekorator3 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        UzytkownikDrogi s1 = new Samochod();
        UzytkownikDrogi s2 = new Pieszy();
        UzytkownikDrogi s3 = new Rower();

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

    }
}

abstract class UzytkownikDrogi {
    protected String uzytkownik = "Uzytkownik Drogi";
    public abstract int predkosc();
    
    public String about(){
        return uzytkownik;
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
