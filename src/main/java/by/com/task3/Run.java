package by.com.task3;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Run {

    public Properties asProperties(String filename) {
        try (InputStream inputStream = this.getClass().getClassLoader().getResourceAsStream(filename)) {
            Properties properties = new Properties();
            properties.load(inputStream);
            return properties;
        } catch (IOException e) {
            throw new RuntimeException(e.getMessage());
        }
    }
    // метод перезаписывает старые имена в проперти файле на новые, не работает
//    public  void replaceProperties(String key, String filename, String value, String writeFile) {
//        try (InputStream inputStream = this.getClass().getClassLoader().getResourceAsStream(filename)) {
//            Properties properties = new Properties();
//            properties.load(inputStream);
//            properties.setProperty(key, value);
//            properties.store(new FileOutputStream(writeFile), null);
//        } catch (IOException e) {
//            throw new RuntimeException(e.getMessage());
//        }
//    }
}