package awesomecucumber.factory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class DriverFactory {
    private static ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    public static WebDriver initializeDriver(String browser) {
        WebDriver driver;
        switch (browser){
            case "chrome":
                ChromeOptions options = new ChromeOptions();
                driver = new ChromeDriver(options);
                break;

            case "firefox":
                FirefoxOptions optionsFirefox = new FirefoxOptions();
                driver = new FirefoxDriver(optionsFirefox);
                break;
            default:
                throw new IllegalStateException("Invalid browser: " + browser);
        }

        driver.manage().window().maximize();
        DriverFactory.driver.set(driver);
        return driver;
    }

    public static WebDriver getDriver(){
        return driver.get();
    }
}
