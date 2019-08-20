package com.example;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import org.junit.Assert;

public class SeleniumWithTestNGLiveTest {

    private SeleniumExample seleniumExample;
    private String expectedUsername = "testUsername";
    private String expectedMsg = "test message";
    private String expectedOnlineCount = "1";
    private String expectedLoginPageHeader = "Chat Room";

    @BeforeSuite
    public void setUp() {
        seleniumExample = new SeleniumExample();
    }

    @AfterSuite
    public void tearDown() {
        seleniumExample.closeWindow();
    }

    @Test
    public void testLoginAndSendMessageAndLogout() {
        seleniumExample.login();
        // get username
        String actualUserName = seleniumExample.getUsername();
        Assert.assertEquals(expectedUsername, actualUserName);
        // type message
        seleniumExample.sendMessage(expectedMsg);
        String actualMsg = seleniumExample.getMessageSent(expectedMsg);
        Assert.assertTrue(actualMsg.contains(expectedMsg));
        // check online count
        String actualOnlineCount = seleniumExample.getUserCount();
        Assert.assertEquals(expectedOnlineCount, actualOnlineCount);
        // test logout
        seleniumExample.logout();
        // check logout
        String actualLoginPageHeader = seleniumExample.getLoginPageHeader();
        Assert.assertEquals(expectedLoginPageHeader, actualLoginPageHeader);
    }

}
