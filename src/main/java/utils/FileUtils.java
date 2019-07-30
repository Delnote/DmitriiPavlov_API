package utils;

import lombok.Getter;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import static Enums.PropSettings.SPELLER_PROPERTY_PATH;

@Getter
public class FileUtils {
    private Properties prop = new Properties();
    private Properties spellerProp = readSpellerPropertiesFromFile(SPELLER_PROPERTY_PATH.getName());
    private String domain = spellerProp.getProperty("speller.path");
    private String paramKey = spellerProp.getProperty("speller.paramKey");

//todo тут нет еще методов, которые бы помгали выгребать конкретную пропертю. Каждый раз при получении проперти читать файл - это неправильно.
// fixed
    private Properties readSpellerPropertiesFromFile(String filePath) {

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
