import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class SeleniumCrecion {
    ChromeDriver chromeDriver;
    @BeforeEach
    public void openBrowser(){
        System.setProperty("webdriver.chrome.driver","src/test/resources/driver/chromedriver.exe");
        chromeDriver = new ChromeDriver();
        // implicit wait
        chromeDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        chromeDriver.manage().window().maximize();
        chromeDriver.get("http://todo.ly/");
    }
    @Test
    public void verifyCreationProject() throws InterruptedException {


        chromeDriver.findElement(By.xpath("//img[@src='/Images/design/pagelogin.png']")).click();
        chromeDriver.findElement(By.xpath("//input[@name='ctl00$MainContent$LoginControl1$TextBoxEmail']")).sendKeys("rodriviladegut@gmail.com");
        chromeDriver.findElement(By.xpath("//input[contains(@name,'LoginControl1$TextBoxPassword')]")).sendKeys("12345");
        chromeDriver.findElement(By.id("ctl00_MainContent_LoginControl1_ButtonLogin")).click();


        chromeDriver.findElement(By.xpath("//*[@id=\"MainTable\"]/tbody/tr/td[1]/div[6]/div/table/tbody/tr/td[2]")).click();
        chromeDriver.findElement(By.id("NewProjNameInput")).sendKeys("RodrigoV");
        chromeDriver.findElement(By.id("NewProjNameButton")).click();

        Thread.sleep(5000);

        Assertions.assertTrue(chromeDriver.findElement(By.id("CurrentProjectTitle")).getText().equals("RodrigoV"),"ERRROR el texto es distinto");


    }

    @Test
    public void verifyUpdateProject() throws InterruptedException {


        chromeDriver.findElement(By.xpath("//img[@src='/Images/design/pagelogin.png']")).click();
        chromeDriver.findElement(By.xpath("//input[@name='ctl00$MainContent$LoginControl1$TextBoxEmail']")).sendKeys("rodriviladegut@gmail.com");
        chromeDriver.findElement(By.xpath("//input[contains(@name,'LoginControl1$TextBoxPassword')]")).sendKeys("12345");
        chromeDriver.findElement(By.id("ctl00_MainContent_LoginControl1_ButtonLogin")).click();

        chromeDriver.findElement(By.xpath("//*[@id=\"ItemId_3982508\"]")).click();
        chromeDriver.findElement(By.xpath("//*[@id=\"ItemId_3982508\"]/table/tbody/tr/td[4]/div[2]")).click();
        chromeDriver.findElement(By.xpath("//*[@id=\"projectContextMenu\"]/li[1]")).click();
        chromeDriver.findElement(By.id("ItemEditTextbox")).clear();
        chromeDriver.findElement(By.id("ItemEditTextbox")).sendKeys("RodrigoVUpdate");
        chromeDriver.findElement(By.id("ItemEditSubmit")).click();

        Thread.sleep(5000);

        Assertions.assertTrue(chromeDriver.findElement(By.id("CurrentProjectTitle")).getText().equals("RodrigoVUpdate"),"ERRROR el texto es distinto");


    }



    @AfterEach
    public void closeBrowser(){
        chromeDriver.quit();
    }

}
