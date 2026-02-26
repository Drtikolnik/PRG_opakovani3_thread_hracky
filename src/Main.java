import Delnici.*;
import Sklady.SkladMaterialy;
import Sklady.SkladSoucastky;
import java.awt.*;

void main() {
    Scanner sc = new Scanner(System.in);

    SkladMaterialy m = new SkladMaterialy();
    SkladSoucastky s = new SkladSoucastky();

    IO.println("Kolik chceš hraček?");
    s.setPozadavek(sc.nextInt());
    sc.nextLine();

    DelnikVyrobceHlava vyrobceHlava = new DelnikVyrobceHlava(m, s);
    DelnikVyrobceTelo vyrobceTelo = new DelnikVyrobceTelo(m, s);
    DelnikVyrobceRuce vyrobceRuce = new DelnikVyrobceRuce(m, s);
    DelnikVyrobceNohy vyrobceNohy = new DelnikVyrobceNohy(m, s);

    DelnikSkladnik skladnik = new DelnikSkladnik(m, s);

    DelnikMonter monter1 = new DelnikMonter(m, s);
    DelnikMonter monter2 = new DelnikMonter(m, s);

    Thread vyrobniStaniceHlava = new Thread(vyrobceHlava);
    Thread vyrobniStaniceTelo = new Thread(vyrobceTelo);
    Thread vyrobniStaniceNohy = new Thread(vyrobceRuce);
    Thread vyrobniStaniceRuce = new Thread(vyrobceNohy);

    Thread skladnikStanice = new Thread(skladnik);

    Thread montovaciStanice1 = new Thread(monter1);
    Thread montovaciStanice2 = new Thread(monter2);

    try{
        vyrobniStaniceHlava.start();
        vyrobniStaniceTelo.start();
        vyrobniStaniceNohy.start();
        vyrobniStaniceRuce.start();

        skladnikStanice.start();

        montovaciStanice1.start();
        montovaciStanice2.start();
    }catch(Exception e){
        e.printStackTrace();
    }

    try{
        vyrobniStaniceHlava.join();
        vyrobniStaniceTelo.join();
        vyrobniStaniceNohy.join();
        vyrobniStaniceRuce.join();

        skladnikStanice.join();

        montovaciStanice1.join();
        montovaciStanice2.join();
    }catch(Exception e){
        e.printStackTrace();
    }








    //Log.print("Počet Hlav:" +s.getHlava());         přesunuto do SklasSoucastky - sestavHracku()
    //Log.print("Počet Těl:" +s.getTelo());       přesunuto do SklasSoucastky - sestavHracku()
    //Log.print("Počet Ruce:" +s.getRuce());           přesunuto do SklasSoucastky - sestavHracku()
    //Log.print("Počet Nohy:" +s.getNohy());           přesunuto do SklasSoucastky - sestavHracku()
    //Log.print("počet hraček: " +s.getHracka());          přesunuto do SklasSoucastky - sestavHracku()









}
