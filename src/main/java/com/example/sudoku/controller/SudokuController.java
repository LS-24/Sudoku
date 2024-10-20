package com.example.sudoku.controller;

/**
 * @autor larry zuñiga
 * SudokuController
 * Class that represents the visual part of the game
 *  * Manage events
 */

import com.example.sudoku.model.AlertBox;
import javafx.fxml.FXML;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;

import java.util.ArrayList;
import java.util.Random;


/**
 * SudokuController
 *visual parameters of the game
 */
public class SudokuController {

    protected SudokuGame sudokuGame;

    @FXML
    private VBox tableroVbox;

    @FXML
    private TextArea numeroSugeridoTextArea;

    @FXML
    private Button ayudaButton;

    @FXML
    private Button inicioButton;

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


    private ArrayList<ArrayList<Boolean>> mostrarVacio = new ArrayList<>();


    /**
     * onInformacionLabelClicked
     * @param event
     * generates a window with the game instructions
     */
    @FXML
    void onInformacionLabelClicked(MouseEvent event) {
        new AlertBox().showAlert(
                "Instruciones de juego",
                "El objetivo del juego es completar una cuadrícula de  6x6,\n" +
                        "con números del 1 al 6, de manera que cada fila,\n" +
                        "columna y bloque de 2x3 contenga todos los números sin repetir. ",
                "Si se ingresa un numero incorrecto la celda se resaltara en ROJO,\n" +
                        "Al precionar el boton de ayuda se resaltara con VERDE la celda,\n" +
                        "y se indicara en texto su posicion ,\n" +
                        "Preciona INICIO para comenzar a jugar, mucha suerte, diviertete!!"
        );

    }


    /**
     *controls help button events
     * @param event
     * suggests a number and highlights the box to use
     */
    @FXML
    void onAyudaButtonClick(ActionEvent event) {
        // Create a copy of mostrarVacio
        ArrayList<ArrayList<Boolean>> vacios = new ArrayList<>();
        for (ArrayList<Boolean> fila : mostrarVacio) {
            vacios.add(new ArrayList<>(fila));
        }

        // Find an empty cell
        for (int fila = 0; fila < 6; fila++) {
            for (int columna = 0; columna < 6; columna++) {
                if (vacios.get(fila).get(columna)) { // Check if the cell is empty
                    Integer sugerido = sudokuGame.getCuadricula().get(fila).get(columna);
                    if (sugerido != null) {
                        TextField textFieldCorrespondiente = obtenerTextField(fila, columna);
                        //highlight the suggested cell
                        textFieldCorrespondiente.setStyle("-fx-border-color: green; -fx-border-width: 4px;");
                        numeroSugeridoTextArea.setText("Puede usar el "+sugerido + " en la celda (" + (fila + 1) + ", " + (columna + 1) + ").");
                    }
                    return; // Leave after making a suggestion
                }
            }
        }
        new AlertBox().showAlert("Sin celdas vacías", "No hay celdas vacías para sugerir.", "");
    }


    /**
     *controls game start button events
     * @param event
     * start the game
     */
    @FXML
    void onInicioButtonClick(ActionEvent event) {
        new AlertBox().showAlert(
                "",
                "Precione Aceptar para iniciar un nuevo juego",
                ""
        );
        sudokuGame = new SudokuGame();
        ayudaButton.setDisable(false);
        tableroVbox.setDisable(false);
        numeroSugeridoTextArea.setText("");

        calcularMostrarVacio();

        actualizarInterfaz(sudokuGame.getCuadricula());

    }

    /**
     * calcularMostrarVacio
     * add initial values to mostrarVacio
     */
    private void calcularMostrarVacio() {
        mostrarVacio.clear(); //empty before initializing

        for (int i = 0; i < 6; i++) {
            ArrayList<Boolean> fila = new ArrayList<>();
            for (int j = 0; j < 6; j++) {
                fila.add(false); // Initialize all cells as non-empty
            }
            mostrarVacio.add(fila);
        }

        // Initialize the number of empty cells in each 2x3 house
        for (int filaInicio = 0; filaInicio < 6; filaInicio += 2) {
            for (int columnaInicio = 0; columnaInicio < 6; columnaInicio += 3) {
                marcarCeldasVacias(filaInicio, columnaInicio);
            }
        }
    }

    /**
     * marcarCeldasVacias
     * @param filaInicio
     * @param columnaInicio
     * calculates which TextFields start empty and adds them to showEmpty
     */
    private void marcarCeldasVacias(int filaInicio, int columnaInicio) {
        ArrayList<Integer> posiciones = new ArrayList<>();
        for (int i = 0; i < 6; i++) {
            posiciones.add(i);
        }

        // Select number of random positions
        for (int count = 0; count < 4; count++) {
            Random random = new Random();
            int index = random.nextInt(posiciones.size());
            int pos = posiciones.get(index);
            posiciones.remove(index); // Prevents the same position from being selected multiple times

            int fila = filaInicio + (pos / 3);
            int columna = columnaInicio + (pos % 3);

            mostrarVacio.get(fila).set(columna, true); // mark as empty
        }
    }


    /**
     *update the visual interface
     * @param cuadricula
     * Update game view
     */
    public void actualizarInterfaz(ArrayList<ArrayList<Integer>> cuadricula) {
        for (int fila = 0; fila < 6; fila++) {
            for (int columna = 0; columna < 6; columna++) {
                TextField textField = obtenerTextField(fila, columna);
                int valor = cuadricula.get(fila).get(columna);

                boolean mostrar = mostrarVacio.get(fila).get(columna);
                textField.setText(mostrar ? "" : (valor == 0 ? "" : String.valueOf(valor)));
                textField.setStyle(mostrar ? "" : (valor == 0 ? "-fx-opacity: 0;" : ""));
            }
        }
    }

    /**
     * obtenerTextField
     * @param fila
     * @param columna
     * @return
     * name of the TextArea it refers to
     */
    private TextField obtenerTextField(int fila, int columna) {
        switch (fila) {
            case 0 -> {
                return switch (columna) {
                    case 0 -> c1F1TextField;
                    case 1 -> c1F2TextField;
                    case 2 -> c1F3TextField;
                    case 3 -> c1F4TextField;
                    case 4 -> c1F5TextField;
                    case 5 -> c1F6TextField;
                    default -> null;
                };
            }
            case 1 -> {
                return switch (columna) {
                    case 0 -> c2F1TextField;
                    case 1 -> c2F2TextField;
                    case 2 -> c2F3TextField;
                    case 3 -> c2F4TextField;
                    case 4 -> c2F5TextField;
                    case 5 -> c2F6TextField;
                    default -> null;
                };
            }
            case 2 -> {
                return switch (columna) {
                    case 0 -> c3F1TextField;
                    case 1 -> c3F2TextField;
                    case 2 -> c3F3TextField;
                    case 3 -> c3F4TextField;
                    case 4 -> c3F5TextField;
                    case 5 -> c3F6TextField;
                    default -> null;
                };
            }
            case 3 -> {
                return switch (columna) {
                    case 0 -> c4F1TextField;
                    case 1 -> c4F2TextField;
                    case 2 -> c4F3TextField;
                    case 3 -> c4F4TextField;
                    case 4 -> c4F5TextField;
                    case 5 -> c4F6TextField;
                    default -> null;
                };
            }
            case 4 -> {
                return switch (columna) {
                    case 0 -> c5F1TextField;
                    case 1 -> c5F2TextField;
                    case 2 -> c5F3TextField;
                    case 3 -> c5F4TextField;
                    case 4 -> c5F5TextField;
                    case 5 -> c5F6TextField;
                    default -> null;
                };
            }
            case 5 -> {
                return switch (columna) {
                    case 0 -> c6F1TextField;
                    case 1 -> c6F2TextField;
                    case 2 -> c6F3TextField;
                    case 3 -> c6F4TextField;
                    case 4 -> c6F5TextField;
                    case 5 -> c6F6TextField;
                    default -> null;
                };
            }
            default -> {
                return null;
            }
        }
    }


    /**
     * onEntradasTextFields
     * @param event
     * controls the events generated in the Textfields
     */
    @FXML
    void onEntradasTextFields(KeyEvent event) {
        TextField source = (TextField) event.getSource();
        String input = event.getText();
        int fila = -1, columna = -1;

        // Determines the row and column based on the TextField that was activated
        if (source == c1F1TextField) { fila = 0; columna = 0; }
        else if (source == c1F2TextField) { fila = 0; columna = 1; }
        else if (source == c1F3TextField) { fila = 0; columna = 2; }
        else if (source == c1F4TextField) { fila = 0; columna = 3; }
        else if (source == c1F5TextField) { fila = 0; columna = 4; }
        else if (source == c1F6TextField) { fila = 0; columna = 5; }
        else if (source == c2F1TextField) { fila = 1; columna = 0; }
        else if (source == c2F2TextField) { fila = 1; columna = 1; }
        else if (source == c2F3TextField) { fila = 1; columna = 2; }
        else if (source == c2F4TextField) { fila = 1; columna = 3; }
        else if (source == c2F5TextField) { fila = 1; columna = 4; }
        else if (source == c2F6TextField) { fila = 1; columna = 5; }
        else if (source == c3F1TextField) { fila = 2; columna = 0; }
        else if (source == c3F2TextField) { fila = 2; columna = 1; }
        else if (source == c3F3TextField) { fila = 2; columna = 2; }
        else if (source == c3F4TextField) { fila = 2; columna = 3; }
        else if (source == c3F5TextField) { fila = 2; columna = 4; }
        else if (source == c3F6TextField) { fila = 2; columna = 5; }
        else if (source == c4F1TextField) { fila = 3; columna = 0; }
        else if (source == c4F2TextField) { fila = 3; columna = 1; }
        else if (source == c4F3TextField) { fila = 3; columna = 2; }
        else if (source == c4F4TextField) { fila = 3; columna = 3; }
        else if (source == c4F5TextField) { fila = 3; columna = 4; }
        else if (source == c4F6TextField) { fila = 3; columna = 5; }
        else if (source == c5F1TextField) { fila = 4; columna = 0; }
        else if (source == c5F2TextField) { fila = 4; columna = 1; }
        else if (source == c5F3TextField) { fila = 4; columna = 2; }
        else if (source == c5F4TextField) { fila = 4; columna = 3; }
        else if (source == c5F5TextField) { fila = 4; columna = 4; }
        else if (source == c5F6TextField) { fila = 4; columna = 5; }
        else if (source == c6F1TextField) { fila = 5; columna = 0; }
        else if (source == c6F2TextField) { fila = 5; columna = 1; }
        else if (source == c6F3TextField) { fila = 5; columna = 2; }
        else if (source == c6F4TextField) { fila = 5; columna = 3; }
        else if (source == c6F5TextField) { fila = 5; columna = 4; }
        else if (source == c6F6TextField) { fila = 5; columna = 5; }



        // Validates the text entered by the user
        if (input.matches("[1-6]?")) {
            int value = input.isEmpty() ? 0 : Integer.parseInt(input);

            // Get correct value from grid
            int valorCorrecto = sudokuGame.getCuadricula().get(fila).get(columna);

            //Update the interface
            actualizarInterfaz(sudokuGame.getCuadricula());

            //// If the value is correct, mark the cell as not empty
            if (value == valorCorrecto) {
                mostrarVacio.get(fila).set(columna, false);
            }

            // If the value entered is not correct, set the TextField to red
            // Reset the style if correct
            if (value != valorCorrecto) {
                source.setStyle("-fx-border-color: red; -fx-border-width: 4px;");
                source.setText(input);
            } else {
                source.setStyle("");
                source.setText(String.valueOf(valorCorrecto));
            }

            // Check if the game is over and disable everything
            if (verificarJuegoTerminado()) {
                new AlertBox().showAlert("¡Felicidades!", "¡Has completado el Sudoku correctamente!", "¡Buen trabajo!");
                ayudaButton.setDisable(true);
                numeroSugeridoTextArea.setDisable(true);
                tableroVbox.setDisable(true);

            }
        } else {
            new AlertBox().showAlert(
                    "Error","Número inválido. Debe estar entre 1 y 6.","Intente nuevamente");
            source.setText("");
            source.setStyle("");
        }

    }

    /**
     * verificarJuegoTerminado
     * @return
     * Message that the game is completed
     */
    private boolean verificarJuegoTerminado() {
        // Check if all TextFields are full
        for (int fila = 0; fila < 6; fila++) {
            for (int columna = 0; columna < 6; columna++) {
                TextField textField = obtenerTextField(fila, columna);
                String texto = null;
                if (textField != null) {
                    texto = textField.getText();
                }
                if (texto.isEmpty() || !texto.matches("[1-6]")) {
                    // There is at least one empty or invalid field
                    return false;
                }
            }
        }
        // All are complete
        return true;
    }

}
