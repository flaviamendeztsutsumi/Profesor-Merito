package dominio;

import java.io.Serializable;

public class ProfesorTitular extends Profesor implements Serializable {

    public ProfesorTitular(String nombre) {
        super(nombre);
    }

    
    public double calcularValoracion() {
        double suma = 0;
        for (Merito m : meritos) {
            suma += Math.pow(m.valorar(), 2);
        }

        return Math.pow(suma / 4, 0.5);
    }
}