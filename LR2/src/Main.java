import java.util.Scanner;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Ввод строки для проверки
        System.out.println("Введите строку для проверки:");
        String input = scanner.nextLine();

        // Регулярное выражение для проверки URL
        String regex = "^(https?://)?([a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,}(:[0-9]+)?(/[a-zA-Z0-9-._~:/?#\\[\\]@!$&'()*+,;=]*)?$";

        // Проверка строки на соответствие регулярному выражению
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(input);

        if (matcher.matches()) {
            System.out.println("Строка является валидным URL-адресом.");
        } else {
            System.out.println("Строка не является валидным URL-адресом.");
        }
    }
}
