package utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class FileUtils {

    public static Properties readSpellerPropertiesFromFile(String filePath) {
        Properties prop = new Properties();

        try (FileInputStream fis = new FileInputStream(filePath)) {
            if (fis == null) {
                System.out.println("Sorry, unable to find user.properties");
            }
            prop.load(fis);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return prop;
    }
}
