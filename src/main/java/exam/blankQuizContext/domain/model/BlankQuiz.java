package exam.blankQuizContext.domain.model;

import exam.blankQuizContext.domain.shared.Entity;

public class BlankQuiz implements Entity<BlankQuiz> {
    private String teacherId;
    private int number;
    private int score;
    private BlankQuizId quizId;

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

    public void update(String teacherId, int number, int score) {
        this.teacherId = teacherId;
        this.number = number;
        this.score = score;
    }

    @Override
    public boolean sameIdentityAs(BlankQuiz other) {
        return quizId.sameValueAs(other.quizId);
    }
}
