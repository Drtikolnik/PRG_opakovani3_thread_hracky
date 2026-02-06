package Delnici;

import Sklady.SkladMaterialy;
import Sklady.SkladSoucastky;

public class DelnikVyrobceRuce extends Delnik implements Runnable {
    boolean plastRuceDostatek = true;

    public DelnikVyrobceRuce(SkladMaterialy materialy, SkladSoucastky soucastky) {
        super(materialy, soucastky);
        this.delnikID = 3;
        this.jmeno = "Výrobce Rukou";
    }

    @Override
    public synchronized void run() {

        while(plastRuceDostatek) {
            if(materialy.getPlast()>=20){
                materialy.odectiMaterialRuce();
                soucastky.pridejRuce();
            }else{
                IO.println("Nedostatek materiálů na skladě");
                plastRuceDostatek = false;
            }

        }



    }
}
