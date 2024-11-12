package inlamninguppgift;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.Arrays;
import java.util.Collections;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TextCounterTest_Del2 {
    public TextCounter counter;

    @BeforeEach
    public void setUp() {
        counter = new TextCounter();
    }

    @Test
    public void testMultipleLinesWithStop() {
        counter.processInput(Arrays.asList("Hello, my name is Ibrahim", "Testing multiple lines", "stop"));
        counter.printResultsPart2();  // prints number of lines and characters excluding "stop"
        assertEquals(2, counter.getLineCount(), "Expected line count to be 2");
        assertEquals(47, counter.getCharacterCount(), "Expected character count to be 47");
    }

    @Test
    public void testImmediateStop() {
        counter.processInput(Collections.singletonList("stop"));
        counter.printResultsPart2();  // prints  number of lines and characters excluding "stop"
        assertEquals(0, counter.getLineCount(), "Expected line count to be 0");
        assertEquals(0, counter.getCharacterCount(), "Expected character count to be 0");
    }

    @Test
    public void testSingleLineWithoutStop() {
        counter.processInput(Collections.singletonList("Testing only one line"));
        counter.printResultsPart2();  // prints  number of lines and characters excluding "stop"
        assertEquals(1, counter.getLineCount(), "Expected line count to be 1");
        assertEquals(21, counter.getCharacterCount(), "Expected character count to be 21");
    }
}
