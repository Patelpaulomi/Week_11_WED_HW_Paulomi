package testsuite;
/**
 * Write down the following test into ‘LoginTest’
 * class
 * 1. userShouldLoginSuccessfullyWithValid
 * Credentials()
 * Click on ‘Sign In’ link
 * Enter valid Email
 * Enter valid Password
 * Click on ‘Sign In’ button
 * Verify the ‘Welcome’ text is display
 * 2. verifyTheErrorMessageWithInvalidCredentials
 * Click on ‘Sign In’ link
 * Enter valid Email
 * Enter valid Password
 * Click on ‘Sign In’ button
 * Verify the error message ‘The account sign-in was
 * incorrect or your account is disabled temporarily. Please wait and try again
 * later.’
 * 3. userShouldLogOutSuccessfully
 * Click on ‘Sign In’ link
 * Enter valid Email
 * Enter valid Password
 * Click on ‘Sign In’ button
 * Verify the ‘Welcome’ text is display
 * Click on down aero neare Welcome
 * Click on Sign Out link
 * Verify the text ‘You are signed out’
 */

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class LoginTest extends BaseTest {
    String baseUrl = "https://magento.softwaretestingboard.com/";

    @Before
    public void setup() {
        openBrowser(baseUrl);
    }

    @Test
    public void loginwithvalidCredential() {
        //find Signin link and click on Signin link
        WebElement SigninLink = driver.findElement(By.xpath("//Li[@class='authorization-link']"));
        SigninLink.click();
        //Find the Email field
        WebElement emailField = driver.findElement(By.id("email"));
        //Enter the email address
        emailField.sendKeys("smith0012345@gmail.com");
        //Find the Password field
        WebElement passwordField = driver.findElement(By.id("pass"));
        //Enter the password
        passwordField.sendKeys("John_Smith");
        WebElement Signinbutton = driver.findElement(By.id("send2"));
        Signinbutton.click();
        String expectedMessage = "Welcome, John Smith!";
        WebElement actualTextMessage = driver.findElement(By.xpath("//li[@class='greet welcome']//span[text()='Welcome, John Smith!']"));
        String actualMessage = actualTextMessage.getText();
        Assert.assertEquals(actualMessage, expectedMessage);

    }

    @Test


    public void verifyTheErrorMessageWithInvalidCredentials() {
        //find Signin link and click on Signin link
        WebElement SigninLink = driver.findElement(By.xpath("//Li[@class='authorization-link']"));
        SigninLink.click();
        //Find the Email field
        WebElement emailField = driver.findElement(By.id("email"));
        //Enter the email address
        emailField.sendKeys("smeth00012345@gmaill.com");
        //Find the Password field
        WebElement passwordField = driver.findElement(By.id("pass"));
        //Enter the password
        passwordField.sendKeys("John_Smith");
        WebElement Signinbutton = driver.findElement(By.id("send2"));
        Signinbutton.click();
        String expectedMessage = "The account sign-in was incorrect or your account is disabled temporarily. Please wait and try again later.";
        WebElement actualTextMessage = driver.findElement(By.xpath("//div[contains(text(),'The account sign-in was incorrect or your account is disabled temporarily. Please wait and try again later.')]"));
        String actualMessage = actualTextMessage.getText();
        Assert.assertEquals(actualMessage, expectedMessage);


    }

    @Test
    public void userShouldLogOutSuccessfully() { //find Signin link and click on Signin link
        WebElement SigninLink = driver.findElement(By.xpath("//Li[@class='authorization-link']"));
        SigninLink.click();
        //Find the Email field
        WebElement emailField = driver.findElement(By.id("email"));
        //Enter the email address
        emailField.sendKeys("smith0012345@gmail.com");
        //Find the Password field
        WebElement passwordField = driver.findElement(By.id("pass"));
        //Enter the password
        passwordField.sendKeys("John_Smith");
        WebElement Signinbutton = driver.findElement(By.id("send2"));
        Signinbutton.click();
        //Verify the ‘Welcome’ text is display
        //String expectedMessage = "Welcome, John Smith! ";
        //String eM = "Welcome,";
        //WebElement actualTextElement = driver.findElement(By.xpath("//div[@class='panel header']/ul/li/span[@class='logged-in']"));
        //String actualMessage = actualTextElement.getText();
        //Assert.assertTrue(actualMessage, expectedMessage.contains(eM));
        String expectedMessage = "Welcome, John Smith!";
        WebElement actualTextMessage = driver.findElement(By.xpath("//li[@class='greet welcome']//span[text()='Welcome, John Smith!']"));
        String actualMessage = actualTextMessage.getText();
        Assert.assertEquals(actualMessage, expectedMessage);
        //Find Click on down aero near Welcome
        WebElement clickonDownAero = driver.findElement(By.xpath("//button[@class='action switch']"));
        clickonDownAero.click();
        //Click on Sign Out link
        WebElement clickonSignOutLink = driver.findElement(By.xpath("//li[@class='authorization-link']"));
        clickonSignOutLink.click();
        //Verify the text Verify the text ‘You are signed out
        String exceptedMassage1 = "You are signed out";

        WebElement actualTextMassage1 = driver.findElement(By.xpath("//div[@class='page-title-wrapper']"));
        String actualMassage1 = actualTextMassage1.getText();
        Assert.assertEquals("You are signed out", exceptedMassage1, actualMassage1);
    }

    @After
    public void teardown() {
        closeBrowser();
    }


}



