package geomate.controller;

import geomate.Main;
import geomate.model.Game;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import javafx.util.Duration;

public class MainController {

    private static Game gameInstance;
    //private Game game;
    private Stage primaryStage;

    public MainController() {
        // Constructor sin argumentos requerido por FXMLLoader
    }
/*
    public MainController(Stage primaryStage) {
        this.primaryStage = primaryStage;
        List<Question> questions = QuestionManager.getAllQuestions();
        this.game = new Game(questions);
    }
*/
    public void setPrimaryStage(Stage primaryStage) {
        this.primaryStage = primaryStage;
    }

    public void setGame(Game game) {
        gameInstance = game;
        //this.game = game;
    }

    public static Game getGameInstance() {
        return gameInstance;
    }

        public Game getGame() {
        //return this.game;
        return gameInstance;
    }

    // Anotación @FXML para que JavaFX pueda inyectar el botón desde el archivo FXML
    @FXML
    private Button botonDesafios;

    // Método initialize() que se llama automáticamente después de que se han cargado los componentes del archivo FXML
    @FXML
    public void initialize() {
        /*
         * Inicializa la animación del botón "botonDesafios"
         * Llama al método animarBotonDesafio() para comenzar la animación del botón
         */
        animarBotonDesafio();
    }

    // Método que maneja el evento de clic en el botón "botonDesafios"
    @FXML
    private void iniciarDesafio(ActionEvent event) throws Exception {
        /*
         * Cambia la escena actual a la escena de preguntas
         * Llama al método estático showQuestionScene() de la clase Main
         */
        Main.showQuestionScene(gameInstance);
    }

    @FXML
    private void handleExitButton() {
        primaryStage.close();
    }

    // Método que anima el botón "botonDesafios" cambiando su color de fondo
    private void animarBotonDesafio() {
        // Crea una nueva línea de tiempo (Timeline) para manejar la animación
        Timeline timeline = new Timeline(
                // Define un KeyFrame que cambia el estilo del botón después de 0.5 segundos
                new KeyFrame(Duration.seconds(0.5), e -> botonDesafios.setStyle("-fx-background-color: #4CAF50; -fx-text-fill: WHITE;")),
                // Define otro KeyFrame que cambia el estilo del botón después de 1 segundo
                new KeyFrame(Duration.seconds(1), e -> botonDesafios.setStyle("-fx-background-color: #45A049; -fx-text-fill: WHITE;"))
        );
        // Establece la cantidad de ciclos para la animación, INDEFINITE hace que la animación se repita indefinidamente
        timeline.setCycleCount(Timeline.INDEFINITE);
        // Inicia la animación
        timeline.play();
    }





}
