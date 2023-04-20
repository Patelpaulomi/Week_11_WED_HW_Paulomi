package testsuite;
/**
 * Write down the following test into ‘SaleTest’ class
 * 1. verifyTheTotalItemsDisplayedOnTheWomens
 * JacketsPage()
 * Click on ‘Sale’ Menu tab
 * Click on ‘Jackets’ link on left side
 * under WOMEN’S DEAL Category
 * Verify the text ‘Jackets’ is displayed
 * Count the Total Item Displayed on Page
 * and print the name of all items into
 * console.
 * Verify total 12 Items displayed on page
 */

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class SaleTest extends BaseTest {
    String baseUrl = "https://magento.softwaretestingboard.com/sale.html";

    @Before
    public void setup() {
        openBrowser(baseUrl);

    }

    @Test
    public void verifyTheTotalItemsDisplayedOnTheWomensJacketsPage() {
        //Click on ‘Sale’ Menu tab
        WebElement Salebutton = driver.findElement(By.id("ui-id-8"));
        Salebutton.click();
        //Click on ‘Jackets’ link on left side under WOMEN’S DEAL Category
        WebElement jacketslink = driver.findElement(By.xpath("//li[@class='item']//a[@href='https://magento.softwaretestingboard.com/women/tops-women/jackets-women.html']"));
        jacketslink.click();
        //Verify the text ‘Jackets’ is displayed
        String exceptedMassage = "Jackets";
        WebElement actualTextMessage = driver.findElement(By.xpath("//span[@class='base']"));
        String actualMassage = actualTextMessage.getText();
        Assert.assertEquals(actualMassage, exceptedMassage);
        //Count the Total Item Displayed on Page and print the name of all items into console.
        List<WebElement> itemName = driver.findElements(By.tagName("img"));
        System.out.println(itemName.size());
        for (int i = 1; i < itemName.size(); i++) {
            WebElement item = itemName.get(i);
            String iName = item.getText();
            System.out.println(i + "-" + itemName.get(i).getAttribute("alt"));
        }
        //Verify total 12 Items displayed on page
        String exceptedMassage2 = "12 Items";
        WebElement actualTextMassage2 = driver.findElement(By.xpath("//p[@class='toolbar-amount']"));
        String actualMassage2 = actualTextMassage2.getText();
        Assert.assertEquals(exceptedMassage2, actualMassage2);


    }

    @After
    public void tearDown() {
        closeBrowser();
    }
}





