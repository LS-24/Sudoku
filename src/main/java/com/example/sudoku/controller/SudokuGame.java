package com.example.sudoku.controller;

/**
 * @autor larry zuñiga
 * SudokuGame
 * Class that represents the logic of the Sudoku game.
 * Manage the game grid, validate moves and
 */

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;


public class SudokuGame {

    protected ArrayList<ArrayList<Integer>> cuadricula = new ArrayList<>(6);
    // game board size
    private static final int medida = 6;


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
            ArrayList<Integer> fila = new ArrayList<>(Collections.nCopies (medida, 0));
            cuadricula.add(fila);
        }
    }

    /**
     * iniciarCuadriculaConValores
     * enter some values to the board
     */
    private void iniciarCuadriculaConValores() {
        Random random = new Random();
        int cantidadDeIniciales = 2; // Total number of numbers to place on the board at random

        for (int numerosColocados = 0; numerosColocados < cantidadDeIniciales; ) {
            int fila = random.nextInt(medida); // Select a random row
            int columna = random.nextInt(medida); // Select a random column
            int numero = random.nextInt(medida) + 1; // Generates a number between 1 and 6

            // Check if the position is empty and if the number can be used
            if (cuadricula.get(fila).get(columna) == 0 && puedeUsarNumero(fila, columna, numero)) {
                cuadricula.get(fila).set(columna, numero);
                numerosColocados++;
            }
        }

        // Validate initial grid could be resolved
        if (!validarCuadriculaInicial()) {
            iniciarCuadricula(); // Restart the grid
        }
    }

    /**
     * validarCuadriculaInicial
     * @return
     */
    public boolean validarCuadriculaInicial() {
        for (int fila = 0; fila < medida; fila++) {
            for (int columna = 0; columna < medida; columna++) {
                // If the cell is empty
                if (cuadricula.get(fila).get(columna) == 0) {
                    // Try numbers from 1 to 6
                    for (int num = 1; num <= medida; num++) {
                        if (puedeUsarNumero(fila, columna, num)) {
                            // Colocar el número
                            cuadricula.get(fila).set(columna, num);

                            // Recursively try to solve the rest
                            if (validarCuadriculaInicial()) {
                                return true;
                            }

                            // Undo the movement
                            cuadricula.get(fila).set(columna, 0);
                        }
                    }
                    return false; // If no number worked, return false
                }
            }
        }
        return true; // If there are no empty cells, the Sudoku is solved
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
     * quadricula for the game
     */
    public ArrayList<ArrayList<Integer>> getCuadricula() {
        return cuadricula;
    }

}
