package Delnici;

import Sklady.SkladMaterialy;
import Sklady.SkladSoucastky;

public class DelnikVyrobceNohy extends Delnik implements Runnable {
    private int vyrobenoVeci = 0;

    public DelnikVyrobceNohy(SkladMaterialy materialy, SkladSoucastky soucastky) {
        super(materialy, soucastky);
        this.delnikID = 4;
        this.jmeno = "Výrobce Nohou";
    }

    @Override
    public synchronized void run() {
        try{
            for(;;) {
                Thread.sleep(500);
                materialy.odectiMaterial(30, 0, 0);
                soucastky.pridejNohy();
                vyrobenoVeci++;

                if(vyrobenoVeci%10 == 0){
                    System.out.println("Dělník " +Thread.currentThread().getName()+ " si dává pauzu");
                    Thread.sleep(3000);
                }

                Thread.sleep(1000); //dělník potřebuje trochu času na přípravu materiálů

                if(soucastky.getNohy()==100 ){
                    System.out.println("Dělník " +Thread.currentThread().getName()+ " na 10 sekund pozastaven kvůli vysokému počtu součástek.");
                    Thread.sleep(10000);
                }
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
