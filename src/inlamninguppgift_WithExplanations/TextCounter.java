package inlamninguppgift_WithExplanations; // Declares the package, organizing this class with related files.

import java.util.List; // Imports List from java.util, allowing us to use List<String> to handle multiple lines of input.

public class TextCounter { // Declares the TextCounter class, responsible for counting lines, characters, words, and identifying the longest word.

    private int lineCount = 0;           // Tracks the number of lines processed, starting from 0.
    private int characterCount = 0;      // Tracks the total number of characters processed, starting from 0.
    private int wordCount = 0;           // Tracks the total number of words processed, starting from 0.
    private String longestWord = "";     // Stores the longest word encountered, initially set to an empty string.
    private boolean stopCommandEntered = false; // Indicates if the "stop" command has been entered, starting as false.

    // Processes a list of lines, counting lines, characters, and words, and stops processing if "stop" is encountered.
    public void processInput(List<String> lines) {
        for (String line : lines) { // Loops through each line in the list.
            if (line.equalsIgnoreCase("stop")) { // Checks if the line matches "stop" (case-insensitive).
                stopCommandEntered = true;      // Sets stopCommandEntered to true if "stop" is found.
                break;                          // Exits the loop to stop processing further lines.
            }
            addLine(line);                      // Processes the line and updates counts if it is not "stop".
        }
    }

    // Adds a line to update line, character, and word counts and finds the longest word in the line.
    private void addLine(String line) {
        lineCount++;                             // Increments lineCount by 1 for each processed line.
        characterCount += line.length();         // Adds the number of characters in the line to characterCount.

        String[] words = line.split("\\s+");     // Splits the line into words using whitespace as the delimiter.
        wordCount += words.length;               // Adds the count of words in this line to the total word count.
        updateLongestWord(words);                // Checks for the longest word in the line.
    }

    // Checks each word to update the longest word encountered in the current line.
    private void updateLongestWord(String[] words) {
        for (String word : words) {              // Iterates through each word in the array.
            if (word.length() > longestWord.length()) { // Compares word length to the current longest word.
                longestWord = word;              // Updates longestWord if the current word is longer.
            }
        }
    }

    // Prints results for Part 2 requirements, displaying only the number of lines and characters.
    public void printResultsPart2() {
        System.out.println("Number of lines (excluding 'stop'): " + lineCount);  // Prints line count, excluding "stop".
        System.out.println("Number of characters (excluding 'stop'): " + characterCount); // Prints character count, excluding "stop".
    }

    // Prints results for Part 3 requirements, adding word count and longest word to the output.
    public void printResultsPart3() {
        printResultsPart2(); // Calls printResultsPart2 to display line and character counts first.
        System.out.println("Number of words: " + wordCount); // Prints the total word count.
        System.out.println("Longest word: " + longestWord); // Prints the longest word encountered.
    }

    // Getter for line count, useful for verifying line count in tests.
    public int getLineCount() {
        return lineCount; // Returns the total number of lines, excluding "stop".
    }

    // Getter for character count, useful for verifying character count in tests.
    public int getCharacterCount() {
        return characterCount; // Returns the total number of characters, excluding "stop".
    }

    // Getter for word count, useful for verifying word count in tests.
    public int getWordCount() {
        return wordCount; // Returns the total number of words.
    }

    // Getter for the longest word, useful for verifying the longest word in tests.
    public String getLongestWord() {
        return longestWord; // Returns the longest word encountered.
    }

    // Getter to check if "stop" was entered, useful for verifying if processing stopped.
    public boolean isStopCommandEntered() {
        return stopCommandEntered; // Returns true if "stop" was encountered during processing.
    }

    // Resets all counters and flags, useful for resetting the state in tests.
    public void reset() {
        lineCount = 0;            // Resets line count to zero.
        characterCount = 0;       // Resets character count to zero.
        wordCount = 0;            // Resets word count to zero.
        longestWord = "";         // Clears the longest word.
        stopCommandEntered = false; // Resets the stop command flag to false.
    }
}

/*
Explanation Summary:
Field Declarations:
lineCount, characterCount, wordCount, longestWord, and stopCommandEntered track cumulative counts and the longest word, and detect the "stop" command.
Methods:
processInput(List<String> lines): Processes lines, stops on "stop".
addLine(String line): Adds line details to counts and checks for longest word.
updateLongestWord(String[] words): Finds the longest word in the current line.
printResultsPart2() and printResultsPart3(): Display counts based on the requirements for Part 2 and Part 3.
reset(): Clears all fields for a clean state, useful in testing.
These explanations cover each line and its purpose, with connections to how fields are updated and methods interact with each other to fulfill the requirements. Let me know if further clarification is needed.
 */