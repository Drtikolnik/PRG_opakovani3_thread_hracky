package Delnici;

import Sklady.SkladMaterialy;
import Sklady.SkladSoucastky;

public class DelnikVyrobceHlava extends Delnik implements Runnable {

    public DelnikVyrobceHlava(SkladMaterialy materialy, SkladSoucastky soucastky) {
        super(materialy, soucastky);
        this.delnikID = 1;
        this.jmeno = "Výrobce Hlav";
    }

    @Override
    public synchronized void run() {
        try{
            for(;;) {
                materialy.odectiMaterial(10, 2);
                soucastky.pridejHlava();

                Thread.sleep(100);
            }
        }catch(InterruptedException e){}




    }
}
