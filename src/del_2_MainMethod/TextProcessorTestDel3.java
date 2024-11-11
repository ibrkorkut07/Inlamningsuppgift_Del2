//package del_2_MainMethod;
//import java.util.Scanner;
//
//public class TextProcessorTestDel3 {
//    public static void main(String[] args) {
//        del_2_MainMethod.TextCounter counter = new TextCounter();
//        Scanner scanner = new Scanner(System.in);
//
//        System.out.println("Enter lines of text. Type 'stop' when done:");
//
//        // Loop to accept user input until "stop" is entered
//        while (true) {
//            System.out.print("Input line: ");
//            String line = scanner.nextLine();
//            if (counter.isStopCommand(line)) {
//                break;
//            }
//            counter.addLine(line);
//        }
//
//        // Display results
//        System.out.println("\nResults:");
//        System.out.println("Lines counted: " + counter.getLineCount());
//        System.out.println("Characters counted: " + counter.getCharacterCount());
//        System.out.println("Words counted: " + counter.getWordCount());
//        System.out.println("Longest word: " + counter.getLongestWord());
//
//        // Basic assertions for testing
//        if (counter.getLineCount() > 0) {
//            System.out.println("Line count is valid.");
//        } else {
//            System.out.println("Expected more than 0 lines.");
//        }
//
//        if (counter.getCharacterCount() > 0) {
//            System.out.println("Character count is valid.");
//        } else {
//            System.out.println("Expected more than 0 characters.");
//        }
//
//        if (counter.getWordCount() > 0) {
//            System.out.println("Word count is valid.");
//        } else {
//            System.out.println("Expected more than 0 words.");
//        }
//
//        if (counter.getLongestWord().length() > 0) {
//            System.out.println("Longest word is valid.");
//        } else {
//            System.out.println("Expected a non-empty longest word.");
//        }
//
//        scanner.close();
//    }
//}
