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
        counter.processInput(Arrays.asList("Hello world", "This is a test", "stop"));
        counter.printResultsPart3();  // Should print lines, characters, words, and longest word
        assertEquals(2, counter.getLineCount(), "Expected line count to be 2");
        assertEquals(25, counter.getCharacterCount(), "Expected character count to be 25");
        assertEquals(6, counter.getWordCount(), "Expected word count to be 5");
        assertEquals("Hello", counter.getLongestWord(), "Expected longest word to be 'Hello'");
    }

    @Test
    public void testImmediateStop() {
        counter.processInput(Collections.singletonList("stop"));
        counter.printResultsPart3();  // Should print lines, characters, words, and longest word as 0
        assertEquals(0, counter.getLineCount(), "Expected line count to be 0");
        assertEquals(0, counter.getCharacterCount(), "Expected character count to be 0");
        assertEquals(0, counter.getWordCount(), "Expected word count to be 0");
        assertEquals("", counter.getLongestWord(), "Expected longest word to be empty");
    }

    @Test
    public void testSingleLineWithoutStop() {
        counter.processInput(Collections.singletonList("Only one line here"));
        counter.printResultsPart3();  // Should print 1 line, 18 characters, 4 words, and longest word "Only"
        assertEquals(1, counter.getLineCount(), "Expected line count to be 1");
        assertEquals(18, counter.getCharacterCount(), "Expected character count to be 18");
        assertEquals(4, counter.getWordCount(), "Expected word count to be 4");
        assertEquals("Only", counter.getLongestWord(), "Expected longest word to be 'Only'");
    }
}
