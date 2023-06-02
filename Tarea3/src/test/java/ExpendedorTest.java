import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ExpendedorTest {
    @Test
    @DisplayName("Test Expendedor")
    public void testExpendedor() {
        Expendedor expendedor = new Expendedor(5, 200);

        // Prueba de comprar una bebida válida con suficiente pago
        Moneda moneda = new Moneda(500) {
            @Override
            public int getValor() {
                return 0;
            }
        };
        Producto producto = null;
        try {
            producto = expendedor.comprarBebida(moneda, 1);
        } catch (Exception e) {
            e.printStackTrace();
        }
        assertNotNull(producto);
        assertEquals("Coca Cola", producto.getNombre());

        // Prueba de comprar una bebida válida con pago insuficiente
        moneda = new Moneda(100) {
            @Override
            public int getValor() {
                return 0;
            }
        };
        Moneda finalMoneda = moneda;
        assertThrows(PagoInsuficienteException.class, () -> expendedor.comprarBebida(finalMoneda, 2));

        // Prueba de comprar una bebida inválida
        moneda = new Moneda(500) {
            @Override
            public int getValor() {
                return 0;
            }
        };
        Moneda finalMoneda1 = moneda;
        assertThrows(NoHayProductoException.class, () -> expendedor.comprarBebida(finalMoneda1, 5));

        // Prueba de obtener el vuelto
        Moneda vuelto = expendedor.getVuelto();
        assertNotNull(vuelto);
        assertEquals(300, vuelto.getValor());
    }
}
