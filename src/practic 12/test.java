import java.util.Scanner;

public class test {
    // Функция main.
    public static void main(String[] args) {
        // Инициализируем переменную ввода.
        Scanner scanner = new Scanner(System.in);

        // Ввод ФИО.
        System.out.print("ФИО: ");
        String name = scanner.nextLine();

        while (true) {
            // Ввод ИНН.
            System.out.print("ИНН: ");
            String INN = scanner.nextLine();
            try {
                // Проверяем, корректен ли ИНН. Если ИНН корректен,
                // программа пойдет дальше и не выбросит ошибку.
                checkinn(INN);

                // Выходим из цикла.
                System.out.println("Корретный ИНН");
                return;
            } catch (inn ex) {
                // Выводим на экран ошибку.
                System.out.println("Не корректный ИНН");
                System.out.println(ex.toString());
                System.out.println("Попробуй еще раз");
            }
        }
    }

    static void checkinn(String INN) throws inn {
        // Неверная длина ИНН.
        if (INN.length() != 12)
            throw new inn("Неверное количество цифр.");
            // ИНН содержит символы, не являющиеся цифрами.
        else
            for (int i = 0; i < INN.length(); i++)
                if ((int) INN.charAt(i) < 48 || (int) INN.charAt(i) > 57)
                    throw new inn("Некорректные символы.");
    }
}