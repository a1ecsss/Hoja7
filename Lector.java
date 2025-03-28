import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Lector {
    private Arbol<String, Producto> skuArbol;
    private Arbol<String, Producto> nombreArbol;

    public Lector() {
        skuArbol = new Arbol<>();
        nombreArbol = new Arbol<>();
    }

    //cargar los productos desde un archivo CSV
    public void cargarInventarioDesdeCSV(String rutaArchivo) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(rutaArchivo));
        String linea;
        while ((linea = br.readLine()) != null) {
            //se pasa todo a minusculas y sin espacios en los extremos
            //separar los datos por comas
            String[] datos = linea.split(",");
            String sku = datos[0].toLowerCase().trim();
            String nombre = datos[1].toLowerCase().trim();
            String descripcion = datos[2].toLowerCase().trim();
            String cantidadTalla = datos[3].toLowerCase().trim();
            Producto producto = new Producto(sku, nombre, descripcion, cantidadTalla);
            skuArbol.insertarNodo(sku, producto);
            nombreArbol.insertarNodo(nombre, producto);
        }
        br.close();
    }

    //buscar producto por SKU
    public Producto buscarPorSku(String sku) {
        return skuArbol.buscar(sku);
    }

    //buscar producto por nombre
    public Producto buscarPorNombre(String nombre) {
        return nombreArbol.buscar(nombre);
    }

    //mostrar productos en orden por nombre
    public void listarPorNombre() {
        nombreArbol.inorder();
    }

    //mostrar productos en orden por SKU
    public void listarPorSku() {
        skuArbol.inorder();
    }
}
