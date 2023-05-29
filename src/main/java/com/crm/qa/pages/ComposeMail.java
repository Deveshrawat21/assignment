package com.crm.qa.pages;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;

import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class ComposeMail extends TestBase {
	public ComposeMail() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//a[@data-test-id='compose-button']")
	WebElement composeBtn;

	@FindBy(xpath = "//input[@data-test-id='compose-subject']")
	WebElement subjectName;

	@FindBy(xpath = "//input[@id='message-to-field']")
	WebElement toreceiver;

	@FindBy(xpath = "//div[@data-test-id='rte']")
	WebElement emailBody;

	@FindBy(xpath = "//button[@data-test-id='icon-btn-list_unordered']")
	WebElement bulletIcon;

	@FindBy(xpath = "(//button[@data-test-id='icon-btn-list_unordered'])[2]")
	WebElement bulletBtn;

	@FindBy(xpath = "//div[@data-test-id='compose.attach-button']")
	WebElement attachBtn;

	@FindBy(xpath = "//button[@data-test-id='compose-send-button']")
	WebElement sendBtn;

	@FindBy(xpath = "//a[@data-test-id='folder-list-item']/span/span[.='Inbox']")
	WebElement inboxBtn;

	@FindBy(xpath = "//a[contains(@aria-label,'Unread')and @data-test-read='false']")
	WebElement unreadMsg;

	@FindBy(xpath = "//span[@data-test-id='message-group-subject-text']")
	WebElement verifySubject;

	@FindBy(xpath = "//div[contains(@class,'yahoo-style-wrap')]")
	WebElement verifyEmailBody;

	@FindBy(xpath = "//div[@data-test-id='download-icon']")
	WebElement downloadBtn;

	@FindBy(xpath = "//img[@data-test-id='attachment-thumbnail']")
	WebElement imagePreview;
	
	@FindBy(xpath = "//a[@data-test-id='attachment-download']//div[2]")
	WebElement imageSize;
	

	public void clickOnComposeBtn() {
		composeBtn.click();
	}

	public void clickSubjectName() {
		subjectName.click();
	}

	public void clickReceiverId() {
		toreceiver.click();
	}

	public void clickAttachBtn() {
		attachBtn.click();
	}

	public void clickSendBtn() {
		sendBtn.click();
	}

	public void clickInboxBtn() {
		inboxBtn.click();
	}

	public void clickUnreadMsg() {
		unreadMsg.click();
	}

	public void subjectName(String subject) {
		subjectName.sendKeys(subject);
	}

	public void toreceiver(String receiverId) {
		toreceiver.sendKeys(receiverId);
	}

	public String getSubjectText() {
		return verifySubject.getText();
	}

	public String getEmailText() {
		return verifyEmailBody.getText();
	}

	public void clickOnDownloadBtn() {
		Actions act = new Actions(driver);
		act.moveToElement(imagePreview).perform();
		downloadBtn.click();
	}

	public void verifyDownloadedFile() {
		String downloadDirectory = System.getProperty("user.home") + "/Downloads";
		String expectedFileName = "images.jfif";
		File downloadedFile = new File(downloadDirectory + "/" + expectedFileName);
		if (downloadedFile.delete()) {
			System.out.println("Downloaded file deleted successfully.");
		} else {
			System.out.println("Failed to delete the downloaded file.");
		}
		while (!downloadedFile.exists()) {
		}
		Assert.assertEquals(String.valueOf(downloadedFile.length()), "6577");
		
	}

	public void uploadImage() throws Exception {
		String userDirectory = System.getProperty("user.dir");
		System.out.println("User Directory: " + userDirectory);
		String filePath = userDirectory + "\\Image\\images.jfif";
		System.out.println(filePath);
		StringSelection stringSelection = new StringSelection(filePath);
		Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
		clipboard.setContents(stringSelection, stringSelection);
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_ENTER);

	}

	public void enterEmailBody(String emailBodyLine1, String emailBodyLine2, String emailBodyLine3) {
		emailBody.sendKeys(emailBodyLine1 + Keys.ENTER);
		emailBody.sendKeys(emailBodyLine2 + Keys.ENTER);
		emailBody.sendKeys(emailBodyLine3 + Keys.ENTER);
	}

	public void clickEmailBody() {
		emailBody.click();
	}

	public void makeEmailBullet() throws Exception {
		emailBody.sendKeys(Keys.CONTROL + "a");
		bulletIcon.click();
		bulletBtn.click();
	}

}
