import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        // Переменная ввода данных с клавиатуры.
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите значение 5 карт каждого игрока через пробел:");

        // Ввод колоды первого игрока.
        System.out.print("  Игрок 1:");
        String[] first = scanner.nextLine().split(" ");

        // Ввод колоды второго игрока.
        System.out.print("  Игрок 2:");
        String[] second = scanner.nextLine().split(" ");

        // Выводим результаты тестирования для различных структур данных.
        System.out.println("\nТест:");
        System.out.println("  [Stack] -> " + StackSolve.getWinner(first, second));
        System.out.println("  [Queue] -> " + QueueSolve.getWinner(first, second));
        System.out.println("  [Dequeue] -> " + DequeSolve.getWinner(first, second));
        System.out.println("  [DoubleList] -> " + DoubleListSolve.getWinner(first, second));
    }
}
