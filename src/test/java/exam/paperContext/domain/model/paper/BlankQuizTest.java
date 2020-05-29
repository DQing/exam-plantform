import exam.blankQuizContext.domain.model.BlankQuiz;
import exam.blankQuizContext.domain.model.BlankQuizId;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;

public class BlankQuizTest {


    @Test
    public void should_create_blank_quiz_with_new() {
        final BlankQuizId blankQuizId = new BlankQuizId("quiz-a4c68d5d-6c18-4707-b8c2-1fd18846ebf1");
        final String teacherId = "teacher-6b35fdd8-31de-4af4-9420-3331058260c5";
        final int number = 1;
        final int score = 10;

        BlankQuiz quiz = BlankQuiz.create(blankQuizId, teacherId, number, score);

        assertThat(quiz, is(notNullValue()));

        assertThat(quiz.getQuizId(), is(new BlankQuizId("quiz-a4c68d5d-6c18-4707-b8c2-1fd18846ebf1")));
        assertThat(quiz.getTeacherId(), is(teacherId));
        assertThat(quiz.getNumber(), is(number));
    }
}
