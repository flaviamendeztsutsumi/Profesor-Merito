package dominio;

import java.util.ArrayList;

public abstract class Profesor {
    protected ArrayList<Merito>meritos = new ArrayList<>();
    
    
    public Profesor(String nombre ){
        meritos = new ArrayList<>();

    }

    public abstract double calcularValoracion();

    public Profesor annadirMerito(Merito m)
    {
        meritos.add(m);
        return this;
    }
     



    
    
}
