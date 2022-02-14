package config;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Config {

    private static final String LINUX_DRIVER = "drivers/chromedriver";
    private static final String WINDOWS_DRIVER = "drivers/chromedriver.exe";
    // This property would be resolved depending on the environment
    private final static String BASE_URL = "http://api.blockcypher.com/v1/btc/main/blocks/";

    public static WebDriver getDriver() {
        String OS = System.getProperty("os.name");
        System.out.println(OS);
        switch (OS) {
            case "Linux":
                System.setProperty("webdriver.chrome.driver", LINUX_DRIVER); 
                break;
            case "Windows 10": case "Windows 11":
                System.setProperty("webdriver.chrome.driver", WINDOWS_DRIVER);
                break;
        }
        return new ChromeDriver();
    }

    public static String getBaseUrl() {
        return BASE_URL;
    }

}
