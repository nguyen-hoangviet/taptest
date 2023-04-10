import java.util.HashMap;

public class Subject {
    private String name;
    private HashMap<Division, Double> divisionMultipliers;
    private double allMultiplier;

    public Subject(String name, HashMap<Division, Double> divisionMultipliers, double allMultiplier) {
        this.name = name;
        this.divisionMultipliers = divisionMultipliers;
        this.allMultiplier = allMultiplier;
    }

    public String getName() {
        return name;
    }

    public HashMap<Division, Double> getDivisionMultiplier() {
        return divisionMultipliers;
    }

    public double getAllMultiplier() {
        return allMultiplier;
    }

    public void setDivisionMultipliers(Division division, Double divMultiplier) {
        divisionMultipliers.put(division,divMultiplier);
    }
}
