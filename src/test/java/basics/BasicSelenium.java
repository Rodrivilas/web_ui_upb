package basics;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class BasicSelenium {
    ChromeDriver chromeDriver;
    @BeforeEach
    public void openBrowser(){
        System.setProperty("webdriver.chrome.driver","src/test/resources/driver/chromedriver.exe");
        chromeDriver = new ChromeDriver();
        chromeDriver.get("https://todo.ly/");
    }


    @Test
    public void goToGoogle() throws InterruptedException {
        chromeDriver.findElement(By.xpath("//*[@id=\"ctl00_MainContent_PanelNotAuth\"]/div[2]/div[1]/div[2]/a/img")).click();
        chromeDriver.findElement(By.id("ctl00_MainContent_LoginControl1_TextBoxEmail")).sendKeys("upb_api@api.com");
        chromeDriver.findElement(By.id("ctl00_MainContent_LoginControl1_TextBoxPassword")).sendKeys("12345");
        chromeDriver.findElement(By.id("ctl00_MainContent_LoginControl1_ButtonLogin")).click();
        Thread.sleep(5000);
    }

    @AfterEach
    public void closeBrowser(){
        chromeDriver.quit();
    }


}
