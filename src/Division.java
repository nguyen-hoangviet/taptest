import java.util.ArrayList;
import java.util.List;

public class Division {
    private String name;
    private List<Subject> subjects;
    private double passScore;

    public Division(String name, List<Subject> subjects, double passScore) {
        this.name = name;
        this.subjects = new ArrayList<Subject>(subjects);
        this.passScore = passScore;
    }

    public String getName() {
        return name;
    }

    public List<Subject> getSubjects() {
        return new ArrayList<Subject>(subjects);
    }

    public double getPassScore() {
        return passScore;
    }


}
