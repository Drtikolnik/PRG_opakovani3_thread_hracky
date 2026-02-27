package Sklady;

public class SkladMaterialy{

    private int plast = 10000;
    private int vlasy = 1000;
    private int karton = 600;


    public SkladMaterialy(){}

    public synchronized void doplnMaterial(int novyPlast, int noveVlasy, int novyKarton){
       plast += novyPlast;
       vlasy += noveVlasy;
       karton += novyKarton;

       IO.println("Skladník doručil materiály - Plast: " + plast + " Vlasy: " + vlasy + " Karton: " + karton);
       notifyAll();
    }

    public synchronized void odectiMaterial(int potrebaPlast, int potrebaVlasy, int potrebaKarton) {
        while (plast < potrebaPlast || vlasy < potrebaVlasy || karton < potrebaKarton) {
            System.out.println(Thread.currentThread().getName()+ " čeká na materiál");
            try {
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

        plast -= potrebaPlast;
        vlasy -= potrebaVlasy;
        karton -= potrebaKarton;
    }


    public int getPlast() {
        return plast;
    }

    public int getVlasy() {
        return vlasy;
    }

    public int getKarton() {return karton;}
}
