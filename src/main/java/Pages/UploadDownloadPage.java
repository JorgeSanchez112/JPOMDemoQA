package Pages;

import TestComponents.BasePages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class UploadDownloadPage extends BasePages {
    @FindBy(id = "downloadButton")
    private WebElement downloadButton;

    @FindBy(id = "uploadFile")
    private WebElement uploadFileButton;

    @FindBy(id = "uploadedFilePath")
    private WebElement FilePathText;

    public UploadDownloadPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver,this);
    }

    public void clickOnDownloadButton(){
        downloadButton.click();
    }

    public void searchFileInSelectFile(){
        uploadFileButton.sendKeys("C:\\Users\\Jorge\\Downloads\\sampleFile.jpeg");
    }

    public String getPageTitleText(){
        return pageTitle.getText();
    }

    public String getFilePathText(){
        return FilePathText.getText();
    }

    public String getNameDownloadedFile(){
        return "C:\\fakepath\\" + downloadButton.getAttribute("download");
    }

}
