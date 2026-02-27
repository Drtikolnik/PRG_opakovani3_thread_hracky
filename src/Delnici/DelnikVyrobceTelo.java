package Delnici;

import Sklady.SkladMaterialy;
import Sklady.SkladSoucastky;

public class DelnikVyrobceTelo extends Delnik implements Runnable {
    private int vyrobenoVeci = 0;

    public DelnikVyrobceTelo(SkladMaterialy materialy, SkladSoucastky soucastky) {
        super(materialy, soucastky);
        this.delnikID = 2;
        this.jmeno = "Výrobce Těl";
    }

    @Override
    public synchronized void run() {
        try{
            for(;;) {
                Thread.sleep(750);
                materialy.odectiMaterial(50, 0, 0);
                soucastky.pridejTelo();
                vyrobenoVeci++;

                if(vyrobenoVeci%10 == 0){
                    System.out.println("Dělník " +Thread.currentThread().getName()+ " si dává pauzu");
                    Thread.sleep(3000);
                }

                Thread.sleep(1000); //dělník potřebuje trochu času na přípravu materiálů

                if(soucastky.getTelo()==100 ){
                    System.out.println("Dělník " +Thread.currentThread().getName()+ " na 10 sekund pozastaven kvůli vysokému počtu součástek.");
                    Thread.sleep(10000);
                }
            }
        }catch (InterruptedException e) {}

    }

    public int getVyrobenoVeci() {
        return vyrobenoVeci;
    }

    public String getJmeno() {
        return jmeno;
    }
}
