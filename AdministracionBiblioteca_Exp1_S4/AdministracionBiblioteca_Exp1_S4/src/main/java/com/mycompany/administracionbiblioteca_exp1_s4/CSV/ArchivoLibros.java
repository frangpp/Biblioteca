/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.administracionbiblioteca_exp1_s4.CSV;

/**
 *
 * @author crist
 */
import com.mycompany.administracionbiblioteca_exp1_s4.Modelos.Biblioteca;
import com.mycompany.administracionbiblioteca_exp1_s4.Modelos.Libro;
import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class ArchivoLibros {
    public static void cargarLibros(String rutaArchivo, Biblioteca biblioteca) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(rutaArchivo));
        String linea;
        while ((linea = br.readLine()) != null) {
            String[] partes = linea.split(",");
            if (partes.length == 2) {
                biblioteca.agregarLibro(new Libro(partes[0], partes[1]));
            }
        }
        br.close();
    }

    public ArchivoLibros() {
    }

   
    public static void guardarLibros(String rutaArchivo, ArrayList<Libro> libros) throws IOException {
        FileWriter fw = new FileWriter(rutaArchivo);
        for (Libro libro : libros) {
            fw.write(libro.getTitulo() + "," + libro.getAutor() + "\n");
        }
        fw.close();
    }
}
