import exercises.*;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.print("Введите номер задания: ");
        int ex = scan.nextInt();
        switch (ex) {
            case 1:
                Ex1.RunSort(30);
                break;
            case 2:
                Ex2.RemoveEvenNumbers(30);
                break;
            case 3:
                Ex3.GetListStat(30);
                break;
            case 4:
                Ex4.Run();
                break;
        }
    }
}