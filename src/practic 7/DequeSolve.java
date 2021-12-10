import java.util.ArrayDeque;
import java.util.Deque;

public class DequeSolve {
    // Переменные колод карт первого и второго игроков.
    private static Deque<Integer> firstPlayerDeck;
    private static Deque<Integer> secondPlayerDeck;

    // Метод определения победителя в игре.
    public static String getWinner(String[] firstPlayerDeck, String[] secondPlayerDeck) {
        // Инициализация переменных.
        DequeSolve.firstPlayerDeck = new ArrayDeque<>();
        DequeSolve.secondPlayerDeck = new ArrayDeque<>();

        // Заносим данные о колодах в соответствующие коллекции.
        for (int i = 0; i < 5; i++) {
            DequeSolve.firstPlayerDeck.add(Integer.parseInt(firstPlayerDeck[i]));
            DequeSolve.secondPlayerDeck.add(Integer.parseInt(secondPlayerDeck[i]));
        }

        for (int i = 0; i < 106; i++) {
            // Если у первого игрока закончились карты, то второй
            // победил. Если у второго игрока закончились карты, то
            // первый победил. В противном случае берется старшая карта.
            if (DequeSolve.firstPlayerDeck.size() == 0)
                return "second "+i;
            else if (DequeSolve.secondPlayerDeck.size()== 0)
                return "first "+i;
            else {
                // Вынимаем карты из колод игроков.
                int firstCard = DequeSolve.firstPlayerDeck.remove();
                int secondCard = DequeSolve.secondPlayerDeck.remove();

                // Проверяем, побеждает ли карта "0" карту "9".
                // В противном случае побеждает старшая карта.
                if (firstCard == 0 && secondCard == 9) {
                    DequeSolve.firstPlayerDeck.add(firstCard);
                    DequeSolve.firstPlayerDeck.add(secondCard);
                }
                else if (secondCard == 0 && firstCard == 9){
                    DequeSolve.secondPlayerDeck.add(firstCard);
                    DequeSolve.secondPlayerDeck.add(secondCard);
                }
                else if(firstCard > secondCard){
                    DequeSolve.firstPlayerDeck.add(firstCard);
                    DequeSolve.firstPlayerDeck.add(secondCard);
                }
                else {
                    DequeSolve.secondPlayerDeck.add(firstCard);
                    DequeSolve.secondPlayerDeck.add(secondCard);
                }
            }
        }

        // Если после 106 итераций победитель так и не был определен,
        // возвращаем слово "botva".
        return "botva";
    }
}