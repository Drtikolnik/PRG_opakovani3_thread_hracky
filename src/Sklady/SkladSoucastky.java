package Sklady;

public class SkladSoucastky{

    private int hlava;
    private int telo;
    private int ruce;
    private int nohy;
    private int hracka;

    public SkladSoucastky(){}

    public synchronized void sestavHracku(){
        while((hlava==0 || telo==0 || ruce==0 || nohy==0)){
            System.out.println("Montér " +Thread.currentThread().getName()+ " čeká na součástky");
            try {
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

        hracka++;
    }

    public void pridejHlava() {
        hlava++;
        System.out.println(Thread.currentThread().getName()+ " vyrobil hlavu, CELKEM HLAV: " +hlava);
    }

    public void pridejTelo() {
        telo++;
        System.out.println(Thread.currentThread().getName()+ " vyrobil tělo, CELKEM TĚL: " +telo);
    }

    public void pridejRuce() {
        ruce++;
        System.out.println(Thread.currentThread().getName()+ " vyrobil ruce, CELKEM RUK: " +ruce);
    }

    public void pridejNohy() {
        nohy++;
        System.out.println(Thread.currentThread().getName()+ " vyrobil nohy, CELKEM NOHOU: " +nohy);
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





