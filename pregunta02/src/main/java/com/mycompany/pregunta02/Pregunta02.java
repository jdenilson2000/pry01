/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.pregunta02;

import javax.swing.JOptionPane;
import java.util.ArrayDeque;
import java.util.Deque;

public class Pregunta02 {

    public static void main(String[] args) {
        boolean continuar = true;
        while (continuar) {
            String formula = JOptionPane.showInputDialog(null,
                    "VALIDADOR DE OPERADORES DE UNA FORMULA\n"
                    + "Operadores validos: ( )  [ ]  { }\n\n"
                    + "Ingrese la formula:",
                    "Pregunta 02", JOptionPane.QUESTION_MESSAGE);

            if (formula != null) {
                String resultado = validar(formula);
                int tipo = resultado.contains("Okey")
                        ? JOptionPane.INFORMATION_MESSAGE
                        : JOptionPane.ERROR_MESSAGE;
                JOptionPane.showMessageDialog(null,
                        "Formula: " + formula + "\n\nResultado: " + resultado,
                        "Resultado", tipo);
            }

            continuar = JOptionPane.showConfirmDialog(null, "¿Validar otra formula?",
                    "Continuar", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION;
        }
    }

    public static String validar(String formula) {
        if (formula == null || formula.trim().isEmpty()) {
            return "formula CON ERROR (formula vacia)";
        }

        Deque<Character> pila = new ArrayDeque<>();
        int posicion = 0;

        for (char c : formula.toCharArray()) {
            posicion++;

            if (c == '(' || c == '[' || c == '{') {
                pila.push(c);
            } else if (c == ')' || c == ']' || c == '}') {
                if (pila.isEmpty()) {
                    return "formula CON ERROR (operador '" + c + "' cerrado sin abrirse, posicion " + posicion + ")";
                }
                char abre = pila.pop();
                if (!coinciden(abre, c)) {
                    return "formula CON ERROR (se cierra con '" + c + "' pero se abrio '" + abre + "', posicion " + posicion + ")";
                }
            }
        }

        if (!pila.isEmpty()) {
            char sinCerrar = pila.peek();
            return "formula CON ERROR (operador '" + sinCerrar + "' quedo sin cerrar)";
        }

        return "formula Okey";
    }

    private static boolean coinciden(char abre, char cierra) {
        return (abre == '(' && cierra == ')')
                || (abre == '[' && cierra == ']')
                || (abre == '{' && cierra == '}');
    }
}
