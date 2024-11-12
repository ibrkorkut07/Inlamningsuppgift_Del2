package inlamninguppgift;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TextCounterTest_Del3 {
    private TextCounter counter;

    @BeforeEach
    public void setUp() {
        counter = new TextCounter();
    }

    @Test
    public void testMultipleLinesWithStop() {
        counter.processInput(Arrays.asList("Hello, my name is Ibrahim", "Testing multiple lines", "stop"));
        counter.printResultsPart3();  // prints prints  number of lines, characters, words and longest word
        assertEquals(2, counter.getLineCount(), "Expected line count to be 2");
        assertEquals(47, counter.getCharacterCount(), "Expected character count to be 47");
        assertEquals(8, counter.getWordCount(), "Expected word count to be 8");
        assertEquals("multiple", counter.getLongestWord(), "Expected longest word to be 'multiple'");
    }

    @Test
    public void testImmediateStop() {
        counter.processInput(Collections.singletonList("stop"));
        counter.printResultsPart3();  // prints prints  number of lines, characters, words and longest word
        assertEquals(0, counter.getLineCount(), "Expected line count to be 0");
        assertEquals(0, counter.getCharacterCount(), "Expected character count to be 0");
        assertEquals(0, counter.getWordCount(), "Expected word count to be 0");
        assertEquals("", counter.getLongestWord(), "Expected longest word to be empty");
    }

    @Test
    public void testSingleLineWithoutStop() {
        counter.processInput(Collections.singletonList("Testing only one line"));
        counter.printResultsPart3();  // prints prints  number of lines, characters, words and longest word
        assertEquals(1, counter.getLineCount(), "Expected line count to be 1");
        assertEquals(21, counter.getCharacterCount(), "Expected character count to be 18");
        assertEquals(4, counter.getWordCount(), "Expected word count to be 4");
        assertEquals("Testing", counter.getLongestWord(), "Expected longest word to be 'Testing'");
    }
}
