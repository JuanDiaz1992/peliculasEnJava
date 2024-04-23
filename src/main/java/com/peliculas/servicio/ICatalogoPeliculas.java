package com.peliculas.servicio;

public interface ICatalogoPeliculas {
    public static final String NOMBRE_RECURSO = "peliculas.txt";
    public void agregarPelicula(String nombrePelicula);
    public void listarPeliculas();
    public void buscarPelicula(String nombrePelicula);
    public void iniciarCatalogo();
}
