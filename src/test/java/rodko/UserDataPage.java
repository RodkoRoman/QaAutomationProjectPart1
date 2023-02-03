package rodko;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class UserDataPage {

    public WebDriver driver;

    /**
     * конструктор класса, занимающийся инициализацией полей класса
     */
    public UserDataPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    /**
     * определение локатора поля имени
     */
    @FindBy(xpath = "//*[@id=\"__next\"]/div/main/div/section[1]/div/div/div[3]/div/span[1]")
    private WebElement userName;

    /**
     * определение локатора кнопки "Безопасность"
     */
    @FindBy(xpath = "//*[@id=\"__next\"]/div/div/nav/ul/li[5]/a")
    private WebElement safetyBtn;

    /**
     * метод для вытягивания имени пользователя в строку
     */
    public String getUserName() {
        return userName.getText();
    }

    /**
     * метод для нажатия кнопки "Безопасность"
     */
    public void entrySafety() {
        safetyBtn.click();
    }
}
