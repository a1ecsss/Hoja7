public class Producto {
    private String sku;
    private String nombre;
    private String descripcion;
    private String tallas;

    public Producto(String sku, String nombre, String descripcion, String tallas) {
        this.sku = sku;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.tallas = tallas;
    }

    public String getSku() { return sku; }

    public String getNombre() { return nombre; }

    public String getDescripcion() { return descripcion; }

    public String gettallas() { return tallas; }

    //metodo para imprimir datos del producto
    @Override
    public String toString() {
        return "SKU:" + sku + ", Nombre:" + nombre + ", Descripción:" + descripcion + ", Cantidad por talla:" + tallas + "";
    }
}
