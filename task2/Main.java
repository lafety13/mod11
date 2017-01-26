package task2;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    private static File fileContentReplacer(Map<String, String> stringMap) throws IOException {
        File file = new File("src/task2/file.txt");
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

        String path = reWriteFile(stringBuilder.toString()).toString();
        scanner.close();
        System.out.println(stringBuilder.toString());
        return new File(path);
    }

    private static Path reWriteFile(String s) throws IOException {
        return Files.write(Paths.get("src/task2/file.txt"), s.getBytes());
    }

    public static void main(String[] args) throws IOException {
        Map<String, String> stringMap = new HashMap<>();
        stringMap.put("hello", "bye");
        stringMap.put("qw", "1234567");

        fileContentReplacer(stringMap);
    }
}
