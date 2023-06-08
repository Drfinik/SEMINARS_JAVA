import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {

        // task1();
        // task2();
        // task3();
        // task4();
    }

    private static void task1() {
        // Вычислить сумма чисел от 1 до n.
        Scanner sc = new Scanner(System.in);
        System.out.print("Введите число n: ");
        int n = sc.nextInt();

        int sum = 0;
        for (int i = 1; i <= n; i++) {
            sum += i;
        }

        System.out.println("Сумма чисел от 1 до " + n + " равна " + sum);
    }

    public static void task2() {
        // Вывести все простые числа от 1 до 1000
        for (int i = 2; i <= 1000; i++) {
            if (isPrime(i)) {
                System.out.print(i + " ");
            }
        }
    }

    private static boolean isPrime(int number) {
        if (number == 2 || number == 3) {
            return true;
        }
        if (number % 2 == 0 || number % 3 == 0) {
            return false;
        }

        int sqrt = (int) Math.sqrt(number) + 1;
        for (int i = 6; i <= sqrt; i += 6) {
            if (number % (i - 1) == 0 || number % (i + 1) == 0) {
                return false;
            }
        }

        return true;
    }

    public static void task3() {
        // Реализовать простой калькулятор
        Scanner sc = new Scanner(System.in);
        System.out.print("Введите первое число: ");
        double num1 = sc.nextDouble();

        System.out.print("Введите второе число: ");
        double num2 = sc.nextDouble();

        System.out.println("Выберите операцию (+, -, *, /): ");
        char operator = sc.next().charAt(0);

        double result;
        switch (operator) {
            case '+':
                result = num1 + num2;
                break;

            case '-':
                result = num1 - num2;
                break;

            case '*':
                result = num1 * num2;
                break;

            case '/':
                result = num1 / num2;
                break;

            default:
                System.out.println("Операция не выбрана верно");
                return;
        }

        System.out.println(num1 + " " + operator + " " + num2 + " = " + result);
    }

    public static void task4() {
        // Задано уравнение вида q + w = e, q, w, e >= 0. Некоторые цифры могут быть
        // заменены знаком вопроса, например, 2? + ?5 = 69. Требуется восстановить
        // выражение до верного равенства. Предложить хотя бы одно решение или сообщить,
        // что его нет.

        System.out.println("\n\nЗадано выражение: 2? + ?5 = 69 . Восстановить выражение до верного равенства.");
        int count = 0;
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                if (20 + i + j * 10 + 5 == 69) {
                    count += 1;
                    System.out.println(count + ") 2" + i + " + " + j + "5" + " = 69");
                }
            }
        }
        System.out.println("\n");
        if (count == 0) {
            System.out.println("Решений не найдено\n");
            // При заданном выражении: 2? + ?5 = 69, всегда будет найден правильный ответ. Нужно вводит заведомо ложное выражение: 2? - минимальное значение 20, ?5 - минимальное значение 05, 20+05=25, соответственно любое число меньше 25 будет выдавать, что решений нет.
        }

    }
}
