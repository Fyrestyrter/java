import java.util.LinkedList;
import java.util.Queue;

public class QueueSolve {
    // Переменные колод карт первого и второго игроков.
    private static Queue<Integer> firstPlayerDeck;
    private static Queue<Integer> secondPlayerDeck;

    // Метод определения победителя в игре.
    public static String getWinner(String[] firstPlayerDeck, String[] secondPlayerDeck) {
        // Инициализация переменных.
        QueueSolve.firstPlayerDeck = new LinkedList<>();
        QueueSolve.secondPlayerDeck = new LinkedList<>();

        // Заносим данные о колодах в соответствующие коллекции.
        for (int i = 0; i < 5; i++) {
            QueueSolve.firstPlayerDeck.add(Integer.parseInt(firstPlayerDeck[i]));
            QueueSolve.secondPlayerDeck.add(Integer.parseInt(secondPlayerDeck[i]));
        }

        for (int i = 0; i < 106; i++) {
            // Если у первого игрока закончились карты, то второй
            // победил. Если у второго игрока закончились карты, то
            // первый победил. В противном случае берется старшая карта.
            if (QueueSolve.firstPlayerDeck.size() == 0)
                return "second " + i;
            else if (QueueSolve.secondPlayerDeck.size() == 0)
                return "first " + i;
            else {
                // Вынимаем карты из колод игроков.
                int firstCard = QueueSolve.firstPlayerDeck.remove();
                int secondCard = QueueSolve.secondPlayerDeck.remove();

                // Проверяем, побеждает ли карта "0" карту "9".
                // В противном случае побеждает старшая карта.
                if (firstCard == 0 && secondCard == 9) {
                    QueueSolve.firstPlayerDeck.add(firstCard);
                    QueueSolve.firstPlayerDeck.add(secondCard);
                }
                else if (secondCard == 0 && firstCard == 9){
                    QueueSolve.secondPlayerDeck.add(firstCard);
                    QueueSolve.secondPlayerDeck.add(secondCard);
                }
                else if(firstCard > secondCard){
                    QueueSolve.firstPlayerDeck.add(firstCard);
                    QueueSolve.firstPlayerDeck.add(secondCard);
                }
                else {
                    QueueSolve.secondPlayerDeck.add(firstCard);
                    QueueSolve.secondPlayerDeck.add(secondCard);
                }
            }
        }

        // Если после 106 итераций победитель так и не был определен,
        // возвращаем слово "botva".
        return "botva";
    }
}
