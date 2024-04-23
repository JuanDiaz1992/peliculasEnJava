package com.peliculas.servicio;

import com.peliculas.datos.AccesoDatosImpl;
import com.peliculas.datos.IAccesoDatos;
import com.peliculas.domain.Pelicula;
import com.peliculas.excepciones.AccesoDatosEx;
import com.peliculas.excepciones.LecturaDatosEx;

import java.util.List;

public class CatalogoPeliculasImpl implements ICatalogoPeliculas {
    private final IAccesoDatos datos;

    public CatalogoPeliculasImpl() {
        this.datos = new AccesoDatosImpl();
    }

    @Override
    public void agregarPelicula(String nombrePelicula) {
        Pelicula pelicula = new Pelicula(nombrePelicula);
        boolean anexar = false;
        try {
            anexar = datos.existe(NOMBRE_RECURSO);
            datos.escribir(pelicula, NOMBRE_RECURSO, anexar);
        } catch (AccesoDatosEx e) {
            System.out.println("Error de acceso a datos");
            e.printStackTrace();
        }
    }

    @Override
    public void listarPeliculas() {
        try {
            List peliculas = this.datos.listar(NOMBRE_RECURSO);
            peliculas.forEach(System.out::println);
        } catch (LecturaDatosEx e) {
            System.out.println("Error de acceso a datos");
            e.printStackTrace();
        }
    }

    @Override
    public void buscarPelicula(String nombrePelicula) {
        String resultado = null;
        try {
            resultado = this.datos.buscar(NOMBRE_RECURSO,nombrePelicula);
            System.out.println(resultado);
        } catch (LecturaDatosEx e) {
            System.out.println("Error de acceso a datos");
            e.printStackTrace();
        }

    }

    @Override
    public void iniciarCatalogo() {
        try {
            if (this.datos.existe(NOMBRE_RECURSO)){
                datos.borrar(NOMBRE_RECURSO);
                datos.crear(NOMBRE_RECURSO);
            }else {
                datos.crear(NOMBRE_RECURSO);
            }
        } catch (AccesoDatosEx e) {
            System.out.println("Error de acceso a datos");
            e.printStackTrace();
        }
    }
}
