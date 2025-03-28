// "c:\program files\java\jdk-22\bin\java" main

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // crear lector para cargar inventario
        Lector inventario = new Lector();
        Scanner scanner = new Scanner(System.in);
        boolean seguir = true; // bandera para controlar el menú
        
        try {
            // cargar inventario desde csv
            inventario.cargarInventarioDesdeCSV("inventario_ropa_deportiva_100.csv");
            Producto producto;
            String busqueda;
            // bucle del menú
            while (seguir) {
                // mostrar menú
                System.out.println("----- menú -----");
                System.out.println("1. productos por sku");
                System.out.println("2. productos por nombre");
                System.out.println("3. buscar por sku");
                System.out.println("4. buscar por nombre");
                System.out.println("5. salir");
                System.out.print("opción (1-5): ");
                
                int opcion = scanner.nextInt();
                scanner.nextLine(); // limpiar buffer

                switch (opcion) {
                    case 1:
                        // productos por sku
                        System.out.println("productos ordenados por sku:");
                        inventario.listarPorSku();
                        break;

                    case 2:
                        // productos por nombre
                        System.out.println("productos ordenados por nombre:");
                        inventario.listarPorNombre();
                        break;

                    case 3:
                        // buscar por sku
                        System.out.print("ingrese sku: ");
                        busqueda = scanner.nextLine().toLowerCase().trim();
                        producto = inventario.buscarPorSku(busqueda);
                        if (producto != null) {
                            System.out.println("\n encontrado: " + producto + "\n");
                        } else {
                            System.out.println("\nno encontrado.\n");
                        }
                        break;

                    case 4:
                        // buscar por nombre
                        System.out.print("ingrese nombre: ");
                        busqueda = scanner.nextLine().toLowerCase().trim();
                        producto = inventario.buscarPorNombre(busqueda);
                        if (producto != null) {
                            System.out.println("\n encontrado: " + producto + "\n");
                        } else {
                            System.out.println("\nno encontrado.\n");
                        }
                        break;

                    case 5:
                        // salir
                        System.out.println("saliste, vuelve pronto :D");
                        seguir = false; // salir del bucle
                        break;

                    default:
                        System.out.println("opción inválida.");
                        break;
                }
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            scanner.close(); // cerrar scanner
        }
    }
}
