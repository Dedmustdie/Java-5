import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.IOException;

public class MoreTvRegAuthTest {
    WebDriver driver;
    final String URL = "https://more.tv/";

    final String email = "artyomchurin@gmail.com";
    final String password = "artyomartyomartyom";

    @Before
    public void setup() {
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        driver = new ChromeDriver();
    }

    @Test
    public void test() throws InterruptedException {
        driver.get(URL);

        titleTest();
        clickProfilTest();
        inputEmailTest();
        inputPasswordTest();
        clickSignInTest();
    }

    public void titleTest() {
        Assert.assertEquals(driver.getTitle(), "Онлайн-сервис more.tv");
    }


    public void clickProfilTest() throws InterruptedException {
        WebElement signinButton;
        try {
            signinButton = driver
                    .findElement(By.xpath("//a[@class='index-module__link--0IPrm LoginView-module__enterLinkWrapper--FpQlg']"));
        } catch (NoSuchElementException e) {
            signinButton = driver
                    .findElement(By.xpath("//a[@href='/signin']"));
        }

        Assert.assertNotNull(signinButton);
        signinButton.click();
        Thread.sleep(1000);
    }

    public void inputEmailTest() throws InterruptedException {
        var email = driver.findElement(By.xpath("//input[@class='index-module__input--paYAZ']"));
        Assert.assertNotNull(email);
        email.sendKeys(this.email);

        Thread.sleep(1000);
    }

    public void inputPasswordTest() throws InterruptedException {
        var password = driver.findElement(By.xpath("//input[@class='index-module__input--paYAZ']"));
        Assert.assertNotNull(password);
        password.sendKeys(this.password);

        Thread.sleep(1000);
    }

    public void clickSignInTest() throws InterruptedException {
        var signinButton = driver
                    .findElement(By.xpath("//button[@class='index-module__btn--akert index-module__form_btn--hIZ4B Button-module__text-white--KbFNk Button-module__bg-blue--h0yoI Button-module__hasLabel--c51nv Button-module__Button--z6EB4']"));

        Assert.assertNotNull(signinButton);
        signinButton.click();
        Thread.sleep(1000);
    }

    @After
    public void quit() throws InterruptedException {
        Thread.sleep(4000);
        driver.quit();
    }
}