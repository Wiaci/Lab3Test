package init;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Config {

    private static FileInputStream fileInputStream;
    private static Properties properties;

    static {
        try {
            fileInputStream =
                    new FileInputStream("C:\\Users\\R355-W-4-Stud\\Downloads\\Lab3Test\\src\\main\\resources\\configuration.properties");
            properties = new Properties();
            properties.load(fileInputStream);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fileInputStream != null) try {
                fileInputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static String getProperty(String key) {
        return properties.getProperty(key);
    }
}