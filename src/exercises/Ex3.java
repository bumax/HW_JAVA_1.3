package exercises;

import javax.print.attribute.IntegerSyntax;
import java.util.Iterator;

// Задан целочисленный список ArrayList. Найти минимальное, максимальное и среднее из этого списка.
public class Ex3 {
    public static void GetListStat(int size){
        // Генерируем рандомный список:
        var rnd = Ex1.GeneraterandomList(size);
        // Печатаем исходный список:
        System.out.println(rnd);
        int maxVal = Integer.MIN_VALUE;
        int minVal = Integer.MAX_VALUE;
        double avgVal = 0; // Среднее арифметическое
        double rmsVal = 0; // Среднее квадратическое
        double harmVal = 0; // Среднее гармоническое
        double geoVal = 1; // Среднее геометрическое (если хоть один элемент массива равен нулю, то ср.геометрич. будет 0)
        // Объявляем итератор:
        Iterator<Integer> listItr = rnd.iterator();
        while(listItr.hasNext()){
            int curVal = listItr.next();
            if (curVal > maxVal) maxVal = curVal;
            if (curVal < minVal) minVal = curVal;
            // Собираем средние:
            avgVal += curVal;
            rmsVal += Math.pow(curVal,2);
            harmVal += 1.0 / curVal;
            geoVal *= curVal;
        }
        // Вычисляес средние
        avgVal /= size;
        rmsVal /= size;
        rmsVal = Math.sqrt(rmsVal);
        harmVal = size / harmVal;
        geoVal = Math.pow(geoVal, 1.0/size);
        // Вывод:
        System.out.println("Максимальное значение списка: " + maxVal);
        System.out.println("Минимальное значение списка: " + minVal);
        System.out.println("Среднее арифметическое значение списка: " + avgVal);
        System.out.println("Среднее квадратическое значение списка: " + rmsVal);
        System.out.println("Среднее гармоническое значение списка: " + harmVal);
        System.out.println("Среднее геометрическое значение списка: " + geoVal);

    }
}
