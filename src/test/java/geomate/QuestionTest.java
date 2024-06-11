package geomate;

import geomate.model.Question;
import org.junit.Test;
import static org.junit.Assert.*;

public class QuestionTest {

    @Test
    public void testIsCorrectAnswer() {
        String[] answers = {"A", "B", "C", "D"};
        Question question = new Question("What is the correct answer?", answers, 2);
        assertTrue(question.isCorrectAnswer(2));
        assertFalse(question.isCorrectAnswer(1));
    }
}
