package com.example.sudoku.controller;

/**
 * @autor larry zuñiga
 * SudokuGame
 * Class that represents the logic of the Sudoku game.
 * Manage the game grid, validate moves and
 * suggests numbers for empty cells.
 */

import com.example.sudoku.model.AlertBox;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class SudokuGame {

    protected ArrayList<ArrayList<Integer>> cuadricula = new ArrayList<>(6);
    private static final int medida = 6;// tamaño de del tablero de juego


    /**
     * SudokuGame
     * start the game
     */
    public SudokuGame() {
        cuadricula = new ArrayList<>();
        iniciarCuadricula();
        iniciarCuadriculaConValores();
    }

    /**
     * iniciarCuadricula
     * create a new game board
     */
    private void iniciarCuadricula() {
        for (int i = 0; i < medida;i++){
            ArrayList<Integer> fila = new ArrayList(Collections.nCopies (medida, 0));
            cuadricula.add(fila);
        }
    }

    /**
     * iniciarCuadriculaConValores
     * enter some values to the board
     */
    private void iniciarCuadriculaConValores() {
        Random random = new Random();
        int cantidadDeIniciales = 2; // Número total de números a colocar en el tablero

        for (int numerosColocados = 0; numerosColocados < cantidadDeIniciales; ) {
            int fila = random.nextInt(medida); // Selecciona una fila aleatoria
            int columna = random.nextInt(medida); // Selecciona una columna aleatoria
            int numero = random.nextInt(medida) + 1; // Genera un número entre 1 y 6

            // Verificar si la posición está vacía y si el número puede usarse
            if (cuadricula.get(fila).get(columna) == 0 && puedeUsarNumero(fila, columna, numero)) {
                cuadricula.get(fila).set(columna, numero);
                numerosColocados++;
            }
        }

        // Validar la cuadrícula inicial
        if (!validarCuadriculaInicial()) {
            new AlertBox().showAlert("Error", "La cuadrícula inicial no es válida. Regenerando...", "");
            iniciarCuadricula(); // Vuelve a iniciar la cuadrícula
        }
    }

    public boolean validarCuadriculaInicial() {
        for (int fila = 0; fila < medida; fila++) {
            for (int columna = 0; columna < medida; columna++) {
                // Si encontramos una celda vacía
                if (cuadricula.get(fila).get(columna) == 0) {
                    // Probar con números del 1 al 6
                    for (int num = 1; num <= medida; num++) {
                        if (puedeUsarNumero(fila, columna, num)) {
                            // Colocar el número
                            cuadricula.get(fila).set(columna, num);

                            // Recursivamente intentar resolver el resto
                            if (validarCuadriculaInicial()) {
                                return true;
                            }

                            // Deshacer el movimiento
                            cuadricula.get(fila).set(columna, 0);
                        }
                    }
                    return false; // Si ningún número funcionó, retorna falso
                }
            }
        }
        return true; // Si no hay celdas vacías, el Sudoku está resuelto
    }


    /**
     * setNumero
     * validate the numbers entered
     * @param fila
     * @param columna
     * @param valor
     */
    public void setNumero(int fila, int columna, int valor) {
            // Validar que el valor a establecer sea un número válido entre 0 y 6
            if (valor >= 0 && valor <= 6) {
                // Verificar si se puede usar el número en esa posición
                if (puedeUsarNumero(fila, columna, valor)) {
                    cuadricula.get(fila).set(columna, valor); // Establecer el valor en la cuadrícula
                } else {
                    new AlertBox().showAlert(
                            "Error","El número " + valor, " no se puede usar en la posición (" + fila + ", " + columna + ").");
                }
            } else {
                new AlertBox().showAlert(
                        "Error","Número inválido. Debe estar entre 1 y 6.","Intente nuevamente");
            }

    }

    /**
     * sugerirNumero
     * suggests valid numbers to use
     * @param fila
     * @param columna
     * @return number
     */
    public Integer sugerirNumero(int fila, int columna) {
        if (cuadricula.get(fila).get(columna) == 0) {
            for (int num = 1; num <= medida; num++) {
                if (puedeUsarNumero(fila, columna, num)) {
                    return num;
                }
            }
        }
        return null;
    }

    /**
     * puedeUsarNumero
     * check if the number can be used
     * @param fila
     * @param columna
     * @param numero
     * @return
     */
    public boolean puedeUsarNumero(int fila, int columna, int numero) {
        for (int i = 0; i < medida; i++) {
            if (cuadricula.get(fila).get(i) == numero || cuadricula.get(i).get(columna) == numero) {
                return false;
            }
        }
        return !verNumerosEnCuadro(fila, columna, numero);
    }

    /**
     * verNumerosEnCuadro
     *check numbers per box
     * @param fila
     * @param columna
     * @param numero
     * @return
     */
    private boolean verNumerosEnCuadro(int fila, int columna, int numero) {
        int cuadroFila = fila / 2 * 2;
        int cuadroColumna = columna / 3 * 3;

        for (int f = 0; f < 2; f++) {
            for (int c = 0; c < 3; c++) {
                if (cuadricula.get(cuadroFila + f).get(cuadroColumna + c) == numero) {
                    return true;
                }
            }
        }
        return false;
    }


    /**
     *
     * print the created grid
     * @return
     */
    public ArrayList<ArrayList<Integer>> getCuadricula() {
        return cuadricula;
    }

    /**
     * isJuegoTerminado
     * check if the game is over
     * @return
     */
    public boolean isJuegoTerminado() {
        for (int fila = 0; fila < medida; fila++) {
            for (int columna = 0; columna < medida; columna++) {
                if (cuadricula.get(fila).get(columna) == 0) {
                    return false;
                }
            }
        }

        return validarCuadriculaInicial();
    }


}
