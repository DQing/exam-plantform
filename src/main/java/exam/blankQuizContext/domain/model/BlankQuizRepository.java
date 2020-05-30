package exam.blankQuizContext.domain.model;

import java.util.List;

public interface BlankQuizRepository {
    BlankQuiz find(BlankQuizId quizId);

    void save(BlankQuiz quiz);

    BlankQuizId nextBlankQuizId();

    List<BlankQuiz> getAll();

    void delete(String blankQuizId);
}
