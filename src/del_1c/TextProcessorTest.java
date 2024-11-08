package del_01c;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Scanner;

public class TextProcessorTest {

    @Test
    void testUserInputCounting() {
        TextCounter counter = new TextCounter();

        // Simulate user input with multiple lines ending in "stop"
        String simulatedInput = "Hello\nWorld\nstop\n";
        InputStream originalIn = System.in;
        System.setIn(new ByteArrayInputStream(simulatedInput.getBytes()));

        Scanner scanner = new Scanner(System.in);

        while (true) {
            String line = scanner.nextLine();
            if (counter.isStopCommand(line)) {
                break;
            }
            counter.addLine(line);
        }

        // Verify the expected results for multiple lines input
        assertEquals(2, counter.getLineCount(), "Expected 2 lines");
        assertEquals(10, counter.getCharacterCount(), "Expected 10 characters");

        // Reset System.in to its original state
        System.setIn(originalIn);
        scanner.close();
    }

    @Test
    void testImmediateStopCommand() {
        TextCounter counter = new TextCounter();

        // Simulate immediate "stop" input
        String simulatedInput = "stop\n";
        InputStream originalIn = System.in;
        System.setIn(new ByteArrayInputStream(simulatedInput.getBytes()));

        Scanner scanner = new Scanner(System.in);

        String line = scanner.nextLine();
        if (!counter.isStopCommand(line)) {
            counter.addLine(line);
        }

        // Verify that no lines or characters were counted
        assertEquals(0, counter.getLineCount(), "Expected 0 lines");
        assertEquals(0, counter.getCharacterCount(), "Expected 0 characters");

        // Reset System.in to its original state
        System.setIn(originalIn);
        scanner.close();
    }

    @Test
    void testSingleLineNoSpaces() {
        TextCounter counter = new TextCounter();

        // Simulate a single line input without spaces, followed by "stop"
        String simulatedInput = "HelloWorld\nstop\n";
        InputStream originalIn = System.in;
        System.setIn(new ByteArrayInputStream(simulatedInput.getBytes()));

        Scanner scanner = new Scanner(System.in);

        while (true) {
            String line = scanner.nextLine();
            if (counter.isStopCommand(line)) {
                break;
            }
            counter.addLine(line);
        }

        // Verify the expected results for a single line input
        assertEquals(1, counter.getLineCount(), "Expected 1 line");
        assertEquals(10, counter.getCharacterCount(), "Expected 10 characters");

        // Reset System.in to its original state
        System.setIn(originalIn);
        scanner.close();
    }
}
