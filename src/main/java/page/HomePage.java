package page;

import lombok.Data;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * 首页元素设置
 */
@Data
public class HomePage {
    @FindBy(id = "toolbar-search-input")
    private WebElement sousuo;
}
