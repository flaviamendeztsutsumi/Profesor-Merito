package aplicacion;

import presentacion.Interfaz;

public class Principal {
    public static void main(String[] args) {
        // Crear una instancia de la clase Interfaz
        Interfaz interfaz = new Interfaz();

        // Llamar a los métodos de la instancia de Interfaz
        interfaz.annadirProfesorTitular();
        interfaz.annadirCatedratico();
        interfaz.annadirMeritoTitular();
    }
}
