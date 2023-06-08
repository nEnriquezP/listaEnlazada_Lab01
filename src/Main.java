import java.util.Scanner;

class Nodo {
    int dato;
    Nodo siguiente;

    public Nodo(int dato) {
        this.dato = dato;
        this.siguiente = null;
    }
}

class ListaEnlazada {
    private Nodo inicio;

    public ListaEnlazada() {
        inicio = null;
    }

    public void insertarAlInicio(int dato) {
        Nodo nuevoNodo = new Nodo(dato);
        if (inicio == null) {
            inicio = nuevoNodo;
        } else {
            nuevoNodo.siguiente = inicio;
            inicio = nuevoNodo;
        }
        System.out.println("Elemento insertado al inicio");
    }

    public void insertarAlFinal(int dato) {
        Nodo nuevoNodo = new Nodo(dato);
        if (inicio == null) {
            inicio = nuevoNodo;
        } else {
            Nodo actual = inicio;
            while (actual.siguiente != null) {
                actual = actual.siguiente;
            }
            actual.siguiente = nuevoNodo;
        }
        System.out.println("Elemento insertado al final");
    }

    public void recorrer() {
        if (inicio == null) {
            System.out.println("La lista está vacía");
        } else {
            System.out.println("Elementos de la lista:");
            Nodo actual = inicio;
            while (actual != null) {
                System.out.print(actual.dato + " ");
                actual = actual.siguiente;
            }
            System.out.println();
        }
    }

    public void buscarElemento(int elemento) {
        if (inicio == null) {
            System.out.println("La lista está vacía");
        } else {
            Nodo actual = inicio;
            int posicion = 1;
            boolean encontrado = false;
            while (actual != null) {
                if (actual.dato == elemento) {
                    System.out.println("Elemento encontrado en la posición " + posicion);
                    encontrado = true;
                    break;
                }
                actual = actual.siguiente;
                posicion++;
            }
            if (!encontrado) {
                System.out.println("Elemento no encontrado");
            }
        }
    }

    public void borrarElemento(int elemento) {
        if (inicio == null) {
            System.out.println("La lista está vacía");
        } else {
            if (inicio.dato == elemento) {
                inicio = inicio.siguiente;
                System.out.println("Elemento borrado");
            } else {
                Nodo actual = inicio;
                Nodo anterior = null;
                boolean encontrado = false;
                while (actual != null) {
                    if (actual.dato == elemento) {
                        anterior.siguiente = actual.siguiente;
                        System.out.println("Elemento borrado");
                        encontrado = true;
                        break;
                    }
                    anterior = actual;
                    actual = actual.siguiente;
                }
                if (!encontrado) {
                    System.out.println("Elemento no encontrado");
                }
            }
        }
    }
}
//Tarea_Progra3_NelsonEnriquez
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ListaEnlazada lista = new ListaEnlazada();

        int opcion;
        do {
            System.out.println("\n----- MENU -----");
            System.out.println("1. Insertar al inicio");
            System.out.println("2. Insertar al final");
            System.out.println("3. Recorrer");
            System.out.println("4. Buscar elemento");
            System.out.println("5. Borrar elemento");
            System.out.println("0. Salir");
            System.out.print("Ingrese una opción: ");
            opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    System.out.print("Ingrese el elemento a insertar al inicio: ");
                    int datoInicio = scanner.nextInt();
                    lista.insertarAlInicio(datoInicio);
                    break;
                case 2:
                    System.out.print("Ingrese el elemento a insertar al final: ");
                    int datoFinal = scanner.nextInt();
                    lista.insertarAlFinal(datoFinal);
                    break;
                case 3:
                    lista.recorrer();
                    break;
                case 4:
                    System.out.print("Ingrese el elemento a buscar: ");
                    int elementoBuscar = scanner.nextInt();
                    lista.buscarElemento(elementoBuscar);
                    break;
                case 5:
                    System.out.print("Ingrese el elemento a borrar: ");
                    int elementoBorrar = scanner.nextInt();
                    lista.borrarElemento(elementoBorrar);
                    break;
                case 0:
                    System.out.println("Saliendo del programa...");
                    break;
                default:
                    System.out.println("Opción inválida");
                    break;
            }
        } while (opcion != 0);
        scanner.close();
    }
}
