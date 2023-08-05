//TASK-02 WORD COUNTER

import java.util.Scanner;

public class Wordcounter{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter a text or type 'file' to provide a file path:");
        String Input = sc.nextLine();

        String text = "";

        if (Input.equalsIgnoreCase("file")) {
            System.out.println("Enter the file path:");
            String filePath = sc.nextLine();
            // Read the file content
            text = readFileContent(filePath);
        } else {
            text = Input;
        }

        int wordCount = countWords(text);
        System.out.println("Total word count: " + wordCount);

        sc.close();
    }

    public static int countWords(String text) {
        String[] words = text.split("[\\s\\p{Punct}]+");
        return words.length;
    }

    public static String readFileContent(String filePath) {
        return "";
    }
}
