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

public class DemoQAXPath {

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
    public void ClickMeButtonsTest() {
        WebElement buttons = driver.findElement(new By.ByXPath("//span[text()='Buttons']"));
        buttons.click();

        WebElement clickMe = driver.findElement(new By.ByXPath("//button[text()='Click Me']"));
        clickMe.click();

        WebElement txtMessage = driver.findElement(new By.ByXPath("//p[@id='dynamicClickMessage']"));
        System.out.println(txtMessage.getText());

    }

    @Test
    public void addRecordTest() throws InterruptedException {

        WebElement clickWebtables = driver.findElement(new By.ByXPath("//span[text()='Web Tables']"));
        clickWebtables.click();

        WebElement addButton = driver.findElement(new By.ByXPath("//button[@id='addNewRecordButton']"));
        addButton.click();

        WebElement firstName = driver.findElement(new By.ByXPath("//input[@id='firstName']"));
        firstName.sendKeys("Kübra");

        WebElement lastName = driver.findElement(new By.ByXPath("//input[@id='lastName']"));
        lastName.sendKeys("Dikmen");

        WebElement email = driver.findElement(new By.ByXPath("//input[@id='userEmail']"));
        email.sendKeys("kubradikmen@mail.com");

        WebElement age = driver.findElement(new By.ByXPath("//input[@id='age']"));
        age.sendKeys("27");

        WebElement salary = driver.findElement(new By.ByXPath("//input[@id='salary']"));
        salary.sendKeys("123455");

        WebElement department = driver.findElement(new By.ByXPath("//input[@id='department']"));
        department.sendKeys("Test");

        WebElement btnSubmit = driver.findElement(new By.ByXPath("//button[@id='submit']"));
        btnSubmit.click();

        Thread.sleep(10000);

        //EDİT İŞLEMİ

        WebElement btnEdit = driver.findElement(new By.ByXPath("//span[@id='edit-record-4']"));
        btnEdit.click();

        Thread.sleep(5000);

        WebElement UpdateAge = driver.findElement(new By.ByXPath("//input[@id='age']"));

        UpdateAge.clear();
        UpdateAge.sendKeys("28");

        WebElement btnAfterEdit = driver.findElement(new By.ByXPath("//button[@id='submit']"));
        btnAfterEdit.click();



    }

    @AfterMethod(alwaysRun = true)
    public void  after(){
        webDriver.quitDriver();
    }
}
