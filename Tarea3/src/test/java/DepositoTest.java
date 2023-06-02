import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import static org.junit.jupiter.api.Assertions.*;
class DepositoTest {
    @Test
    @DisplayName("Test de agregar bebidas")
    public void testdeposito() {

        var deposito = new Deposito<>();
        var cocacola = new CocaCola(1);
        var sprite = new Sprite(1);

        deposito.addProducto(cocacola);
        deposito.addProducto(sprite);

        assertEquals(cocacola, deposito.getProducto());
        assertEquals(sprite, deposito.getProducto());

    }

    @Test
    @DisplayName("Test de agregar dulces")
    public void testdeposito2() {

        var deposito = new Deposito<>();
        var super8 = new Super8(1);
        var snicker = new Snicker(1);

        deposito.addProducto(super8);
        deposito.addProducto(snicker);

        assertEquals(super8, deposito.getProducto());
        assertEquals(snicker, deposito.getProducto());

    }



}