package del_2;

public class TextCounter {
    private int lineCount;
    private int characterCount;
    private int spaceCount;

    public TextCounter() {
        this.lineCount = 0;
        this.characterCount = 0;
        this.spaceCount = 0;
    }

    // Method to add a line and count its characters and spaces
    public void addLine(String line) {
        lineCount++;
        characterCount += line.length();
        spaceCount += countSpaces(line);
    }

    // Method to check if the input line is "stop"
    public boolean isStop(String line) {
        return line.equalsIgnoreCase("stop");
    }

    // Method to count spaces in a line
    private int countSpaces(String line) {
        int spaces = 0;
        for (char ch : line.toCharArray()) {
            if (ch == ' ') {
                spaces++;
            }
        }
        return spaces;
    }

    // Getters for line count, character count, and space count
    public int getLineCount() {
        return lineCount;
    }

    public int getCharacterCount() {
        return characterCount;
    }

    public int getSpaceCount() {
        return spaceCount;
    }
}
