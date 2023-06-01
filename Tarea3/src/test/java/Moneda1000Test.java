import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import static org.junit.jupiter.api.Assertions.*;
class Moneda1000Test {
    @Test
    @DisplayName("Test de valor de monedas de 1000")
    public void testmoneda1000() {

        var moneda1000 = new Moneda1000();

        assertEquals(1000, moneda1000.getValor());
    }
}