package inlamninguppgift_WithExplanations; // Declares the package, grouping this test class with other related files.

import org.junit.jupiter.api.BeforeEach; // Imports @BeforeEach annotation for setting up initial conditions for tests.
import org.junit.jupiter.api.Test; // Imports @Test annotation to mark methods as individual test cases.

import java.util.Arrays; // Imports Arrays for creating lists of strings (input data) in test cases.
import java.util.Collections; // Imports Collections to create single-element lists (for cases with one line of input).

import static org.junit.jupiter.api.Assertions.assertEquals; // Imports assertEquals for verifying expected vs. actual values in tests.

public class TextCounterTest_Del2 { // Declares the TextCounterTest_Del2 class to verify TextCounter behavior for Part 2 requirements.
    private TextCounter counter; // Declares a TextCounter instance, used to test different scenarios in each test case.

    @BeforeEach // Specifies that the setUp method should run before each test, ensuring a fresh TextCounter instance.
    public void setUp() {
        counter = new TextCounter(); // Initializes a new TextCounter instance to reset counts before each test case.
    }

    @Test // Marks this as a test case for JUnit.
    public void testMultipleLinesWithStop() { // Tests processing multiple lines with "stop" to ensure correct counting.
        counter.processInput(Arrays.asList("Hello world", "This is a test", "stop")); // Calls processInput with three lines, stopping at "stop".
        counter.printResultsPart2(); // Calls printResultsPart2 to print only the line and character counts.

        assertEquals(2, counter.getLineCount(), "Expected line count to be 2"); // Asserts line count is 2, excluding "stop".
        assertEquals(25, counter.getCharacterCount(), "Expected character count to be 25"); // Asserts character count is 25, excluding "stop".
    }

    @Test // Marks this as a test case for JUnit.
    public void testImmediateStop() { // Tests behavior when "stop" is the first input to verify zero counts.
        counter.processInput(Collections.singletonList("stop")); // Calls processInput with only "stop".
        counter.printResultsPart2(); // Calls printResultsPart2 to print line and character counts, expected to be zero.

        assertEquals(0, counter.getLineCount(), "Expected line count to be 0"); // Asserts line count is 0, as "stop" was the only input.
        assertEquals(0, counter.getCharacterCount(), "Expected character count to be 0"); // Asserts character count is 0, as no characters were counted.
    }

    @Test // Marks this as a test case for JUnit.
    public void testSingleLineWithoutStop() { // Tests processing a single line without "stop" to verify correct counting.
        counter.processInput(Collections.singletonList("Only one line here")); // Calls processInput with one line.
        counter.printResultsPart2(); // Calls printResultsPart2 to print only the line and character counts.

        assertEquals(1, counter.getLineCount(), "Expected line count to be 1"); // Asserts line count is 1 since one line was added.
        assertEquals(18, counter.getCharacterCount(), "Expected character count to be 18"); // Asserts character count is 18, matching the line's length.
    }
}

/*
xplanation Summary:
Imports and Class Declaration:

The imports bring in necessary JUnit annotations and assertion methods.
TextCounterTest_Del2 verifies the functionality of TextCounter specifically for Part 2.
Field and @BeforeEach Setup:

counter is a TextCounter instance used in each test.
setUp() creates a new TextCounter object before each test to ensure a clean slate.
Test Methods:

testMultipleLinesWithStop:

Processes three lines, with "stop" as the last line.
Calls printResultsPart2() to display the line and character counts, excluding "stop".
Asserts that lineCount is 2 and characterCount is 25, excluding "stop".
testImmediateStop:

Tests with "stop" as the only input to check that no lines or characters are counted.
Calls printResultsPart2() to verify zero output for lines and characters.
Asserts lineCount and characterCount are both 0.
testSingleLineWithoutStop:

Processes one line without "stop", verifying basic counting.
Calls printResultsPart2() to print the count results.
Asserts that lineCount is 1 and characterCount is 18, based on the length of the single line.
These explanations detail the purpose and behavior of each line, verifying the TextCounter class functionality for Part 2.
 */