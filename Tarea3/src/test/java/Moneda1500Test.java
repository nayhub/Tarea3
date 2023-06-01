import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import static org.junit.jupiter.api.Assertions.*;
class Moneda1500Test {
    @Test
    @DisplayName("Test de valor de monedas de 1500")
    public void testmoneda1500() {

        var moneda1500 = new Moneda1500();

        assertEquals(1500, moneda1500.getValor());
    }
}