package site.nomoreparties.stellarburgers.helpers;

import com.github.javafaker.Faker;
import site.nomoreparties.stellarburgers.model.UserData;

import java.util.Random;

public class Utils {
    /**
     * Вспомогательльные методы, генерации данных
     */
    Random random = new Random();
    Faker faker = new Faker();

    public UserData generateRandomUser() {
        String email = generateRandomEmail();
        String password = generateRandomPassword();
        String name = generateRandomName();
        return new UserData(email, password, name);

    }

    public String generateRandomName() {
        return faker.name().firstName();
    }

    public String generateRandomPassword() {
        return faker.internet()
                .password(6, 12, true, true, true);
    }

    public String generateShortPassword() {
        return faker.internet()
                .password(1, 5, true, true, true);
    }

    public String generateRandomEmail() {
        return faker.internet().emailAddress();
    }

}