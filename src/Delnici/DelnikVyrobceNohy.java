package Delnici;

import Sklady.SkladMaterialy;
import Sklady.SkladSoucastky;

public class DelnikVyrobceNohy extends Delnik implements Runnable {
    boolean plastNohyDostatek = true;

    public DelnikVyrobceNohy(SkladMaterialy materialy, SkladSoucastky soucastky) {
        super(materialy, soucastky);
        this.delnikID = 4;
        this.jmeno = "Výrobce Nohou";
    }

    @Override
    public synchronized void run() {

        while(plastNohyDostatek) {
            if(materialy.getPlast()>=30){
                materialy.odectiMaterialNohy();
                soucastky.pridejNohy();
            }else{
                IO.println("Nedostatek materiálů na skladě");
                plastNohyDostatek = false;
            }

        }



    }
}
