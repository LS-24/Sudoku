package com.example.sudoku.controller;

import com.example.sudoku.model.AlertBox;
import javafx.scene.input.KeyEvent;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class SudokuGame {

    protected ArrayList<ArrayList<Integer>> cuadricula = new ArrayList<>(6);
    private static final int tamaño = 6;// tamaño de del tablero de juego
    boolean isNumber;

    public SudokuGame() {
        cuadricula = new ArrayList<>();
        iniciarCuadricula();
        iniciarCuadriculaConValores();
    }

    private void iniciarCuadricula() {
        for (int i = 0; i < 6;i++){
            ArrayList<Integer> fila = new ArrayList(Collections.nCopies (tamaño, 0));
            cuadricula.add(fila);
        }
    }

    private void iniciarCuadriculaConValores() {
        Random random = new Random();
        int cantidadDeIniciales = 10; // cantidad de numero con que iniciara el juego

        for (int i = 0; i < cantidadDeIniciales; i++) {
            int fila = random.nextInt(tamaño);
            int columna = random.nextInt(tamaño);
            int numero = random.nextInt(tamaño) + 1; // genera valor entre 1 y 6

            if (sePuedeUsarNumero(fila, columna, numero)){
                cuadricula.get(fila).set(columna, numero);
            } else {
                i--; // busca otro si no se puede usar
            }
        }
    }

    private boolean sePuedeUsarNumero(int fila, int columna, int numero) {
        for (int f = 0; f < tamaño; f++) {
            if (cuadricula.get(fila).get(f) == numero) {
                return false;
            }
        }

        for (int c = 0; c < tamaño; c++) {
            if (cuadricula.get(c).get(columna) == numero) {
                return false;
            }
        }
        return true;
    }

    public ArrayList<ArrayList<Integer>> getCuadricula() {
        return cuadricula;
    }

    private static boolean validarIngresoNumeros(String datos) //Check that the value meets the appropriate parameters
    {
        return datos.matches("[1-6]");
    }

    public void comprobarNumero(String datos) {//If the number is accepted it indicates that it can be used, otherwise it generates an alert window
        if ((validarIngresoNumeros(datos))) {
            isNumber = true;
            System.out.println(datos);
        } else {
            new AlertBox().showAlert(
                    "Error",
                    "Los numeros no son validos",
                    "Ingrese un numero entre 1 y 6!!");
        }
    }

    public void onEntradaTextField(KeyEvent event, int fila, int columna) {
        comprobarNumero(event.getText());
        if (isNumber) {
            int numero = Integer.parseInt(event.getText());
            if (numero >=1 && numero <= 6) {
                cuadricula.get(fila).set(columna, numero); //guarda el numero

                if (!validarCuadricula()){
                    new AlertBox().showAlert(
                            "Error",
                            "Tablero no valido",
                            "Por favor, verificar numeros ingresados"
                    );
                }

            }
        }
    }

    public boolean validarCuadricula() {

        for (int fil = 0; fil < tamaño; fil++) {
            boolean [] ver = new boolean[tamaño + 1];
            for  (int col = 0; col < ver.length; col++) {
                Integer num = cuadricula.get(fil).get(col);
                if (num != 0) {
                    if (ver[num]) {
                        return false;
                    }
                    ver[num] = true;
                }
            }
        }

        for (int col = 0; col < tamaño; col++) { // validar columnas
            boolean[] ver = new boolean[tamaño + 1];
            for (int fil = 0; fil < tamaño; fil++) {
                int num = cuadricula.get(fil).get(col);
                if (num != 0) {
                    if (ver[num]) {
                        return false;
                    }
                    ver[num] = true;
                }
            }
        }

        for (int fil = 0; fil < 2 ; fil++ ) { // verificar cuadros
            for (int col = 0; col <3; col++ ) {
                boolean [] ver = new boolean[tamaño + 1];
                for (int f = 0 ; f < 3; f++ ){
                    for (int c = 0; c < 2; c++ ){
                        int num = cuadricula.get(fil* 3 + f).get(col * 2 + c);
                        if (num != 0) {
                            if (ver[num]) {
                                return false;
                            }
                            ver[num] = true;
                        }
                    }
                }
            }
        }
        return true;

    }


}
