import io.qameta.allure.Step;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Account {

    private final String name;
    public Account(String name) {
        this.name = name;
    }

    private static final String NAME_PATTERN = "(?=.{3,19}$)[а-яА-Яa-zA-Z]+\\s{1}[а-яА-Яa-zA-Z]+";
    //Указываем через регулярное выражение минимум и максимум символов в строке
    // а так же какие это могут быть символы и где может быть расположен единственный пробел
    private static final Pattern namePattern = Pattern.compile(NAME_PATTERN);

    @Step ("Метод checkNameToEmboss")
    public boolean checkNameToEmboss(String name) {
        Matcher matcher = namePattern.matcher(name);
        return matcher.matches();
    }
}
