package org.hyperskill.linearEquationSolver;


import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

    protected final static Pattern IN_PATTERN = Pattern.compile("-in (\\w+\\.txt)");
    protected final static Pattern OUT_PATTERN = Pattern.compile("-out (\\w+\\.txt)");

    public static void main(String[] args) {

    }

    public static String[] checkCommandLine(String[] args) {
        if (args == null) {
            return new String[]{"", ""};
        }
        String filenameInput = "";
        String filenameOutput = "";
        String commandLine = String.join(" ", args);
        Matcher matcher = IN_PATTERN.matcher(commandLine);
        if (matcher.find()) {
            filenameInput = matcher.group(1);
        }
        matcher = OUT_PATTERN.matcher(commandLine);
        if (matcher.find()) {
            filenameOutput = matcher.group(1);
        }
        return new String[]{filenameInput, filenameOutput};
    }


}
