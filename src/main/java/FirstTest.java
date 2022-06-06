import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class FirstTest {

    @Test
    public void checkMinSum(){
        System.setProperty("webdriver.chrome.driver","src/main/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(4));

        driver.get("https://next.privat24.ua/money-transfer/card");
        driver.manage().window().fullscreen();

        By FirstCardNumber = By.xpath("//input[@data-qa-node='numberdebitSource']");
        By FirstTerm = By.xpath("//input[@data-qa-node='expiredebitSource']");
        By FirstCVV = By.xpath("//input[@data-qa-node='cvvdebitSource']");
        By FirstName = By.xpath("//input[@data-qa-node='firstNamedebitSource']");
        By LastName = By.xpath("//input[@data-qa-node='lastNamedebitSource']");
        By SecondCardNumber = By.xpath("//input[@data-qa-node='numberreceiver']");
        By FirstName1 = By.xpath("//input[@data-qa-node='firstNamereceiver']");
        By LastName2 = By.xpath("//input[@data-qa-node='lastNamereceiver']");
        By amount = By.xpath("//input[@data-qa-node='amount']");
        By submitBTN = By.xpath("//span[@data-qa-node='toggle-comment']");
        By comment = By.xpath("//textarea[@data-qa-node='comment']");
        By submit = By.xpath("//button[@class='sc-VigVT hcHAAV']");

        driver.findElement(FirstCardNumber).sendKeys("4006895689048337");
        driver.findElement(FirstTerm).sendKeys("0323");
        driver.findElement(FirstCVV).sendKeys("111");
        driver.findElement(FirstName).sendKeys("Gloria");
        driver.findElement(LastName).sendKeys("Hayakawa");
        driver.findElement(SecondCardNumber).sendKeys("4552331448138217");
        driver.findElement(FirstName1).sendKeys("Federico");
        driver.findElement(LastName2).sendKeys("Stojan");
        driver.findElement(amount).sendKeys("500");
        driver.findElement(submitBTN).click();
        driver.findElement(comment).sendKeys("TestTest");
        driver.findElement(submit).submit();

        Assert.assertEquals("TestTest",
                driver.findElement(By.xpath("//div[@data-qa-node='comment']")).getText());
        Assert.assertEquals("Картка відправника",
                driver.findElement(By.xpath("//div[@data-qa-node='payer-name']")).getText());
        Assert.assertEquals("4006 8956 8904 8337",
                driver.findElement(By.xpath("//span[@data-qa-node='payer-card']")).getText());
        Assert.assertEquals("FEDERICO STOJAN",
                driver.findElement(By.xpath("//div[@data-qa-node='receiver-name']")).getText());
        Assert.assertEquals("4552 3314 4813 8217",
                driver.findElement(By.xpath("//span[@data-qa-node='receiver-card']")).getText());
        Assert.assertEquals("500 UAH",
                driver.findElement(By.xpath("//div[@data-qa-node='payer-amount']")).getText());
        Assert.assertEquals("106.72 UAH",
                driver.findElement(By.xpath("//div[@data-qa-node='payer-currency']")).getText());
        Assert.assertEquals("500 UAH",
                driver.findElement(By.xpath("//div[@data-qa-node='receiver-amount']")).getText());
        Assert.assertEquals("0 UAH",
                driver.findElement(By.xpath("//div[@data-qa-node='receiver-currency']")).getText());


    }
}
