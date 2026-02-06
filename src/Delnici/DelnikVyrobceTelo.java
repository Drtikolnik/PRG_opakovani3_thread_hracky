package Delnici;

import Sklady.SkladMaterialy;
import Sklady.SkladSoucastky;

public class DelnikVyrobceTelo extends Delnik implements Runnable {
    boolean plastTeloDostatek = true;

    public DelnikVyrobceTelo(SkladMaterialy materialy, SkladSoucastky soucastky) {
        super(materialy, soucastky);
        this.delnikID = 2;
        this.jmeno = "Výrobce Těl";
    }

    @Override
    public synchronized void run() {

        while(plastTeloDostatek) {
            if(materialy.getPlast()>=50){
                materialy.odectiMaterialTelo();
                soucastky.pridejTelo();
            }else{
                IO.println("Nedostatek materiálů na skladě");
                plastTeloDostatek = false;
            }

        }



    }
}
