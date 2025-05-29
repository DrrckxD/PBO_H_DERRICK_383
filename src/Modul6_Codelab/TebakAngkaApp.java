package Modul6_Codelab;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.*;
import javafx.stage.Stage;

public class TebakAngkaApp extends Application {

    private GameLogic game;
    private TextField inputField;
    private Label feedbackLabel;
    private Label percobaanLabel;
    private Button tombol;
    private Button keluarButton;

    @Override
    public void start(Stage primaryStage) {
        game = new GameLogic();

        showGuideDialog();

        // Judul
        Label judulLabel = new Label("🔮 Tebak Angka 1–100");
        judulLabel.setFont(Font.font("Verdana", FontWeight.BOLD, 20));
        judulLabel.setTextFill(Color.DARKBLUE);

        // Feedback
        feedbackLabel = new Label("Masukkan tebakanmu!");
        feedbackLabel.setFont(Font.font("Arial", FontWeight.SEMI_BOLD, 14));
        feedbackLabel.setTextFill(Color.GRAY);

        // Input
        inputField = new TextField();
        inputField.setPromptText("Masukkan angka di sini");
        inputField.setMaxWidth(180);

        // Tombol Coba/Main Lagi
        tombol = new Button("✅ Coba Tebak!");
        tombol.setStyle("-fx-background-color: #4CAF50; -fx-text-fill: white;");
        tombol.setOnAction(e -> handleTebakan());

        // Tombol Keluar
        keluarButton = new Button("❌ Keluar");
        keluarButton.setStyle("-fx-background-color: #f44336; -fx-text-fill: white;");
        keluarButton.setOnAction(e -> {
            primaryStage.close();
        });

        // Label percobaan
        percobaanLabel = new Label("Jumlah percobaan: 0");

        // Layout
        VBox root = new VBox(10);
        root.setPadding(new Insets(20));
        root.setAlignment(Pos.CENTER);
        root.setStyle("-fx-background-color: #f0f8ff;");

        HBox inputRow = new HBox(10, inputField, tombol);
        inputRow.setAlignment(Pos.CENTER);

        HBox exitRow = new HBox(keluarButton);
        exitRow.setAlignment(Pos.CENTER);
        exitRow.setPadding(new Insets(10, 0, 0, 0));

        root.getChildren().addAll(judulLabel, feedbackLabel, inputRow, percobaanLabel, exitRow);


        Scene scene = new Scene(root, 360, 260);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Tebak Angka Advance");
        primaryStage.setResizable(false);
        primaryStage.show();
    }

    private void handleTebakan() {
        if (game.isSudahBenar()) {
            game.resetGame();
            tombol.setText("✅ Coba Tebak!");
            tombol.setStyle("-fx-background-color: #4CAF50; -fx-text-fill: white;");
            feedbackLabel.setText("Masukkan tebakanmu!");
            feedbackLabel.setTextFill(Color.GRAY);
            percobaanLabel.setText("Jumlah percobaan: 0");
            inputField.setDisable(false);
            inputField.clear();
            return;
        }

        String input = inputField.getText();
        try {
            int tebakan = Integer.parseInt(input);
            String hasil = game.cekTebakan(tebakan);

            switch (hasil) {
                case "Terlalu kecil!":
                    feedbackLabel.setText("⚠️ Terlalu kecil!");
                    feedbackLabel.setTextFill(Color.ORANGE);
                    break;
                case "Terlalu besar!":
                    feedbackLabel.setText("⚠️ Terlalu besar!");
                    feedbackLabel.setTextFill(Color.ORANGE);
                    break;
                case "Tebakan benar!":
                    feedbackLabel.setText("✅ Tebakan benar!");
                    feedbackLabel.setTextFill(Color.GREEN);
                    tombol.setText("🔁 Main Lagi");
                    tombol.setStyle("-fx-background-color: #2196F3; -fx-text-fill: white;");
                    inputField.setDisable(true);
                    break;
            }

            percobaanLabel.setText("Jumlah percobaan: " + game.getJumlahPercobaan());
        } catch (NumberFormatException e) {
            feedbackLabel.setText("❗ Masukkan angka valid!");
            feedbackLabel.setTextFill(Color.RED);
        }
    }

    private void showGuideDialog() {
        Alert guide = new Alert(Alert.AlertType.INFORMATION);
        guide.setTitle("Cara Bermain");
        guide.setHeaderText("Panduan Bermain Tebak Angka 1–100");
        guide.setContentText(
                "🎯 Komputer telah memilih satu angka antara 1 hingga 100.\n\n" +
                        "🧠 Tugasmu adalah menebak angka tersebut.\n\n" +
                        "👉 Masukkan tebakanmu pada kolom yang tersedia, lalu tekan 'Coba Tebak!'.\n\n" +
                        "🔁 Jika tebakanmu benar, kamu bisa tekan 'Main Lagi' untuk bermain ulang.\n\n" +
                        "❌ Gunakan tombol 'Keluar' untuk menutup aplikasi.\n\n" +
                        "Selamat bermain dan semoga berhasil! 🎉"
        );
        guide.showAndWait();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
