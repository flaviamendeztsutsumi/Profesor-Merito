package dominio;

import java.io.Serializable;
import java.util.ArrayList;

public abstract class Profesor implements Serializable{
    protected ArrayList<Merito> meritos = new ArrayList<>();
    protected String nombre;

    public Profesor(String nombre) 
    {
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

    public String toString(){
        return "Nombre: " + nombre +"\n Meritos: " + meritos;
        }

    public Object getNombre() {
        return null;
    }

   
}
