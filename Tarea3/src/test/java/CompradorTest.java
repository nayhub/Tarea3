import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CompradorTest {
    private Comprador compradorPrueba;
    private Expendedor expendedorPrueba = new Expendedor(3,300);
    private Moneda monedaPrueba = new Moneda1000();
    @BeforeEach
    void setUp() throws NoHayProductoException, PagoInsuficienteException, PagoIncorrectoException {
        compradorPrueba = new Comprador(monedaPrueba, 3, expendedorPrueba);
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    @DisplayName("Test de vuelto")
    public void testvuelto() {
        System.out.println("Tu vuelto es: "+compradorPrueba.Vuelto());
        assertEquals(700, compradorPrueba.Vuelto());
    }

    @Test
    @DisplayName("Test Dulce")
    public void nombreProducto() {
        System.out.println("Comio: "+ compradorPrueba.ComisteBebiste());
        assertEquals("Snicker",compradorPrueba.ComisteBebiste());
    }
}