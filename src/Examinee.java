import java.util.HashMap;
import java.util.Map;

public class Examinee {
    private final Division division;
    private final HashMap<Subject, Double> scores;

    public Examinee(Division division, Map<Subject, Double> scores) {
        this.division = division;
        this.scores = new HashMap<>(scores);
    }

    public Division getDivision() {
        return division;
    }

    public Map<Subject, Double> getScores() {
        return new HashMap<>(scores);
    }
}
