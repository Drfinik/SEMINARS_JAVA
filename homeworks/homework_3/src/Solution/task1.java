package Solution;

import java.util.ArrayList;
import java.util.Collections;

/**
 * task1
 */
public class task1 {

    public static void choosingNumbers(String[] args) {
        
        ArrayList<Integer> list = new ArrayList<>();
        list.add(5);
        list.add(2);
        list.add(1);
        list.add(9);
        list.add(8);
        list.add(4);
        System.out.println("Исходный список: " + list);

        // удаление чётных чисел
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) % 2 == 0) {
                list.remove(i);
                i--;
            }
        }

        // поиск минимального значения
        int min = Collections.min(list);

        // поиск максимального значения
        int max = Collections.max(list);

        // поиск среднего значения
        int sum = 0;
        for (int number : list) {
            sum += number;
        }
        int average = sum / list.size();

        System.out.println("Список после удаления чётных чисел: " + list);
        System.out.println("Минимальное значение: " + min);
        System.out.println("Максимальное значение: " + max);
        System.out.println("Среднее значение: " + average);
    }
}