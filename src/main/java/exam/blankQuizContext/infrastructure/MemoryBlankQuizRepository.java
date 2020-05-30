package exam.blankQuizContext.infrastructure;

import exam.blankQuizContext.domain.model.BlankQuiz;
import exam.blankQuizContext.domain.model.BlankQuizId;
import exam.blankQuizContext.domain.model.BlankQuizRepository;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;

@Component
public class MemoryBlankQuizRepository implements BlankQuizRepository {
    private Set<BlankQuiz> blankQuizzes = new HashSet<>();

    @Override
    public BlankQuiz find(BlankQuizId quizId) {
        return blankQuizzes.stream().filter(quiz -> {
            return quiz.getQuizId().equals(quizId);
        }).findFirst().orElseThrow(NullPointerException::new);
    }

    @Override
    public void save(exam.blankQuizContext.domain.model.BlankQuiz quiz) {
        blankQuizzes.add(quiz);
    }

    @Override
    public BlankQuizId nextBlankQuizId() {
        return new BlankQuizId("blankQuiz-" + UUID.randomUUID().toString());
    }

    @Override
    public List<BlankQuiz> getAll() {
        return blankQuizzes.stream().collect(Collectors.toList());
    }

}
