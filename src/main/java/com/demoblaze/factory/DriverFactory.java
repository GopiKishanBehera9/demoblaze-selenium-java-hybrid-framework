package com.demoblaze.factory;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import com.demoblaze.config.ConfigReader;
import com.demoblaze.driver.DriverManager;
import com.demoblaze.enums.BrowserType;
import com.demoblaze.exceptions.InvalidBrowserException;

import io.github.bonigarcia.wdm.WebDriverManager;

/**
 * DriverFactory
 *
 * Creates browser instances based on configuration.
 *
 * @author Gopi Kishan Behera
 */
public final class DriverFactory {

    private DriverFactory() {
        throw new IllegalStateException("Utility class");
    }

    public static void initDriver() {
    	
    	System.out.println("===== DriverFactory Started =====");
    	
        String browserName = ConfigReader.getProperty("browser");
        System.out.println(browserName);
        boolean headless = Boolean.parseBoolean(ConfigReader.getProperty("headless"));
        System.out.println(headless);
        boolean incognito = Boolean.parseBoolean(ConfigReader.getProperty("incognito"));
        System.out.println(incognito);
        BrowserType browser = BrowserType.valueOf(browserName.toUpperCase());

        WebDriver driver;

        switch (browser) {

        case CHROME:
        	
        	System.out.println("Setting up ChromeDriver");
            WebDriverManager.chromedriver().setup();

            ChromeOptions chromeOptions = new ChromeOptions();
            

            if (headless) {
                chromeOptions.addArguments("--headless=new");
            }

            if (incognito) {
                chromeOptions.addArguments("--incognito");
            }

            System.out.println("Creating ChromeDriver...");
            driver = new ChromeDriver(chromeOptions);
            System.out.println("ChromeDriver Created");

            break;

        case EDGE:

            WebDriverManager.edgedriver().setup();

            EdgeOptions edgeOptions = new EdgeOptions();

            if (headless) {
                edgeOptions.addArguments("--headless=new");
            }

            if (incognito) {
                edgeOptions.addArguments("--inprivate");
            }

            driver = new EdgeDriver(edgeOptions);

            break;

        case FIREFOX:

            WebDriverManager.firefoxdriver().setup();

            FirefoxOptions firefoxOptions = new FirefoxOptions();

            if (headless) {
                firefoxOptions.addArguments("-headless");
            }

            driver = new FirefoxDriver(firefoxOptions);

            break;

        default:

        	throw new InvalidBrowserException(
        	        "Unsupported browser : " + browserName);

        }

        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();

        driver.manage().timeouts().implicitlyWait(
                Duration.ofSeconds(Integer.parseInt(ConfigReader.getProperty("implicit.wait"))));

        driver.manage().timeouts().pageLoadTimeout(
                Duration.ofSeconds(Integer.parseInt(ConfigReader.getProperty("page.load.timeout"))));

        DriverManager.setDriver(driver);

    }

    public static void quitDriver() {

        if (DriverManager.getDriver() != null) {

            DriverManager.getDriver().quit();
            DriverManager.unload();

        }

    }

}