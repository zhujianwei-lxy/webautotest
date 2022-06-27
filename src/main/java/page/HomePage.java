package page;

import lombok.Data;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.LoadableComponent;
import org.testng.Assert;
import utils.Utils;

/**
 * 首页元素设置
 */
@Data
public class HomePage{

    // 搜索框
    @FindBy(id = "toolbar-search-input")
    private WebElement searchBar;

    // 搜索按钮
    @FindBy(id = "toolbar-search-button")
    private WebElement searchButton;

    // 标签列表，可修改属性可见
    @FindBy(xpath = "//*[@id=\"floor-nav_557\"]/div/div")
    private WebElement listOfTags;
}
