package utils;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.safari.SafariDriver;

@Data
public class Utils {

    /**
     * @Description 获取chrome浏览器驱动
     * @return 浏览器驱动
     */
    public static WebDriver getChromeDriver(){
        System.setProperty("webdriver.chrome.driver", "./driver/chromedriver");
        ChromeDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        return driver;
    }

    /**
     * @Description 封装修改页面元素属性
     */
    public static void setAttribute(WebDriver webDriver, WebElement element, String attributeName, String value){
        JavascriptExecutor js = (JavascriptExecutor) webDriver;
        js.executeScript("arguments[0].setAttribute(arguments[1],arguments[2])",element,attributeName,value);
    }

    /**
     * @Description 封装删除页面元素属性
     */
    public static void removeAttribute(WebDriver webDriver, WebElement element,String attributeName){
        JavascriptExecutor js = (JavascriptExecutor) webDriver;
        js.executeScript("arguments[0].removeAttribute(arguments[1],arguments[2])",element,attributeName);
    }

}
