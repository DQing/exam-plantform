package exam.blankQuizContext.application;

import exam.blankQuizContext.domain.model.BlankQuiz;
import exam.blankQuizContext.domain.model.BlankQuizId;
import exam.blankQuizContext.domain.model.BlankQuizRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BlankQuizService {
    private BlankQuizRepository blankQuizRepository;

    @Autowired
    public BlankQuizService(BlankQuizRepository blankQuizRepository) {
        this.blankQuizRepository = blankQuizRepository;
    }

    public BlankQuizId create(BlankQuizCommand command) {

        BlankQuizId blankQuizId = blankQuizRepository.nextBlankQuizId();
        final BlankQuiz quiz = BlankQuiz.create(blankQuizId, command.getTeacherId(), command.getNumber(), command.getScore());
        blankQuizRepository.save(quiz);

        return blankQuizId;
    }

    public void updateBlankQuiz(String blankQuizId, BlankQuizCommand command) {
        final BlankQuiz quiz = blankQuizRepository.find(new BlankQuizId(blankQuizId));

        quiz.update(command.getTeacherId(), command.getNumber(), command.getScore());
    }

    public List<BlankQuiz> getAll() {
        return blankQuizRepository.getAll();
    }
}
