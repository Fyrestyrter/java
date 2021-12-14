// Класс Ping.
class Ping implements Runnable{
    @Override
    public void run() {
        while (true) {
            // Выводим "Ping".
            System.out.println("Ping");
            try {
                // Делаем задержку потока на 250 мс.
                Thread.sleep(250);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

// Класс Pong.
class Pong implements Runnable{
    @Override
    public void run() {
        while (true) {
            // Выводим "Pong".
            System.out.println("Pong");
            try {
                // Делаем задержку потока на 250 мс.
                Thread.sleep(250);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

public class pingpong {
    // Функция main.
    public static void main(String[] args)
    {
        // Запускаем "Ping" в отдельном потоке.
        Ping ping = new Ping();
        Thread pingObj = new Thread(ping);
        pingObj.start();

        // Запускаем "Pong" в отдельном потоке.
        Pong pong = new Pong();
        Thread pongObj = new Thread(pong);
        pongObj.start();
    }
}