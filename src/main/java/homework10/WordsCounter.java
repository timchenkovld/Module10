package homework10;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class WordsCounter {
    private static final String ABSOLUTE_PATH = "src/main/java/homework10/words.txt";
    private int theCounter = 0;
    private int isCounter = 0;
    private int sunnyCounter = 0;
    private int dayCounter = 0;

    public void wordsCountFromFile() {
        File file = new File(ABSOLUTE_PATH);
        if (!file.exists()) {
            throw new RuntimeException("File with name " + file.getName() + " doesn't exist");
        }
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line = reader.readLine();
            while (line != null) {
                countWordsInLine(line);
                line = reader.readLine();
            }
            printWordCounts();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void countWordsInLine(String line) {
        String[] words = line.split("\\s+");
        for (String word : words) {
            if (word.equals("the")) {
                theCounter++;
            }
            if (word.equals("is")) {
                isCounter++;
            }
            if (word.equals("sunny")) {
                sunnyCounter++;
            }
            if (word.equals("day")) {
                dayCounter++;
            }
        }
    }
    private void printWordCounts() {
        System.out.println("the " + theCounter);
        System.out.println("is " + isCounter);
        System.out.println("sunny " + sunnyCounter);
        System.out.println("day " + dayCounter);
    }
}
