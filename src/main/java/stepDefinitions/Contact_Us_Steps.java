package stepDefinitions;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;

import java.util.Map;

public class Contact_Us_Steps {
    private WebDriver driver;

    @Before
    public void setup() {
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.setPageLoadStrategy(PageLoadStrategy.NORMAL);
        driver = new ChromeDriver(chromeOptions);
        driver.manage().window().maximize();
    }

    @After
    public void tearDown() {
        driver.quit();
    }

    @Given("I access the webdriver university contact us page")
    public void i_access_the_webdriver_university_contact_us_page() {
        driver.get("https://www.webdriveruniversity.com/Contact-Us/contactus.html");
    }
    @When("I fill in the following information:")
    public void i_fill_in_the_following_information(DataTable dataTable) {
        // Convierte la tabla de datos en una lista de mapas, donde cada mapa representa una fila de la tabla.
        Map<String, String> table = dataTable.asMap(String.class, String.class);
        // Ahora puedes acceder a los valores de la tabla de datos utilizando los nombres de las columnas.
        String name = table.get("Name");
        String lastname = table.get("LastName");
        String email = table.get("Email");
        String comments = table.get("Comments");

        driver.findElement(By.xpath("//input[@name='first_name']")).sendKeys(name);
        driver.findElement(By.xpath("//input[@name='last_name']")).sendKeys(lastname);
        driver.findElement(By.xpath("//input[@name='email']")).sendKeys(email);
        driver.findElement(By.xpath("//textarea[@name='message']")).sendKeys(comments);
    }
    @When("I click on the Submit button")
    public void i_click_on_the_submit_button() {
        driver.findElement(By.xpath("//input[@value='SUBMIT']")).click();
    }
    @Then("I should see a confirmation message")
    public void i_should_see_a_confirmation_message() {
        WebElement ActualMessage = driver.findElement(By.xpath("//div[@id='contact_reply']/h1"));
        String ExpectedMessage = "Thank You for your Message!";

        Assert.assertEquals(ActualMessage.getText(), ExpectedMessage);
    }
}
