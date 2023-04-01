package exercises;

import java.util.ListIterator;

// Пусть дан произвольный список целых чисел, удалить из него чётные числа
public class Ex2 {
    public static void RemoveEvenNumbers(int size) {
        // Генерируем рандомный список:
        var rnd = Ex1.GeneraterandomList(size);
        // Печатаем исходный список:
        System.out.println(rnd);
        // Объявляем итератор:
        ListIterator<Integer> listItr = rnd.listIterator();
        // Перебираем список
        while (listItr.hasNext()) {
            // Если число четное, удаляем его из списка
            if (listItr.next() % 2 == 0) listItr.remove();
        }
        // Выводим результат:
        System.out.println(rnd);
    }
}
