package Sklady;

public class SkladSoucastky{

    private int hlava;
    private int telo;
    private int ruce;
    private int nohy;

    public SkladSoucastky(){}



    public void pridejHlava() {
        hlava++;
    }

    public void pridejTelo() {
        telo++;
    }

    public void pridejRuce() {
        ruce++;
    }

    public void pridejNohy() {
        nohy++;
    }


    public int getHlava() {
        return hlava;
    }

    public int getTelo() {
        return telo;
    }

    public int getRuce() {
        return ruce;
    }

    public int getNohy() {
        return nohy;
    }
}





