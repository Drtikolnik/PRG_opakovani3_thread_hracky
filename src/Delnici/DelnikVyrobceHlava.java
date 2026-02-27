package Delnici;

import Sklady.SkladMaterialy;
import Sklady.SkladSoucastky;

public class DelnikVyrobceHlava extends Delnik implements Runnable {
    private int vyrobenoVeci = 0;

    public DelnikVyrobceHlava(SkladMaterialy materialy, SkladSoucastky soucastky) {
        super(materialy, soucastky);
        this.delnikID = 1;
        this.jmeno = "Výrobce Hlav";
    }

    @Override
    public synchronized void run() {
        try{
            for(;;) {
                Thread.sleep(2000);
                int kolikVlasu = 0;
                int jakaPanenka = (int) (Math.random() * 100) + 1;
                if(jakaPanenka<=50) { //dlouhé vlasy
                    kolikVlasu = 3;
                }else if(jakaPanenka<=70) { //krátké vlasy
                    kolikVlasu = 1;
                }else if(jakaPanenka<=80) { //plešatá
                    kolikVlasu = 0;
                }else if(jakaPanenka<=100) { //normální vlasy
                    kolikVlasu = 1; //nemělo by to být spíš dva?
                }

                materialy.odectiMaterial(10, kolikVlasu, 0);
                soucastky.pridejHlava();
                vyrobenoVeci++;

                if(vyrobenoVeci%10 == 0){
                    System.out.println("Dělník " +Thread.currentThread().getName()+ " si dává pauzu");
                    Thread.sleep(3000);
                }

                Thread.sleep(1000); //dělník potřebuje trochu času na přípravu materiálů

                if(soucastky.getHlava()==100 ){
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
