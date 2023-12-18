package tools;

public class ColorOutput {
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_RESET = "\u001B[0m";

    public String greenMessage(String message) {
        StringBuilder sb = new StringBuilder();
        sb.append(ANSI_GREEN);
        sb.append(message);
        sb.append(ANSI_RESET);
        return sb.toString();
    }

    public String redMessage(String message) {
        StringBuilder sb = new StringBuilder();
        sb.append(ANSI_RED);
        sb.append(message);
        sb.append(ANSI_RESET);
        return sb.toString();
    }

    public String yellowMessage(String message) {
        StringBuilder sb = new StringBuilder();
        sb.append(ANSI_YELLOW);
        sb.append(message);
        sb.append(ANSI_RESET);
        return sb.toString();
    }

    public String cyanMessage(String message) {
        StringBuilder sb = new StringBuilder();
        sb.append(ANSI_CYAN);
        sb.append(message);
        sb.append(ANSI_RESET);
        return sb.toString();
    }

    public String blueMessage(String message) {
        StringBuilder sb = new StringBuilder();
        sb.append(ANSI_BLUE);
        sb.append(message);
        sb.append(ANSI_RESET);
        return sb.toString();
    }

    public String purpleMessage(String message) {
        StringBuilder sb = new StringBuilder();
        sb.append(ANSI_PURPLE);
        sb.append(message);
        sb.append(ANSI_RESET);
        return sb.toString();
    }
}
