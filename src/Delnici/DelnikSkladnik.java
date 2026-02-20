package Delnici;

import Sklady.SkladMaterialy;
import Sklady.SkladSoucastky;
import java.util.Random;

public class DelnikSkladnik extends Delnik implements Runnable {

    public DelnikSkladnik(SkladMaterialy materialy, SkladSoucastky soucastky) {
        super(materialy, soucastky);
        this.delnikID = 10;
        this.jmeno = "Skladník";
    }

    @Override
    public synchronized void run() {
        try {
            for(;;){
                Thread.sleep(1000);

                int randomPlast = (int)(Math.random() * 1000) + 1;
                int randomVlasy = (int)(Math.random() * 100) + 1;

                materialy.doplnMaterial(randomPlast, randomVlasy);
            }
        }catch(InterruptedException e){}




    }
}
