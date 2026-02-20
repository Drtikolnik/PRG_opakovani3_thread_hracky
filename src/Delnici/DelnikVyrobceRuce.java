package Delnici;

import Sklady.SkladMaterialy;
import Sklady.SkladSoucastky;

public class DelnikVyrobceRuce extends Delnik implements Runnable {

    public DelnikVyrobceRuce(SkladMaterialy materialy, SkladSoucastky soucastky) {
        super(materialy, soucastky);
        this.delnikID = 3;
        this.jmeno = "Výrobce Rukou";
    }

    @Override
    public synchronized void run() {
        try{
            for(;;) {
                materialy.odectiMaterial(20, 0);
                soucastky.pridejRuce();

                Thread.sleep(100);
            }
        }catch(InterruptedException e){}





    }
}
