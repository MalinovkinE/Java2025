import java.util.Scanner;
public class lab5_4 {

    public static double average(String text, int sum, int count) {
        // Завершаем метод, если строка пустая
        if (text.trim().isEmpty()) {
            if (count == 0) return 0;
            return (double) sum / count;
        }

        // Находим пробелы между числами
        int spaceIndex = text.indexOf(' ');
        String currentWord;
        String restOfText;

        if (spaceIndex == -1) {
            currentWord = text;
            restOfText = "";
        } else {
            currentWord = text.substring(0, spaceIndex);
            restOfText = text.substring(spaceIndex + 1);
        }

        try {
            int number = Integer.parseInt(currentWord);
            return average(restOfText, sum + number, count + 1);
        } catch (NumberFormatException e) {
            return average(restOfText, sum, count);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите числа: ");
        String input = scanner.nextLine();

        double result = average(input, 0, 0);
        System.out.println("Результат: " + result);
    }
}