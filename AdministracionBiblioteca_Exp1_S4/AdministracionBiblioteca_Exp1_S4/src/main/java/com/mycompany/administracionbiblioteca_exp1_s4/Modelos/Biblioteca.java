/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.administracionbiblioteca_exp1_s4.Modelos;

/**
 *
 * @author crist
 */
import com.mycompany.administracionbiblioteca_exp1_s4.Excepcion.LibroNoEncontradoException;
import com.mycompany.administracionbiblioteca_exp1_s4.Excepcion.LibroYaPrestadoException;
import java.util.ArrayList;
import java.util.HashMap;

public class Biblioteca {
    private ArrayList<Libro> libros;
    private HashMap<String, Usuario> usuarios;

    public Biblioteca() {
        libros = new ArrayList<>();
        usuarios = new HashMap<>();
    }

    public void agregarLibro(Libro libro) {
        libros.add(libro);
    }

    public void agregarUsuario(Usuario usuario) {
        usuarios.put(usuario.getRut(), usuario);
    }

    public Libro buscarLibro(String titulo) throws LibroNoEncontradoException {
        for (Libro libro : libros) {
            if (libro.getTitulo().equalsIgnoreCase(titulo)) {
                return libro;
            }
        }
        throw new LibroNoEncontradoException("El libro '" + titulo + "' no fue encontrado.");
    }

    public void prestarLibro(String titulo) throws LibroNoEncontradoException, LibroYaPrestadoException {
        Libro libro = buscarLibro(titulo);
        if (libro.estaPrestado()) {
            throw new LibroYaPrestadoException("El libro '" + titulo + "' ya está prestado.");
        }
        libro.prestar();
    }

    public ArrayList<Libro> getLibros() {
        return libros;
    }

    public Biblioteca(ArrayList<Libro> libros, HashMap<String, Usuario> usuarios) {
        this.libros = libros;
        this.usuarios = usuarios;
    }

   

    public HashMap<String, Usuario> getUsuarios() {
        return usuarios;
    }

    public void setLibros(ArrayList<Libro> libros) {
        this.libros = libros;
    }

    public void setUsuarios(HashMap<String, Usuario> usuarios) {
        this.usuarios = usuarios;
    }

   
    
}
