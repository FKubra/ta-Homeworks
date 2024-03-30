package testAutomation.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.*;
import org.openqa.selenium.WebDriver;
import testAutomation.drivers.Driver;
import testAutomation.utils.PropertyManager;

import java.net.MalformedURLException;
import java.util.List;

public class DemoQACSS {

    public static WebDriver driver;
    Driver webDriver = new Driver();
    PropertyManager propertyManager= new PropertyManager();
    String url =propertyManager.getProperty("APP_URL");

    @BeforeMethod(alwaysRun = true)
    public void before() throws MalformedURLException {
        driver = webDriver.initializeDriver();
        driver.get(url);
    }

    @Test
    public void openDemoQaTest() {
        String pageTitle = driver.getTitle();
        Assert.assertEquals(pageTitle,"DEMOQA");
    }

    @Test
    public void ClickMeButtonsTest() {
        WebElement buttons = driver.findElement(new By.ByCssSelector(".collapse.element-list.show > .menu-list > li:nth-of-type(5)"));
        Assert.assertNotNull(buttons);
        buttons.click();

        WebElement clickMe = driver.findElement(new By.ByCssSelector("div:nth-child(4)>button"));
        Assert.assertNotNull(clickMe);
        clickMe.click();

        WebElement txtMessage = driver.findElement(new By.ByCssSelector("#dynamicClickMessage"));
        System.out.println(txtMessage.getText());
        Assert.assertEquals(txtMessage.getText(), "You have done a dynamic click");

    }

    @Test
    public void addRecordTest() throws InterruptedException {

        WebElement clickWebtables = driver.findElement(new By.ByCssSelector(".collapse.element-list.show > .menu-list > li:nth-of-type(4)"));
        clickWebtables.click();

        WebElement addButton = driver.findElement(new By.ByCssSelector("button#addNewRecordButton"));
        addButton.click();

        WebElement firstName = driver.findElement(new By.ByCssSelector("#firstName"));
        firstName.sendKeys("Kübra");

        WebElement lastName = driver.findElement(new By.ByCssSelector("#lastName"));
        lastName.sendKeys("Dikmen");

        WebElement email = driver.findElement(new By.ByCssSelector("#userEmail"));
        email.sendKeys("kubradikmen@mail.com");

        WebElement age = driver.findElement(new By.ByCssSelector("#age"));
        age.sendKeys("27");

        WebElement salary = driver.findElement(new By.ByCssSelector("#salary"));
        salary.sendKeys("123455");

        WebElement department = driver.findElement(new By.ByCssSelector("#department"));
        department.sendKeys("Test");

        WebElement btnSubmit = driver.findElement(new By.ByCssSelector("#submit"));
        btnSubmit.click();

        WebElement name = driver.findElement(new By.ByCssSelector("div:nth-of-type(4) > div[role='row'] > div:nth-of-type(1)"));
        Assert.assertEquals(name.getText(),"Kübra");

        Thread.sleep(10000);

        //EDİT İŞLEMİ

        WebElement btnEdit = driver.findElement(new By.ByCssSelector("#edit-record-4"));
        btnEdit.click();

        Thread.sleep(5000);

        WebElement UpdateAge = driver.findElement(new By.ByCssSelector("#age"));

        UpdateAge.clear();
        UpdateAge.sendKeys("28");

        WebElement btnAfterEdit = driver.findElement(new By.ByCssSelector("#submit"));
        btnAfterEdit.click();

        WebElement updateName = driver.findElement(new By.ByCssSelector("div:nth-of-type(4) > div[role='row'] > div:nth-of-type(3)"));
        Assert.assertEquals(updateName.getText(),"28");

    }

    @AfterMethod(alwaysRun = true)
    public void  after(){
        webDriver.quitDriver();
    }
}
