import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import static org.junit.jupiter.api.Assertions.*;
class Moneda500Test {
    @Test
    @DisplayName("Test de valor de monedas de 500")
    public void testmoneda500() {

        var moneda500 = new Moneda500();

        assertEquals(500, moneda500.getValor());
    }
}