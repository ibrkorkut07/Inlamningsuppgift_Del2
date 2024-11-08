package del_01c;

public class TextCounter {
    private int lineCount = 0;
    private int characterCount = 0;

    // Adds a line to the count
    public void addLine(String line) {
        lineCount++;
        characterCount += line.length();
    }

    // Checks if the input is "stop"
    public boolean isStopCommand(String line) {
        return line.equalsIgnoreCase("stop");
    }

    // Getters
    public int getLineCount() {
        return lineCount;
    }

    public int getCharacterCount() {
        return characterCount;
    }
}
