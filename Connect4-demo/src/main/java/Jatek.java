import java.util.Random;
import java.util.Scanner;

public class Jatek   {

    private Palya palya;
    private Jatekos jatekos1;
    private Jatekos jatekos2;
    private Jatekos currentJatekos;
    private Adatbazis adatbazis;


    public int gepValasztasa(){
        Random random = new Random();
        System.out.println("A gép gondolkodik...");
        int gepBekert = random.nextInt(7)+1;
        return gepBekert;
    }
    
    public Jatek(){
        System.out.println("Program betöltése...");
        System.out.print("Üdvözöllek a Connect4 nevű játékban!\nJátékos neve: ");
        Scanner scanner = new Scanner(System.in);
        String nev = scanner.next();
        System.out.println(nev + " nevű játékos készülj!");
        System.out.println("Pálya inicializálása...");
        palya = new Palya();
        adatbazis = new Adatbazis();
        jatekos1 = new Jatekos(nev, 'O');
        jatekos2 = new Jatekos("Gép", 'X');
        currentJatekos = jatekos1;

        boolean jatekVege = false;


        while(!jatekVege){
            palya.palyaKiirasa();
            System.out.println(currentJatekos.getNev() + " választ... ");

            if(currentJatekos == jatekos1) {
                int bekert = scanner.nextInt();
                if(bekert > 0 && bekert < 8) {
                    palya.palyaModositas(bekert, currentJatekos.getJel());
                    currentJatekos = (currentJatekos == jatekos1) ? jatekos2 : jatekos1;
                }else{
                    System.out.println("Csak valós oszlopot adhatsz meg!");
                    //bekert = scanner.nextInt();
                }
//                if(palya.oszlopTele(bekert)){
//                    System.out.println("Válassz más oszlopot, ez már tele van.");
//                    bekert = scanner.nextInt();
//                }
            }else{
                palya.palyaModositas(gepValasztasa(), currentJatekos.getJel());
                palya.palyaKiirasa();
                currentJatekos = (currentJatekos == jatekos1) ? jatekos2 : jatekos1;
            }

            jatekVege = palya.gyoztesEllenorzes(currentJatekos.getJel());

                if(jatekVege){
                    palya.palyaKiirasa();
                    System.out.println(currentJatekos.getNev()+ " nyert!");
                    adatbazis.gyoztestHozzaad(currentJatekos.getNev());
                    break;
                }

            }
            if(!jatekVege){
                palya.palyaKiirasa();
                System.out.println("Döntetlen");
            }

        scanner.close();
           // palya.jatekMentese();
        adatbazis.ranglistaKiirasa();
        }

    }

