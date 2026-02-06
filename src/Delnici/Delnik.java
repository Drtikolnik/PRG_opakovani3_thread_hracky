package Delnici;

import Sklady.SkladMaterialy;
import Sklady.SkladSoucastky;

public abstract class Delnik{
    public SkladMaterialy materialy;
    public SkladSoucastky soucastky;

    public int delnikID;
    public String jmeno;

    public Delnik(SkladMaterialy materialy, SkladSoucastky soucastky) {
        this.materialy = materialy;
        this.soucastky = soucastky;
    }
}
