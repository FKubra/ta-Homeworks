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
    public void ClickMeButtonsTest() {
        WebElement buttons = driver.findElement(new By.ByCssSelector(".collapse.element-list.show > .menu-list > li:nth-of-type(5)"));
        buttons.click();

        WebElement clickMe = driver.findElement(new By.ByCssSelector("div:nth-child(4)>button"));
        clickMe.click();

        WebElement txtMessage = driver.findElement(new By.ByCssSelector("#dynamicClickMessage"));
        System.out.println(txtMessage.getText());

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

//        WebElement btnEdit = driver.findElement(new By.ByCssSelector("#edit-record-4"));
//        btnEdit.click();

        findEntry("kubradikmen@mail.com");

        Thread.sleep(40000);

        age.clear();
        salary.clear();

        age.sendKeys("28");
        salary.sendKeys("12344345");
        btnSubmit.click();


    }

    public void findEntry(String text) {

        List<WebElement> tableElements = driver.findElements(By.cssSelector(".rt-table .rt-tbody [role='row'] .rt-td:nth-of-type(4)"));


        for(int i=0; i< tableElements.size();i++){

            if (tableElements.get(i).getText().equalsIgnoreCase(text)){
                driver.findElement(By.cssSelector("#edit-record-" + (i + 1))).click();
                break;
            }
        }
    }

    @AfterMethod(alwaysRun = true)
    public void  after(){
        webDriver.quitDriver();
    }
}
