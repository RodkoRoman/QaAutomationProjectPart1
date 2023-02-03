package rodko;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SafetyPage {

    public WebDriver driver;

    /**
     * конструктор класса, занимающийся инициализацией полей класса
     */
    public SafetyPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    /**
     * определение локатора кнопки выхода со всех устройств
     */
    @FindBy(xpath = "//*[@id=\"__next\"]/div/main/div/section[5]/div/div[2]/div")
    private WebElement logoutFromAllDevicesBtn;

    /**
     * определение локатора кнопки выхода
     */
    @FindBy(xpath = "/html/body/div[2]/div[2]/div/div/div/div/div[3]/button[1]")
    private WebElement logoutBtn;

    /**
     * метод для вызова окна, для подтверждения выхода со всех устройств
     */
    public void entryLogoutFromAllDevices() {
        logoutFromAllDevicesBtn.click();
    }

    /**
     * метод для нажатия кнопки выход
     */
    public void logoutUser() {
        logoutBtn.click();
    }
}
