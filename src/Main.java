import Delnici.DelnikVyrobceHlava;
import Delnici.DelnikVyrobceNohy;
import Delnici.DelnikVyrobceRuce;
import Delnici.DelnikVyrobceTelo;
import Sklady.SkladMaterialy;
import Sklady.SkladSoucastky;

void main() {

    SkladMaterialy m = new SkladMaterialy();
    SkladSoucastky s = new SkladSoucastky();

    DelnikVyrobceHlava vyrobceHlava = new DelnikVyrobceHlava(m, s);
    DelnikVyrobceTelo vyrobceTelo = new DelnikVyrobceTelo(m, s);
    DelnikVyrobceRuce vyrobceRuce = new DelnikVyrobceRuce(m, s);
    DelnikVyrobceNohy vyrobceNohy = new DelnikVyrobceNohy(m, s);

    Thread vyrobniStaniceHlava = new Thread(vyrobceHlava);
    Thread vyrobniStaniceTelo = new Thread(vyrobceTelo);
    Thread vyrobniStaniceNohy = new Thread(vyrobceRuce);
    Thread vyrobniStaniceRuce = new Thread(vyrobceNohy);

    try{
        vyrobniStaniceHlava.start();
        vyrobniStaniceTelo.start();
        vyrobniStaniceNohy.start();
        vyrobniStaniceRuce.start();
    }catch(Exception e){
        e.printStackTrace();
    }

    try{
        vyrobniStaniceHlava.join();
        vyrobniStaniceTelo.join();
        vyrobniStaniceNohy.join();
        vyrobniStaniceRuce.join();
    }catch(Exception e){
        e.printStackTrace();
    }

    System.out.println("Počet Hlav:" +s.getHlava());
    System.out.println("Počet Těl:" +s.getTelo());
    System.out.println("Počet Ruce:" +s.getRuce());
    System.out.println("Počet Nohy:" +s.getNohy());









}
