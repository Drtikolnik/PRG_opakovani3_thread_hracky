package Delnici;

import Sklady.SkladMaterialy;
import Sklady.SkladSoucastky;

public class DelnikMonter extends Delnik implements Runnable {

    public DelnikMonter(SkladMaterialy materialy, SkladSoucastky soucastky) {
        super(materialy, soucastky);
        this.delnikID = 100;
        this.jmeno = "Montér hraček";
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
