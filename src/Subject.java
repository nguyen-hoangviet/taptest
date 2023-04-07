import java.util.HashMap;
import java.util.Map;

public class Subject {
    private final String name;
    private final HashMap<Division, Double> divisionMultipliers;
    private final double allMultiplier;

    public Subject(String name, Map<Division, Double> divisionMultipliers, double allMultiplier) {
        this.name = name;
        this.divisionMultipliers = new HashMap<>(divisionMultipliers);
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
