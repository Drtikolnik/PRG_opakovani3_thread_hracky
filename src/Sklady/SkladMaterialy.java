package Sklady;

public class SkladMaterialy{

    private int plast = 10000;
    private int vlasy = 1000;


    public SkladMaterialy(){}

    public synchronized void doplnMaterial(int novyPlast, int noveVlasy){
       plast += novyPlast;
       vlasy += noveVlasy;

       IO.println("Skladník doručil materiály - Plast: " + plast + " Vlasy: " + vlasy);
       notifyAll();
    }

    public synchronized void odectiMaterial(int potrebaPlast, int potrebaVlasy) {
        while (plast < potrebaPlast || vlasy < potrebaVlasy) {
            System.out.println(Thread.currentThread().getName()+ " čeká na materiál");
            try {
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

        plast -= potrebaPlast;
        vlasy -= potrebaVlasy;
    }


    public int getPlast() {
        return plast;
    }

    public int getVlasy() {
        return vlasy;
    }
}
