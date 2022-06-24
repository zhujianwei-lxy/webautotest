package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Utils {

    /**
     * @Description 获取chrome浏览器驱动
     * @return 浏览器驱动
     */
    public static WebDriver getDriver(){
        System.setProperty("webdriver.chrome.driver", "./driver/chromedriver");
        ChromeDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        return driver;
    }

}
