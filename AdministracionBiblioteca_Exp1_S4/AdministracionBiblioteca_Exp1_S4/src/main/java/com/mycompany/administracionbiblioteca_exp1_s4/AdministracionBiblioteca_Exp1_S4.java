/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.administracionbiblioteca_exp1_s4;

import com.mycompany.administracionbiblioteca_exp1_s4.CSV.ArchivoLibros;
import com.mycompany.administracionbiblioteca_exp1_s4.Excepcion.LibroNoEncontradoException;
import com.mycompany.administracionbiblioteca_exp1_s4.Excepcion.LibroYaPrestadoException;
import com.mycompany.administracionbiblioteca_exp1_s4.Modelos.Biblioteca;
import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author crist
 */
public class AdministracionBiblioteca_Exp1_S4 {

    public static void main(String[] args) {
         Biblioteca biblioteca = new Biblioteca();
        Scanner sc = new Scanner(System.in);

        // Cargar libros desde archivo (opcional)
        try {
            ArchivoLibros.cargarLibros("libros.csv", biblioteca);
        } catch (IOException e) {
            System.out.println("Error al leer archivo: " + e.getMessage());
        }

        try {
            System.out.print("Ingrese título del libro a prestar: ");
            String titulo = sc.nextLine();
            biblioteca.prestarLibro(titulo);
            System.out.println("Libro prestado exitosamente.");
        } catch (LibroNoEncontradoException | LibroYaPrestadoException e) {
            System.out.println("Error: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Error inesperado: " + e.getMessage());
        }

        // Guardar libros al cerrar (opcional)
        try {
            ArchivoLibros.guardarLibros("libros.csv", biblioteca.getLibros());
        } catch (IOException e) {
            System.out.println("Error al guardar libros: " + e.getMessage());
        }
    }
}
