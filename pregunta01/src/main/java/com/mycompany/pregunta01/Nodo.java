package com.mycompany.pregunta01;

public class Nodo {

    private Alumno dato;
    private Nodo sig;

    public Nodo(Alumno dato) {
        this.dato = dato;
        this.sig = null;
    }

    public Alumno getDato() {
        return dato;
    }

    public void setDato(Alumno dato) {
        this.dato = dato;
    }

    public Nodo getSig() {
        return sig;
    }

    public void setSig(Nodo sig) {
        this.sig = sig;
    }
}
