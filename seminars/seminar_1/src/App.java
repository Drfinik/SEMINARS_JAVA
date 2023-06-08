import java.time.LocalTime;
import java.util.Scanner;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class App {
    public static void main(String[] args) throws Exception {

        // task1();
        // task2();
        // task3();
        // task4();
        // task5();
        // task6();
        // task7();
        // task8();
        // task9();
    }

    private static void task1() {

        System.out.println("Hello, World!");

        // Написать программу, которая запросит пользователя ввести <Имя> в консоли.
        // Получит введенную строку и выведет в консоль сообщение “Привет, <Имя>!”
        Scanner iScanner = new Scanner(System.in);

        System.out.printf("Enter your name: ");

        String name = iScanner.nextLine();

        // System.out.printf("Hello, %s!\n", name);
        Depends(name);
        // System.out.println("Hello, " + name);

    }

    public static void Depends(String name) {
        // В консоли запросить имя пользователя. В зависимости от текущего времени,
        // вывести приветствие вида
        // "Доброе утро, <Имя>!", если время от 05:00 до 11:59
        // "Добрый день, <Имя>!", если время от 12:00 до 17:59;
        // "Добрый вечер, <Имя>!", если время от 18:00 до 22:59;
        // "Доброй ночи, <Имя>!", если время от 23:00 до 4:59
        LocalTime lt = LocalTime.now();
        System.out.println(lt);

        if (lt.getHour() >= 18 && lt.getHour() < 23) {
            System.out.printf("Good evening, %s!\n", name);
        } else if (lt.getHour() >= 23 || lt.getHour() < 5) {
            System.out.printf("Good night, %s!\n", name);
        } else if (lt.getHour() >= 5 || lt.getHour() < 12) {
            System.out.printf("Good morning, %s!\n", name);
        } else if (lt.getHour() >= 12 || lt.getHour() < 18) {
            System.out.printf("Good afternoon, %s!\n", name);
        }
    }

    private static void task2() {
        // Дан массив двоичных чисел, например [1,1,0,1,1,1], вывести
        // максимальное количество подряд идущих 1.

        int[] arr = { 1, 1, 0, 1, 1, 1 };
        int cnt = 0;
        int max_cnt = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 1)
                cnt++;
            else
                cnt = 0;
            if (cnt > max_cnt)
                max_cnt = cnt;
        }
        System.out.println(max_cnt);
    }

    private static void task3() {
        // Дан массив nums = [3,2,2,3] и число val = 3.
        // Если в массиве есть числа, равные заданному, нужно перенести эти элементы в
        // конец массива.
        // Таким образом, первые несколько (или все) элементов массива должны быть
        // отличны от заданного, а остальные - равны ему.
        int[] arr = new int[] { 1, 1, 0, 3, 1, 1, 3, 0, 1 };
        int val = 3;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == val) {
                for (int j = i; j < arr.length - 1; j++)
                    arr[j] = arr[j + 1];
                arr[arr.length - 1] = val;
            }
        }

        for (int item : arr)
            System.out.printf("%d\t", item);

    }

    private static void task4() {
        // Напишите метод, который находит самую длинную строку общего префикса среди
        // массива строк.
        // Если общего префикса нет, вернуть пустую строку "".
        String[] lines = { "dom", "domovoy", "domashniy" };
        System.out.println(findPfx(lines));
        System.out.println(lines[0].substring(0, findPfx(lines)));

    }

    private static int findPfx(String[] lines) {
        int res = 0;
        boolean pfxExist = true;
        while (pfxExist) {
            res++;
            for (int i = 0; i < (lines.length - 1); i++) {
                if (res <= lines[i].length() && res <= lines[i + 1].length()) {
                    if (lines[i].substring(0, res).compareTo(lines[i + 1].substring(0, res)) != 0) {
                        res--;
                        pfxExist = false;
                        break;
                    }
                } else {
                    res--;
                    pfxExist = false;
                    break;
                }
            }
        }
        return res;
    }

    public static int findPrefix(String[] strs) {
        String[] lStrs = Arrays.stream(strs).map(s -> s.toLowerCase()).toArray(String[]::new);
        String first = lStrs[0];
        boolean found = false;
        int result = 0;
        for (int prefixLength = 1; prefixLength < first.length(); prefixLength++) {
            String prefix = first.substring(0, prefixLength + 1);
            boolean match = true;
            for (int i = 1; i < lStrs.length; i++) {
                String checkingStr = lStrs[i];
                if (!checkingStr.startsWith(prefix)) {
                    match = false;
                    break;
                }
            }
            if (match) {
                result = prefixLength;
            } else
                break;
        }
        return result;
    }

    private static void task5() {
        // Во фразе "Добро пожаловать на курс по Java" переставить слова в обратном
        // порядке.
        String phrase = "Добро пожаловать на курс по Java";
        String[] words = phrase.split(" ");
        String reversedPhrase = "";

        for (int i = words.length - 1; i >= 0; i--) {
            reversedPhrase += words[i] + " ";
        }

        System.out.println("Перестановка слов в обратном порядке: " + reversedPhrase.trim());
    }

    private static void task6() {
        // Реализовать функцию возведения числа а в степень b. a, b из Z.
        // Сводя количество выполняемых действий к минимуму.
        // Пример 1: а = 3, b = 2, ответ: 9
        // Пример 2: а = 2, b = -2, ответ: 0.25
        // Пример 3: а = 3, b = 0, ответ: 1
        int a = 3;
        int b = 2;

        int result = power(a, b);
        System.out.println(a + " в степени " + b + " равно " + result);
    }

    private static int power(int a, int b) {
        if (b == 0) {
            return 1;
        }

        int temp = power(a, b / 2);
        if (b % 2 == 0) {
            return temp * temp;
        } else {
            return a * temp * temp;
        }
    }

    private static void task7() {
        // На вход некоторому исполнителю подаётся два числа (a, b).
        // У исполнителя есть две команды
        // команда 1 (к1): увеличить в с раза, а умножается на c
        // команда 2 (к2): увеличить на d ( +2 ), к a прибавляется d
        // Написать программу, которая выдаёт набор команд, позволяющий число a
        // превратить в число b или сообщить, что это невозможно
        // Пример 1: а = 1, b = 7, c = 1, d = 3
        // ответ: к1, к1, к1, к1, к1, к1 или к1, к2, к1, к1, к1 или к1, к1, к2, к1.
        // Пример 2: а = 11, b = 7, c = 2, d = 1
        // ответ: “”.
        int a = 11;
        int b = 7;
        int c = 2;
        int d = 1;

        Queue<Integer> queue = new LinkedList<>();
        Set<Integer> visited = new HashSet<>();
        Queue<String> commands = new LinkedList<>();
        queue.offer(a);
        commands.offer("");

        while (!queue.isEmpty()) {
            int current = queue.poll();
            String currentCommands = commands.poll();
            visited.add(current);

            if (current == b) {
                System.out.println("Набор команд: " + currentCommands);
                return;
            }

            int newNum = current * c;
            if (newNum == b) {
                System.out.println("Набор команд: " + currentCommands + " к1");
                return;
            } else if (!visited.contains(newNum) && newNum > 0 && newNum <= b * 10) {
                queue.offer(newNum);
                commands.offer(currentCommands + " к1");
            }

            newNum = current + d;
            if (newNum == b) {
                System.out.println("Набор команд: " + currentCommands + " к2");
                return;
            } else if (!visited.contains(newNum) && newNum > 0 && newNum <= b * 10) {
                queue.offer(newNum);
                commands.offer(currentCommands + " к2");
            }
        }

        System.out.println("Решения не существует");

    }

    private static void task8() {
        // Задан массив, например, nums = [1,7,3,6,5,6]. Написать программу, которая
        // найдет индекс i для этого массива такой, что сумма элементов с индексами < i
        // равна сумме элементов с индексами > i.
        int[] nums = { 1, 7, 3, 6, 5, 6 };
        int index = findIndex(nums);
        System.out.println("Индекс равен " + index);
    }

    private static int findIndex(int[] nums) {
        int totalSum = 0;

        for (int num : nums) {
            totalSum += num;
        }

        int leftSum = 0;
        for (int i = 0; i < nums.length; i++) {
            int rightSum = totalSum - leftSum - nums[i];
            if (leftSum == rightSum) {
                return i;
            }
            leftSum += nums[i];
        }

        return -1;
    }

    private static void task9() {
        // Записать в файл следующие данные: Name Surname Age , Kate Smith 20 , Paul
        // Green 25 , Mike Black 23 .
        String[] names = { "Kate Smith 20", "Paul Green 25", "Mike Black 23" };

        try {
            FileWriter fileWriter = new FileWriter("output.txt");
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

            for (String name : names) {
                bufferedWriter.write(name);
                bufferedWriter.newLine();
            }

            bufferedWriter.close();
            System.out.println("Данные записаны в файл output.txt");
        } catch (IOException e) {
            System.out.println("Ошибка записи в файл");
            e.printStackTrace();
        }
    }
}
// https://metanit.com/java/tutorial/

// https://github.com/Golikov-Andrey/JavaUnit1Gr4580