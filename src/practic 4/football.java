import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class football {

    private int RealMadridCount = 0;
    private int MilanCount = 0;

    football() {
        // Создать новый контейнер (окна) JFrame.
        JFrame frame = new JFrame("Football");

        // Установка начального размера фрейма и перемещение
        // в центр экрана.
        frame.setSize(600, 300);
        frame.setLocationRelativeTo(null);

        // Завершаем работу программы, если пользователь закрывает приложение.
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Отобразить фрейм.
        frame.setVisible(true);

        // Создаем кнопку с текстом "AC Milan".
        JButton milanButton = new JButton("AC Milan");
        milanButton.setBounds(140,70,100, 40);

        // Создаем кнопку с текстом "Real Madrid".
        JButton realMadridButton = new JButton("Real Madrid");
        realMadridButton.setBounds(20,70,100, 40);

        // Создаем текстовый блок с текстом "Result".
        JLabel resultLabel = new JLabel("Result: 0 X 0");
        resultLabel.setBounds(20, 20, 220, 40);
        resultLabel.setVerticalAlignment(JLabel.BOTTOM);
        resultLabel.setHorizontalAlignment(JLabel.CENTER);

        // Создаем текстовый блок с текстом "Last Scorer".
        JLabel lastScoreLabel = new JLabel("Last Scorer: N/A");
        lastScoreLabel.setBounds(250, 70, 220, 20);
        lastScoreLabel.setVerticalAlignment(JLabel.CENTER);
        lastScoreLabel.setHorizontalAlignment(JLabel.LEFT);

        // Создаем текстовый блок с текстом "Winner".
        JLabel winnerLabel = new JLabel("Winner: DRAW");
        winnerLabel.setBounds(250, 90, 220, 20);
        winnerLabel.setVerticalAlignment(JLabel.CENTER);
        winnerLabel.setHorizontalAlignment(JLabel.LEFT);

        // Добавляем элементы управления в фрейм.
        frame.add(milanButton);
        frame.add(realMadridButton);
        frame.add(resultLabel);
        frame.add(lastScoreLabel);
        frame.add(winnerLabel);

        frame.setLayout(null);

        realMadridButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                RealMadridCount++;
                resultLabel.setText("Result: " + RealMadridCount + " X " + MilanCount);
                lastScoreLabel.setText("Last Scorer: Real Madrid");
                if (RealMadridCount > MilanCount)
                    winnerLabel.setText("Winner: Real Madrid");
                else if (RealMadridCount == MilanCount)
                    winnerLabel.setText("Winner: DRAW");
                else
                    winnerLabel.setText("Winner: AC Milan");
            }
        });

        milanButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MilanCount++;
                resultLabel.setText("Result: " + RealMadridCount + " X " + MilanCount);
                lastScoreLabel.setText("Last Scorer: AC Milan");
                if (RealMadridCount > MilanCount)
                    winnerLabel.setText("Winner: Real Madrid");
                else if (RealMadridCount == MilanCount)
                    winnerLabel.setText("Winner: DRAW");
                else
                    winnerLabel.setText("Winner: AC Milan");
            }
        });
    }

    public static void main(String[] args) {
        // Создать фрейм в потоке диспетчера событий (создает объект SwingDemo)
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new football();
            }
        });
    }
}
