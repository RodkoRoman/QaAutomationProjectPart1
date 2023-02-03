package rodko;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProfilePage {
    public WebDriver driver;

    /**
     * конструктор класса, занимающийся инициализацией полей класса
     */
    public ProfilePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    /**
     * определение локатора кнопки "Данные"
     */
    @FindBy(xpath = "//*[@id=\"__next\"]/div/div/nav/ul/li[2]/a")
    private WebElement userDataBtn;

    /**
     * метод для входа на страницу "Данные"
     */
    public void entryUserData() {
        userDataBtn.click();
    }


}
