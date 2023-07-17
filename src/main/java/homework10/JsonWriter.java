package homework10;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class JsonWriter {
    private static final String INPUT_FILE_PATH = "src/main/java/homework10/file2.txt";
    private static final String OUTPUT_FILE_PATH = "src/main/java/homework10/user.json";

    public void readFromFile() {
        File inputFile = new File(INPUT_FILE_PATH);
        if (!inputFile.exists()) {
            throw new RuntimeException("Input file " + inputFile.getName() + " doesn't exist");
        }
        List<User> users = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(inputFile))) {
            String header = reader.readLine();
            String line = reader.readLine();
            while (line != null) {
                String[] columns = line.split(" ");
                String name = columns[0];
                int age = Integer.parseInt(columns[1]);
                User user = new User(name, age);
                users.add(user);
                line = reader.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        File outputFile = new File(OUTPUT_FILE_PATH);
        try (Writer writer = new FileWriter(outputFile)) {
            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            gson.toJson(users, writer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}