import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Palya {

    private final int sor = 6;
    private final int oszlop = 7;
    private char[][] palya;

    public char[][] getPalya() {
        return palya;
    }

    public Palya(){
        palya = new char[sor][oszlop];
        for (int i = 0; i < sor; i++) {
            for (int j = 0; j < oszlop; j++) {
                palya[i][j] = '-';
            }
        }
    }

    public short palyaKiirasa(){
        System.out.println();
        for (int i = 0; i < sor; i++) {
            for (int j = 0; j < oszlop; j++) {
                System.out.print(" "+ palya[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println(" 1  2  3  4  5  6  7");
        return 0;
    }

    public boolean palyaModositas(int bekert, char jel){
        for (int i = sor-1; i >=0 ; i--) {
            if(palya[i][bekert-1]== '-'){
                palya[i][bekert-1] = jel;
                return true;
            }
        }
        return false;
    }
//    public boolean oszlopTele(int bekert){
//        for(int i = 0; i < sor; i++){
//            if(palya[i][bekert] != '-')return true;
//        }return false;
//    }
    public void jatekMentese(String filepath) throws IOException {
        try (BufferedWriter kiir = new BufferedWriter(new FileWriter(filepath))) {
            for (int i = 0; i < 6; i++) {
                for (int j = 0; j < 7; j++) {
                    kiir.write(palya[i][j]);
                }
                kiir.newLine();
            }
        }
    }

    public boolean gyoztesEllenorzes(char jel){

            for(int i = 0; i<sor; i++){
                for (int j = 0;j < oszlop - 3;j++){
                    if (palya[i][j] == jel && palya[i][j+1] == jel && palya[i][j+2] == jel && palya[i][j+3] == jel){
                        return true;
                    }
                }
            }

            for(int i = 0; i < sor - 3; i++){
                for(int j = 0; j < oszlop; j++){
                    if (palya[i][j] == jel && palya[i+1][j] == jel && palya[i+2][j] == jel && palya[i+3][j] == jel){
                        return true;
                    }
                }
            }

            for(int i = 3; i < sor; i++){
                for(int j = 0; j < oszlop - 3; j++){
                    if (palya[i][j] == jel && palya[i-1][j+1] == jel && palya[i-2][j+2] == jel && palya[i-3][j+3] == jel){
                        return true;
                    }
                }
            }

            for(int i = 0; i < sor - 3; i++){
                for(int j = 0; j < oszlop - 3; j++){
                    if (palya[i][j] == jel && palya[i+1][j+1] == jel && palya[i+2][j+2] == jel && palya[i+3][j+3] == jel){
                        return true;
                    }
                }
            }
            return false;

    }

}

