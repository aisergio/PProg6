package geomate.controller;

import geomate.Main;
import geomate.model.Game;
import geomate.model.Question;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.util.Duration;

public class QuestionController {

    // Instancia del juego que maneja la lógica del juego
    private Game game;
    private Stage primaryStage;

    /*
     * La anotación @FXML permite que el cargador de FXML inyecte los elementos marcados.
     * VBox es un contenedor para contener la pregunta y los botones de respuesta.
     */
    @FXML
    private VBox questionBox;

    @FXML
    private Label questionLabel; // Label para mostrar el texto de la pregunta

    @FXML
    private Label scoreLabel; // Label para mostrar el puntaje

//    @FXML
//    private Label progressBar; // Barra de progreso para mostrar el progreso

    @FXML
    private ProgressBar progressBar; // Barra de progreso para mostrar el progreso

     /*
     * Botones para las opciones de respuesta.
     */
    @FXML
    private Button answerButton1;
    @FXML
    private Button answerButton2;
    @FXML
    private Button answerButton3;
    @FXML
    private Button answerButton4;

    @FXML
    private Label progressLabel; // Label para mostrar el progreso

    private Question currentQuestion; // La pregunta actual que se muestra en la pantalla

    /*
     * Método initialize() que se llama automáticamente después de que se han cargado los componentes del archivo FXML.
     */
    @FXML
    public void initialize() {
        // El juego debe ser inicializado antes de usarlo
        if (game != null) {
            // Obtener la instancia de Game de MainController
            game = MainController.getGameInstance();
            loadRandomQuestion();
            updateScoreAndProgress();
            updateProgress();
        }
    }

//    public void setGame(Game game) {
//        this.game = game;
//    }

    public void setGame(Game game) {
        this.game = game;
        loadRandomQuestion();
        updateScoreAndProgress();
    }

    /*
     * Label para mostrar el texto de la pregunta.
     */

    private void loadRandomQuestion() {
        //currentQuestion = QuestionManager.getRandomQuestion();
        currentQuestion = game.getCurrentQuestion();
        if (currentQuestion != null) {
            questionLabel.setText(currentQuestion.getQuestionText());
            String[] answers = currentQuestion.getAnswers();
            answerButton1.setText(answers[0]);
            answerButton2.setText(answers[1]);
            answerButton3.setText(answers[2]);
            answerButton4.setText(answers[3]);

            /*
             * Configura los controladores de eventos para los botones de respuesta.
             * Cuando se hace clic en un botón, se llama a handleAnswer() con el índice correspondiente.
             */
            answerButton1.setOnAction(event -> handleAnswer(0));
            answerButton2.setOnAction(event -> handleAnswer(1));
            answerButton3.setOnAction(event -> handleAnswer(2));
            answerButton4.setOnAction(event -> handleAnswer(3));
        } else {
            // No hay más preguntas, mostrar pantalla de fin del juego
            showEndGameScreen();
        }
    }

    private void handleAnswer(int selectedIndex) {
        boolean isCorrect = currentQuestion.isCorrectAnswer(selectedIndex);
        String message = isCorrect ? "¡Correcto!" : "Incorrecto. Intenta de nuevo.";
        questionLabel.setText(message);

        if (isCorrect) {
            game.incrementScore();
        }
        game.nextQuestion();
        updateProgress();

        if (game.getCurrentQuestionIndex() < game.getTotalQuestions()) {
            new Timeline(new KeyFrame(Duration.seconds(1), e -> loadRandomQuestion())).play();
        } else {
            // Mostrar pantalla de fin del juego
            showEndGameScreen();
        }
        updateScoreAndProgress();
    }

    /*
     * Actualiza el puntaje y el progreso del juego.
     */

    public void updateScoreAndProgress() {
        scoreLabel.setText("Puntaje: " + game.getScore());
        progressBar.setProgress((double) game.getCurrentQuestionIndex() / game.getTotalQuestions());
    }

    /*
     * Actualiza el progreso del juego.
     */
//    private void updateProgress() {
//        int currentQuestionIndex = game.getCurrentQuestionIndex() + 1; // +1 para contar la pregunta actual
//        int totalQuestions = game.getTotalQuestions();
//        progressLabel.setText("Progreso: " + currentQuestionIndex + "/" + totalQuestions);
//    }

    private void updateProgress() {
        int currentQuestionIndex = Math.min(game.getCurrentQuestionIndex(), game.getTotalQuestions() - 1) + 1; // Asegurar que el índice no supere el total de preguntas
        int totalQuestions = game.getTotalQuestions();
        progressLabel.setText("Progreso: " + currentQuestionIndex + "/" + totalQuestions);
    }

    /*
     * Devuelve el puntaje actual del juego.
     */
    public int getScore() {
        return game.getScore();
    }

    /*
     * Devuelve el progreso actual del juego como un valor entre 0 y 1.
     */
    public double getProgress() {
        return (double) game.getCurrentQuestionIndex() / game.getTotalQuestions();
    }

    @FXML
    private void handleBackButton() {
        try {
            Main.showMainScene();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void showEndGameScreen() {
        questionLabel.setText("Juego terminado. Tu puntaje es: " + game.getScore());
        // Aquí puedes agregar lógica adicional para mostrar una pantalla de fin de juego
    }

    public void setPrimaryStage(Stage primaryStage) {
        this.primaryStage = primaryStage;
    }
}
