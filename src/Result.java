import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Result {
    private ArrayList<Subject> subjects;
    private ArrayList<Division> divisions;
    private String acronyms;

    private double totalPassScore;
    private static ArrayList<Examinee> examinees;

    public Result(ArrayList<Subject> subjects, ArrayList<Division> divisions, String acronyms, double totalPassScore) {
        this.subjects = subjects;
        this.divisions = divisions;
        this.acronyms = acronyms;
        this.totalPassScore = totalPassScore;
    }
    public void input(String input) {
        String[] list = input.split("\r\n");
        for (int i = 1; i < list.length; i++) {
            String[] vals = list[i].split(" ");
            HashMap<Subject, Double> scores = new HashMap<>();
            for (int j = 1; j < vals.length; j++) {
                scores.put(subjects.get(j),Double.parseDouble(vals[j]));
            }
            examinees.add(new Examinee(divisions.get(acronyms.indexOf(vals[0])),scores));
        }
    }

    public int countPassers() {
        int passers = 0;
        for (Examinee examinee: examinees) {
            double totalDiv = 0;
            double totalAll = 0;
            Division division = examinee.getDivision();
            for (Subject subject: division.getSubjects()) {
                totalDiv += examinee.getScores().get(subject) * subject.getDivisionMultiplier().get(division);
            }
            for (Subject subject: subjects) {
                totalAll += examinee.getScores().get(subject) * subject.getAllMultiplier();
            }
            if (totalDiv >= division.getPassScore() && totalAll > totalPassScore)
                passers += 1;
        }
        return passers;
    }
}