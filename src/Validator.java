public class Validator {
    public Boolean validResult(String input, String acronyms, int[] maxIndexes) {
        try {
            String[] list = input.split("\r\n");
            if (list.length == 0) return false;
            if (list.length == 1) return Integer.parseInt(list[0]) == 0;
            if (list.length != Integer.getInteger(list[0]) + 1) return false;
            for (String s : list) {
                String[] line = s.split(" ");
                if (line.length < 2 || line.length < maxIndexes[acronyms.indexOf(line[0])]) return false;
                if (Integer.parseInt(line[0]) >= 0 || !acronyms.contains(line[0])) return false;
                for (String l : line) {
                    if (Double.parseDouble(l) < 0) return false;
                }
            }
            return true;
        }
        catch (Exception e) {
            return false;
        }
    }

    public int getInt(String num) {
        try {
            return Integer.parseInt(num);
        }
        catch (Exception e) {
            return -1;
        }
    }

    public double getFloat(String num) {
        try {
            return Double.parseDouble(num);
        }
        catch (Exception e) {
            return -1;
        }
    }

    public Boolean validAcronym(String input) {
        if (input.length() == 1) return false;
        return input.charAt(0) >= 'a' && input.charAt(0) <= 'z';
    }

    public Boolean validchoices(int[] choices) {
        return choices.length > 0;
    }

    public Boolean availableAcronym(String acronym, String acronyms) {
        return !acronyms.contains(acronym);
    }

    public Boolean validName(String input) {
        return input.length() > 0;
    }

    public Boolean condition(int type, String input, String acronyms, int[] maxIndexes) {
        switch (type) {
            case 0:
                return getInt(input) >= 0;
            case 1:
                return validName(input);
            case 2:
                return validchoices(maxIndexes);
            case 3:
                return validAcronym(input) && availableAcronym(input,acronyms);
            case 4:
                return getFloat(input) >= 0;
            case 5:
                return validResult(input,acronyms,maxIndexes);
            default:
                return true;
        }
    }
}
