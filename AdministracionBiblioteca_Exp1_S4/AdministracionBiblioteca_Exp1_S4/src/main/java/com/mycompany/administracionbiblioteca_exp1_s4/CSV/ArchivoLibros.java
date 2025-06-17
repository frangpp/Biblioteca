/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.administracionbiblioteca_exp1_s4.CSV;

/**
 *
 * @author crist
 */

import com.mycompany.administracionbiblioteca_exp1_s4.Modelos.Libro;
import java.io.*;
import java.util.HashMap;


public class ArchivoLibros {
    public static HashMap<String, Libro> cargarLibros(String rutaArchivo) throws IOException {
        HashMap<String, Libro> libros = new HashMap<>();
        BufferedReader br = new BufferedReader(new FileReader(rutaArchivo));
        String linea;
        br.readLine(); // Saltar la cabecera
        while ((linea = br.readLine()) != null) {
            String[] partes = linea.split(",");
            if (partes.length == 4) {
                String titulo = partes[0].trim();
                String autor = partes[1].trim();
                int fecha = Integer.parseInt(partes[2].trim());
                String genero = partes[3].trim();
                libros.put(titulo, new Libro(titulo, autor, fecha, genero));
            }
        }
        br.close();
        return libros;
    }
}
