package task4;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    private static int checkWord(String word) throws IOException {
        File file = new File("src/task4/file.txt");
        if (!file.exists()) file.createNewFile();

        Scanner scanner = new Scanner(file);

        int wordCounter = 0;
        while (scanner.hasNext()) {
            if (scanner.next().equals(word)) {
                wordCounter++;
            }
        }
        scanner.close();
        return wordCounter;
    }

    public static void main(String[] args) throws IOException {
        System.out.println(checkWord("hello"));
    }
}
