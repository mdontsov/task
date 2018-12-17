package root;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

public class Task {

    private String line;
    private BufferedReader bufferedReader;

    private void readSourceAndProcessData() throws IOException {

        String propsPath = "src/main/resources/example.properties";
        Map<String, String> propsMap = new HashMap<>();

        String inputPath = new String(Files.readAllBytes(Paths.get("src/main/resources/input.xml")));

        bufferedReader = new BufferedReader(new FileReader(propsPath));
        while ((line = bufferedReader.readLine()) != null) {

            line = line.replace("\"", "");
            String[] parts = line.split("=");
            String key = parts[0];
            String value = parts[1];
            propsMap.put(key, value);
        }

        for (Map.Entry<String, String> entry : propsMap.entrySet()) {
            inputPath = inputPath.replace("${" + entry.getKey() + "}", entry.getValue());
            BufferedWriter writer = new BufferedWriter(new FileWriter("src/main/resources/TEST2.xml"));
            writer.write(inputPath);
            writer.close();
        }
    }

    public static void main(String[] args) throws IOException {

        Task task = new Task();
        task.readSourceAndProcessData();
    }
}
