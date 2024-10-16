package com.example.sudoku.model;

import javafx.scene.control.Alert;

/**
 * Alertbox
 * parameters for alert window
 */
public class AlertBox implements IAlertBox {
    @Override
    public void showAlert( String title, String header, String content) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(header);
        alert.setContentText(content);
        alert.showAndWait();
    }
}
