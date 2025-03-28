public class Arbol<K extends Comparable<K>, V> {
    private Nodo<K, V> raiz;

    public Arbol() {
        this.raiz = null;
    }

    //insertarNodo un nuevo nodo
    public void insertarNodo(K clave, V valor) {
        raiz = insertarNodo(raiz, clave, valor);
    }

    private Nodo<K, V> insertarNodo(Nodo<K, V> raiz, K clave, V valor) {
        if (raiz == null) {
            return new Nodo<>(clave, valor);
        }
        if (clave.compareTo(raiz.getClave()) < 0) {
            raiz.setleft(insertarNodo(raiz.getleft(), clave, valor));
        } else if (clave.compareTo(raiz.getClave()) > 0) {
            raiz.setright(insertarNodo(raiz.getright(), clave, valor));
        }
        return raiz;
    }

    //buscar un nodo por su clave
    public V buscar(K clave) {
        return buscarNodo(raiz, clave);
    }

    private V buscarNodo(Nodo<K, V> raiz, K clave) {
        if (raiz == null) {
            return null;
        }
        if (clave.compareTo(raiz.getClave()) < 0) {
            return buscarNodo(raiz.getleft(), clave);
        } else if (clave.compareTo(raiz.getClave()) > 0) {
            return buscarNodo(raiz.getright(), clave);
        }
        return raiz.getValor();
    }

    // Método para recorrer el árbol en orden
    public void inorder() {
        inorderRecursivo(raiz);
    }

    private void inorderRecursivo(Nodo<K, V> raiz) {
        if (raiz != null) {
            inorderRecursivo(raiz.getleft());
            System.out.println(raiz.getValor().toString());
            inorderRecursivo(raiz.getright());
        }
    }
}
