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
        clickWithWait(downloadButton);
    }

    public void searchFileInSelectFile(){
        sendKeysToElement(uploadFileButton,"C:\\Users\\Jorge\\Downloads\\sampleFile.jpeg");
    }

    public String getPageTitleText(){
        return getElementTextWithWait(pageTitle);
    }

    public String getFilePathText(){
        return getElementTextWithWait(FilePathText);
    }

    public String getNameDownloadedFile(){
        final String FAKEPATH = "C:\\fakepath\\";
        final String DOWNLOAD_ATTRIBUTE = "download";

        return FAKEPATH + getElementAttribute(downloadButton,DOWNLOAD_ATTRIBUTE);
    }

}
