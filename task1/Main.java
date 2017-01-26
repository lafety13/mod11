package task1;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    static String replace(Map<String, String> stringMap) throws IOException {
        File file = new File("src/task1/file.txt");
        if (!file.exists()) file.createNewFile();

        StringBuilder stringBuilder = new StringBuilder();
        Scanner scanner = new Scanner(file);

        while (scanner.hasNext()) {
            String str = scanner.next();

            for (Map.Entry entry : stringMap.entrySet()) {
                str = str.replace((String)entry.getKey(), (String)entry.getValue());
            }
            stringBuilder.append(str).append(" ");

        }
        scanner.close();
        return stringBuilder.toString();
    }

    public static void main(String[] args) throws IOException {
        Map<String, String> stringMap = new HashMap<>();
        stringMap.put("hello", "bye");
        stringMap.put("qw", "1234567");

        System.out.println(replace(stringMap));
    }
}
