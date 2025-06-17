/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.administracionbiblioteca_exp1_s4;

import com.mycompany.administracionbiblioteca_exp1_s4.CSV.ArchivoLibros;
import com.mycompany.administracionbiblioteca_exp1_s4.Excepcion.LibroNoEncontradoException;
import com.mycompany.administracionbiblioteca_exp1_s4.Excepcion.LibroYaPrestadoException;
import com.mycompany.administracionbiblioteca_exp1_s4.Modelos.Libro;

import java.io.IOException;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author frangpp
 */
public class AdministracionBiblioteca_Exp1_S4 {
    public static void main(String[] args) {
        try {
            HashMap<String, Libro> libros = ArchivoLibros.cargarLibros("/Users/franciscagoeppinger/Downloads/Biblioteca-main/AdministracionBiblioteca_Exp1_S4/AdministracionBiblioteca_Exp1_S4/src/main/java/com/mycompany/administracionbiblioteca_exp1_s4/CSV/libros.csv");
            Scanner scanner = new Scanner(System.in);
            int opcion = 0;
    
            do {
                System.out.println("-----------------------");
                System.out.println("--- Menú Biblioteca ---");
                System.out.println("1. Ver todos los libros");
                System.out.println("2. Buscar libro por título");
                System.out.println("3. Buscar libro por autor");
                System.out.println("4. Solicitar préstamo");
                System.out.println("5. Devolver libro");
                System.out.println("6. Salir");
                System.out.println("-----------------------");
                System.out.print("Seleccione una opción: ");
                
                try{
                    opcion = scanner.nextInt();
                    scanner.nextLine(); 

                    switch (opcion) {
                        case 1:
                            System.out.println("--- Lista de libros ---");
                            for (Libro libro : libros.values()) {
                                System.out.println(libro);
                            }
                            break;

                        case 2:
                            System.out.print("Ingrese el título del libro: ");
                            String titulo = scanner.nextLine();
                            try {
                                Libro libro = buscarLibroPorTitulo(libros, titulo);
                                System.out.println(libro);
                            } catch (LibroNoEncontradoException e) {
                                System.out.println(e.getMessage());
                            }
                            break;

                        case 3:
                            System.out.print("Ingrese el autor del libro: ");
                            String autor = scanner.nextLine();
                            buscarLibrosPorAutor(libros, autor);
                            break;

                        case 4:
                            System.out.print("Ingrese el título del libro que desea solicitar: ");
                            String tituloPrestamo = scanner.nextLine();
                            try {
                                solicitarPrestamo(libros, tituloPrestamo);
                                System.out.println("Préstamo realizado con éxito: " + tituloPrestamo);
                            } catch (LibroNoEncontradoException | LibroYaPrestadoException e) {
                                System.out.println(e.getMessage());
                            }
                            break;
                        
                        case 5:
                            System.out.print("Ingrese el título del libro que desea devolver: ");
                            String tituloDevolver = scanner.nextLine();
                            try {
                                devolverLibro(libros, tituloDevolver);
                                System.out.println("Devolución realizada con éxito: " + tituloDevolver);
                            } catch (LibroNoEncontradoException e) {
                                System.out.println(e.getMessage());
                            }
                            break;

                        case 6:
                            System.out.println("Gracias por usar nuestra Biblioteca, Cuida tus libros y vuelve pronto.");
                            break;

                        default:
                            System.out.println("Opción no válida.");
                        }
                    } catch (InputMismatchException e) {
                    System.out.println("Entrada no válida. Por favor, ingrese un número.");
                    scanner.nextLine();
                }
            } while (opcion != 6);

            scanner.close();
            
        } catch (IOException e) {
            System.out.println("Error al cargar los libros: " + e.getMessage());
        }
    }

    // Este metodo permite buscar aunque escribar solo el nombre, o con mayusculas o minusculas
    private static Libro buscarLibroPorTitulo(HashMap<String, Libro> libros, String titulo) throws LibroNoEncontradoException {
        for (Libro libro : libros.values()) {
            if (libro.getTitulo().toLowerCase().contains(titulo.toLowerCase())) { 
                return libro;
            }
        }
        throw new LibroNoEncontradoException("El libro con título que contiene '" + titulo + "' no fue encontrado.");
    }

    private static void buscarLibrosPorAutor(HashMap<String, Libro> libros, String autor) {
        boolean encontrado = false;
        for (Libro libro : libros.values()) {
            if (libro.getAutor().toLowerCase().contains(autor.toLowerCase())) { // Comparar ignorando mayúsculas y permitiendo coincidencias parciales
                System.out.println(libro);
                encontrado = true;
            }
        }
        if (!encontrado) {
            System.out.println("No se encontraron libros de este autor.");
        }
    }

    private static void solicitarPrestamo(HashMap<String, Libro> libros, String titulo) throws LibroNoEncontradoException, LibroYaPrestadoException {
        Libro libro = buscarLibroPorTitulo(libros, titulo);
        if (libro.isTomado()) {
            throw new LibroYaPrestadoException("El libro '" + titulo + "' ya está prestado.");
        }
        libro.tomado();
    }

    private static void devolverLibro(HashMap<String, Libro> libros, String titulo) throws LibroNoEncontradoException {
        Libro libro = buscarLibroPorTitulo(libros, titulo);
        if (!libro.isTomado()) {
            System.out.println("El libro '" + titulo + "' no estaba prestado.");
        } else {
            libro.devolver();
        }
    }
}