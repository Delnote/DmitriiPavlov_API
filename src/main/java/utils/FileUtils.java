package utils;

import lombok.Getter;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import static Enums.PropSettings.SPELLER_PROPERTY_PATH;

@Getter
public class FileUtils {
    private Properties prop = new Properties();
    private String domain;
    private String paramKey;

    public void readSpellerPropertiesFromFile() {

        try (FileInputStream fis = new FileInputStream(SPELLER_PROPERTY_PATH.getName())) {

            prop.load(fis);
            domain = prop.getProperty("speller.path");
            paramKey = prop.getProperty("speller.paramKey");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
