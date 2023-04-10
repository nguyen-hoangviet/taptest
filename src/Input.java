import javax.swing.*;
import javax.swing.JCheckBox;
import javax.swing.JOptionPane;
import static javax.swing.UIManager.getIcon;
public class Input {
    Validator validator = new Validator();
    public String input(int type, String acronyms, int[] maxIndexes, String message, String error) {
        String result = (String) JOptionPane.showInputDialog(null,
        "Enter " + message + ":", "Exam Passers Counter",
                JOptionPane.PLAIN_MESSAGE, null, null, "");
        while (!validator.condition(type, result, acronyms, maxIndexes)) {
            JOptionPane.showMessageDialog(null,"Please enter " + error + ".");
            result = (String) JOptionPane.showInputDialog(null,
                    "Enter " + message + ":", "Exam Passers Counter",
                    JOptionPane.PLAIN_MESSAGE, getIcon("src/icons/truck.png"), null, "");
        }
        return result;
    }

    public int[] option(int type, String[] options, String message, String error) {
        int[] result = choose(options,message);
        while (!validator.condition(type, null, null, result)) {
            JOptionPane.showMessageDialog(null, "Please enter " + error + ".");
            result = choose(options,message);
        }
        return result;
    }

    public int[] choose(String[] options, String message) {
        JCheckBox[] checkboxes = new JCheckBox[options.length];
        for (int i = 0; i < options.length; i++) {
            checkboxes[i] = new JCheckBox(options[i]);
        }
        int result = JOptionPane.showConfirmDialog(null, checkboxes, "Enter " + message + ":",
                JOptionPane.OK_CANCEL_OPTION);
        if (result == JOptionPane.OK_OPTION) {
            int count = 0;
            for (int i = 0; i < options.length; i++) {
                if (checkboxes[i].isSelected()) {
                    count++;
                }
            }
            int[] selectedIndexes = new int[count];
            int j = 0;
            for (int i = 0; i < options.length; i++) {
                if (checkboxes[i].isSelected()) {
                    selectedIndexes[j] = i;
                    j++;
                }
            }
            return selectedIndexes;
        } else {
            return new int[0];
        }
    }

    public void output(String message) {
        JOptionPane.showMessageDialog(null,message);
    }

    public String resInput(int type, String acronyms, int[] maxIndexes, String message, String error) {
        JTextArea textArea = new JTextArea(40, 40);
        JScrollPane scrollPane = new JScrollPane(textArea);
        JOptionPane.showOptionDialog(null, scrollPane, "Enter " + message + ":",
                JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, null, null);
        String result = textArea.getText();
        System.out.println(result);
        while (!validator.condition(type, result, acronyms, maxIndexes)) {
            JOptionPane.showMessageDialog(null, "Please enter " + error + ".");
            JOptionPane.showOptionDialog(null, scrollPane, "Enter " + message + ":",
                    JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, null, null);
            result = textArea.getText();
        }
        return result;
    }
}
