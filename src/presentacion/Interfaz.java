package presentacion;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Scanner;

import dominio.Articulo;
import dominio.Catedratico;
import dominio.Profesor;
import dominio.ProfesorTitular;
import dominio.Proyecto;

public class Interfaz implements Serializable{
    
    private ArrayList<Profesor> profesores;
    private Scanner sc = new Scanner(System.in);


    public Interfaz()
    {
       leer();
       grabar();

    }


    private void leer(){
        ObjectInputStream obj;
        File file = new File("merito.txt");
            try{
                obj = new ObjectInputStream(new FileInputStream(file));
                try{
                    profesores = (ArrayList<Profesor>)obj.readObject();
                    obj.close();
               
            } catch(Exception e){
                System.out.println("no leido");
                profesores = new ArrayList<>();
            }
        }catch(Exception e){
              profesores = new ArrayList<>();
        }
     
    }

    private void grabar() {
        ObjectOutputStream obj;
        File file = new File("meritos.txt");
            try{
                obj= new ObjectOutputStream(new FileOutputStream(file));
                obj.writeObject(profesores);
                    obj.close();
                System.out.println("Guardado.");
            }
            catch(Exception e){
                System.out.println("Error al guardar");
                System.out.println(e);
            }
 
    }

    public void annadirProfesorTitular()
    {
        System.out.println("Introduzca el nombre del profesor: ");
        String nombre = sc.nextLine();
        profesores.add(new ProfesorTitular(nombre));
    }

    public void annadirCatedratico()
    {
        System.out.println("Introduzca el nombre del Catedratico: ");
        String nombre = sc.nextLine();
        profesores.add(new Catedratico(nombre));
    }

    public void annadirMeritoTitular()
    {
        System.out.println("Introduce el nombre del profesor");
        String nombre = sc.nextLine();
        int n = profesores.indexOf(new ProfesorTitular(nombre));
        if (n == -1)
        {
            System.out.println("Profesor no existe");
        }

        else{

        
            System.out.println("Titulo del Merito: ");
            String titulo = sc.nextLine();
            System.out.println("Escoja el tipo de mérito: ");
            System.out.println("1. Articulo");
            System.out.println("2. Proyecto");
            int opcion = sc.nextInt();
            sc.nextLine();
            if(opcion == 1)
            {
                System.out.println("Introduzca el impacto del articulo");
                double impacto = sc.nextDouble();
                sc.nextLine();
                profesores.get(n).annadirMerito(new Articulo(titulo, impacto));

            }
            else if (opcion == 2)
            {
                System.out.println("Introduzca la financiación");
                double financion = sc.nextDouble();
                sc.nextLine();
                profesores.get(n).annadirMerito(new Proyecto(titulo, financion));



            }
            else
            {
                System.out.println("Error opción incorrecta");
            }
        }

    }

    

    


 
}


