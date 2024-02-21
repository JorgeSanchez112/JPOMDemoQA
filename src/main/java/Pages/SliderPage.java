package Pages;

import TestComponents.BasePages;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SliderPage extends BasePages {
    @FindBy(css = "input.range-slider")
    private WebElement inputRange;
    @FindBy(id = "sliderValue")
    private WebElement containerValue;

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
        return pageTitle.getText();
    }

    public String getContainerValueText(){
        return containerValue.getAttribute("value");
    }

    public String getValueTextOfInputRange(){
        return inputRange.getAttribute("value");
    }

}
