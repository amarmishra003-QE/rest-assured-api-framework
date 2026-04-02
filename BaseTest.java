import io.restassured.RestAssured;
import org.testng.annotations.BeforeClass;

import java.io.FileInputStream;
import java.util.Properties;

public class BaseTest {

    @BeforeClass
    public void setup() {

        try {
            Properties prop = new Properties();
            FileInputStream fis = new FileInputStream("config.properties");
            prop.load(fis);

            RestAssured.baseURI = prop.getProperty("baseUrl");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}