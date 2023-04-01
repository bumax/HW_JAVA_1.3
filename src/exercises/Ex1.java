package exercises;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// Реализовать алгоритм сортировки слиянием
public class Ex1 {
    public static List<Integer> MergeSort(List<Integer> inList) {

        if (inList.size() <= 1) return inList; // Условия выхода из рекурсии

        List<Integer> result = new ArrayList<Integer>(inList.size()); // Инициализируем возвращаемый список
        List<Integer> left = MergeSort(inList.subList(0, inList.size() / 2)); // Разбиваем список на 2 равные части: левый...
        List<Integer> right = MergeSort(inList.subList(inList.size() / 2, inList.size())); // .. и правый, рекурсивно вызывая функцию сортировки

        int leftPointer = 0; // Указатель на текущую позицию элемента левого списка
        int rightPointer = 0; // Указатель на текущую позицию элемента правого списка
        // Начинаем собирать результирующий список:
        while (leftPointer < left.size() && rightPointer < right.size()) {
            if (left.get(leftPointer) <= right.get(rightPointer)) {
                result.add(left.get(leftPointer));
                leftPointer++;
            } else {
                result.add(right.get(rightPointer));
                rightPointer++;
            }
        }
        // Если раньше кончился правый список, "добиваем" результат значениями из левого списка
        while (leftPointer < left.size()) {
            result.add(left.get(leftPointer));
            leftPointer++;
        }
        // Если раньше кончился левый список, "добиваем" результат значениями из правого списка
        while (rightPointer < right.size()) {
            result.add(right.get(rightPointer));
            rightPointer++;
        }
        // Возвращаем результат
        return result;
    }

    public static void RunSort(int size) {
        // Выводим исходный список
        var rnd = GeneraterandomList(size);
        System.out.println("IN: " + rnd);
        // Выводим отсортированный список
        System.out.println("OUT: " + MergeSort(rnd));
    }
    public static List<Integer> GeneraterandomList(int size) {
        List<Integer> rnd = new ArrayList<Integer>(size);
        for (int i = 0; i < size; i++) {
            rnd.add((int) (Math.random() * 100));
        }
        return rnd;
    }
}
