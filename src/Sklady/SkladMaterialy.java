package Sklady;

public class SkladMaterialy{

    private int plast = 10000;
    private int vlasy = 1000;


    public SkladMaterialy(){}



    public void odectiMaterialHlava() {
        plast -= 10;
    }

    public void odectiMaterialTelo() {
        plast -= 50;
    }

    public void odectiMaterialRuce() {
        plast -= 20;
    }

    public void odectiMaterialNohy() {
        plast -= 30;
    }


    public int getPlast() {
        return plast;
    }

    public int getVlasy() {
        return vlasy;
    }
}
