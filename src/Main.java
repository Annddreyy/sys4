import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        // Ввод умножаемых чисел
        System.out.println("Введите a >> ");
        int a = scan.nextInt();
        System.out.println("Введите b >> ");
        int b = scan.nextInt();

        // Ввод номера выбранной функции
        System.out.println("Введите номер метода для умножения без умножения " +
                "(1 - сложение, 2 - рекурсия, 3 - побитовый сдвиг): ");
        int N = scan.nextInt();

        // Выбор функции в зависимости от ответа пользователя
        switch (N) {
            case 1:
                System.out.println(multiplication_addition(a, b));
                break;
            case 2:
                System.out.println(multiplication_recursion(a, b));
                break;
            case 3:
                System.out.println(multiplication_bit_operations(a, b));
                break;
            default:
                System.out.println("Вы ввели неверные данные!");
        }
    }

    // Умножение с помощью сложения
    private static int multiplication_addition(int a, int b) {
        int result = 0;
        for (int i = 0; i < Math.abs(b); i++) result += a;
        if (b < 0) result = -result; // Если второе число было отрицательное, то используемый унарный минус
        return result;
    }

    // Умножение с помощью рекурсии
    private static int multiplication_recursion(int a, int b) {
        if (b == 0) return 0;
        else if (b > 0) return a + multiplication_recursion(a, b - 1);
        return -multiplication_recursion(a, -b);
    }

    // Умножение с помощью побитовых операций
    private static int multiplication_bit_operations(int a, int b) {
        int result = 0;
        int k = b; // Сохраняем значение числа b
        if (b < 0) b = -b; // Если b было отрицательным, то делаем его положительным
        while (b != 0) {
            if ((b & 1) != 0) result += a; // Если последний бит числа b не равен, то добавляем a к ответу
            a <<= 1; // Умножаем число a с помощью сдвига влево
            b >>= 1; // Делим число b на два с помощью сдвга вправо
        }
        if (k < 0)
            result = -result; // Если число b было отрицательным, то результат умножения меняем на противоположный
        return result;
    }
}
