import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class AutomationProject2 {


    @Test
    public void test() throws InterruptedException {
        WebDriver driver = null;
       try{
           driver = new ChromeDriver();
           driver.manage().window().maximize();
           driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
           driver.get("https://open.spotify.com/");
           driver.findElement(By.xpath("//span[.='Log in']")).click();
           driver.findElement(By.id("login-username")).sendKeys("fredo.fernando777@gmail.com", Keys.TAB, "Montreal89107939495", Keys.ENTER);
           driver.findElement(By.xpath("//span[@data-testid='username-first-letter']")).isDisplayed();
           driver.findElement(By.xpath("//span[.='Search']")).click();
           driver.findElement(By.xpath("//input[@data-testid='search-input']")).sendKeys("Adele Hello");
           driver.findElement(By.xpath("(//button[@aria-label='Play Hello by Adele'])[1]")).sendKeys(Keys.ENTER);


           String actualHello = driver.findElement(By.xpath("//a[@data-testid='context-item-link']")).getText();
           Assert.assertEquals(actualHello, "Hello");
           String actualAdele = driver.findElement(By.xpath("//a[@data-testid='context-item-info-artist']")).getText();
           Assert.assertEquals(actualAdele, "Adele");

           Thread.sleep(5000);

           driver.findElement(By.xpath("//button[@data-testid='user-widget-link']")).click();
           driver.findElement(By.xpath("//button[@data-testid='user-widget-dropdown-logout']")).click();
           driver.findElement(By.xpath("//span[.='Log in']")).isDisplayed();

       }finally {
           driver.quit();
       }

    }
}
