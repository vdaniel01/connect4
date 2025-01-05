import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.io.File;
import java.io.IOException;

public class PalyaTest {

    private Palya palya;

    @BeforeEach
    public void setUp() {
        palya = new Palya();
    }

    @Test
    public void testPalyaKiirasa() {
        StringBuilder sb = new StringBuilder();
        sb.append("\n");
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 7; j++) {
                sb.append(" - ");
            }
            sb.append("\n");
        }
        sb.append(" 1  2  3  4  5  6  7\n");

        assertEquals(sb.toString(), palya.palyaKiirasa());
    }

    @Test
    public void testPalyaModositas() {
        // Tesztelni kell, hogy a palyaModositas valóban frissíti a táblát
        boolean result = palya.palyaModositas(3, 'X');
        assertTrue(result, "A módosításnak sikeresnek kell lennie");
        assertEquals('X', palya.getPalya()[5][2], "Az X jelnek a harmadik oszlop legalsó sorába kell kerülnie");
    }

    @Test
    public void testGyoztesEllenorzes() {
        // Teszteljük, hogy a gyoztesEllenorzes megfelelően felismeri a győzelmet vízszintesen
        palya.getPalya()[5][0] = 'X';
        palya.getPalya()[5][1] = 'X';
        palya.getPalya()[5][2] = 'X';
        palya.getPalya()[5][3] = 'X';

        boolean result = palya.gyoztesEllenorzes('X');
        assertTrue(result, "A győzelmet felismerni kell vízszintesen");

        // Teszteljük, hogy függőlegesen is helyes a győzelem ellenőrzés
        palya.getPalya()[0][0] = 'O';
        palya.getPalya()[1][0] = 'O';
        palya.getPalya()[2][0] = 'O';
        palya.getPalya()[3][0] = 'O';

        result = palya.gyoztesEllenorzes('O');
        assertTrue(result, "A győzelmet felismerni kell függőlegesen");
    }

}
