package inlamninguppgift_WithExplanations; // Declares the package, grouping this test class with other related files.

import org.junit.jupiter.api.BeforeEach; // Imports @BeforeEach annotation for setting up initial conditions for tests.
import org.junit.jupiter.api.Test; // Imports @Test annotation to mark methods as individual test cases.

import java.util.Arrays; // Imports Arrays for creating lists of strings (input data) in test cases.
import java.util.Collections; // Imports Collections to create single-element lists (for cases with one line of input).

import static org.junit.jupiter.api.Assertions.assertEquals; // Imports assertEquals for verifying expected vs. actual values in tests.

public class TextCounterTest_Del3 { // Declares the TextCounterTest_Del3 class to verify TextCounter behavior for Part 3 requirements.
    private TextCounter counter; // Declares a TextCounter instance to test different scenarios in each test case.

    @BeforeEach // Specifies that the setUp method should run before each test, ensuring a fresh TextCounter instance.
    public void setUp() {
        counter = new TextCounter(); // Initializes a new TextCounter instance to reset counts before each test case.
    }

    @Test // Marks this as a test case for JUnit.
    public void testMultipleLinesWithStop() { // Tests processing multiple lines with "stop" to ensure correct counting.
        counter.processInput(Arrays.asList("Hello world", "This is a test", "stop")); // Calls processInput with three lines, stopping at "stop".
        counter.printResultsPart3(); // Calls printResultsPart3 to print line, character, word counts, and longest word.

        assertEquals(2, counter.getLineCount(), "Expected line count to be 2"); // Asserts line count is 2, excluding "stop".
        assertEquals(25, counter.getCharacterCount(), "Expected character count to be 25"); // Asserts character count is 25, excluding "stop".
        assertEquals(6, counter.getWordCount(), "Expected word count to be 6"); // Asserts word count is 6.
        assertEquals("Hello", counter.getLongestWord(), "Expected longest word to be 'Hello'"); // Asserts longest word is "Hello".
    }

    @Test // Marks this as a test case for JUnit.
    public void testImmediateStop() { // Tests behavior when "stop" is the first input to verify zero counts.
        counter.processInput(Collections.singletonList("stop")); // Calls processInput with only "stop".
        counter.printResultsPart3(); // Calls printResultsPart3 to print line, character, word counts, and longest word.

        assertEquals(0, counter.getLineCount(), "Expected line count to be 0"); // Asserts line count is 0, as "stop" was the only input.
        assertEquals(0, counter.getCharacterCount(), "Expected character count to be 0"); // Asserts character count is 0, as no characters were counted.
        assertEquals(0, counter.getWordCount(), "Expected word count to be 0"); // Asserts word count is 0, as no words were counted.
        assertEquals("", counter.getLongestWord(), "Expected longest word to be empty"); // Asserts longest word is empty since no words were processed.
    }

    @Test // Marks this as a test case for JUnit.
    public void testSingleLineWithoutStop() { // Tests processing a single line without "stop" to verify correct counting.
        counter.processInput(Collections.singletonList("Only one line here")); // Calls processInput with one line.
        counter.printResultsPart3(); // Calls printResultsPart3 to print line, character, word counts, and longest word.

        assertEquals(1, counter.getLineCount(), "Expected line count to be 1"); // Asserts line count is 1 since one line was added.
        assertEquals(18, counter.getCharacterCount(), "Expected character count to be 18"); // Asserts character count is 18, matching the line's length.
        assertEquals(4, counter.getWordCount(), "Expected word count to be 4"); // Asserts word count is 4, counting each word in the line.
        assertEquals("Only", counter.getLongestWord(), "Expected longest word to be 'Only'"); // Asserts longest word is "Only".
    }
}

/*
Explanation Summary:
Imports and Class Declaration:

The imports bring in necessary JUnit annotations and assertion methods.
TextCounterTest_Del3 is designed to verify the functionality of TextCounter for Part 3 requirements (including words and longest word).
Field and @BeforeEach Setup:

counter is a TextCounter instance used in each test.
setUp() creates a new TextCounter object before each test to ensure a clean slate.
Test Methods:

testMultipleLinesWithStop:

Processes three lines, with "stop" as the last line.
Calls printResultsPart3() to display the counts for lines, characters, words, and the longest word, excluding "stop".
Asserts lineCount is 2, characterCount is 25, wordCount is 6, and longestWord is "Hello".
testImmediateStop:

Tests with "stop" as the only input to check that no lines, characters, or words are counted, and that the longest word is empty.
Calls printResultsPart3() to verify zero output for lines, characters, words, and longest word.
Asserts lineCount, characterCount, and wordCount are all 0, and longestWord is empty.
testSingleLineWithoutStop:

Processes one line without "stop", verifying basic counting.
Calls printResultsPart3() to print the results, including line, character, word count, and longest word.
Asserts lineCount is 1, characterCount is 18, wordCount is 4, and longestWord is "Only".
These explanations cover each line's purpose and how each part of TextCounterTest_Del3 interacts with TextCounter to fulfill Part 3 requirements.
 */