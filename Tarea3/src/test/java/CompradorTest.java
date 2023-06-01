import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CompradorTest {
    private Comprador compradorTest;
    private Expendedor expendedorTest = new Expendedor(3,300);
    private Moneda monedaTest = new Moneda1000();
    @BeforeEach
    void setUp() throws NoHayProductoException, PagoInsuficienteException, PagoIncorrectoException {
        compradorTest = new Comprador(monedaTest, 3, expendedorTest);
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    @DisplayName("Test de vuelto")
    public void Vuelto() {
        System.out.println("Tu vuelto es: "+compradorTest.Vuelto());
        assertEquals(700, compradorTest.Vuelto());
    }

    @Test
    @DisplayName("Test del producto")
    public void Producto() {
        System.out.println("Compro: "+ compradorTest.ComisteBebiste());
        assertEquals("snickers",compradorTest.ComisteBebiste());
    }
}