package rodko;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class LoginTest {
    public static LoginPage loginPage;
    public static ProfilePage profilePage;
    public static UserDataPage userDataPage;
    public static SafetyPage safetyPage;
    public static WebDriver driver;

    /**
     * осуществление первоначальной настройки
     */
    @BeforeClass
    public static void setup() {
        //определение пути до драйвера и его настройка
        System.setProperty("webdriver.chrome.driver", "D:\\Users\\Rodko-RS\\chromedriver\\chromedriver.exe");

        //создание экземпляра драйвера
        driver = new ChromeDriver();
        loginPage = new LoginPage(driver);
        profilePage = new ProfilePage(driver);
        userDataPage = new UserDataPage(driver);
        safetyPage = new SafetyPage(driver);

        //окно разворачивается на полный экран
        driver.manage()
                .window()
                .maximize();

        //задержка на выполнение теста = 10 сек.
        driver.manage()
                .timeouts()
                .implicitlyWait(10, TimeUnit.SECONDS);

        //получение ссылки на страницу входа из файла настроек
        driver.get("https://passport.yandex.ru/auth");
    }

    @Test
    public void loginTest() {
        //вводим логин
        loginPage.inputLogin(ConfProperties.getProperty("login"));

        //нажимаем кнопку входа
        loginPage.clickLoginBtn();

        //вводим пароль
        loginPage.inputPasswd(ConfProperties.getProperty("password"));

        //нажимаем кнопку входа
        loginPage.clickLoginBtn();

        //проверяем имя
        profilePage.entryUserData();
        String user = userDataPage.getUserName();
        Assert.assertEquals("Роман Родько", user);

        //выходим со всех устройств
        userDataPage.entrySafety();
        safetyPage.entryLogoutFromAllDevices();
        safetyPage.logoutUser();

    }
}
