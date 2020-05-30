package exam.blankQuizContext.application;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class BlankQuizCommand {
    private String teacherId;
    private int number;
    private int score;
}