package Delnici;

import Sklady.SkladMaterialy;
import Sklady.SkladSoucastky;

public class DelnikBalic extends Delnik implements Runnable {
    private int vyrobenoVeci = 0;


    public DelnikBalic(SkladMaterialy materialy, SkladSoucastky soucastky) {
        super(materialy, soucastky);
        this.delnikID = 100;
        this.jmeno = "Balič";
    }

    @Override
    public synchronized void run() {
        try{
            for(;;) {
                Thread.sleep(1000);
                materialy.odectiMaterial(0,0,10);
                soucastky.zabalHracku();
                vyrobenoVeci++;

                if(vyrobenoVeci%10 == 0){
                    System.out.println("Dělník " +Thread.currentThread().getName()+ " si dává pauzu");
                    Thread.sleep(3000);
                }

                Thread.sleep(1000); //dělník potřebuje trochu času na přípravu součástek
            }
        }catch(InterruptedException e){}


    }


    public int getVyrobenoVeci() {
        return vyrobenoVeci;
    }

    public String getJmeno() {
        return jmeno;
    }

}
