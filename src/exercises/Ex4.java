package exercises;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

// Реализовать разность массивов и симметрическую разность
public class Ex4 {
    public static void Run() {
        var rnd1 = Ex1.GeneraterandomList(20);
        System.out.println("List 1: " + rnd1);
        var rnd2 = Ex1.GeneraterandomList(20);
        System.out.println("List 2: " + rnd2);
        // Сортируем списки, чтобы можно было применить алгоритм бинарного поиска
        rnd1 = Ex1.MergeSort(rnd1);
        rnd2 = Ex1.MergeSort(rnd2);
        List<Integer> leftJoin = new ArrayList<Integer>();
        List<Integer> innerJoin = new ArrayList<Integer>();
        Iterator<Integer> listItr = rnd1.iterator();
        while (listItr.hasNext()) {
            int val = listItr.next();
            boolean isFound = IsExist(val, rnd2);
            // проверяем найден элемент или нет, а также избавляемся от дубликатов в результирующем списке:
            if (!isFound && (leftJoin.size() == 0 || leftJoin.get(leftJoin.size() - 1) != val))
                leftJoin.add(val);
            else if (isFound && (innerJoin.size() == 0 || innerJoin.get(innerJoin.size() - 1) != val))
                innerJoin.add(val);
        }
        System.out.println("Left Join: " + leftJoin);
        System.out.println("Inner Join: " + innerJoin);
    }

    // Бинарный поиск элемента в массиве:
    private static boolean IsExist(int val, List<Integer> testList) {
        int low = 0;
        int high = testList.size() - 1;

        while (low < high) {
            // Делим пополам сумму макс и мин (побитово смещать, конечно, круче, но менее понятно :) )
            int mid = (low + high) / 2;
            // Получаем значение данного элемента в списке
            int midVal = testList.get(mid);
            // Сравниваем с искомым
            if (midVal < val)
                low = mid + 1;
            else if (midVal > val)
                high = mid - 1;
            else
                // Элемент найден
                return true;
        }
        // Элемент не найден
        return false;
    }
}
