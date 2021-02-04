package test.quiz;

public class Scores {
    private String name;
    private String answer;
    private int score;

    public Scores() {
    }

    public Scores(String name, String answer, int score) {
        this.name = name;
        this.answer = answer;
        this.score = score;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }
}
