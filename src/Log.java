import Delnici.*;
import Sklady.SkladMaterialy;
import Sklady.SkladSoucastky;
import java.awt.*;

public class Log implements Runnable {
    public SkladMaterialy materialy;
    public SkladSoucastky soucastky;


    public Log(SkladMaterialy materialy, SkladSoucastky soucastky) {
        this.materialy = materialy;
        this.soucastky = soucastky;
    }


    protected static synchronized void print(String message){
        System.out.println(message);
    }

    @Override
    public synchronized void run() {

            for(;;) {
                while(!soucastky.isDokoncitVyrobu()){
                    try {
                        wait();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }

                System.exit(0);
            }


    }




}
