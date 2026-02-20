package Delnici;

import Sklady.SkladMaterialy;
import Sklady.SkladSoucastky;

public class DelnikVyrobceTelo extends Delnik implements Runnable {

    public DelnikVyrobceTelo(SkladMaterialy materialy, SkladSoucastky soucastky) {
        super(materialy, soucastky);
        this.delnikID = 2;
        this.jmeno = "Výrobce Těl";
    }

    @Override
    public synchronized void run() {
        try{
            for(;;) {
                materialy.odectiMaterial(50, 0);
                soucastky.pridejTelo();

                Thread.sleep(100);
            }
        }catch (InterruptedException e) {}




    }
}
