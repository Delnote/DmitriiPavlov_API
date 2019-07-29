package utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class FileUtils {
//todo тут нет еще методов, которые бы помгали выгребать конкретную пропертю. Каждый раз при получении проперти читать файл - это неправильно.
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
