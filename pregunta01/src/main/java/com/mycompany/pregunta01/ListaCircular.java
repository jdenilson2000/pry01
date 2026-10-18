package com.mycompany.pregunta01;

import java.time.LocalDate;
import javax.swing.JOptionPane;

public class ListaCircular {

    private Nodo cabeza;

    public ListaCircular() {
        this.cabeza = null;
        // 5 alumnos HARDCODEADOS en el constructor
        agregarInterno(new Alumno(1001, "Ana Torres Quispe", LocalDate.of(2001, 3, 14), 58.40));
        agregarInterno(new Alumno(1002, "Luis Ramirez Soto", LocalDate.of(2000, 7, 22), 72.15));
        agregarInterno(new Alumno(1003, "Maria Lopez Vega", LocalDate.of(2002, 11, 5), 49.80));
        agregarInterno(new Alumno(1004, "Carlos Garcia Ruiz", LocalDate.of(1999, 1, 30), 81.25));
        agregarInterno(new Alumno(1005, "Sofia Mendez Cruz", LocalDate.of(2001, 9, 17), 55.60));
    }

    // METODO DE ENLISTAR (3 pts)
    public void enlistar() {
        JOptionPane.showMessageDialog(null, listar(), "Lista circular de alumnos",
                JOptionPane.INFORMATION_MESSAGE);
    }

    // METODO DE AGREGAR (3 pts)
    public void agregar(Alumno alumno) {
        agregarInterno(alumno);
        JOptionPane.showMessageDialog(null, "Alumno agregado:\n" + alumno,
                "Agregado", JOptionPane.INFORMATION_MESSAGE);
    }

    private void agregarInterno(Alumno alumno) {
        Nodo nuevo = new Nodo(alumno);
        if (cabeza == null) {
            cabeza = nuevo;
            nuevo.setSig(nuevo); // se apunta a si mismo (circular)
            return;
        }
        Nodo ultimo = cabeza;
        while (ultimo.getSig() != cabeza) {
            ultimo = ultimo.getSig();
        }
        ultimo.setSig(nuevo);
        nuevo.setSig(cabeza);
    }

    // METODO DE ELIMINAR AL FINAL (3 pts)
    public void eliminarFinal() {
        if (cabeza == null) {
            JOptionPane.showMessageDialog(null, "La lista esta vacia.",
                    "Aviso", JOptionPane.WARNING_MESSAGE);
            return;
        }
        Alumno eliminado;
        if (cabeza.getSig() == cabeza) { // unico nodo
            eliminado = cabeza.getDato();
            cabeza = null;
        } else {
            Nodo ultimo = cabeza;
            while (ultimo.getSig().getSig() != cabeza) {
                ultimo = ultimo.getSig();
            }
            eliminado = ultimo.getSig().getDato();
            ultimo.setSig(cabeza);
        }
        JOptionPane.showMessageDialog(null, "Eliminado del final:\n" + eliminado,
                "Eliminado", JOptionPane.INFORMATION_MESSAGE);
    }

    public boolean estaVacia() {
        return cabeza == null;
    }

    public int contar() {
        if (cabeza == null) {
            return 0;
        }
        int n = 0;
        Nodo aux = cabeza;
        do {
            n++;
            aux = aux.getSig();
        } while (aux != cabeza);
        return n;
    }

    public String listar() {
        if (cabeza == null) {
            return "La lista circular esta VACIA.";
        }
        StringBuilder sb = new StringBuilder();
        sb.append("+----------+------------------------+------------+------------+\n");
        sb.append("| CODIGO   | NOMBRE                 | FECHA NAC. | PESO       |\n");
        sb.append("+----------+------------------------+------------+------------+\n");
        Nodo aux = cabeza;
        int posicion = 1;
        do {
            sb.append(String.format("%d. %s%n", posicion, aux.getDato()));
            aux = aux.getSig();
            posicion++;
        } while (aux != cabeza);
        sb.append("+----------+------------------------+------------+------------+\n");
        sb.append("Total de alumnos: ").append(contar());
        return sb.toString();
    }
}
