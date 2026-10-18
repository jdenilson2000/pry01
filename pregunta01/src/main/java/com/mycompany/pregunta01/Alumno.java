package com.mycompany.pregunta01;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Alumno {

    private static final DateTimeFormatter FORMATO = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    private int codiAlum;
    private String nombAlum;
    private LocalDate fechNaciAlum;
    private double pesoAlum;

    public Alumno(int codiAlum, String nombAlum, LocalDate fechNaciAlum, double pesoAlum) {
        this.codiAlum = codiAlum;
        this.nombAlum = nombAlum;
        this.fechNaciAlum = fechNaciAlum;
        this.pesoAlum = pesoAlum;
    }

    public int getCodiAlum() {
        return codiAlum;
    }

    public void setCodiAlum(int codiAlum) {
        this.codiAlum = codiAlum;
    }

    public String getNombAlum() {
        return nombAlum;
    }

    public void setNombAlum(String nombAlum) {
        this.nombAlum = nombAlum;
    }

    public LocalDate getFechNaciAlum() {
        return fechNaciAlum;
    }

    public void setFechNaciAlum(LocalDate fechNaciAlum) {
        this.fechNaciAlum = fechNaciAlum;
    }

    public double getPesoAlum() {
        return pesoAlum;
    }

    public void setPesoAlum(double pesoAlum) {
        this.pesoAlum = pesoAlum;
    }

    @Override
    public String toString() {
        return String.format("| %-8d | %-22s | %-10s | %6.2f kg |",
                codiAlum, nombAlum, fechNaciAlum.format(FORMATO), pesoAlum);
    }
}
