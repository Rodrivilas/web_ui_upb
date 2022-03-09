package basics;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;

public class SeleniumFirefox {

    FirefoxDriver firefoxDriver;

    @BeforeEach
    public void openBrowser(){
        System.setProperty("webdriver.gecko.driver","src/test/resources/driver/geckodriver.exe");
        firefoxDriver=new FirefoxDriver();
        firefoxDriver.get("http://todo.ly/");
    }

    @Test
    public void goToFireFox() throws InterruptedException {
        firefoxDriver.findElement(By.xpath("//*[@id=\"ctl00_MainContent_PanelNotAuth\"]/div[2]/div[1]/div[2]/a/img")).click();
        firefoxDriver.findElement(By.id("ctl00_MainContent_LoginControl1_TextBoxEmail")).sendKeys("upb_api@api.com");
        firefoxDriver.findElement(By.id("ctl00_MainContent_LoginControl1_TextBoxPassword")).sendKeys("12345");
        firefoxDriver.findElement(By.id("ctl00_MainContent_LoginControl1_ButtonLogin")).click();
        Thread.sleep(5000);
    }

    @AfterEach
    public void closeBrowser(){
        firefoxDriver.quit();
    }
}