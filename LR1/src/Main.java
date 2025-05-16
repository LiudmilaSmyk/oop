import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Ввод текста
        System.out.println("Введите текст:");
        String text = scanner.nextLine();

        // Ввод символа для замены
        System.out.println("Введите символ для замены:");
        char replacementChar = scanner.next().charAt(0);

        // Ввод позиции символа для замены
        System.out.println("Введите позицию символа для замены (k):");
        int k = scanner.nextInt();

        // Замена k-й буквы в каждом слове
        String[] words = text.split(" ");
        for (int i = 0; i < words.length; i++) {
            if (k <= words[i].length()) {
                char[] wordChars = words[i].toCharArray();
                wordChars[k - 1] = replacementChar;
                words[i] = new String(wordChars);
            }
        }

        // Вывод результата
        System.out.println("Результат:");
        for (String word : words) {
            System.out.print(word + " ");
        }
    }
}
