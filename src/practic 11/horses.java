public class horses {
    public static void main(String[] args) {
        int n = 3;
        System.out.println("Несинхронизированные потоки: ");
        Runner runner = new Runner();
        for (int i = 0; i < n; i++) {
            Thread thread = new Thread(runner);
            thread.setName("Лошадь " + (i + 1));
            thread.start();
        }
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
        }
        System.out.println("Синхронизированные потоки: ");
        SyncRunner syncrunner = new SyncRunner();
        for (int i = 0; i < n; i++) {
            Thread thread = new Thread(syncrunner);
            thread.setName("Лошадь " + (i + 1));
            thread.start();
        }
    }
}

class Runner implements Runnable {
    public void run() {
        System.out.println(Thread.currentThread().getName() + " стартовала");
        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
        }
        System.out.println(Thread.currentThread().getName() + " финишировала");
    }
}

class SyncRunner implements Runnable {
    public synchronized void run() {
        System.out.println(Thread.currentThread().getName() + " стартовала");
        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
        }
        System.out.println(Thread.currentThread().getName() + " финишировала");
    }
}
