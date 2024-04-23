package com.peliculas;

import com.peliculas.servicio.CatalogoPeliculasImpl;
import com.peliculas.servicio.ICatalogoPeliculas;

import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int opcion;
        String nombreAchivo;
        ICatalogoPeliculas catalogo = new CatalogoPeliculasImpl();
        do {
            System.out.println("**********Menú principal***********");

            System.out.print(
                    "1) Iniciar catálogo\n"+
                    "2) Agregar pelicula\n"+
                    "3) Listar peliculas\n"+
                    "4) Buscar Pelicula\n"+
                    "0) Salir\n"+
                    "Elije una opción: ");
            opcion = Integer.parseInt(scanner.nextLine());
            switch (opcion){
                case 1:
                    catalogo.iniciarCatalogo();
                    break;
                case 2:
                    String nombre = scanner.nextLine();
                    catalogo.agregarPelicula(nombre);
                    break;
                case 3:
                    catalogo.listarPeliculas();
                    break;
                case 4:
                    System.out.print("Ingresa el nombre de la pelicula a buscar: ");
                    String buscar = scanner.nextLine();
                    catalogo.buscarPelicula(buscar);
                    break;
                case 0:
                    System.out.println("Saliendo del sistema");
                    break;
                default:
                    System.out.println("Elija una opción valida.");
                    break;
            }

        }while (opcion != 0);
    }
}