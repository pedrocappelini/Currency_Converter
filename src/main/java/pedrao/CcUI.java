package pedrao;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class CcUI {

    private Label welcomeLabel;
    private Label exampleLabel;
    private Label amountLabel;
    private Label resultLabel;
    private VBox layout;
    private GridPane grid;
    private Button convertButton;
    private Button clearButton;
    private Button closeAppButton;
    private final Stage primaryStage;
    private final Validators validators;
    private final Converter converter;
    private final TextField currencyDisplay = new TextField();
    private final TextField amountDisplay = new TextField();
    private final TextField resultDisplay = new TextField();

    public CcUI(Stage primaryStage, Validators validators, Converter converter) {
        this.primaryStage = primaryStage;
        this.validators = validators;
        this.converter = converter;
    }

    public void buildUI() {
        primaryStage.initStyle(StageStyle.TRANSPARENT);
        primaryStage.setTitle("Currency Converter");

        welcomeLabel = new Label("Welcome to the Currency Converter");
        welcomeLabel.setStyle("-fx-font-size: 22; -fx-font-weight: bold;");
        exampleLabel = new Label("Currency: ");
        exampleLabel.setStyle("-fx-font-size: 18; -fx-font-weight: bold;");
        amountLabel = new Label("Amount:");
        amountLabel.setStyle("-fx-font-size: 18; -fx-font-weight: bold;");
        resultLabel = new Label("Result:");
        resultLabel.setStyle("-fx-font-size: 18; -fx-font-weight: bold;");

        currencyDisplay.setPromptText("e.g., USD to EUR");
        amountDisplay.setPromptText("Amount");
        resultDisplay.setPromptText("The result will appear here");
        currencyDisplay.setPrefHeight(40);
        amountDisplay.setPrefHeight(40);
        resultDisplay.setPrefHeight(40);
        resultDisplay.setEditable(false);
        currencyDisplay.setStyle("-fx-font-size: 18; -fx-font-weight: bold; -fx-background-color: #f4f4f8");
        amountDisplay.setStyle("-fx-font-size: 18; -fx-font-weight: bold; -fx-background-color: #f4f4f8");
        resultDisplay.setStyle("-fx-font-size: 18; -fx-font-weight: bold; -fx-background-color: #f4f4f8");

        Button changeThemeButton = new Button("\uD83D\uDD2E");
        closeAppButton = new Button("❌");
        convertButton = new Button("Convert");
        clearButton = new Button("Clear");
        convertButton.setOnAction(e -> convertCurrency());
        clearButton.setOnAction(e -> clearUI());
        changeThemeButton.setOnAction(e -> toggleTheme());
        closeAppButton.setOnAction(e -> primaryStage.close());
        convertButton.setStyle("-fx-font-size: 18; -fx-font-weight: bold; -fx-background-color: #50e3c2; -fx-text-fill: white;");
        clearButton.setStyle("-fx-font-size: 18; -fx-font-weight: bold; -fx-background-color: #e94e77; -fx-text-fill: white;");
        changeThemeButton.setStyle("-fx-font-size: 12; -fx-font-weight: bold; -fx-background-color: #4a90e2; -fx-text-fill: white;");
        changeThemeButton.setStyle("-fx-background-color: white");
        closeAppButton.setStyle("-fx-font-weight: bold; -fx-background-color: #e94e77; -fx-text-fill: white;");

        grid = new GridPane();
        grid.setPadding(new Insets(10));
        grid.setVgap(5);
        grid.setHgap(8);
        grid.setAlignment(javafx.geometry.Pos.CENTER);
        grid.setStyle("-fx-background-color: #ffffff;");

        // Use HBox to align the buttons horizontally in the top bar
        HBox topBar = new HBox(10);
        topBar.setAlignment(javafx.geometry.Pos.TOP_LEFT); // Align buttons horizontally
        topBar.getChildren().addAll(changeThemeButton, closeAppButton);

        grid.add(welcomeLabel, 0, 0);
        grid.add(exampleLabel, 0, 1);
        grid.add(currencyDisplay, 0, 2);
        grid.add(amountLabel, 0, 3);
        grid.add(amountDisplay, 0, 4);
        grid.add(resultLabel, 0, 6);
        grid.add(resultDisplay, 0, 7);

        HBox buttons = new HBox(10);
        buttons.setAlignment(javafx.geometry.Pos.CENTER);
        buttons.getChildren().addAll(convertButton, clearButton);

        grid.add(buttons, 0, 5);

        layout = new VBox(10);
        layout.setPadding(new Insets(10));
        layout.getChildren().addAll(topBar, grid); // Add the topBar above the grid
        layout.setStyle("-fx-background-color: #4a90e2;");

        Scene scene = new Scene(layout,500,380);
        primaryStage.setScene(scene);
        primaryStage.setResizable(false);
        primaryStage.show();
        scene.setOnKeyPressed(event -> {
            if(event.getCode().toString().equals("ENTER")) {
                convertButton.fire();
            }
        });
    }

    private void toggleTheme() {
        String currentStyle = layout.getStyle();

        if (currentStyle.equals("-fx-background-color: #4a90e2;")) { // Dark
            layout.setStyle("-fx-background-color: #333333;");
            grid.setStyle("-fx-background-color: #444444;");
            exampleLabel.setStyle("-fx-font-size: 18; -fx-font-weight: bold; -fx-text-fill: white");
            welcomeLabel.setStyle("-fx-font-size: 22; -fx-font-weight: bold; -fx-text-fill: white");
            resultLabel.setStyle("-fx-font-size: 18; -fx-font-weight: bold; -fx-text-fill: white");
            amountLabel.setStyle("-fx-font-size: 18; -fx-font-weight: bold; -fx-text-fill: white");
            currencyDisplay.setStyle("-fx-background-color: #555555; -fx-font-size: 18; -fx-font-weight: bold; -fx-text-fill: white");
            amountDisplay.setStyle("-fx-background-color: #555555; -fx-font-size: 18; -fx-font-weight: bold; -fx-text-fill: white");
            resultDisplay.setStyle("-fx-background-color: #555555; -fx-font-size: 18; -fx-font-weight: bold; -fx-text-fill: white");
            convertButton.setStyle("-fx-background-color: #888888; -fx-text-fill: white; -fx-font-size: 18; -fx-font-weight: bold;");
            clearButton.setStyle("-fx-background-color: #e94e77; -fx-text-fill: white; -fx-font-size: 18; -fx-font-weight: bold;");
        } else { // Light
            layout.setStyle("-fx-background-color: #4a90e2;");
            grid.setStyle("-fx-background-color: #ffffff;");
            exampleLabel.setStyle("-fx-font-size: 18; -fx-font-weight: bold;");
            welcomeLabel.setStyle("-fx-font-size: 22; -fx-font-weight: bold;");
            resultLabel.setStyle("-fx-font-size: 18; -fx-font-weight: bold;");
            amountLabel.setStyle("-fx-font-size: 18; -fx-font-weight: bold;");
            currencyDisplay.setStyle("-fx-background-color: #f4f4f9; -fx-font-size: 18; -fx-font-weight: bold;");
            amountDisplay.setStyle("-fx-background-color: #f4f4f9; -fx-font-size: 18; -fx-font-weight: bold;");
            resultDisplay.setStyle("-fx-background-color: #f4f4f9; -fx-font-size: 18; -fx-font-weight: bold;");
            convertButton.setStyle("-fx-background-color: #50e3c2; -fx-text-fill: white; -fx-font-size: 18; -fx-font-weight: bold;");
            clearButton.setStyle("-fx-background-color: #e94e77; -fx-text-fill: white; -fx-font-size: 18; -fx-font-weight: bold;");
        }
    }

    private void convertCurrency() {
        String[] input = validators.readBaseInput(currencyDisplay.getText());
        if (input[0].startsWith("error")) {
            currencyDisplay.clear();
            currencyDisplay.setPromptText("Invalid input. Please follow the example.");
            return;
        }

        double amount;
        try {
            amount = validators.value(amountDisplay.getText());
        } catch (NumberFormatException e) {
            amountDisplay.clear();
            amountDisplay.setPromptText("Invalid amount.");
            return;
        }

        double result = converter.convert(amount, input[0], input[1]);
        if (result == -1) {
            currencyDisplay.clear();
            currencyDisplay.setPromptText("Currency not supported or non existent.");
        } else {
            String resultComma = Double.toString(result).replace(".", ",");
            resultDisplay.setText(resultComma + " " + input[1].toUpperCase());
        }
    }

    public void clearUI() {
        currencyDisplay.clear();
        amountDisplay.clear();
        resultDisplay.clear();
        currencyDisplay.setPromptText("e.g., USD to EUR");
        amountDisplay.setPromptText("Amount");
        resultDisplay.setPromptText("The result will appear here");
    }
}