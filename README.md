                                                        Command Line Text Reader

This project is a command-line program that reads user input until the word "stop" is entered. After "stop" is typed, the program summarizes the input with specific statistics.

Part 2 - Basic Features

The program: 
Reads lines of text from the user until they type "stop."
Displays the total number of characters and lines (excluding the line with "stop").

Structure:
InputReader: Manages input/output with the user.

TextStats: Keeps track of the character and line counts.

Part 3 - Extended Features (more functionality) 

The program:
Counts and displays the total number of words.
Identifies and displays the longest word entered.

Updated Structure:
InputReader: Continues to handle user interaction.

TextStats: Now also counts words, identifies the longest word and checks for "stop."

Testing
JUnit tests verify:
Character and line counting.
Word counting and longest word identification.
