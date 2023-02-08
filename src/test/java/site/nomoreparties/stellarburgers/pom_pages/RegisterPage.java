package site.nomoreparties.stellarburgers.pom_pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Описание страницы регистрации пользователя
 */

public class RegisterPage {
    private WebDriver driver;

    public RegisterPage(WebDriver driver) {
        this.driver = driver;
    }
    /* POM локаторы */
    //Ссылка "Войти"
    private final By loginLink = By.xpath("//*[starts-with(@href, '/login')]");

    /* POM методы */
    public void goToLoginPage() {
        driver.findElement(loginLink).click();
    }

    /* POM чеки */
}
