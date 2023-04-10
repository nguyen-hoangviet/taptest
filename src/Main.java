import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
            String acronyms = "";
            ArrayList<Subject> subjects = new ArrayList<>();
            ArrayList<Division> divisions = new ArrayList<>();
            Input input = new Input();
            int subjectNumber = Integer.parseInt(input.input(0,null,null,
                    "number of subjects","a positive integer"));
            String[] names = new String[subjectNumber];
            for (int i = 0; i < subjectNumber; i++) {
                String name = input.input(1,null,null,"#" +
                        (i + 1) + " subject 's name","a valid name");
                names[i] = name;
                double allMultiplier = Double.parseDouble(input.input(4,null,null,"#" +
                        (i + 1) + " subject 's multiplier in total score","a positive number"));
                subjects.add(new Subject(name,new HashMap<Division,Double>(),allMultiplier));
            }
            int divisionNumber = Integer.parseInt(input.input(0,null,null,
                "number of divisions","a positive integer"));
            int[] maxIndexes = new int[divisionNumber];
            for (int i = 0; i < divisionNumber; i++) {
                String name = input.input(1,null,null,"#" +
                        (i + 1) + " division 's name","a valid name");
                int[] divisionSubjectIndexes = input.option(2, names,name + "'s subjects",
                        "choose at least one option");
                Arrays.sort(divisionSubjectIndexes);
                maxIndexes[i] = divisionSubjectIndexes[divisionSubjectIndexes.length - 1];
                String acronym = input.input(3,acronyms,null,name + " 's acronym",
                        "a valid character");
                acronyms += acronym;
                ArrayList<Subject> divisionSubjects = new ArrayList<>();
                for (int j: divisionSubjectIndexes) {
                    divisionSubjects.add(subjects.get(j));
                }
                double divPassScore = Double.parseDouble(input.input(4,null,null,name
                        + "'s pass score","a positive number"));
                Division division = new Division(name,divisionSubjects,divPassScore);
                divisions.add(division);
                for (int j: divisionSubjectIndexes) {
                    double divMultiplier = Double.parseDouble(input.input(0,null,null,
                            subjects.get(j).getName() +
                                    "'s multiplier in " + name + "'s score","a positive number"));
                    subjects.get(j).setDivisionMultipliers(division,divMultiplier);
                }
            }
            double totalPassScore = Double.parseDouble(input.input(4,null,null,
               "total pass score","a positive number"));
            String resultInput = input.resInput(5,acronyms,maxIndexes,
                    "exam result","a valid test result");
            Result result = new Result(subjects,divisions,acronyms,totalPassScore);
            result.input(resultInput);
            input.output("The number of passers in the exam is " + result.countPassers());
    }
}