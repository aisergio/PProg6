package geomate;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import geomate.model.QuestionManager;

public class Main extends Application {

    /*
     * Variable estática para almacenar la referencia al objeto Stage principal.
     */
    private static Stage primaryStage;

    /*
     * Método start() que se llama cuando se inicia la aplicación JavaFX.
     * @param primaryStage el escenario principal de la aplicación.
     * @throws Exception si ocurre algún error durante la carga de recursos.
     */
    @Override
    public void start(Stage primaryStage) throws Exception {
        /*
         * Asigna el escenario principal a la variable estática.
         */
        this.primaryStage = primaryStage;

        /*
         * Carga las preguntas desde un archivo JSON usando el método loadQuestionsFromFile() de QuestionManager.
         */
        QuestionManager.loadQuestionsFromFile("/preguntas6.json");

        /*
         * Muestra la escena principal llamando al método showMainScene().
         */
        showMainScene();
    }

    /*
     * Método estático para mostrar la escena principal.
     * @throws Exception si ocurre algún error durante la carga del archivo FXML.
     */
    public static void showMainScene() throws Exception {
        /*
         * Carga el archivo FXML de la escena principal.
         */
        Parent root = FXMLLoader.load(Main.class.getResource("/fxml/MainScene.fxml"));

        /*
         * Crea una nueva escena con el contenido cargado del archivo FXML.
         */
        Scene scene = new Scene(root);

        /*
         * Establece el título de la ventana.
         */
        primaryStage.setTitle("Inicio");

        /*
         * Asigna la escena al escenario principal y la muestra.
         */
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /*
     * Método estático para mostrar la escena de preguntas.
     * @throws Exception si ocurre algún error durante la carga del archivo FXML.
     */
    public static void showQuestionScene() throws Exception {
        /*
         * Carga el archivo FXML de la escena de preguntas.
         */
        Parent root = FXMLLoader.load(Main.class.getResource("/fxml/QuestionScene.fxml"));

        /*
         * Crea una nueva escena con el contenido cargado del archivo FXML.
         */
        Scene scene = new Scene(root);

        /*
         * Establece el título de la ventana.
         */
        primaryStage.setTitle("Preguntas");

        /*
         * Asigna la escena al escenario principal y la muestra.
         */
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /*
     * Método main() que lanza la aplicación JavaFX.
     * @param args los argumentos de la línea de comandos.
     */
    public static void main(String[] args) {
        launch(args);
    }
}
