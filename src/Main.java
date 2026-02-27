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

    DelnikMonter monter1 = new DelnikMonter(m, s, "Montér1");
    DelnikMonter monter2 = new DelnikMonter(m, s, "Montér2");

    DelnikBalic balic = new DelnikBalic(m, s);

    Log ukoncit = new Log(m, s);


    Thread vyrobniStaniceHlava = new Thread(vyrobceHlava);
    Thread vyrobniStaniceTelo = new Thread(vyrobceTelo);
    Thread vyrobniStaniceNohy = new Thread(vyrobceRuce);
    Thread vyrobniStaniceRuce = new Thread(vyrobceNohy);

    Thread skladnikStanice = new Thread(skladnik);

    Thread montovaciStanice1 = new Thread(monter1);
    Thread montovaciStanice2 = new Thread(monter2);

    Thread baliciStanice = new Thread(balic);

    Thread ukoncitThead = new Thread(ukoncit);




    try{
        vyrobniStaniceHlava.start();
        vyrobniStaniceTelo.start();
        vyrobniStaniceNohy.start();
        vyrobniStaniceRuce.start();

        skladnikStanice.start();

        montovaciStanice1.start();
        montovaciStanice2.start();

        baliciStanice.start();

        ukoncitThead.start();
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

        baliciStanice.join();

        ukoncitThead.join();
    }catch(Exception e){
        e.printStackTrace();
    }



    for(;;){
        if(s.isDokoncitVyrobu() == true){
            IO.print("Počet Hlav:" +s.getHlava());
            IO.print("Počet Těl:" +s.getTelo());
            IO.print("Počet Ruce:" +s.getRuce());
            IO.print("Počet Nohy:" +s.getNohy());
            IO.print("počet hraček: " +s.getHracka());

            IO.print(vyrobceHlava.getJmeno()+ " vyrobil "   +vyrobceHlava.getVyrobenoVeci()+ " součástek");
            IO.print(vyrobceNohy.getJmeno()+ " vyrobil "   +vyrobceNohy.getVyrobenoVeci()+ " součástek");
            IO.print(vyrobceRuce.getJmeno()+ " vyrobil "   +vyrobceRuce.getVyrobenoVeci()+ " součástek");
            IO.print(vyrobceTelo.getJmeno()+ " vyrobil "   +vyrobceTelo.getVyrobenoVeci()+ " součástek");

            IO.print(monter1.getJmeno()+ " sestavil "   +monter1.getVyrobenoVeci()+ " hraček");
            IO.print(monter2.getJmeno()+ " sestavil "   +monter2.getVyrobenoVeci()+ " hraček");

            IO.print(balic.getJmeno()+ " zabalil "   +balic.getVyrobenoVeci()+ " krabic");

            System.exit(0);
        }
    }






    //Log.print("Počet Hlav:" +s.getHlava());         přesunuto do SklasSoucastky - sestavHracku()
    //Log.print("Počet Těl:" +s.getTelo());       přesunuto do SklasSoucastky - sestavHracku()
    //Log.print("Počet Ruce:" +s.getRuce());           přesunuto do SklasSoucastky - sestavHracku()
    //Log.print("Počet Nohy:" +s.getNohy());           přesunuto do SklasSoucastky - sestavHracku()
    //Log.print("počet hraček: " +s.getHracka());          přesunuto do SklasSoucastky - sestavHracku()









}
