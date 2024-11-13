package inlamninguppgift;

import java.util.List;

public class TextCounter {
    private int lineCount = 0;
    private int characterCount = 0;
    private int wordCount = 0;
    private String longestWord = "";
    private boolean stopCommandEntered = false;

    // To process a list of lines, counting lines and characters (stop if "stop" is encountered)
    public void processInput(List<String> lines) {
        for (String line : lines) {
            if (line.equalsIgnoreCase("stop")) {
                stopCommandEntered = true;
                break;
            }
            addLine(line);
        }
    }

    // To add a line to line and character counts and to update word-related properties
    private void addLine(String line) {
        lineCount++;
        characterCount += line.length();

        String[] words = line.split("\\s+");
        wordCount += words.length;
        updateLongestWord(words);
    }

    // To check and update the longest word in the current line
    private void updateLongestWord(String[] words) {
        for (String word : words) {
            if (word.length() > longestWord.length()) {
                longestWord = word;
            }
        }
    }

    // To print results for Del 2 (lines and characters only)
    public void printResultsPart2() {
        System.out.println("Number of lines (excluding 'stop'): " + lineCount);
        System.out.println("Number of characters (excluding 'stop'): " + characterCount);
    }

    // To print results for Del 3 (includes words and longest word)
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

    // To reset all counters and "stopCommandEntered" flag
    public void reset() {
        lineCount = 0;
        characterCount = 0;
        wordCount = 0;
        longestWord = "";
        stopCommandEntered = false;
    }
}
