package Pages;

import TestComponents.config.PageBase;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SliderPage extends PageBase {
    @FindBy(css = "input.range-slider")
    private WebElement inputRange;
    @FindBy(id = "sliderValue")
    private WebElement containerValue;

    private final String VALUE_ATTRIBUTE = "value";

    public SliderPage(WebDriver driver) {
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

    public synchronized String getContainerValueText(){
        return getElementAttribute(containerValue,VALUE_ATTRIBUTE);
    }

    public synchronized String getValueTextOfInputRange(){
        return getElementAttribute(inputRange,VALUE_ATTRIBUTE);
    }

}
