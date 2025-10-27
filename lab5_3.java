import java.util.Scanner;

public class lab5_3 {

    public static double area(int a, int b, int c, int d, int e, int f) {

        double ac = Math.sqrt(Math.pow(c - a, 2) + Math.pow(d - b, 2));
        double ce = Math.sqrt(Math.pow(e - c, 2) + Math.pow(f - d, 2));
        double triangleArea = (ac * ce) / 2;

        return Math.round(triangleArea * 100.0) / 100.0;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите координаты точек в формате (x,y):");

        System.out.print("Точка A: ");
        String[] pointA = scanner.nextLine().replace("(", "").replace(")", "").split(",");
        int a = Integer.parseInt(pointA[0].trim());
        int b = Integer.parseInt(pointA[1].trim());

        System.out.print("Точка C: ");
        String[] pointC = scanner.nextLine().replace("(", "").replace(")", "").split(",");
        int c = Integer.parseInt(pointC[0].trim());
        int d = Integer.parseInt(pointC[1].trim());

        System.out.print("Точка E: ");
        String[] pointE = scanner.nextLine().replace("(", "").replace(")", "").split(",");
        int e = Integer.parseInt(pointE[0].trim());
        int f = Integer.parseInt(pointE[1].trim());

        // Вычисляем площадь
        double result = area(a, b, c, d, e, f);
        System.out.printf("Площадь треугольника: %.2f\n", result);

        scanner.close();
    }
}