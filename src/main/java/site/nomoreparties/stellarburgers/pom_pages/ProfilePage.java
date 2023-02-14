package site.nomoreparties.stellarburgers.pom_pages;

import io.restassured.http.ContentType;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static io.restassured.RestAssured.given;

/**
 * Описание страницы личного кабинет пользователя (доступно только для авторизованнх пользователей)
 */

public class ProfilePage {
    /* POM локаторы */
    //кнопка "Выход"
    private final By exitButton = By.xpath(".//button[text()='Выход']");
    //кнопка "Профиль"
    private final By profileButton = By.xpath(".//a[contains(@href, 'profile')]");
    //Логотип
    private final By logo = By.xpath(".//div[contains(@class, 'header__logo')]");
    private final WebDriver driver;
    public ProfilePage(WebDriver driver) {
        this.driver = driver;
    }

    /* POM методы */
    public void deleteUserViaApi(String accessToken) {
        given().contentType(ContentType.JSON)
                .baseUri("https://stellarburgers.nomoreparties.site")
                .header("Authorization", accessToken)
                .when()
                .delete("/api/auth/user");
    }

    public void logout() {
        driver.findElement(exitButton).click();
    }

    public void goToMainPage() {
        driver.findElement(logo).click();
    }

    /* POM чеки */
    public boolean isCurrentPositionProfilePage() {
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOfElementLocated(profileButton));
        try {
            driver.findElement(profileButton);
            return true;
        } catch (NoSuchElementException ex) {
            return false;
        }

    }


}
