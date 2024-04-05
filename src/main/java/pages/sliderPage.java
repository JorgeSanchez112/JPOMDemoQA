package pages;

import testComponents.config.pageBase;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class sliderPage extends pageBase {
    @FindBy(css = "input.range-slider")
    private WebElement inputRange;
    @FindBy(id = "sliderValue")
    private WebElement containerValue;

    private final String VALUE_ATTRIBUTE = "value";

    public sliderPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver,this);
    }

    public void changeRangeInputToMinValue(){
        inputRange.sendKeys(Keys.HOME);
    }

    public void changeRangeInputToMaxValue(){
        inputRange.sendKeys(Keys.chord(Keys.SHIFT, Keys.END));
    }

    public String getPageTitleText(){
        return getElementTextWithWait(pageTitle);
    }

    public String getContainerValueText(){
        return getElementAttribute(containerValue,VALUE_ATTRIBUTE);
    }

    public String getValueTextOfInputRange(){
        return getElementAttribute(inputRange,VALUE_ATTRIBUTE);
    }

}