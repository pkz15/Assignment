package utils;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigProperties {

    // Declare a static Properties object
    public static Properties property;

    // Path to the configuration file
    private static final String CONFIG_PATH = System.getProperty("user.dir") + "/" +"src/test/resources/config/config.properties";

    // Method to initialize the Properties object
    public static void initializePropertyFile() {
        property = new Properties();

        try (FileInputStream instm = new FileInputStream(CONFIG_PATH)) {
            
            property.load(instm);
            System.out.println("Configuration file loaded successfully.");
        } catch (FileNotFoundException e) {
            System.err.println("Configuration file not found: " + CONFIG_PATH);
            e.printStackTrace();
        } catch (IOException e) {
            System.err.println("Error reading the configuration file.");
            e.printStackTrace();
        }
    }
}


    