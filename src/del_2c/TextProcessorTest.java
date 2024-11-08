package del_1c;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.Scanner;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public class TextProcessorTest {

    private TextCounter counter;
    private Scanner scanner;

    @BeforeEach
    void setUp() {
        counter = new TextCounter();
        scanner = new Scanner(System.in);
    }

    @Test
    void testUserInputCounting() {
        System.out.println("Test 1: Enter multiple lines of text. Type 'stop' when done:");

        while (true) {
            System.out.print("Input line: ");
            String line = scanner.nextLine();
            if (counter.isStopCommand(line)) {
                break;
            }
            counter.addLine(line);
        }

        System.out.println("Test 1 results:");
        System.out.println("Lines counted: " + counter.getLineCount());
        System.out.println("Characters counted: " + counter.getCharacterCount());

        // Assertion example (adjust based on expected input):
        assertTrue(counter.getLineCount() > 0, "Expected more than 0 lines");
        assertTrue(counter.getCharacterCount() > 0, "Expected more than 0 characters");
    }

    @Test
    void testImmediateStopCommand() {
        System.out.println("Test 2: Type 'stop' immediately without any other input:");
        System.out.print("Input: ");

        String line = scanner.nextLine();
        if (!counter.isStopCommand(line)) {
            counter.addLine(line);
        }

        System.out.println("Test 2 results:");
        System.out.println("Lines counted: " + counter.getLineCount());  // Expected: 0
        System.out.println("Characters counted: " + counter.getCharacterCount());  // Expected: 0

        assertEquals(0, counter.getLineCount(), "Expected 0 lines");
        assertEquals(0, counter.getCharacterCount(), "Expected 0 characters");
    }

    @Test
    void testSingleLineNoSpaces() {
        System.out.println("Test 3: Enter a single line without spaces. Then type 'stop':");

        while (true) {
            System.out.print("Input line: ");
            String line = scanner.nextLine();
            if (counter.isStopCommand(line)) {
                break;
            }
            counter.addLine(line);
        }

        System.out.println("Test 3 results:");
        System.out.println("Lines counted: " + counter.getLineCount());
        System.out.println("Characters counted: " + counter.getCharacterCount());

        assertEquals(1, counter.getLineCount(), "Expected 1 line for single line input");
        assertTrue(counter.getCharacterCount() > 0, "Expected non-zero character count");
    }
}

/*
 JUnit can technically handle interactive input by design, though it’s generally not common practice
 for automated testing. However, if you are encountering issues with the "read-only" console error in IntelliJ,
 it’s likely due to the IDE’s handling of interactive console input within JUnit tests.

Here are some final steps to ensure interactive input works within JUnit in IntelliJ:

Step 1: Confirm IntelliJ Run/Debug Configuration Settings
Ensure that Emulate terminal in output console is enabled:

Go to Run > Edit Configurations in IntelliJ.
Select your JUnit test configuration.
Check if there’s an Emulate terminal in output console option. If so, make sure it is enabled. This will allow
the console to act more like a terminal, supporting interactive input.
Step 2: Run Each JUnit Test Individually
Running all tests sequentially may cause IntelliJ to restrict console input for later tests.
Try running each test individually:

Right-click on the test method (e.g., testUserInputCounting()) and select Run.
Enter input as prompted by the console for each test.
Step 3: Updated Code for Interactive Console Input in JUnit Tests
If the above settings are configured, the following code should allow you to enter
interactive input in IntelliJ’s console directly within each test.

java
Copy code
package del_1b;

import org.junit.jupiter.api.Test;
import java.util.Scanner;
import static org.junit.jupiter.api.Assertions.*;

public class TextProcessorTest {

    @Test
    void testUserInputCounting() {
        TextCounter counter = new TextCounter();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Test 1: Enter multiple lines of text. Type 'stop' when done:");
        while (true) {
            System.out.print("Input line: ");
            String line = scanner.nextLine();
            if (counter.isStopCommand(line)) {
                break;
            }
            counter.addLine(line);
        }

        System.out.println("Test 1 results:");
        System.out.println("Lines counted: " + counter.getLineCount());
        System.out.println("Characters counted: " + counter.getCharacterCount());

        assertTrue(counter.getLineCount() > 0, "Expected more than 0 lines");
        assertTrue(counter.getCharacterCount() > 0, "Expected more than 0 characters");
    }

    @Test
    void testImmediateStopCommand() {
        TextCounter counter = new TextCounter();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Test 2: Type 'stop' immediately without any other input:");
        System.out.print("Input: ");

        String line = scanner.nextLine();
        if (!counter.isStopCommand(line)) {
            counter.addLine(line);
        }

        System.out.println("Test 2 results:");
        System.out.println("Lines counted: " + counter.getLineCount());  // Expected: 0
        System.out.println("Characters counted: " + counter.getCharacterCount());  // Expected: 0

        assertEquals(0, counter.getLineCount(), "Expected 0 lines");
        assertEquals(0, counter.getCharacterCount(), "Expected 0 characters");
    }

    @Test
    void testSingleLineNoSpaces() {
        TextCounter counter = new TextCounter();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Test 3: Enter a single line without spaces. Then type 'stop':");
        while (true) {
            System.out.print("Input line: ");
            String line = scanner.nextLine();
            if (counter.isStopCommand(line)) {
                break;
            }
            counter.addLine(line);
        }

        System.out.println("Test 3 results:");
        System.out.println("Lines counted: " + counter.getLineCount());
        System.out.println("Characters counted: " + counter.getCharacterCount());

        assertEquals(1, counter.getLineCount(), "Expected 1 line for single line input");
        assertTrue(counter.getCharacterCount() > 0, "Expected non-zero character count");
    }
}
Summary
Run/Debug Configuration: Check that Emulate terminal in output console is enabled in IntelliJ.
Individual Test Execution: Run each test individually and enter input when prompted.
JUnit Console Input: If configured correctly, IntelliJ should allow interactive input within each JUnit test.
This setup should enable interactive input for JUnit tests in IntelliJ’s console. Let me know
if this solution works for you or if you’re encountering additional issues.

 */