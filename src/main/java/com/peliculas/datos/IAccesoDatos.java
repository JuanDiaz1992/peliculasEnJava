package com.peliculas.datos;

import com.peliculas.domain.Pelicula;
import com.peliculas.excepciones.AccesoDatosEx;
import com.peliculas.excepciones.EscrituraDatosEx;
import com.peliculas.excepciones.LecturaDatosEx;

import java.util.List;

public interface IAccesoDatos {
    public boolean existe(String nombreArchivo) throws AccesoDatosEx;
    public List<Pelicula> listar(String nombreArchivo) throws LecturaDatosEx;
    public void escribir(Pelicula pelicula,String nombreArchivo, boolean anexar) throws EscrituraDatosEx;
    public String buscar(String nombreArchivo, String nombrePelicula) throws LecturaDatosEx;
    public void crear(String nombreArchivo) throws AccesoDatosEx;
    public void borrar(String nombreArchivo) throws AccesoDatosEx;
}
