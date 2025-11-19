package com.projektestsiak.controllers.admin;

import com.projektestsiak.models.SessionManager;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;

public class AdminDashboardController {

    @FXML
    private Label welcomeLabel;

    @FXML
    public void initialize() {
        welcomeLabel.setText("Selamat Datang, " + SessionManager.getCurrentNama() + "! (Admin)");
    }

    @FXML
    private void handleLogout() {
        SessionManager.logout();
        loadScene("/fxml/auth/login.fxml");
    }

    @FXML
    private void handleManageUsers() {
        showAlert("Info", "Fitur Manajemen User akan segera hadir!");
    }

    @FXML
    private void handleManageCourses() {
        showAlert("Info", "Fitur Manajemen Mata Kuliah akan segera hadir!");
    }

    @FXML
    private void handleApprovals() {
        showAlert("Info", "Fitur Persetujuan Pendaftaran akan segera hadir!");
    }

    private void loadScene(String fxmlPath) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource(fxmlPath));
            Parent root = loader.load();
            Stage stage = (Stage) welcomeLabel.getScene().getWindow();
            stage.setScene(new Scene(root, 1000, 700));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void showAlert(String title, String message) {
        javafx.scene.control.Alert alert = new javafx.scene.control.Alert(javafx.scene.control.Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}