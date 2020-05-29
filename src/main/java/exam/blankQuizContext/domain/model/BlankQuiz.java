package exam.blankQuizContext.domain.model;

public class BlankQuiz {
    private static String teacherId;
    private static int number;
    private static int score;
    private final BlankQuizId quizId;

    public BlankQuiz(BlankQuizId quizId, String teacherId, int number, int score) {

        this.quizId = quizId;
        this.teacherId = teacherId;
        this.number = number;
        this.score = score;
    }

    public String getTeacherId() {
        return teacherId;
    }

    public int getNumber() {
        return number;
    }

    public int getScore() {
        return score;
    }

    public BlankQuizId getQuizId() {
        return quizId;
    }

    public static BlankQuiz create(BlankQuizId quizId, String teacherId, int number, int score) {
        return new BlankQuiz(quizId, teacherId, number, score);
    }
}
