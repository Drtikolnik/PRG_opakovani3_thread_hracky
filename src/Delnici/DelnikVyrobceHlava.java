package Delnici;

import Sklady.SkladMaterialy;
import Sklady.SkladSoucastky;

public class DelnikVyrobceHlava extends Delnik implements Runnable {
    boolean plastHlavaDostatek = true;
    boolean vlasyHlavaDostatek = true;

    public DelnikVyrobceHlava(SkladMaterialy materialy, SkladSoucastky soucastky) {
        super(materialy, soucastky);
        this.delnikID = 1;
        this.jmeno = "Výrobce Hlav";
    }

    @Override
    public synchronized void run() {

        while(plastHlavaDostatek && vlasyHlavaDostatek) {
            if(materialy.getPlast()>=10 && materialy.getVlasy()>=2){
                materialy.odectiMaterialHlava();
                soucastky.pridejHlava();
            }else{
                IO.println("Nedostatek materiálů na skladě");
                plastHlavaDostatek = false;
                vlasyHlavaDostatek = false;
            }
        }



    }
}
