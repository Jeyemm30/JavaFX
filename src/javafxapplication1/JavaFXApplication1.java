
package JavaFXApplication1;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class JavaFXApplication1 extends Application {

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Feedback Form");

        // Labels
        Label nameLabel = new Label("Name:");
        Label emailLabel = new Label("Email:");
        Label feedbackLabel = new Label("Feedback:");
        Label ratingLabel = new Label("Rating:");

        // TextFields and TextArea
        TextField nameField = new TextField();
        TextField emailField = new TextField();
        TextArea feedbackArea = new TextArea();
        feedbackArea.setWrapText(true);

        // ComboBox for rating
        ComboBox<String> ratingBox = new ComboBox<>();
        ratingBox.getItems().addAll("Excellent", "Good", "Fair", "Poor");

        // Buttons
        Button submitButton = new Button("Submit");
        Button clearButton = new Button("Clear");

        // Layout using GridPane
        GridPane grid = new GridPane();
        grid.setPadding(new Insets(20));
        grid.setVgap(10);
        grid.setHgap(10);

        // Add components to the grid
        grid.add(nameLabel, 0, 0);
        grid.add(nameField, 1, 0);
        grid.add(emailLabel, 0, 1);
        grid.add(emailField, 1, 1);
        grid.add(feedbackLabel, 0, 2);
        grid.add(feedbackArea, 1, 2);
        grid.add(ratingLabel, 0, 3);
        grid.add(ratingBox, 1, 3);
        grid.add(submitButton, 0, 4);
        grid.add(clearButton, 1, 4);

        // Submit button event handling
        submitButton.setOnAction(e -> {
            String name = nameField.getText().trim();
            String email = emailField.getText().trim();
            String feedback = feedbackArea.getText().trim();
            String rating = ratingBox.getValue();

            // Basic validation
            if (name.isEmpty() || email.isEmpty() || feedback.isEmpty() || rating == null) {
                showAlert(Alert.AlertType.ERROR, "Form Error", "Please fill in all fields.");
                return;
            }

            if (!email.matches("^[\\w.-]+@[\\w.-]+\\.[a-zA-Z]{2,}$")) {
                showAlert(Alert.AlertType.ERROR, "Invalid Email", "Please enter a valid email address.");
                return;
            }

            // Output to console
            System.out.println("Name: " + name);
            System.out.println("Email: " + email);
            System.out.println("Feedback: " + feedback);
            System.out.println("Rating: " + rating);
        });

        // Clear button using lambda expression
        clearButton.setOnAction(e -> {
            nameField.clear();
            emailField.clear();
            feedbackArea.clear();
            ratingBox.setValue(null);
        });

        // Set up scene and show stage
        Scene scene = new Scene(grid, 600, 350);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    // Helper method to show alerts
    private void showAlert(Alert.AlertType alertType, String title, String message) {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }

    // Main method to launch the application
    public static void main(String[] args) {
        launch(args);
    }
}
