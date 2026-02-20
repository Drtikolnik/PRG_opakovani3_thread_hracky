import Delnici.*;
import Sklady.SkladMaterialy;
import Sklady.SkladSoucastky;

void main() {

    SkladMaterialy m = new SkladMaterialy();
    SkladSoucastky s = new SkladSoucastky();

    DelnikVyrobceHlava vyrobceHlava = new DelnikVyrobceHlava(m, s);
    DelnikVyrobceTelo vyrobceTelo = new DelnikVyrobceTelo(m, s);
    DelnikVyrobceRuce vyrobceRuce = new DelnikVyrobceRuce(m, s);
    DelnikVyrobceNohy vyrobceNohy = new DelnikVyrobceNohy(m, s);

    DelnikSkladnik skladnik = new DelnikSkladnik(m, s);

    Thread vyrobniStaniceHlava = new Thread(vyrobceHlava);
    Thread vyrobniStaniceTelo = new Thread(vyrobceTelo);
    Thread vyrobniStaniceNohy = new Thread(vyrobceRuce);
    Thread vyrobniStaniceRuce = new Thread(vyrobceNohy);

    Thread skladnikStanice = new Thread(skladnik);

    try{
        vyrobniStaniceHlava.start();
        vyrobniStaniceTelo.start();
        vyrobniStaniceNohy.start();
        vyrobniStaniceRuce.start();

        skladnikStanice.start();
    }catch(Exception e){
        e.printStackTrace();
    }

    try{
        vyrobniStaniceHlava.join();
        vyrobniStaniceTelo.join();
        vyrobniStaniceNohy.join();
        vyrobniStaniceRuce.join();

        skladnikStanice.join();
    }catch(Exception e){
        e.printStackTrace();
    }

    Log.print("Počet Hlav:" +s.getHlava());
    Log.print("Počet Těl:" +s.getTelo());
    Log.print("Počet Ruce:" +s.getRuce());
    Log.print("Počet Nohy:" +s.getNohy());









}
