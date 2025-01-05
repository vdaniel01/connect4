import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;
import org.junit.jupiter.api.Test;

import java.util.Random;

class JatekTest {
    @Test
    void testGepValasztasa() {
        Random randomMock = mock(Random.class);
        when(randomMock.nextInt(7)).thenReturn(5);
        Jatek jatek = new Jatek();
        int eredmeny = jatek.gepValasztasa();
        assertEquals(6, eredmeny);
    }
}
