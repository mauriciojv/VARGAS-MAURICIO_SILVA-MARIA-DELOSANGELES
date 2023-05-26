package com.backend.entity;

public class Odontologo {
    private String Nombre;
    private String Apellido;
    public  int Matricula;

    public Odontologo(String nombre, String apellido, int matricula) {
        this.Nombre = nombre;
        this.Apellido = apellido;
        this.Matricula = matricula;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public String getApellido() {
        return Apellido;
    }

    public void setApellido(String apellido) {
        Apellido = apellido;
    }

    public int getMatricula() {
        return Matricula;
    }

    public void setMatricula(int matricula) {
        Matricula = matricula;
    }

    public String toString(){
        return "Nombre: " + Nombre + " - Apellido: " + Apellido + " - Matricula Número : " + Matricula;
    }
}
