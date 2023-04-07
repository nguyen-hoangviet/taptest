import javax.swing.*;
import static javax.swing.UIManager.getIcon;
public class Input {
    public String input(int type, String acronyms, int[] maxIndexes, String message, String error) {
        Validator validator = new Validator();
        String result = (String) JOptionPane.showInputDialog(null,
        "Enter " + message + ":", "Exam Passers Counter",
                JOptionPane.PLAIN_MESSAGE, getIcon("src/icons/truck.png"), null, "");
        while (!validator.condition(type, result, acronyms, maxIndexes)) {
            JOptionPane.showMessageDialog(null,"Please enter " + error + ".");
            result = (String) JOptionPane.showInputDialog(null,
                    "Enter " + message + ":", "Exam Passers Counter",
                    JOptionPane.PLAIN_MESSAGE, getIcon("src/icons/truck.png"), null, "");
        }
        return result;
    }

    public int[] option(int type, String[] options, String message, String error) {
        Validator validator = new Validator();
        JList subjectlist = new JList(options);
        JOptionPane.showMessageDialog(
                null, options, "Enter " + message + ":", JOptionPane.PLAIN_MESSAGE);
        while (!validator.condition(type, null, null, subjectlist.getSelectedIndices())) {
            JOptionPane.showMessageDialog(null, "Please enter " + error + ".");
        }
        return subjectlist.getSelectedIndices();
    }

    public void output(String message) {
        JOptionPane.showMessageDialog(null,message);
    }
}
