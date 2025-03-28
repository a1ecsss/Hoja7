import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class ArbolTest {
    private Arbol<String, String> arbol;

    @Before
    public void setUp() {
        arbol = new Arbol<>();
    }

    @Test
    public void testInsertarNodo() {
        arbol.insertarNodo("123", "Producto 1");
        String resultado = arbol.buscar("123");
        assertEquals("Producto 1", resultado);
    }

    @Test
    public void testBuscarNodoExistente() {
        arbol.insertarNodo("123", "Producto 1");
        arbol.insertarNodo("456", "Producto 2");
        String resultado = arbol.buscar("123");
        assertEquals("Producto 1", resultado);

        resultado = arbol.buscar("456");
        assertEquals("Producto 2", resultado);
    }

    @Test
    public void testBuscarNodoNoExistente() {
        String resultado = arbol.buscar("999");
        assertNull(resultado);
    }

    @Test
    public void testRecorridoEnOrden() {
        arbol.insertarNodo("123", "Producto 1");
        arbol.insertarNodo("456", "Producto 2");
        arbol.insertarNodo("789", "Producto 3");
    }
}
