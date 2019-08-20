package com.example;

import com.example.springbootchatproject.config.SeleniumConfig;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class SeleniumExample {

    private SeleniumConfig config;
    private String url = "http://localhost:8090/";

    public SeleniumExample() {
        config = new SeleniumConfig();
        config.getDriver().get(url);
    }

    public void closeWindow() {
        this.config.getDriver().close();
    }

    public String getTitle() {
        return this.config.getDriver().getTitle();
    }
    
    public void login() {
        typeUsername();
        clickLoginButton();
    }

    public void logout() {
        clickLogoutButton();
    }

    private void clickLogoutButton() {
        this.config.getDriver().findElement(By.xpath("//i[contains(text(),'exit_to_app')]")).click();
    }

    private void typeUsername() {
        this.config.getDriver().findElement(By.id("username")).click();
        this.config.getDriver().findElement(By.id("username")).sendKeys("testUsername");
    }

    private void clickLoginButton() {
        this.config.getDriver().findElement(By.partialLinkText("Login")).click();
    }

    public void getAboutBaeldungPage() {
        closeOverlay();
        clickAboutLink();
        clickAboutUsLink();
    }

    private void closeOverlay() {
        List<WebElement> webElementList = this.config.getDriver().findElements(By.tagName("a"));
        if (webElementList != null) {
            webElementList.stream()
                    .filter(webElement -> "Close".equalsIgnoreCase(webElement.getAttribute("title")))
                    .filter(WebElement::isDisplayed)
                    .findAny()
                    .ifPresent(WebElement::click);
        }
    }

    private void clickAboutLink() {
        this.config.getDriver().findElement(By.partialLinkText("About")).click();
    }

    private void clickAboutUsLink() {
        Actions builder = new Actions(config.getDriver());
        WebElement element = this.config.getDriver().findElement(By.partialLinkText("About Baeldung."));
        builder.moveToElement(element).build().perform();
    }

    public boolean isAuthorInformationAvailable() {
        return this.config.getDriver()
                .findElement(By.cssSelector("article > .row > div"))
                .isDisplayed();
    }

    public String getUsername() {
        return this.config.getDriver()
                .findElement(By.id("username")).getText();
    }

    public void sendMessage(String msg) {
        this.config.getDriver().findElement(By.id("msg")).click();
        this.config.getDriver().findElement(By.id("msg")).sendKeys(msg);
        this.config.getDriver().findElement(By.xpath("//button[contains(text(),'Send')]")).click();
    }

    public String getMessageSent(String msg) {
        String msgXpath = "//div[contains(text(),'"+msg+"')]";
        return this.config.getDriver().findElement(By.xpath(msgXpath)).getText();
    }

    public String getUserCount() {
        return this.config.getDriver().findElement(By.className("chat-num")).getText();
    }

    public String getLoginPageHeader() {
        return this.config.getDriver().findElement(By.tagName("h3")).getText();
    }
}