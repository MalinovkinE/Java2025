import java.util.Scanner;

public class lab4_3 {

    private static boolean isPrime(int num){
        for (int j = 2; j < Math.sqrt(num) + 1; j++){
            if (num % j == 0) return false;
        }
        return true;
    }



    public static void main(String[] arg){
        Scanner scanner = new Scanner(System.in);
        double sumNonPrime= 0;
        int minPirmeNum = 0;
        double cntNonPrime = 0;
        String input;
        int number;

        while (true){
            System.out.println("Введите число: ");
            input = scanner.nextLine();
            if (input.equals("stop"))break;

            number = Integer.parseInt(input);
            if (number <= 1 || number == 22){
                System.out.println("invalid");
                continue;
            }
            if (isPrime(number)){
                if (minPirmeNum == 0){
                    minPirmeNum = number;
                }
                else if (number < minPirmeNum)minPirmeNum = number;
            }
            else {
                sumNonPrime += number;
                cntNonPrime++;
            }
        }
        if (minPirmeNum == 0) System.out.println("prime_undefind");
        else System.out.println("prime_" + minPirmeNum);
        if (cntNonPrime == 0) System.out.println("non_prime_undefined");
        else{
            double avarageNonPrimeNumber = sumNonPrime / cntNonPrime;
            System.out.println("non_prime_" + avarageNonPrimeNumber);
        }

    }
}
