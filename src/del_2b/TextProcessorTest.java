package del_1b;

import java.util.Scanner;

public class TextProcessorTest {

    public void testUserInputCounting() {
        TextCounter counter = new TextCounter();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Test 1: Enter multiple lines of text. Type 'stop' when done:");
        while (true) {
            System.out.print("Input line: ");  // Prompt for clarity
            String line = scanner.nextLine();
            if (counter.isStopCommand(line)) {
                break;
            }
            counter.addLine(line);
        }

        System.out.println("Test 1 results:");
        System.out.println("Lines counted: " + counter.getLineCount());
        System.out.println("Characters counted: " + counter.getCharacterCount());
    }

    public void testImmediateStopCommand() {
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
    }

    public void testSingleLineNoSpaces() {
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
    }

    public static void main(String[] args) {
        TextProcessorTest test = new TextProcessorTest();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Running Test 1...");
        System.out.println("Press Enter to start Test 1.");
        scanner.nextLine(); // Wait for Enter to start Test 1
        test.testUserInputCounting();

        System.out.println("\nRunning Test 2...");
        System.out.println("Press Enter to start Test 2.");
        scanner.nextLine(); // Wait for Enter to start Test 2
        test.testImmediateStopCommand();

        System.out.println("\nRunning Test 3...");
        System.out.println("Press Enter to start Test 3.");
        scanner.nextLine(); // Wait for Enter to start Test 3
        test.testSingleLineNoSpaces();

        scanner.close();
    }
}
