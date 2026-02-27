package Sklady;

public class SkladSoucastky{

    private int hlava;
    private int telo;
    private int ruce;
    private int nohy;
    private int hracka;
    private int pozadavek;
    private int krabiceSHrackou;

    private boolean dokoncitVyrobu = false;

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

        zkontrolujHracku();
        vypisAZastavVyrobu();
        notifyAll();
    }

    public synchronized void zkontrolujHracku(){
        System.out.println("Hračka prošla kontrolou");
    }

    public synchronized void zabalHracku(){
        while(hracka != 0){
            System.out.println("Montér " +Thread.currentThread().getName()+ " čeká na hračku");
            try {
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        hracka--;
        krabiceSHrackou++;
        System.out.println(Thread.currentThread().getName()+ " zabalil hračku, CELKEM ZABALENÝCH KRABIC: " +krabiceSHrackou);
        notifyAll();
    }

    public synchronized void vypisAZastavVyrobu(){
        if(krabiceSHrackou == pozadavek){
            dokoncitVyrobu = true;
            IO.println("");
            IO.println("--------------------------------");
            IO.println("");
            IO.println("Výroba dokončena");
            IO.println("Počet Hlav:" +getHlava());
            IO.println("Počet Těl:" +getTelo());
            IO.println("Počet Ruce:" +getRuce());
            IO.println("Počet Nohy:" +getNohy());
            IO.println("Počet hraček: " +getHracka());
            IO.println("Počet hraček zablených v krabici: " +getKrabiceSHrackou());
            IO.println("");

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

    public boolean isDokoncitVyrobu() {
        return dokoncitVyrobu;
    }

    public int getKrabiceSHrackou() {
        return krabiceSHrackou;
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





