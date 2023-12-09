package presentacion;

import java.io.*;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Objects;
import java.util.Scanner;

import dominio.Articulo;
import dominio.Catedratico;
import dominio.Profesor;
import dominio.ProfesorTitular;
import dominio.Proyecto;

public class Interfaz implements Serializable {

    private ArrayList<Profesor> profesores;
    private Scanner sc = new Scanner(System.in);

    public Interfaz() {
        leer();
    }

    private void leer() {
        ObjectInputStream obj;
        File file = new File("merito.txt");
        try {
            obj = new ObjectInputStream(new FileInputStream(file));
            try {
                profesores = (ArrayList<Profesor>) obj.readObject();
                obj.close();
            } catch (Exception e) {
                System.out.println("No se pudo leer el archivo");
                profesores = new ArrayList<>();
            }
        } catch (Exception e) {
            profesores = new ArrayList<>();
        }
    }

    private boolean grabar() {
        ObjectOutputStream obj;
        File file = new File("merito.txt");
        try {
            obj = new ObjectOutputStream(new FileOutputStream(file));
            obj.writeObject(profesores);
            obj.close();
            System.out.println("Guardado.");
            return true;
        } catch (Exception e) {
            System.out.println("Error al guardar");
            System.out.println(e);
            return false;
        }
    }

    public void anadirProfesorTitular() {
        System.out.print("Introduzca el nombre del profesor: ");
        String nombre = sc.nextLine();
        profesores.add(new ProfesorTitular(nombre));
    }

    public void anadirCatedratico() {
        System.out.print("Introduzca el nombre del Catedrático: ");
        String nombre = sc.nextLine();
        profesores.add(new Catedratico(nombre));
    }

    public void anadirMerito() {
        System.out.print("Introduce el nombre del profesor: ");
        String nombre = sc.nextLine();
        int n = buscarProfesor(nombre);

        if (n == -1) {
            System.out.println("Profesor no existe");
        } else {
            System.out.print("Titulo del Mérito: ");
            String titulo = sc.nextLine();
            System.out.println("Escoja el tipo de mérito:");
            System.out.println("1. Articulo");
            System.out.println("2. Proyecto");

            try {
                int opcion = sc.nextInt();
                sc.nextLine(); // Consume la nueva línea después del número

                if (opcion == 1) {
                    System.out.print("Introduzca el impacto del artículo: ");
                    double impacto = sc.nextDouble();
                    sc.nextLine();
                    profesores.get(n).anadirMerito(new Articulo(titulo, impacto));
                } else if (opcion == 2) {
                    System.out.print("Introduzca la financiación: ");
                    double financion = sc.nextDouble();
                    sc.nextLine();
                    profesores.get(n).anadirMerito(new Proyecto(titulo, financion));
                } else {
                    System.out.println("Error opción incorrecta");
                }
            } catch (InputMismatchException e) {
                System.out.println("Error: Ingresa un valor numérico válido.");
                sc.nextLine(); // Limpia el buffer del scanner
            }
        }
    }

    private int buscarProfesor(String nombre) {
        if (profesores != null) {
            String nombreLimpio = nombre.trim().toLowerCase();

            for (int i = 0; i < profesores.size(); i++) {
                Profesor profesor = profesores.get(i);
                if (profesor != null && profesor.getNombre() != null
                        && Objects.equals(profesor.getNombre().trim().toLowerCase(), nombreLimpio)) {
                    return i;
                }
            }
        }
        return -1;
    }

    public void menuMerito() {
        System.out.println("========= Menú de Méritos =========");
        System.out.println("|1. Añadir Profesor Titular        |");
        System.out.println("|2. Añadir Catedrático             |");
        System.out.println("|3. Añadir Mérito                  |");
        System.out.println("|4. Mostrar Profesores con Méritos |");
        System.out.println("|5. Guardar y Salir                |");
        System.out.print("Elige una opción: ");
    }

    public void iniciar() {
        boolean continuar = true;

        while (continuar) {
            menuMerito();
            String opcion = sc.nextLine();

            if ("1".equals(opcion)) {
                anadirProfesorTitular();
            } else if ("2".equals(opcion)) {
                anadirCatedratico();
            } else if ("3".equals(opcion)) {
                anadirMerito();
            } else if ("4".equals(opcion)) {
                mostrarProfesores();
            } else if ("5".equals(opcion)) {
                continuar = grabar();
            } else {
                System.out.println("Opción incorrecta.");
            }
        }
    }

    public void mostrarProfesores() {
        for (Profesor p : profesores) {
            System.out.println(p);
        }
    }
}
