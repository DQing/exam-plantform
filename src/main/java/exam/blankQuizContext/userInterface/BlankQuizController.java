package exam.blankQuizContext.userInterface;

import exam.blankQuizContext.application.BlankQuizCommand;
import exam.blankQuizContext.application.BlankQuizService;
import exam.blankQuizContext.domain.model.BlankQuiz;
import exam.blankQuizContext.domain.model.BlankQuizId;
import exam.paperContext.application.AssemblePaperCommand;
import exam.paperContext.domain.model.paper.Paper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BlankQuizController {

    private BlankQuizService blankQuizService;

    @Autowired
    public BlankQuizController(BlankQuizService blankQuizService) {
        this.blankQuizService = blankQuizService;
    }

    @PostMapping("/blankQuizzes")
    @ResponseBody
    @ResponseStatus(HttpStatus.CREATED)
    BlankQuizDTO create(@RequestBody BlankQuizCommand command) {
        final BlankQuizId blankQuizId = blankQuizService.create(command);
        return BlankQuizDTO.from(blankQuizId);
    }

    @GetMapping("/blankQuizzes")
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    List<BlankQuiz> getAll() {
        return blankQuizService.getAll();
    }

    @PutMapping("/blankQuizzes/{blankQuizId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void update(@PathVariable String blankQuizId, @RequestBody BlankQuizCommand command) {
        blankQuizService.updateBlankQuiz(blankQuizId, command);
    }
}
