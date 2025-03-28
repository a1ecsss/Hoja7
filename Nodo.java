public class Nodo<K, V> {
    private K clave;
    private V valor;
    private Nodo<K, V> left;
    private Nodo<K, V> right;

    public Nodo(K clave, V valor) {
        this.clave = clave;
        this.valor = valor;
        this.left = null;
        this.right = null;
    }

    public K getClave() {
        return clave;
    }

    public V getValor() {
        return valor;
    }

    public Nodo<K, V> getleft() {
        return left;
    }

    public Nodo<K, V> getright() {
        return right;
    }

    public void setleft(Nodo<K, V> left) {
        this.left = left;
    }

    public void setright(Nodo<K, V> right) {
        this.right = right;
    }
}