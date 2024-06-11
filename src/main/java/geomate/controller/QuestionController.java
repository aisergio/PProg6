package geomate.controller;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.util.Duration;
import geomate.model.Question;
import geomate.model.QuestionManager;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class QuestionController {

    /*
     * La anotación @FXML permite que el cargador de FXML inyecte los elementos marcados.
     * VBox es un contenedor para contener la pregunta y los botones de respuesta.
     */
    @FXML
    private VBox questionBox;

    /*
     * Label para mostrar el texto de la pregunta.
     */
    @FXML
    private Label questionLabel;

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

    /*
     * Pregunta actual que se está mostrando.
     */
    private Question currentQuestion;

    /*
     * El método initialize() se llama después de que se hayan inyectado los elementos FXML.
     * Este método carga una pregunta aleatoria cuando se inicializa el controlador.
     */
    @FXML
    public void initialize() {
        loadRandomQuestion();
    }

    /*
     * Este método carga una pregunta aleatoria y configura los botones de respuesta.
     * Obtiene una pregunta aleatoria de QuestionManager y actualiza los elementos de la interfaz de usuario.
     */
    private void loadRandomQuestion() {
        currentQuestion = QuestionManager.getRandomQuestion();
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
        }
    }

    /*
     * Este método maneja la lógica cuando se hace clic en un botón de respuesta.
     * Verifica si la respuesta seleccionada es correcta y actualiza el label de la pregunta con el resultado.
     * Luego, espera un segundo antes de cargar una nueva pregunta aleatoria.
     */
    private void handleAnswer(int selectedIndex) {
        boolean isCorrect = currentQuestion.isCorrectAnswer(selectedIndex);
        String message = isCorrect ? "¡Correcto!" : "Incorrecto. Intenta de nuevo.";
        questionLabel.setText(message);

        // Espera un segundo antes de cargar la siguiente pregunta
        new Timeline(new KeyFrame(Duration.seconds(1), e -> loadRandomQuestion())).play();
    }
}
