package del_2c; // Package declaration

// The TextCounter class is responsible for counting lines, characters, words,
// and identifying the longest word in the input provided.
// TextProcessorTest uses this class to verify that these counts are correct.
public class TextCounter {
    private int lineCount = 0; // Tracks the number of lines processed
    private int characterCount = 0; // Tracks the total number of characters
    private int wordCount = 0; // Tracks the total number of words
    private String longestWord = ""; // Stores the longest word encountered

    // Adds a line of text to be processed by updating line, character, and word counts.
    // TextProcessorTest calls this method to process each new line input by the user.
    public void addLine(String line) {
        lineCount++; // Increment line count by 1 each time a new line is added
        characterCount += line.length(); // Add the length of the line to total character count

        // Split the line into words by spaces
        String[] words = line.split("\\s+");
        wordCount += words.length; // Add the number of words in this line to the total word count

        // Determine the longest word in the current line
        for (String word : words) {
            if (word.length() > longestWord.length()) { // Check if current word is the longest
                longestWord = word; // Update longestWord if the current word is longer
            }
        }
    }

    // Checks if the input line matches the "stop" command to end user input
    // TextProcessorTest calls this method to see if the user typed "stop".
    public boolean isStopCommand(String line) {
        return line.equalsIgnoreCase("stop"); // Returns true if line equals "stop" (case-insensitive)
    }

    // Getter for line count, used by TextProcessorTest to verify line counting
    public int getLineCount() {
        return lineCount;
    }

    // Getter for character count, used by TextProcessorTest to verify character counting
    public int getCharacterCount() {
        return characterCount;
    }

    // Getter for word count, used by TextProcessorTest to verify word counting
    public int getWordCount() {
        return wordCount;
    }

    // Getter for the longest word, used by TextProcessorTest to verify tracking of longest word
    public String getLongestWord() {
        return longestWord;
    }
}
