package org.example;

import org.apache.commons.io.FileUtils;
import org.jbehave.core.annotations.*;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

public class DemoSteps {
    WebDriver driver;


    private String seleniumHubUrl = "http://3.66.163.86:4444/wd/hub";

    @BeforeScenario
    public void setup() {
        DesiredCapabilities capability = new DesiredCapabilities();
        FirefoxOptions firefoxOptions = new FirefoxOptions();
        capability.merge(firefoxOptions);
        try {
            driver = new RemoteWebDriver(new URL(seleniumHubUrl), capability);
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
        driver.manage().window().maximize();
        waitABit(driver, 10000);

    }

    @Given("I open alza.sk")
    public void I_open_google() throws IOException {
        try {
            driver.get("https://alza.sk/");
        }
        catch (Exception e){
            File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(scrFile, new File("screenshot.png"));
        }
    }
    @When("I search for cheapest macbook")
    public void I_serach_for_my_blogs() throws InterruptedException, IOException {
        try {
            driver.findElement(By.xpath("//*[text()='Rozumiem']")).click();
            waitABit(driver, 5000);
            driver.findElement(By.xpath("//*[text()='Počítače a notebooky']")).click();
            waitABit(driver, 5000);
            driver.findElement(By.xpath("//span[text()='Notebooky']")).click();
            waitABit(driver, 5000);
            driver.findElement(By.xpath("//*[@id=\"content0\"]/div[1]/div[2]/div[6]/div/div[1]/a[8]/span[text()='MacBook']")).click();
            waitABit(driver, 5000);
            driver.findElement(By.xpath("//*[@id=\"content0\"]/div[1]/div[2]/div[6]/div/div[1]/a[4]/span[text()='MacBook Pro']")).click();
            waitABit(driver, 5000);
            driver.findElement(By.xpath("//*[@id=\"content0\"]/div[1]/div[2]/div[6]/div/div[1]/a[2]/span[text()='MacBook Pro 16\" M3']")).click();
            waitABit(driver, 5000);
            driver.findElement(By.xpath("//*[text()='Najlacnejšie']")).click();
            waitABit(driver, 5000);
        }
        catch (Exception e){
            File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(scrFile, new File("screenshot.png"));
        }
    }
    @Then("I add laptop to basket")
    public void I_assert_the_URL() throws IOException {
        try {
            // click on the first Macbook
            driver.findElement(By.xpath("//*[@id=\"boxes\"]/div[1]/div[1]/div[2]/a")).click();
            waitABit(driver, 5000);
            // add to basket
            driver.findElement(By.xpath("//*[@id=\"detailText\"]/div[6]/div[2]/a/span[2]")).click();
            waitABit(driver, 5000);
            // continue to basket
            driver.findElement(By.xpath("//*[@id=\"varBToBasketButton\"]/span")).click();
            waitABit(driver, 5000);
            // click on continue
            driver.findElement(By.xpath("//*[@id=\"blockBtnRight\"]/a/span[1]")).click();
            waitABit(driver, 5000);
        }
        catch (Exception e){
            File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(scrFile, new File("screenshot.png"));
        }

    }

    @AfterStories
    public void exit() {
        driver.quit();
    }

    public void waitABit(WebDriver driver, long mils) {
        synchronized (driver){
            try{
                driver.wait(mils);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
