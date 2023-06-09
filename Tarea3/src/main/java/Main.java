import java.util.ArrayList;
public class Main {
    public static void main(String[] args) {
        Expendedor exp = new Expendedor(1, 300);
        Comprador c = null;
        Moneda m = null;


        try {
            m = new Moneda500();
            c = new Comprador(m, 1, exp);
            System.out.println("Bebida " + c.ComisteBebiste() + " tu vuelto es de " + c.Vuelto());
            m = new Moneda500();
            c = new Comprador(m, 2, exp);
            System.out.println("Bebida " + c.ComisteBebiste() + " tu vuelto es de " + c.Vuelto());
            m = new Moneda1000();
            c = new Comprador(m, 3, exp);
            System.out.println("Dulce " + c.ComisteBebiste() + " tu vuelto es de " + c.Vuelto());
            m = new Moneda1500();
            c = new Comprador(m, 4, exp);
            System.out.println("Dulce " + c.ComisteBebiste() + " tu vuelto es de " + c.Vuelto());
        }
        catch (PagoInsuficienteException INS) {
            int devolucion = m.getValor();
            System.out.println("No le alcanza, " + "tenga su devolucion "+devolucion );
        }
        catch (NoHayProductoException noHay){
            int devolucion = m.getValor();
            System.out.println("No queda el dulce o bebida elegido,"+"devolucion "+devolucion );
        }
        catch (PagoIncorrectoException ErrorEnPago){
            System.out.println("Error en su pago, intente nuevamente");
        }
    }
}

/**
 superclase de bebida
 */
abstract class Producto {
    private int serie;

    /**
     * constructor el cual recibe la serie del producto
     * @param serie
     */
    public Producto(int serie){
        this.serie=serie;
    }

    /** metodo que retorna la serie con getter
     *
     */

    public int getSerie(){
        return serie;
    }

    /** metodo abstracto que toma el nombre del producto con un getter
     *
     */

    public abstract String getnombre();

    public abstract String getNombre();
}


/**
 superclase abstracta para CocaCola y Sprite y subclase de Producto
 */
abstract class Bebida extends Producto{

    /**
     constructor el cual recibe la serie de la bebida
     */
    public Bebida(int serie) {
        super(serie);
    }


}

/** subclase de bebida
 *
 */
class CocaCola extends Bebida {

    /** constructor el cual recibe la serie de cocacola
     *
     * @param serie
     */


    public CocaCola(int serie)
    {
        super(serie);
    }

    /** metodo para obtener el nombre de la bebida con un getter
     *
     * @return cocacola
     */
    public String getnombre() {
        return "cocacola";
    }

    @Override
    public String getNombre() {
        return null;
    }
}

/** subclase de bebida
 *
 */
class Sprite extends Bebida  {

    /** constructor el cual recibe la serie de sprite
     *
     * @param serie
     */
    public Sprite(int serie)
    {
        super(serie);
    }

    public String getnombre() {

        /** metodo para obtener el nombre de la bebida con un getter
         *
         * @return sprite
         */

        return "sprite";
    }

    @Override
    public String getNombre() {
        return null;
    }
}
/**
 superclase abstracta para Snicker y Super8, subclase de Producto
 */
abstract class Dulce extends Producto{

    /** constructor el cual recibe la serie de la bebida
     *
     * @param serie
     */

    public Dulce(int serie) {
        super(serie);
    }

    /** subclase de Dulce
     *
     */
}
class Snicker extends Dulce{

    /** constructor el cual recibe la serie de Snicker
     *
     * @param serie
     */
    public Snicker(int serie)
    {
        super(serie);
    }

    /** metodo para obtener el nombre del dulce con un getter
     *
     * @return snicker
     */

    public String getnombre() {
        return "snicker";
    }

    @Override
    public String getNombre() {
        return null;
    }
}

/** subclase de Dulce
 *
 */
class Super8 extends Dulce {

    /** constructor el cual recibe la serie de Super8
     *
     * @param serie
     */

    public Super8(int serie)
    {
        super(serie);
    }

    /** constructor el cual recibe la serie de Super8
     *
     * @return Super8
     */
    public String getnombre() {

        return "super8";
    }

    @Override
    public String getNombre() {
        return null;
    }
}
/**
 * clase para el comprador del producto
 */
class Comprador {

    private String producto;

    private Expendedor exp;

    private int vuelto;

    /** exepción para pago insuficiente y en caso de que no haya producto
     *
     *
     * @param m
     * @param cualBebida
     * @param exp
     * @throws PagoInsuficienteException
     * @throws NoHayProductoException
     */

    public Comprador(Moneda m, int cualBebida, Expendedor exp) throws PagoInsuficienteException, NoHayProductoException {
        this.exp = exp;

        Producto productoComprado = exp.comprarBebida(m, cualBebida);
        if (productoComprado != null) {
            for (ProductosEnumeracion productoEnum : ProductosEnumeracion.values()) {
                if (productoEnum.getNum() == cualBebida) {
                    producto = productoEnum.name();
                    break;
                }
            }
        }

        Moneda moneda;
        do {
            moneda = exp.getVuelto();
            if (moneda != null) {
                vuelto += moneda.getValor();
            }
        } while (moneda != null);
    }



    /** metodo que retorna vuelto
     *
     * @return vuelto
     */

    public int Vuelto() {
        return vuelto;
    }

    /** metodo qye retorna el sabor del producto
     *
     * @return sabor
     */
    public String ComisteBebiste() {
        return producto;
    }
}


/** clase que almacena productos
 *
 * @param <T>
 */

class Deposito<T> {

    /** parametro que declara un arreglo al.
     *
     */
    private ArrayList<T> al;

    /** constructor que crea el arreglo de los productos
     *
     */

    public Deposito() {
        al = new ArrayList<T>();
    }

    /** metodo que agrega productos al arreglo
     *
     * @param producto
     */

    public void addProducto(T producto) {
        al.add(producto);
    }

    /** metodo que saca productos del arreglo
     *
     * @return
     */

    public T getProducto() {

        if (al.size() == 0) return null;

        T b = al.remove(0);
        return b;
    }
}

/** clase que almacena monedas para el vuelto
 *
 * @param <T>
 */
class DepositoV<T> {

    /** parametro que crea un arreglo mon
     *
     */
    private ArrayList<T> mon;

    /** constructor para realizar el vuelto
     *
     */
    public DepositoV() {
        mon = new ArrayList<T>();
    }

    /** metodo que agrega monedas al deposito
     *
     * @param moneda
     */
    public void addMoneda(T moneda) {
        mon.add(moneda);
    }

    /** metodo que saca monedas del deposito
     *
     */
    public T getMoneda() {
        if (mon.size() == 0) return null;

        T moneda = mon.remove(0);
        return moneda;
    }

}


/** clase del expendedor
 *
 */

class Expendedor {
    private Deposito coca;
    private Deposito sprite;
    private Deposito snicker;
    private Deposito super8;
    private DepositoV<Moneda> monVu;
    private int Precio;

    public Expendedor(int numProducto, int Precio) {
        this.Precio = Precio;
        coca = new Deposito();
        sprite = new Deposito();
        snicker = new Deposito();
        super8 = new Deposito();
        monVu = new DepositoV<>();

        int initialProductId = 100;

        for (int i = 0; i < numProducto; i++) {
            coca.addProducto(new CocaCola(initialProductId + i));
            sprite.addProducto(new Sprite(initialProductId + 100 + i));
            snicker.addProducto(new Snicker(initialProductId + 200 + i));
            super8.addProducto(new Super8(initialProductId + 300 + i));
        }
    }

    public Producto comprarBebida(Moneda m, int n) throws NullPointerException, NoHayProductoException, PagoInsuficienteException {
        if (m == null)
            throw new PagoIncorrectoException("Pago inválido");

        int vuelto = m.getValor();
        Bebida cc = null;
        Bebida sp = null;
        Dulce sk = null;
        Dulce s8 = null;

        switch (n) {
            case 1:
                if (m.getValor() >= Precio) {
                    cc = (Bebida) coca.getProducto();
                    if (cc != null) {
                        vuelto = m.getValor() - Precio;
                    } else {
                        throw new NoHayProductoException("No hay producto, elija otro por favor");
                    }
                } else {
                    throw new PagoInsuficienteException("Pago insuficiente");
                }
                break;
            case 2:
                if (m.getValor() >= Precio) {
                    sp = (Bebida) sprite.getProducto();
                    if (sp != null) {
                        vuelto = m.getValor() - Precio;
                    } else {
                        throw new NoHayProductoException("No hay producto, elija otro por favor");
                    }
                } else {
                    throw new PagoInsuficienteException("Pago insuficiente");
                }
                break;
            case 3:
                if (m.getValor() >= Precio) {
                    sk = (Dulce) snicker.getProducto();
                    if (sk != null) {
                        vuelto = m.getValor() - Precio;
                    } else {
                        throw new NoHayProductoException("No hay producto, elija otro por favor");
                    }
                } else {
                    throw new PagoInsuficienteException("Pago insuficiente");
                }
                break;
            case 4:
                if (m.getValor() >= Precio) {
                    s8 = (Dulce) super8.getProducto();
                    if (s8 != null) {
                        vuelto = m.getValor() - Precio;
                    } else {
                        throw new NoHayProductoException("No hay producto, elija otro por favor");
                    }
                } else {
                    throw new PagoInsuficienteException("Pago insuficiente");
                }
                break;
            default:
                throw new NoHayProductoException("No existe ese producto, elija otro por favor");
        }

        while (vuelto > 0) {
            monVu.addMoneda(new Moneda100());
            vuelto = vuelto - 100;
        }

        switch (n) {
            case 1:
                return cc;
            case 2:
                return sp;
            case 3:
                return sk;
            case 4:
                return s8;
            default:
                return null;
        }
    }

    public Moneda getVuelto() {
        return monVu.getMoneda();
    }
}

/** superclase abstracta para monedas
 *
 */
abstract class Moneda {
    public Moneda(int i) {
    }

    /** metodo para obtener serie por medio de getter
     *
     * @return moneda
     */
    public Moneda getSerie() {
        return this;
    }

    /** metodo abstracto para obtener el valor
     *
     * @return valor
     */

    public abstract int getValor();

}
/** subclase de Moneda para monedas de 100
 *
 */
class Moneda100 extends Moneda {
    public Moneda100() {
        super(500);
    }

    /** metodo para obtener valor de producto por medio de getter al ser 100
     *
     * @return 100
     */
    public int getValor() {
        return 100;
    }
}
/** subclase de Moneda para monedas de 500
 *
 */
class Moneda500 extends Moneda{
    public Moneda500()
    {
        super(500); }

    /** metodo para obtener valor de producto por medio de getter al ser 500
     *
     * @return 500
     */
    public int getValor()
    {
        return 500; }
}
/** subclase de Moneda para monedas de 1000
 *
 */
class Moneda1000 extends Moneda{
    public Moneda1000(){ super(500); }

    /**
     * metodo para obtener valor de producto por medio de getter al ser 1000
     * @return 1000'
     */
    public int getValor(){ return 1000; }
}
/** subclase de Moneda para monedas de 1500}
 *
 */
class Moneda1500 extends Moneda{
    public Moneda1500(){ super(500); }

    /** metodo para obtener valor de producto por medio de getter al ser 1500
     *
     * @return 1500
     */
    public int getValor(){ return 1500; }
}
/** clase para la exepción en el caso de que no hayan productos
 *
 */
class NoHayProductoException extends Exception{

    /** constructor el cual recibe la exepción si es que no hay producto
     *
     * @param NoHay
     */
    public NoHayProductoException(String NoHay){
        super(NoHay);
    }
}
/** clase para la exepción en caso de que el pago del producto sea invalido
 *
 */
class PagoIncorrectoException extends NullPointerException{

    /**
     * constructor el cual recibe la exepción si es que el pago es invalido
     *
     * @param pagoinvalido
     */
    public PagoIncorrectoException(String pagoinvalido){
        super(pagoinvalido);
    }
}
/** clase para la exepción en caso de que el que el valor ingresado sea inferior
 * al solicitado
 */
class PagoInsuficienteException extends Exception{

    /** constructor el cual recibe la exepción si es que el valor ingresado es inferior
     * al solicitado
     *
     * @param noalcanza
     */
    public PagoInsuficienteException(String noalcanza){
        super(noalcanza);
    }
}
