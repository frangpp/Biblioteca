/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.administracionbiblioteca_exp1_s4.Modelos;

/**
 *
 * @author crist
 */
public class Libro {
    
    private String titulo;
    private String autor;
    private int fecha;
    private String genero;
    private boolean tomado;


    public Libro(String titulo, String autor, int anio, String genero) {
        this.titulo = titulo;
        this.autor = autor;
        this.fecha = anio;
        this.genero = genero;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getAutor() {
        return autor;
    }

    public int getFecha() {
        return fecha;
    }

    public String getGenero() {
        return genero;
    }

    public boolean isTomado() {
        return tomado;
    }

    public void tomado() {
        this.tomado = true;
    }

    public void devolver() {
        this.tomado = false;
    }

    @Override
    public String toString() {
        return "Titulo: " + titulo + ", Autor: " + autor + ", Año: " + fecha + ", Género: " + genero +
               ", Tomado: " + (tomado ? "Sí" : "No");
    }

}


