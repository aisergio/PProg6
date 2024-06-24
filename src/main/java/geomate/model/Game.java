package geomate.model;

import java.util.List;

public class Game {
    private List<Question> questions;
    private int currentQuestionIndex = 0;
    private int score = 0;

    private static final int MAX_QUESTIONS = 10;

//    public Game(List<Question> questions) {
//        this.questions = questions;
//        this.currentQuestionIndex = 0;
//        this.score = 0;
//    }

    public Game(List<Question> questions) {
        this.questions = questions;
    }

//    public Game(List<Question> allQuestions) {
//        // Limitar las preguntas a un máximo de 10
//        questions = new ArrayList<>(allQuestions.subList(0, Math.min(allQuestions.size(), MAX_QUESTIONS)));
//        currentQuestionIndex = 0;
//        score = 0;
//    }

    public Question getCurrentQuestion() {
        if (currentQuestionIndex < questions.size()) {
            return questions.get(currentQuestionIndex);
        } else {
            return null;
        }
    }

    public void nextQuestion() {
        if (currentQuestionIndex < questions.size()) {
            currentQuestionIndex++;
        }
    }

    public int getCurrentQuestionIndex() {
        return currentQuestionIndex;
    }

    public int getTotalQuestions() {
        return questions.size();
    }

    public int getScore() {
        return score;
    }

    public void incrementScore() {
        score++;
    }
}
