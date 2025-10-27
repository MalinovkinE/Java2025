import java.util.Scanner;

public class lab3_3 {
    public static void main(String[] arg){
        int N = 22;
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        while (!((num >= -15 * N && num <= -11 * N) || (num >= 11 * N && num <= 15 * N))){
            System.out.println("Not_yet");
            num = scanner.nextInt();
        }
        System.out.println("Correct number_" + num);

    }
}

