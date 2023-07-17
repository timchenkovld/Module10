package homework10;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PhoneNumberValidator {
    private static final String ABSOLUTE_PATH = "src/main/java/homework10/file1.txt";

    public void validateNumbersFromFile() {
        File file = new File(ABSOLUTE_PATH);
        if (!file.exists()) {
            throw new RuntimeException("File with name " + file.getName() + " doesn't exist");
        }
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String phoneNumber = reader.readLine();
            while (phoneNumber != null) {
                if (isValidNumber(phoneNumber)) {
                    System.out.println(phoneNumber);
                }
                phoneNumber = reader.readLine();
            }
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }

    public boolean isValidNumber(String phoneNumber) {
        Pattern pattern1 = Pattern.compile("\\(\\d{3}\\) \\d{3}-\\d{4}");
        Matcher matcher1 = pattern1.matcher(phoneNumber);
        if (matcher1.matches()) {
            return true;
        }
        Pattern pattern2 = Pattern.compile("\\d{3}-\\d{3}-\\d{4}");
        Matcher matcher2 = pattern2.matcher(phoneNumber);
        if (matcher2.matches()) {
            return true;
        }

        return false;
    }
}