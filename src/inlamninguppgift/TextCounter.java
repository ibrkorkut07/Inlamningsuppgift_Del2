package inlamninguppgift;

import java.util.List;

public class TextCounter {
    private int lineCount = 0;           // Tracks the number of lines
    private int characterCount = 0;      // Tracks the number of characters
    private int wordCount = 0;           // Tracks the number of words
    private String longestWord = "";     // Stores the longest word found
    private boolean stopCommandEntered = false; // Indicates if "stop" was entered

    // Processes a list of lines, counting lines and characters, stopping if "stop" is encountered
    public void processInput(List<String> lines) {
        for (String line : lines) {
            if (line.equalsIgnoreCase("stop")) {  // Stop command
                stopCommandEntered = true;
                break;
            }
            addLine(line);                        // Count line details if not "stop"
        }
    }

    // Adds a line to line and character counts and updates word-related properties
    private void addLine(String line) {
        lineCount++;                               // Increment line count
        characterCount += line.length();           // Add to character count

        String[] words = line.split("\\s+");       // Split line by spaces to get words
        wordCount += words.length;                 // Add to word count
        updateLongestWord(words);                  // Check for longest word
    }

    // Checks and updates the longest word in the current line
    private void updateLongestWord(String[] words) {
        for (String word : words) {
            if (word.length() > longestWord.length()) {
                longestWord = word;
            }
        }
    }

    // Prints results for Part 2 (lines and characters only)
    public void printResultsPart2() {
        System.out.println("Number of lines (excluding 'stop'): " + lineCount);
        System.out.println("Number of characters (excluding 'stop'): " + characterCount);
    }

    // Prints results for Part 3 (includes words and longest word)
    public void printResultsPart3() {
        printResultsPart2();
        System.out.println("Number of words: " + wordCount);
        System.out.println("Longest word: " + longestWord);
    }

    // Getters for testing
    public int getLineCount() {
        return lineCount;
    }

    public int getCharacterCount() {
        return characterCount;
    }

    public int getWordCount() {
        return wordCount;
    }

    public String getLongestWord() {
        return longestWord;
    }

    public boolean isStopCommandEntered() {
        return stopCommandEntered;
    }

    // Resets all counters and flags (useful for testing)
    public void reset() {
        lineCount = 0;
        characterCount = 0;
        wordCount = 0;
        longestWord = "";
        stopCommandEntered = false;
    }
}
