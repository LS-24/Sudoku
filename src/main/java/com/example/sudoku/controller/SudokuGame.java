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
        int cantidadDeInicialesPorCuadro = 5; // Number of numbers to be placed per box

        for (int cuadroFila = 0; cuadroFila < 2; cuadroFila++) {
            for (int cuadroColumna = 0; cuadroColumna < 3; cuadroColumna++) {
                int numerosColocados = 0;

                while (numerosColocados < cantidadDeInicialesPorCuadro) {
                    int fila = cuadroFila * 3 + random.nextInt(3);
                    int columna = cuadroColumna * 2 + random.nextInt(2);
                    int numero = random.nextInt(medida) + 1; // generates number between 1 and 6

                    // If the number is invalid or empty
                    if (cuadricula.get(fila).get(columna) == 0 && puedeUsarNumero(fila, columna, numero)) {
                        cuadricula.get(fila).set(columna, numero);
                        numerosColocados++;
                    }
                }
            }
        }

        // validate grid initial grid
        if (!validarCuadriculaInicial()) {
            new AlertBox().showAlert("Error", "La cuadrícula inicial no es válida. Regenerando...", "");
            iniciarCuadricula();
        }
    }

    /**
     * validarCuadriculaInicial
     * validate if the initial board is good
     * @return boolean
     */
    public boolean validarCuadriculaInicial() {
        for (int fila = 0; fila < medida; fila++) {
            boolean[] verFila = new boolean[medida + 1];
            boolean[] verColumna = new boolean[medida + 1];

            for (int columna = 0; columna < medida; columna++) {
                // Validar fila
                int numFila = cuadricula.get(fila).get(columna);
                if (numFila != 0) {
                    if (verFila[numFila]) {
                        return false; // Duplicado en fila
                    }
                    verFila[numFila] = true;
                }

                // Validar columna
                int numColumna = cuadricula.get(columna).get(fila);
                if (numColumna != 0) {
                    if (verColumna[numColumna]) {
                        return false; // Duplicado en columna
                    }
                    verColumna[numColumna] = true;
                }
            }
        }

        // Validar cuadros de 2x3
        for (int cuadroFila = 0; cuadroFila < 2; cuadroFila++) {
            for (int cuadroColumna = 0; cuadroColumna < 3; cuadroColumna++) {
                boolean[] verCuadro = new boolean[medida + 1];
                for (int f = 0; f < 3; f++) {
                    for (int c = 0; c < 2; c++) {
                        int num = cuadricula.get(cuadroFila * 3 + f).get(cuadroColumna * 2 + c);
                        if (num != 0) {
                            if (verCuadro[num]) {
                                return false; // Duplicado en cuadro
                            }
                            verCuadro[num] = true;
                        }
                    }
                }
            }
        }

        return true; // La cuadrícula es válida
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
                return false; // Verifica filas y columnas
            }
        }

        return !verNumerosEnCuadro(fila, columna, numero); // Verifica en el cuadro
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
        int cuadroFila = fila / 3 * 3;
        int cuadroColumna = columna / 2 * 2;

        for (int f = 0; f < 3; f++) {
            for (int c = 0; c < 2; c++) {
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
