package test.quiz;

import java.util.Arrays;
import java.util.Objects;

public class Question {
    private  String question;
    private  String correctAnswer;
    private  String[] answerOptions;

    public Question() {
    }

    public Question(String question, String correctAnswer, String... answerOptions) {
        this.question = question;
        this.correctAnswer = correctAnswer;
        this.answerOptions = answerOptions;
    }

    public void printAnswer() {
        System.out.println("Выберите один вариант овета: ");
        for (int i = 0; i < answerOptions.length; i++) {
            System.out.println(i + 1 + ". " + answerOptions[i]);
        }
    }

    public int checkAnswer(String answer) {
        if (answer.equals(correctAnswer))
            return 1;
        else return 0;
    }

    public String getQuestion() {
        return question;
    }

    public String getCorrectAnswer() {
        return correctAnswer;
    }

    public String[] getAnswerOptions() {
        return answerOptions;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Question question1 = (Question) o;
        return Objects.equals(question, question1.question) && Objects.equals(correctAnswer, question1.correctAnswer) && Arrays.equals(answerOptions, question1.answerOptions);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(question, correctAnswer);
        result = 31 * result + Arrays.hashCode(answerOptions);
        return result;
    }
}

