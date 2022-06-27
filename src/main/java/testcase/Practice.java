package testcase;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;
import page.HomePage;
import utils.Utils;

import java.io.File;

public class Practice {
    WebDriver driver = Utils.getChromeDriver();
    HomePage homePage = new HomePage();
    JavascriptExecutor js;

    /**
     * @Description 访问网址
     */
    @Test
    public void demo1() {
        driver.get("https://www.csdn.net/");//打开该网页
        driver.quit();//退出浏览器
    }

    /**
     * @Description 访问网址
     */
    @Test
    public void demo2() {
        driver.navigate().to("https://www.csdn.net/");//打开该网页
        driver.quit();//退出浏览器
    }

    /**
     * @Description 返回上一个访问的网页
     */
    @Test
    public void demo3() {
        String url1 = "https://www.csdn.net/";
        String url2 = "https://www.baidu.com/";
        driver.navigate().to(url1);//先访问csdn
        driver.navigate().to(url2);//再访问百度
        driver.navigate().back();//返回到上一次访问的csdn
        driver.quit();//退出浏览器
    }

    /**
     * @Description 前进下一个访问的网页
     */
    @Test
    public void demo4() {
        String url1 = "https://www.csdn.net/";
        String url2 = "https://www.baidu.com/";
        driver.navigate().to(url1);//先访问csdn
        driver.navigate().to(url2);//再访问百度
        driver.navigate().back();//返回到上一次访问的csdn
        driver.navigate().forward();//从csdn跳转到百度
        driver.quit();
    }

    /**
     * @Description 访问网址
     */
    @Test
    public void demo5() {
        driver.navigate().to("https://www.csdn.net/");//打开该网页
        driver.navigate().refresh();//刷新
        driver.quit();//退出浏览器
    }

    /**
     * @Description 获取页面title
     */
    @Test
    public void getTitle() {
        driver.navigate().to("https://www.csdn.net/");//打开该网页
        String title = driver.getTitle();
        System.out.println(title);
        Assert.assertEquals("CSDN - 专业开发者社区", title);//断言
        driver.quit();//退出浏览器
    }

    /**
     * @Description 获取页面的源代码
     */
    @Test
    public void getPageSource() {
        driver.navigate().to("https://www.csdn.net/");//打开该网页
        String pageSource = driver.getPageSource();
        System.out.println(pageSource);
        Assert.assertTrue(pageSource.contains("专业开发者社区"));
        driver.quit();//退出浏览器
    }

    /**
     * @Description 获取页面的URL地址
     */
    @Test
    public void getPageUrl() {
        driver.navigate().to("https://www.csdn.net/");//打开该网页
        String currentUrl = driver.getCurrentUrl();
        System.out.println(currentUrl);
        driver.quit();//退出浏览器
    }

    /**
     * @Description 清除输入框内容
     */
    @Test
    public void clearInputBoxContent() {
        PageFactory.initElements(driver, homePage);
        driver.navigate().to("https://www.csdn.net/");//打开该网页
        homePage.getSearchBar().clear();
        driver.quit();//退出浏览器
    }

    /**
     * @Description 输入框输入内容
     */
    @Test
    public void sendTextToInputBoxContent() {
        PageFactory.initElements(driver, homePage);
        driver.navigate().to("https://www.csdn.net/");//打开该网页
        homePage.getSearchBar().clear();
        homePage.getSearchBar().sendKeys("测试");
        driver.quit();//退出浏览器
    }

    /**
     * @Description 单击
     */
    @Test
    public void click() {
        PageFactory.initElements(driver, homePage);
        driver.navigate().to("https://www.csdn.net/");//打开该网页
        homePage.getSearchBar().clear();
        homePage.getSearchBar().sendKeys("测试");
        homePage.getSearchButton().click();
        driver.quit();//退出浏览器
    }

    /**
     * @Description 双击
     */
    @Test
    public void doubleClick() {
        PageFactory.initElements(driver, homePage);
        driver.navigate().to("https://www.csdn.net/");//打开该网页
        homePage.getSearchBar().clear();
        homePage.getSearchBar().sendKeys("测试");
        Actions actions = new Actions(driver);// 创建action对象ÒÒÒ
        actions.doubleClick(homePage.getSearchButton()).build().perform();// 对该元素进行双击操作
        driver.quit();//退出浏览器
    }

    /**
     * @Description 封装修改页面元素属性
     */
    public void setAttribute(WebDriver webDriver, WebElement element,String attributeName,String value){
        JavascriptExecutor js = (JavascriptExecutor) webDriver;
        js.executeScript("arguments[0].setAttribute(arguments[1],arguments[2])",element,attributeName,value);
    }

    /**
     * @Description 封装删除页面元素属性
     */
    public void removeAttribute(WebDriver webDriver, WebElement element,String attributeName){
        JavascriptExecutor js = (JavascriptExecutor) webDriver;
        js.executeScript("arguments[0].removeAttribute(arguments[1],arguments[2])",element,attributeName);
    }

    /**
     * @Description 修改标签class值
     */
    @Test
    public void reviseClassProperty(){
        PageFactory.initElements(driver, homePage);
        driver.navigate().to("https://www.csdn.net/");//打开该网页
        setAttribute(driver, homePage.getListOfTags(),"class","blog-nav active");
    }

    @Test
    public void demo6(){
        File file;
        driver.navigate().to("https://www.csdn.net/");//打开该网页
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        file = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        Utils.creatFile(file);
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        driver.quit();
    }

}
