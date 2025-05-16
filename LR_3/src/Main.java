import java.util.Stack;
import java.io.File;

public class Main {
    public static void main(String[] args) {
        // Создание стека для хранения элементов каталога
        Stack<String> stack = new Stack<>();

        // Путь к каталогу
        String directoryPath = "C:\\Users\\Людмила\\Desktop\\Универ";

        // Создание объекта File для каталога
        File directory = new File(directoryPath);

        // Проверка, является ли путь каталогом
        if (directory.isDirectory()) {
            // Получение списка файлов и подкаталогов в каталоге
            File[] files = directory.listFiles();

            if (files != null) {
                // Добавление элементов каталога в стек
                for (File file : files) {
                    stack.push(file.getName());
                }

                // Вывод элементов стека
                System.out.println("Элементы стека:");
                while (!stack.empty()) {
                    System.out.println(stack.pop());
                }
            } else {
                System.out.println("Каталог пуст.");
            }
        } else {
            System.out.println("Указанный путь не является каталогом.");
        }
    }
}
