package site.nomoreparties.stellarburgers.pom_pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;

/**
 * Описание главной страницы авторизации пользователя
 */
public class LoginPage {

    private WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }
    // some_client@mail.com
    //123456
    /* POM локаторы */
    //поле ввода e-mail
    private final By emailInput = By.xpath(".//input[@name='name']");
    //поле ввода пароля
    private final By passwordInput = By.xpath(".//input[@name='Пароль']");
    //кнопка "Войти"
    private final By enterButton = By.xpath(".//button[text()='Войти']");
    // Заголовок формы авторизации
    private final By loginHeader = By.xpath(".//h2[text()='Вход']");
    //Ссылка "Зарегистрироваться"
    private final By registerLink = By.xpath("//*[starts-with(@href, '/register')]");
    //Ссылка "Восстановить пароль"
    private final By restorePasswordLink = By.xpath("//*[starts-with(@href, '/forgot-password')]");


    /* POM методы */
    public void logIn(String email, String password) {
        driver.findElement(emailInput).click();
        driver.findElement(emailInput).clear();
        driver.findElement(emailInput).sendKeys(email);
        driver.findElement(passwordInput).click();
        driver.findElement(passwordInput).clear();
        driver.findElement(passwordInput).sendKeys(password);
        driver.findElement(enterButton).click();

    }

    public void goToRegisterPage() {
        driver.findElement(registerLink).click();
    }

    public void goToRestorePasswordPage() {
        driver.findElement(restorePasswordLink).click();
    }

    /* POM чеки */
    public boolean isCurrentPositionLoginPage() {
        try {
            driver.findElement(loginHeader);
            return true;
        } catch (NoSuchElementException ex) {
            return false;
        }

    }


}
