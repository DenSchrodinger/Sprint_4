import org.junit.Test;
import org.junit.runner.RunWith;
import io.qameta.allure.junit4.DisplayName;
import org.junit.runners.Parameterized;
import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class AccountTest {
    private final String testingName;
    private final boolean expectedResult;

    public AccountTest(String testingName, boolean expectedResult) {
        this.testingName = testingName;
        this.expectedResult = expectedResult;
    }

    @Parameterized.Parameters
    public  static Object[][] getNameData(){
        return new Object[][] {
                {"Малыш Котопес", true}, // Стандартное имя
                {"Малыш Котопессссссс", true}, // Стандартное имя с пробелом, увеличенное до 19 символов
                {"М К", true}, // Сокращённое имя с пробелом, есть 3 символа
                {"Tyler Durden", true}, // Имя на латинице, 12 символов
                {"", false}, // Пустая строка
                {"МК", false}, // Имя из менее чем 3х символов
                {"Малышш Котопёссссссс", false}, // Имя из 20 символов
                {" Малыш Котопес", false}, // Пробел перед именем
                {"Малыш Котопес ", false}, // Пробел после имени
                {"Малыш  Котопес", false}, // Двойной пробел между словами в имени
                {"555 666", false}, // Имя из цифр
                {"??? ***", false}, // Имя из служебных символов
                {"Малыш", false}, // Имя без пробела и из одного слова
                {"Малыш кото пес", false}, // Имя из трёх слов
        };
    }

    @Test
    @DisplayName("Проверка имени по параметрам.")
    public void checkNameToEmboss() {
        Account account = new Account(testingName);
        boolean actualResult = account.checkNameToEmboss(testingName);
        assertEquals(expectedResult, actualResult);
    }

}