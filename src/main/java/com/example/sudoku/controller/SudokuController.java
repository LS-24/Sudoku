package com.example.sudoku.controller;

import com.example.sudoku.model.AlertBox;
import javafx.fxml.FXML;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.InputMethodEvent;
import javafx.scene.input.KeyEvent;


/**
 * SudokuController
 * run the game
 */

public class SudokuController {
    @FXML
    private Button ayudaButton;

    @FXML
    private TextField c1F1TextField;

    @FXML
    private TextField c1F2TextField;

    @FXML
    private TextField c1F3TextField;

    @FXML
    private TextField c1F4TextField;

    @FXML
    private TextField c1F5TextField;

    @FXML
    private TextField c1F6TextField;

    @FXML
    private TextField c2F1TextField;

    @FXML
    private TextField c2F2TextField;

    @FXML
    private TextField c2F3TextField;

    @FXML
    private TextField c2F4TextField;

    @FXML
    private TextField c2F5TextField;

    @FXML
    private TextField c2F6TextField;

    @FXML
    private TextField c3F1TextField;

    @FXML
    private TextField c3F2TextField;

    @FXML
    private TextField c3F3TextField;

    @FXML
    private TextField c3F4TextField;

    @FXML
    private TextField c3F5TextField;

    @FXML
    private TextField c3F6TextField;

    @FXML
    private TextField c4F1TextField;

    @FXML
    private TextField c4F2TextField;

    @FXML
    private TextField c4F3TextField;

    @FXML
    private TextField c4F4TextField;

    @FXML
    private TextField c4F5TextField;

    @FXML
    private TextField c4F6TextField;

    @FXML
    private TextField c5F1TextField;

    @FXML
    private TextField c5F2TextField;

    @FXML
    private TextField c5F3TextField;

    @FXML
    private TextField c5F4TextField;

    @FXML
    private TextField c5F5TextField;

    @FXML
    private TextField c5F6TextField;

    @FXML
    private TextField c6F1TextField;

    @FXML
    private TextField c6F2TextField;

    @FXML
    private TextField c6F3TextField;

    @FXML
    private TextField c6F4TextField;

    @FXML
    private TextField c6F5TextField;

    @FXML
    private TextField c6F6TextField;

    @FXML
    private Button inicioButton;

    boolean isNumber;

    int[][] cuadricula = {
            {0,0,0,0,0,0},
            {0,0,0,0,0,0},
            {0,0,0,0,0,0},
            {0,0,0,0,0,0},
            {0,0,0,0,0,0},
            {0,0,0,0,0,0},
    };


    @FXML
    void onAyudaButtonClick(ActionEvent event) {

    }

    @FXML
    void onInicioButtonClick(ActionEvent event) {

    }

    @FXML
    void onInputC1F1TextField(KeyEvent event) {
        comprobarNumero(event.getText());
        if (isNumber && Integer.parseInt((event.getText())) <=6 && Integer.parseInt((event.getText())) >=1)//validates that the data entered is between 1 and 6
        {
            cuadricula[0][0] = Integer.parseInt((event.getText()));//saves the accepted value in the corresponding space
            c1F1TextField.setText(String.valueOf(cuadricula[0][0]));//assigns the value to the corresponding space
        }

    }

    @FXML
    void onInputC1F2TextField(KeyEvent event) {
        comprobarNumero(event.getText());
        if (isNumber && Integer.parseInt((event.getText())) <=6 && Integer.parseInt((event.getText())) >=1) {
            cuadricula[1][0] = Integer.parseInt((event.getText()));
            c1F2TextField.setText(String.valueOf(cuadricula[1][0]));
        }

        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 6; j++) {
                System.out.print(cuadricula[i][j]);
            }
            System.out.println();
        }

    }



    @FXML
    void onInputC1F3TextField(KeyEvent event) {
        comprobarNumero(event.getText());
        if (isNumber && Integer.parseInt((event.getText())) <=6 && Integer.parseInt((event.getText())) >=1) {
            cuadricula[2][0] = Integer.parseInt((event.getText()));
            c1F3TextField.setText(String.valueOf(cuadricula[2][0]));
        }

    }

    @FXML
    void onInputC1F4TextField(KeyEvent event) {
        comprobarNumero(event.getText());
        if (isNumber && Integer.parseInt((event.getText())) <=6 && Integer.parseInt((event.getText())) >=1) {
            cuadricula[3][0] = Integer.parseInt((event.getText()));
            c1F4TextField.setText(String.valueOf(cuadricula[3][0]));
        }

    }

    @FXML
    void onInputC1F5TextField(KeyEvent event) {
        comprobarNumero(event.getText());
        if (isNumber && Integer.parseInt((event.getText())) <=6 && Integer.parseInt((event.getText())) >=1) {
            cuadricula[4][0] = Integer.parseInt((event.getText()));
            c1F5TextField.setText(String.valueOf(cuadricula[4][0]));
        }

    }

    @FXML
    void onInputC1F6TextField(KeyEvent event) {
        comprobarNumero(event.getText());
        if (isNumber && Integer.parseInt((event.getText())) <=6 && Integer.parseInt((event.getText())) >=1) {
            cuadricula[5][0] = Integer.parseInt((event.getText()));
            c1F6TextField.setText(String.valueOf(cuadricula[5][0]));
        }

    }

    @FXML
    void onInputC2F1TextField(KeyEvent event) {
        comprobarNumero(event.getText());
        if (isNumber && Integer.parseInt((event.getText())) <=6 && Integer.parseInt((event.getText())) >=1) {
            cuadricula[0][1] = Integer.parseInt((event.getText()));
            c2F1TextField.setText(String.valueOf(cuadricula[0][1]));
        }

    }

    @FXML
    void onInputC2F2TextField(KeyEvent event) {
        comprobarNumero(event.getText());
        if (isNumber && Integer.parseInt((event.getText())) <=6 && Integer.parseInt((event.getText())) >=1) {
            cuadricula[1][1] = Integer.parseInt((event.getText()));
            c1F2TextField.setText(String.valueOf(cuadricula[1][1]));
        }

    }

    @FXML
    void onInputC2F3TextField(KeyEvent event) {
        comprobarNumero(event.getText());
        if (isNumber && Integer.parseInt((event.getText())) <=6 && Integer.parseInt((event.getText())) >=1) {
            cuadricula[2][1] = Integer.parseInt((event.getText()));
            c2F3TextField.setText(String.valueOf(cuadricula[2][1]));
        }

    }

    @FXML
    void onInputC2F4TextField(KeyEvent event) {
        comprobarNumero(event.getText());
        if (isNumber && Integer.parseInt((event.getText())) <=6 && Integer.parseInt((event.getText())) >=1) {
            cuadricula[3][1] = Integer.parseInt((event.getText()));
            c2F4TextField.setText(String.valueOf(cuadricula[3][1]));
        }

    }

    @FXML
    void onInputC2F5TextField(KeyEvent event) {
        comprobarNumero(event.getText());
        if (isNumber && Integer.parseInt((event.getText())) <=6 && Integer.parseInt((event.getText())) >=1) {
            cuadricula[4][1] = Integer.parseInt((event.getText()));
            c2F5TextField.setText(String.valueOf(cuadricula[4][1]));
        }

    }

    @FXML
    void onInputC2F6TextField(KeyEvent event) {
        comprobarNumero(event.getText());
        if (isNumber && Integer.parseInt((event.getText())) <=6 && Integer.parseInt((event.getText())) >=1) {
            cuadricula[5][1] = Integer.parseInt((event.getText()));
            c2F6TextField.setText(String.valueOf(cuadricula[5][1]));
        }

    }

    @FXML
    void onInputC3F1TextField(KeyEvent event) {
        comprobarNumero(event.getText());
        if (isNumber && Integer.parseInt((event.getText())) <=6 && Integer.parseInt((event.getText())) >=1) {
            cuadricula[0][2] = Integer.parseInt((event.getText()));
            c3F1TextField.setText(String.valueOf(cuadricula[0][2]));
        }

    }

    @FXML
    void onInputC3F2TextField(KeyEvent event) {
        comprobarNumero(event.getText());
        if (isNumber && Integer.parseInt((event.getText())) <=6 && Integer.parseInt((event.getText())) >=1) {
            cuadricula[1][2] = Integer.parseInt((event.getText()));
            c3F2TextField.setText(String.valueOf(cuadricula[1][2]));
        }

    }

    @FXML
    void onInputC3F3TextField(KeyEvent event) {
        comprobarNumero(event.getText());
        if (isNumber && Integer.parseInt((event.getText())) <=6 && Integer.parseInt((event.getText())) >=1) {
            cuadricula[2][2] = Integer.parseInt((event.getText()));
            c3F3TextField.setText(String.valueOf(cuadricula[2][2]));
        }

    }

    @FXML
    void onInputC3F4TextField(KeyEvent event) {
        comprobarNumero(event.getText());
        if (isNumber && Integer.parseInt((event.getText())) <=6 && Integer.parseInt((event.getText())) >=1) {
            cuadricula[3][2] = Integer.parseInt((event.getText()));
            c3F4TextField.setText(String.valueOf(cuadricula[3][2]));
        }

    }

    @FXML
    void onInputC3F5TextField(KeyEvent event) {
        comprobarNumero(event.getText());
        if (isNumber && Integer.parseInt((event.getText())) <=6 && Integer.parseInt((event.getText())) >=1) {
            cuadricula[4][2] = Integer.parseInt((event.getText()));
            c3F5TextField.setText(String.valueOf(cuadricula[4][2]));
        }

    }

    @FXML
    void onInputC3F6TextField(KeyEvent event) {
        comprobarNumero(event.getText());
        if (isNumber && Integer.parseInt((event.getText())) <=6 && Integer.parseInt((event.getText())) >=1) {
            cuadricula[5][2] = Integer.parseInt((event.getText()));
            c3F6TextField.setText(String.valueOf(cuadricula[5][2]));
        }

    }

    @FXML
    void onInputC4F1TextField(KeyEvent event) {
        comprobarNumero(event.getText());
        if (isNumber && Integer.parseInt((event.getText())) <=6 && Integer.parseInt((event.getText())) >=1) {
            cuadricula[0][3] = Integer.parseInt((event.getText()));
            c4F1TextField.setText(String.valueOf(cuadricula[0][3]));
        }

    }

    @FXML
    void onInputC4F2TextField(KeyEvent event) {
        comprobarNumero(event.getText());
        if (isNumber && Integer.parseInt((event.getText())) <=6 && Integer.parseInt((event.getText())) >=1) {
            cuadricula[1][3] = Integer.parseInt((event.getText()));
            c4F2TextField.setText(String.valueOf(cuadricula[1][3]));
        }

    }

    @FXML
    void onInputC4F3TextField(KeyEvent event) {
        comprobarNumero(event.getText());
        if (isNumber && Integer.parseInt((event.getText())) <=6 && Integer.parseInt((event.getText())) >=1) {
            cuadricula[2][3] = Integer.parseInt((event.getText()));
            c4F3TextField.setText(String.valueOf(cuadricula[2][3]));
        }

    }

    @FXML
    void onInputC4F4TextField(KeyEvent event) {
        comprobarNumero(event.getText());
        if (isNumber && Integer.parseInt((event.getText())) <=6 && Integer.parseInt((event.getText())) >=1) {
            cuadricula[3][3] = Integer.parseInt((event.getText()));
            c4F4TextField.setText(String.valueOf(cuadricula[3][3]));
        }

    }

    @FXML
    void onInputC4F5TextField(KeyEvent event) {
        comprobarNumero(event.getText());
        if (isNumber && Integer.parseInt((event.getText())) <=6 && Integer.parseInt((event.getText())) >=1) {
            cuadricula[4][3] = Integer.parseInt((event.getText()));
            c4F5TextField.setText(String.valueOf(cuadricula[4][3]));
        }

    }

    @FXML
    void onInputC4F6TextField(KeyEvent event) {
        comprobarNumero(event.getText());
        if (isNumber && Integer.parseInt((event.getText())) <=6 && Integer.parseInt((event.getText())) >=1) {
            cuadricula[5][3] = Integer.parseInt((event.getText()));
            c4F6TextField.setText(String.valueOf(cuadricula[5][3]));
        }

    }

    @FXML
    void onInputC5F1TextField(KeyEvent event) {
        comprobarNumero(event.getText());
        if (isNumber && Integer.parseInt((event.getText())) <=6 && Integer.parseInt((event.getText())) >=1) {
            cuadricula[0][4] = Integer.parseInt((event.getText()));
            c5F1TextField.setText(String.valueOf(cuadricula[0][4]));
        }

    }

    @FXML
    void onInputC5F2TextField(KeyEvent event) {
        comprobarNumero(event.getText());
        if (isNumber && Integer.parseInt((event.getText())) <=6 && Integer.parseInt((event.getText())) >=1) {
            cuadricula[1][4] = Integer.parseInt((event.getText()));
            c5F2TextField.setText(String.valueOf(cuadricula[1][4]));
        }

    }

    @FXML
    void onInputC5F3TextField(KeyEvent event) {
        comprobarNumero(event.getText());
        if (isNumber && Integer.parseInt((event.getText())) <=6 && Integer.parseInt((event.getText())) >=1) {
            cuadricula[2][4] = Integer.parseInt((event.getText()));
            c5F3TextField.setText(String.valueOf(cuadricula[2][4]));
        }

    }

    @FXML
    void onInputC5F4TextField(KeyEvent event) {
        comprobarNumero(event.getText());
        if (isNumber && Integer.parseInt((event.getText())) <=6 && Integer.parseInt((event.getText())) >=1) {
            cuadricula[3][4] = Integer.parseInt((event.getText()));
            c5F4TextField.setText(String.valueOf(cuadricula[3][4]));
        }

    }

    @FXML
    void onInputC5F5TextField(KeyEvent event) {
        comprobarNumero(event.getText());
        if (isNumber && Integer.parseInt((event.getText())) <=6 && Integer.parseInt((event.getText())) >=1) {
            cuadricula[4][4] = Integer.parseInt((event.getText()));
            c5F5TextField.setText(String.valueOf(cuadricula[4][4]));
        }

    }

    @FXML
    void onInputC5F6TextField(KeyEvent event) {
        comprobarNumero(event.getText());
        if (isNumber && Integer.parseInt((event.getText())) <=6 && Integer.parseInt((event.getText())) >=1) {
            cuadricula[5][4] = Integer.parseInt((event.getText()));
            c5F6TextField.setText(String.valueOf(cuadricula[5][4]));
        }

    }

    @FXML
    void onInputC6F1TextField(KeyEvent event) {
        comprobarNumero(event.getText());
        if (isNumber && Integer.parseInt((event.getText())) <=6 && Integer.parseInt((event.getText())) >=1) {
            cuadricula[0][5] = Integer.parseInt((event.getText()));
            c6F1TextField.setText(String.valueOf(cuadricula[0][5]));
        }

    }

    @FXML
    void onInputC6F2TextField(KeyEvent event) {
        comprobarNumero(event.getText());
        if (isNumber && Integer.parseInt((event.getText())) <=6 && Integer.parseInt((event.getText())) >=1) {
            cuadricula[1][5] = Integer.parseInt((event.getText()));
            c6F2TextField.setText(String.valueOf(cuadricula[1][5]));
        }

    }

    @FXML
    void onInputC6F3TextField(KeyEvent event) {
        comprobarNumero(event.getText());
        if (isNumber && Integer.parseInt((event.getText())) <=6 && Integer.parseInt((event.getText())) >=1) {
            cuadricula[2][5] = Integer.parseInt((event.getText()));
            c6F3TextField.setText(String.valueOf(cuadricula[2][5]));
        }

    }

    @FXML
    void onInputC6F4TextField(KeyEvent event) {
        comprobarNumero(event.getText());
        if (isNumber && Integer.parseInt((event.getText())) <=6 && Integer.parseInt((event.getText())) >=1) {
            cuadricula[3][5] = Integer.parseInt((event.getText()));
            c6F4TextField.setText(String.valueOf(cuadricula[3][5]));
        }

    }

    @FXML
    void onInputC6F5TextField(KeyEvent event) {
        comprobarNumero(event.getText());
        if (isNumber && Integer.parseInt((event.getText())) <=6 && Integer.parseInt((event.getText())) >=1) {
            cuadricula[4][5] = Integer.parseInt((event.getText()));
            c6F5TextField.setText(String.valueOf(cuadricula[4][5]));
        }

    }

    @FXML
    void onInputC6F6TextField(KeyEvent event) {
        comprobarNumero(event.getText());
        if (isNumber && Integer.parseInt((event.getText())) <=6 && Integer.parseInt((event.getText())) >=1) {
            cuadricula[5][5] = Integer.parseInt((event.getText()));
            c6F6TextField.setText(String.valueOf(cuadricula[5][5]));
        }

    }

    private static boolean validarIngresoNumeros(String datos) //Check that the value meets the appropriate parameters
    {
        return datos.matches("[A-Z,a-z,7-9,0]");
    }

    public void comprobarNumero(String datos) {//If the number is accepted it indicates that it can be used, otherwise it generates an alert window
        if ((validarIngresoNumeros(datos))) {
            new AlertBox().showAlert(
                    "Error",
                    "Los numeros no son validos",
                    "Ingrese un numero entre 1 y 6!!");
        }
        isNumber= true;
        System.out.println(datos);

    }



}