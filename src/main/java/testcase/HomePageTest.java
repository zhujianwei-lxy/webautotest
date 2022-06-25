package testcase;

import io.qameta.allure.Allure;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;
import page.HomePage;
import utils.Utils;

import java.util.concurrent.TimeUnit;

public class HomePageTest{
    HomePage homePage = new HomePage();
    WebDriver driver = Utils.getChromeDriver();


    @Test
    public void searchBarTest(){
        driver.get("https://www.csdn.net/");
        PageFactory.initElements(driver, homePage);
        Allure.addAttachment("输入","测试");
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        homePage.getSearchBar().sendKeys("测试");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        driver.close();
    }
}
