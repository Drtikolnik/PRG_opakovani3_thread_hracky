package Sklady;

public class SkladSoucastky{

    private int hlava;
    private int telo;
    private int ruce;
    private int nohy;
    private int hracka;
    private int pozadavek;

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

        hlava--;
        telo--;
        ruce--;
        nohy--;
        hracka++;
        System.out.println(Thread.currentThread().getName()+ " sestavil hračku, CELKEM HRAČEK: " +hracka);

        if(hracka == pozadavek){
            System.out.println("Výroba dokončena");
            IO.println("Počet Hlav:" +getHlava());
            IO.println("Počet Těl:" +getTelo());
            IO.println("Počet Ruce:" +getRuce());
            IO.println("Počet Nohy:" +getNohy());
            IO.println("počet hraček: " +getHracka());
            System.exit(0);
        }

    }

    public synchronized void pridejHlava() {
        hlava++;
        System.out.println(Thread.currentThread().getName()+ " vyrobil hlavu, CELKEM HLAV: " +hlava);
        notifyAll();
    }

    public synchronized void pridejTelo() {
        telo++;
        System.out.println(Thread.currentThread().getName()+ " vyrobil tělo, CELKEM TĚL: " +telo);
        notifyAll();
    }

    public synchronized void pridejRuce() {
        ruce++;
        System.out.println(Thread.currentThread().getName()+ " vyrobil ruce, CELKEM RUK: " +ruce);
        notifyAll();
    }

    public synchronized void pridejNohy() {
        nohy++;
        System.out.println(Thread.currentThread().getName()+ " vyrobil nohy, CELKEM NOHOU: " +nohy);
        notifyAll();
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

    public int getHracka() {
        return hracka;
    }

    public int getPozadavek() {
        return pozadavek;
    }

    public void setPozadavek(int pozadavek) {
        this.pozadavek = pozadavek;
    }
}





