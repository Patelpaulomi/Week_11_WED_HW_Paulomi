package testsuite;
/**
 * 3. Write down the following test into ‘RegisterTest’
 * class
 * 1. verifyThatSignInPageDisplay
 * click on the ‘Create an Account’ link
 * Verify the text ‘Create New Customer Account’
 * 2. userSholdRegisterAccountSuccessfully
 * click on the ‘Create an Account’ link
 * Enter First name
 * Enter Last name
 * Click on checkbox Sign Up for Newsletter
 * Enter Emai
 * Enter Password
 * Enter Confirm Password
 * Click on Create an Account button
 * Verify the text 'Thank you for
 * registering with Main Website Store.’
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

public class RegisterTest extends BaseTest {
    String baseUrl = "https://magento.softwaretestingboard.com/";

    @Before
    public void setup() {
        openBrowser(baseUrl);
    }

    @Test
    public void verifyThatSignInPageDisplay() {
        //find create an account link and click on it
        WebElement createAnAccountLink = driver.findElement(By.linkText("Create an Account"));
        createAnAccountLink.click();
        //Verify the text create new customer account
        String exceptedMassage = "Create New Customer Account";
        WebElement actualTextElement = driver.findElement(By.xpath("//span[@class='base']"));
        String actualMassage = actualTextElement.getText();
        Assert.assertEquals(exceptedMassage, actualMassage);
    }

    @Test
    public void userShouldRegisterAccountSuccessfully() {
        //find create an account link and click on it
        WebElement createAnAccountLink = driver.findElement(By.linkText("Create an Account"));
        createAnAccountLink.click();
        //find first name field
        WebElement firstNameField = driver.findElement(By.id("firstname"));
        //Enter The first Name
        firstNameField.sendKeys("John");
        //find the last name filed
        WebElement lastNameField = driver.findElement(By.id("lastname"));
        //Enter the last name
        lastNameField.sendKeys("Smith");
        //find the SignUp for Newspaper box
        WebElement signUpforNewspaper = driver.findElement(By.xpath("//input[@type='checkbox']"));
        //click on the box
        signUpforNewspaper.click();
        //Find the Email field
        WebElement emailField = driver.findElement(By.id("email_address"));
        //Enter the email address
        emailField.sendKeys("smith0012345@gmail.com");
        //Find the Password field
        WebElement passwordField = driver.findElement(By.id("password"));

        //Enter the password
        passwordField.sendKeys("John_Smith");
        //find the Confirm Password Field
        WebElement confirmPasswordField = driver.findElement(By.id("password-confirmation"));
        //Enter the same password again to confirm
        confirmPasswordField.sendKeys("John_Smith");
        //Find Create an Account Button
        WebElement createanAccountButton = driver.findElement(By.xpath("//button[@title='Create an Account']"));
        createanAccountButton.click();
        //Verify the text 'Thank you for registering with Main Website Store'
        String exceptedMassage = "Thank you for registering with Main Website Store.";
        WebElement actualTextElement = driver.findElement(By.xpath("//div[@class='message-success success message']"));
        String actualMassage = actualTextElement.getText();
        Assert.assertEquals(exceptedMassage, actualMassage);
        //Find Click on down aero near Welcome
        WebElement clickonDownAero = driver.findElement(By.xpath("//button[@class='action switch']"));
        clickonDownAero.click();
        //Click on Sign Out link
        WebElement clickonSignOutLink = driver.findElement(By.xpath("//li[@class='authorization-link']"));
        clickonSignOutLink.click();
        //Verify the text Verify the text ‘You are signed out
        String exceptedMassage1="You are signed out";

       WebElement actualTextMassage1 = driver.findElement(By.xpath("//div[@class='page-title-wrapper']"));
       String actualMassage1 = actualTextMassage1.getText();
        Assert.assertEquals("You are signed out",exceptedMassage1,actualMassage1);

    }

    @After
    public void teardown() {
        closeBrowser();
    }


}
