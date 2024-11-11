package inlamninguppgift;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TextCounterTest_Del2 {
    private TextCounter counter;

    @BeforeEach
    public void setUp() {
        counter = new TextCounter();
    }

    @Test
    public void testMultipleLinesWithStop() {
        counter.processInput(Arrays.asList("Hello world", "This is a test", "stop"));
        counter.printResultsPart2();  // Should print lines and characters excluding "stop"
        assertEquals(2, counter.getLineCount(), "Expected line count to be 2");
        assertEquals(25, counter.getCharacterCount(), "Expected character count to be 25");
    }

    @Test
    public void testImmediateStop() {
        counter.processInput(Collections.singletonList("stop"));
        counter.printResultsPart2();  // Should print lines and characters as 0
        assertEquals(0, counter.getLineCount(), "Expected line count to be 0");
        assertEquals(0, counter.getCharacterCount(), "Expected character count to be 0");
    }

    @Test
    public void testSingleLineWithoutStop() {
        counter.processInput(Collections.singletonList("Only one line here"));
        counter.printResultsPart2();  // Should print 1 line and 18 characters
        assertEquals(1, counter.getLineCount(), "Expected line count to be 1");
        assertEquals(18, counter.getCharacterCount(), "Expected character count to be 18");
    }
}
