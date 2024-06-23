package geomate;

import geomate.controller.MainController;
import geomate.model.Game;
import geomate.model.Question;
import geomate.model.QuestionManager;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.util.List;

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
        this.primaryStage = primaryStage;
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
        FXMLLoader loader = new FXMLLoader(Main.class.getResource("/fxml/MainScene.fxml"));
        Parent root = loader.load();

        /*
         * Crea una nueva escena con el contenido cargado del archivo FXML.
         */
        Scene scene = new Scene(root);

        /*
         * Configuración del controlador después de cargar el FXML.
         */
        MainController controller = loader.getController();
        controller.setPrimaryStage(primaryStage);

        List<Question> questions = QuestionManager.getAllQuestions();
        Game game = new Game(questions);
        controller.setGame(game);

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

    public static void showQuestionScene(Game game) throws Exception {
        FXMLLoader loader = new FXMLLoader(Main.class.getResource("/fxml/QuestionScene.fxml"));
        Parent root = loader.load();
        geomate.controller.QuestionController controller = loader.getController();
        controller.setGame(game);

        /*
         * Crea una nueva escena con el contenido cargado del archivo FXML.
         */
        Scene scene = new Scene(root);

        /*
         * Configuración del controlador después de cargar el FXML.
         */

//        MainController controller = loader.getController();
//        controller.setPrimaryStage(primaryStage);
//        controller.setGame(controller.getGame()); // Asegurar que el juego esté configurado

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
