package del_2_MainMethod;

import java.util.Scanner;

public class TextReader {
    private TextCounter counter;

    // Constructor to initialize the TextCounter
    public TextReader(TextCounter counter) {
        this.counter = counter;
    }

    // Method to read input from the user and process it
    public void readText() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please write a text. Type 'stop' to finish.");

        String line;
        // Continue reading input until "stop" is typed
        while (true) {
            line = scanner.nextLine();
            if (counter.isStop(line)) {
                break; // Stop reading when "stop" is typed
            }
            counter.addLine(line); // Add the line to the counter for processing
        }
        scanner.close();

        // Output the results after "stop" is typed
        System.out.println("Number of lines: " + counter.getLineCount());
        System.out.println("Number of characters: " + counter.getCharacterCount());
        System.out.println("Number of spaces: " + counter.getSpaceCount());
    }

    // Main method to run the program
    public static void main(String[] args) {
        TextCounter counter = new TextCounter();
        TextReader reader = new TextReader(counter);
        reader.readText();
    }
}
