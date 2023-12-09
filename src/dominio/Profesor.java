package dominio;

import java.util.ArrayList;

public abstract class Profesor {
    protected ArrayList<Merito> meritos = new ArrayList<>();
    protected String nombre;

    public Profesor(String nombre) {
        this.nombre = nombre;
    }

    public abstract double calcularValoracion();

    public Profesor anadirMerito(Merito m) {
        meritos.add(m);
        return this;
    }

    public boolean equals(Object obj) {
        Profesor p = (Profesor)obj;
        return this.nombre.equals(p.nombre);
    }

    public String toString() {
        StringBuilder result = new StringBuilder("Nombre: " + nombre + "\nMeritos:\n");
        for (Merito m : meritos) {
            result.append(m.toString()).append("\n");
        }
        return result.toString();
    }

    public String getNombre() {
        return nombre;
    }
}
