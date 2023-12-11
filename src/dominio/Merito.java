package dominio;

import java.io.Serializable;
import java.util.ArrayList;

public abstract class Merito implements Serializable {
    protected String titulo;
    public ArrayList <Merito> meritos;


    public Merito(String titulo){
        this.titulo = titulo;
        meritos = new ArrayList<>();
    }

    public void  setTitulo(String titulo)
    {
        this.titulo = titulo;
    }
    public String getTitulo(){
        return titulo;

    }

    public abstract Double valorar();

    public String toString()
    {
        return "Merito: " + titulo + "\nvaloración" + valorar();
    }
   
}
