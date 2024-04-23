package com.peliculas.datos;

import com.peliculas.domain.Pelicula;
import com.peliculas.excepciones.*;
import java.io.*;
import java.util.*;

public class AccesoDatosImpl implements IAccesoDatos {

    @Override
    public boolean existe(String nombreArchivo){
        File archivo = new File(nombreArchivo);
        return archivo.exists();
    }

    @Override
    public List<Pelicula> listar(String nombreArchivo) throws LecturaDatosEx {
        File archivo = new File(nombreArchivo);
        List<Pelicula> peliculas = new ArrayList<>();
        try {
            BufferedReader entrada = new BufferedReader(new FileReader(archivo));
            String linea = null;
            linea = entrada.readLine();
            while (linea!=null){
                Pelicula pelicula = new Pelicula(linea);
                peliculas.add(pelicula);
                linea = entrada.readLine();
            }
            entrada.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            throw new LecturaDatosEx("Execption al listar peliculas"+e.getMessage());
        } catch (IOException e) {
            e.printStackTrace();
            throw new LecturaDatosEx("Execption al listar peliculas"+e.getMessage());
        }
        return peliculas;
    }

    @Override
    public void escribir(Pelicula pelicula, String nombreArchivo, boolean anexar) throws EscrituraDatosEx {
        File archivo = new File(nombreArchivo);
        try {
            PrintWriter salida = new PrintWriter(new FileWriter(archivo,anexar));
            salida.println(pelicula.getNombre());
            salida.close();
            System.out.println("Se guardo la pelicula: "+pelicula.getNombre());
        } catch (IOException e) {
            e.printStackTrace();
            throw new EscrituraDatosEx("Execption al guardar el dato"+e.getMessage());
        }
    }

    @Override
    public String buscar(String nombreArchivo, String nombrePelicula) throws LecturaDatosEx {
        File archivo = new File(nombreArchivo);
        String resultado = null;
        try {
            BufferedReader entrada = new BufferedReader(new FileReader(archivo));
            String linea = null;
            linea = entrada.readLine();
            while (linea!=null){
                if (nombreArchivo != null && nombrePelicula.equalsIgnoreCase(linea)){
                    resultado = linea;
                    break;
                }
                linea = entrada.readLine();
            }
            entrada.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            throw new LecturaDatosEx("Execption al buscar"+e.getMessage());
        } catch (IOException e) {
            e.printStackTrace();
            throw new LecturaDatosEx("Execption al buscar"+e.getMessage());
        }
        return resultado;
    }

    @Override
    public void crear(String nombreArchivo) throws AccesoDatosEx {
        File archivo = new File(nombreArchivo);
        try {
            PrintWriter salida = new PrintWriter(new FileWriter(archivo));
            salida.close();
            System.out.println("Se ah creado el archivo.");
        } catch (IOException e) {
            e.printStackTrace();
            throw new AccesoDatosEx("Execption al crear el archivo"+e.getMessage());
        }

    }

    @Override
    public void borrar(String nombreArchivo){
        File archivo = new File(nombreArchivo);
        if (archivo.exists()){
            archivo.delete();
            System.out.println("Se a borrado el archivo.");
        }

    }
}
