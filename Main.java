import java.util.Scanner;

public class Main {
    // Definición de nombres de archivos CSV según lo requerido
    static String archivoClientes = "clientes.csv"; //
    static String archivoPedidos = "pedidos.csv";   //

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int opcion = 0;

        do {
            System.out.println("\n--- MENÚ DE GESTIÓN ---");
            System.out.println("1. Registrar un cliente (Persona 1)");
            System.out.println("2. Listar clientes (Persona 1)");
            System.out.println("3. Eliminar un cliente - Lógica (Persona 3)");
            System.out.println("4. Registrar un pedido (Persona 2)");
            System.out.println("5. Listar pedidos de un cliente (Persona 2)");
            System.out.println("6. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = sc.nextInt();
            sc.nextLine(); // Limpiar el buffer

            switch (opcion) {
                case 1: registrarCliente(sc); break;
                case 2: listarClientes(); break;
                case 3: eliminarClienteLogico(sc); break;
                case 4: registrarPedido(sc); break;
                case 5: listarPedidosPorCliente(sc); break;
                case 6: System.out.println("Saliendo..."); break;
                default: System.out.println("Opción no válida.");
            }
        } while (opcion != 6);
    }

    // --- BLOQUE PERSONA 1: CLIENTES ---
    public static void registrarCliente(Scanner sc) {
        // Aquí Persona 1 debe pedir nombre, apellido, teléfono
        // Y guardarlos en clientes.csv con activo = 1
        System.out.println("Trabajando en: Registrar Cliente...");
    }

    public static void listarClientes() {
        // Aquí Persona 1 debe leer clientes.csv y mostrar los que tengan activo = 1
        System.out.println("Trabajando en: Listar Clientes...");
    }

    // --- BLOQUE PERSONA 2: PEDIDOS ---
    public static void registrarPedido(Scanner sc) {
        // Aquí Persona 2 pide id_cliente, producto, precio y cantidad
        // Se guarda en pedidos.csv con activo = 1
        System.out.println("Trabajando en: Registrar Pedido...");
    }

    public static void listarPedidosPorCliente(Scanner sc) {
       System.out.print("Ingrese el ID del cliente: ");
        int idCliente = sc.nextInt();

        listarPedidosPorCliente(idCliente);
    

    
        boolean encontrado = false;

        try (BufferedReader br = new BufferedReader(new FileReader(ARCHIVO_PEDIDOS))) {
            String linea;

            // Saltar encabezado
            br.readLine();

            System.out.println("\nPedidos del cliente ID " + idCliente + ":");

            while ((linea = br.readLine()) != null) {
                String[] datos = linea.split(",");

                int idPedido = Integer.parseInt(datos[0]);
                int clientePedido = Integer.parseInt(datos[1]);
                String producto = datos[2];
                String precio = datos[3];
                String cantidad = datos[4];
                int activo = Integer.parseInt(datos[5]);

                if (clientePedido == idCliente && activo == 1) {
                    System.out.println("Pedido ID: " + idPedido +
                            " | Producto: " + producto +
                            " | Precio: " + precio +
                            " | Cantidad: " + cantidad);
                    encontrado = true;
                }
            }

            if (!encontrado) {
                System.out.println("No hay pedidos activos para este cliente.");
            }

        } catch (IOException e) {
            System.out.println("Error al leer el archivo pedidos.csv");
        }
        System.out.println("Trabajando en: Listar Pedidos de un Cliente...");
    }

    // --- BLOQUE PERSONA 3: ELIMINACIÓN Y SALIDA ---
    public static void eliminarClienteLogico(Scanner sc) {
        // Aquí Persona 3 debe buscar el cliente y cambiar su estado de 1 a 0
        System.out.println("Trabajando en: Eliminar Cliente (Lógica)...");
    }
}