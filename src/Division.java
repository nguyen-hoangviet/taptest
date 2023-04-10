import java.util.ArrayList;

public class Division {
    private String name;
    private ArrayList<Subject> subjects;
    private double passScore;

    public Division(String name, ArrayList<Subject> subjects, double passScore) {
        this.name = name;
        this.subjects = subjects;
        this.passScore = passScore;
    }

    public ArrayList<Subject> getSubjects() {
        return subjects;
    }

    public double getPassScore() {
        return passScore;
    }


}
