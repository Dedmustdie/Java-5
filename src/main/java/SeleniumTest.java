import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumTest {
    WebDriver driver;
    final String URL = "https://irr.ru/";

    @Before
    public void setup() {
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        driver = new ChromeDriver();
    }

    @Test
    public void test() throws InterruptedException {
        driver.get(URL);

        titleTest();
        inputNameOfProductTest();
        chooseCategoryTest();
        inputCityTest();
        clickSearchButtonTest();
    }

    public void titleTest() {
        Assert.assertEquals(driver.getTitle(), "Из рук в руки - доска частных бесплатных объявлений в Москве");
    }

    public void inputNameOfProductTest() throws InterruptedException {
        var nameOfProduct = driver
                .findElement(By.xpath("//input[@data-qa='search__input']"));
        Assert.assertNotNull(nameOfProduct);
        nameOfProduct.sendKeys("lada");

        Thread.sleep(1000);
    }

    public void chooseCategoryTest() throws InterruptedException {
        var selectize = driver
                .findElement(By.xpath("//div[@class='selectize-input items full has-options has-items']"));
        Assert.assertNotNull(selectize);
        selectize.click();

        var dataSelectables = selectize
                .findElements(By.xpath("//div[@data-selectable]"));
        Assert.assertNotNull(dataSelectables);
        dataSelectables.get(1).click();

        Thread.sleep(1000);
    }

    public void inputCityTest() throws InterruptedException {
        var selectize = driver
                .findElement(By.xpath("//a[@class='btnRegion js-selectRegionButton']"));
        Assert.assertNotNull(selectize);
        selectize.click();

        var city = selectize.findElement(By.xpath("//input[@class='_3DjOn8-Hq1HYuSKY1RkHg-']"));
        Assert.assertNotNull(selectize);
        city.sendKeys("Киров");

        Thread.sleep(1000);

        var dataSelectables = selectize
                .findElements(By.xpath("//div[@class='_1qm1t2nc_Nj-A43kFe_bu9']"));
        Assert.assertNotNull(dataSelectables);
        dataSelectables.get(0).click();

        var saveButton = selectize.findElement(By.xpath("//button[@class='_3eOiTlyu2czPY7c6cIFsJS _2vM714Nq1v4c9xK4NBAXmB HIo8Zsdbkzj4aiy-u_4Dv']"));
        saveButton.click();

        Thread.sleep(1000);
    }

    public void clickSearchButtonTest() throws InterruptedException {
        var searchButton = driver.findElement(By.xpath("//button[@class='headerSearch__submitButton headerSearch__submitButton_mainPage']"));
        searchButton.click();
        Thread.sleep(10000);
    }

    @After
    public void quit() {
        driver.quit();
    }
}