import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import static org.junit.jupiter.api.Assertions.*;

class DepositoVTest {
    @Test
    @DisplayName("Prueba de agregar y obtener monedas del depósito")
    public void testDepositoVuelto() {
        DepositoV<MonedaConcreta> deposito = new DepositoV<>();

        MonedaConcreta moneda1 = new MonedaConcreta(100);
        MonedaConcreta moneda2 = new MonedaConcreta(200);
        MonedaConcreta moneda3 = new MonedaConcreta(500);

        deposito.addMoneda(moneda1);
        deposito.addMoneda(moneda2);
        deposito.addMoneda(moneda3);


        assertEquals(moneda1, deposito.getMoneda());
        assertEquals(moneda2, deposito.getMoneda());
        assertEquals(moneda3, deposito.getMoneda());
        assertNull(deposito.getMoneda());
    }
}

