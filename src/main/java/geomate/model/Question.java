package geomate.model;

public class Question {
    /*
     * Campo privado para almacenar el texto de la pregunta.
     */
    private String questionText;

    /*
     * Campo privado para almacenar las opciones de respuesta.
     */
    private String[] answers;

    /*
     * Campo privado para almacenar el índice de la respuesta correcta.
     */
    private int correctAnswerIndex;

    /*
     * Constructor para inicializar una instancia de la clase Question con el texto de la pregunta,
     * las opciones de respuesta y el índice de la respuesta correcta.
     */
    public Question(String questionText, String[] answers, int correctAnswerIndex) {
        this.questionText = questionText;
        this.answers = answers;
        this.correctAnswerIndex = correctAnswerIndex;
    }

    /*
     * Método público para obtener el texto de la pregunta.
     * @return el texto de la pregunta.
     */
    public String getQuestionText() {
        return questionText;
    }

    /*
     * Método público para obtener las opciones de respuesta.
     * @return un array de Strings que contiene las opciones de respuesta.
     */
    public String[] getAnswers() {
        return answers;
    }

    /*
     * Método público para obtener el índice de la respuesta correcta.
     * @return el índice de la respuesta correcta.
     */
    public int getCorrectAnswerIndex() {
        return correctAnswerIndex;
    }

    /*
     * Método público para verificar si una respuesta dada es la correcta.
     * @param index el índice de la respuesta seleccionada.
     * @return true si el índice de la respuesta seleccionada es igual al índice de la respuesta correcta, false en caso contrario.
     */
    public boolean isCorrectAnswer(int index) {
        return index == correctAnswerIndex;
    }
}
