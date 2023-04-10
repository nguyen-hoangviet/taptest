import java.util.HashMap;

public class Examinee {
    private Division division;
    private HashMap<Subject, Double> scores;

    public Examinee(Division division, HashMap<Subject, Double> scores) {
        this.division = division;
        this.scores = scores;
    }

    public Division getDivision() {
        return division;
    }

    public HashMap<Subject, Double> getScores() {
        return scores;
    }
}
