import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import static org.junit.jupiter.api.Assertions.*;
class Moneda100Test {
    @Test
    @DisplayName("Test de valor de monedas de 100")
    public void testmoneda100() {

        var moneda100 = new Moneda100();

        assertEquals(100, moneda100.getValor());
    }
}