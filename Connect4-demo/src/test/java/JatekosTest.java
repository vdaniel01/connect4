import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class JatekosTest {

    private Jatekos jatekos;

    @BeforeEach
    public void setUp() {
        // Minden teszt előtt új játékost hozunk létre
        jatekos = new Jatekos("Anna", 'X');
    }

    @Test
    public void testJatekosNev() {
        // Ellenőrizzük, hogy a játékos neve helyesen van-e beállítva
        assertEquals("Anna", jatekos.getNev(), "A játékos neve helytelen!");
    }

    @Test
    public void testJatekosJel() {
        // Ellenőrizzük, hogy a játékos jele helyesen van-e beállítva
        assertEquals('X', jatekos.getJel(), "A játékos jele helytelen!");
    }
}
