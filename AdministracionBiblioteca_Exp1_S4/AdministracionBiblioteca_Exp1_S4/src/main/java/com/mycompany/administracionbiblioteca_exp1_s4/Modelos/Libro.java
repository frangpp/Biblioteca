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
    private boolean prestado;

    public Libro(String titulo, String autor) {
        this.titulo = titulo;
        this.autor = autor;
        this.prestado = false;
    }

    public String getTitulo() { return titulo; }
    public String getAutor() { return autor; }
    public boolean estaPrestado() { return prestado; }

    public void prestar() { this.prestado = true; }
    public void devolver() { this.prestado = false; }
}


