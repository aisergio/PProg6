package geomate.model;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import geomate.Main;

import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class QuestionManager {
    /*
     * Lista estática para almacenar las preguntas cargadas desde el archivo JSON.
     */
    private static List<Question> questions = new ArrayList<>();

    /*
     * Método estático para cargar preguntas desde un archivo JSON.
     * @param filePath la ruta del archivo JSON que contiene las preguntas.
     */
//    public static void loadQuestionsFromFile(String filePath) {
//        try (InputStreamReader reader = new InputStreamReader(Main.class.getResourceAsStream(filePath))) {
//            /*
//             * Usa Gson para deserializar el contenido del archivo JSON en una lista de objetos Question.
//             * El método fromJson() convierte el contenido del archivo JSON en una lista de preguntas.
//             * TypeToken se usa para obtener el tipo genérico de la lista de preguntas.
//             */
//            questions = new Gson().fromJson(reader, new TypeToken<List<Question>>() {}.getType());
//        } catch (Exception e) {
//            /*
//             * Imprime la traza del stack si ocurre una excepción durante la carga del archivo.
//             */
//            e.printStackTrace();
//        }
//    }

    public static void loadQuestionsFromFile(String filename) {
        try (InputStreamReader reader = new InputStreamReader(Main.class.getResourceAsStream(filename))) {
            questions = new Gson().fromJson(reader, new TypeToken<List<Question>>() {}.getType());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static List<Question> getRandomQuestions(int numQuestions) {
        List<Question> shuffledQuestions = new ArrayList<>(questions);
        Collections.shuffle(shuffledQuestions, new Random());
        return shuffledQuestions.subList(0, numQuestions);
    }

    /*
     * Método estático para obtener todas las preguntas cargadas desde el archivo JSON.
     * @return una lista de preguntas.
     */
    public static List<Question> getAllQuestions() {
        return new ArrayList<>(questions);
    }

    /*
     * Método estático para obtener una pregunta aleatoria de la lista de preguntas.
     * @return una pregunta aleatoria de la lista.
     */
    public static Question getRandomQuestion() {
        /*
         * Crea una instancia de la clase Random para generar un índice aleatorio.
         * Usa el índice aleatorio para seleccionar una pregunta de la lista.
         */
        Random random = new Random();
        return questions.get(random.nextInt(questions.size()));
    }
}
