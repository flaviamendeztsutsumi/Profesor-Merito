package dominio;

import java.io.Serializable;
import java.util.ArrayList;

public abstract class Profesor implements Serializable{
    protected ArrayList<Merito>meritos = new ArrayList<>();
    private Object nombre;
    
    
    public Profesor(String nombre ){
        meritos = new ArrayList<>();

    }
  

    public abstract double calcularValoracion();

    public Profesor annadirMerito(Merito m)
    {
        meritos.add(m);
        return this;
    }

    public boolean equals(Object obj)
    {
        Profesor p = (Profesor)obj;
        return this.nombre.equals(p.nombre);

    }

    public String toString()
    {
        return "Nombre" + nombre + "\nMeritos: " + meritos;
    }
     



    
    
}
