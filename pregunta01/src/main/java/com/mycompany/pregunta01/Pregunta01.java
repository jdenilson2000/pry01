/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.pregunta01;

import java.time.LocalDate;
import javax.swing.JOptionPane;

public class Pregunta01 {

    public static void main(String[] args) {
        ListaCircular lista = new ListaCircular();
        int op = 0;

        do {
            String entrada = JOptionPane.showInputDialog(
                    "LISTA CIRCULAR DE ALUMNOS\n"
                    + "1. Enlistar\n"
                    + "2. Agregar alumno\n"
                    + "3. Eliminar al final\n"
                    + "4. Salir");
            if (entrada == null) {
                break; // cancelar cierra el programa
            }
            try {
                op = Integer.parseInt(entrada.trim());

                switch (op) {
                    case 1:
                        lista.enlistar();
                        break;

                    case 2:
                        String sCodigo = JOptionPane.showInputDialog("Codigo:");
                        if (sCodigo == null) {
                            break;
                        }
                        String nombre = JOptionPane.showInputDialog("Nombre:");
                        if (nombre == null) {
                            break;
                        }
                        String fecha = JOptionPane.showInputDialog("Fecha (AAAA-MM-DD):");
                        if (fecha == null) {
                            break;
                        }
                        String sPeso = JOptionPane.showInputDialog("Peso:");
                        if (sPeso == null) {
                            break;
                        }
                        int codigo = Integer.parseInt(sCodigo.trim());
                        double peso = Double.parseDouble(sPeso.trim());
                        lista.agregar(new Alumno(codigo, nombre.trim(), LocalDate.parse(fecha.trim()), peso));
                        break;

                    case 3:
                        lista.eliminarFinal();
                        break;

                    case 4:
                        JOptionPane.showMessageDialog(null, "Fin del programa");
                        break;

                    default:
                        JOptionPane.showMessageDialog(null, "Opc No valida");
                }
            } catch (NumberFormatException | java.time.format.DateTimeParseException e) {
                JOptionPane.showMessageDialog(null, "Dato invalido o cancelado:\n" + e.getMessage());
                op = 0;
            }
        } while (op != 4);
    }
}
