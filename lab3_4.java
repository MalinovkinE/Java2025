import java.util.Scanner;

public class lab3_4 {
    public static void main(String[] arg){
        Scanner scanner = new Scanner(System.in);
        int mnm = 0;

        System.out.print("Задайте колличестов чисел(n): ");

        for (int n = Integer.parseInt(scanner.nextLine()); n > 0; n--) {
            System.out.print("Введите число: ");
            int num = Integer.parseInt(scanner.nextLine());
            if (mnm == 0) {
                if (num % 3 == 0) mnm = num;
            } else {
                if ((num % 3 == 0) && (num < mnm)) mnm = num;
            }
        }
        if (mnm == 0){
            System.out.println("undefined");
        }
        else {
            System.out.println("Ответ: " + mnm);
        }
    }
}

