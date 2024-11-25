import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AnalogClock extends JFrame {
    private ClockPanel clockPanel;
    private ClockController clockController;

    public AnalogClock() {
        setTitle("Analog Clock");
        setSize(400, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Создание панели часов
        clockPanel = new ClockPanel();
        clockController = new ClockController(clockPanel);

        // Создание кнопки управления
        JButton increaseHourButton = new JButton("+1 Hour");
        JButton decreaseHourButton = new JButton("-1 Hour");
        JButton increaseMinuteButton = new JButton("+1 Minute");
        JButton decreaseMinuteButton = new JButton("-1 Minute");

        // Добавление обработчика событий для кнопок
        increaseHourButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                clockController.increaseHour();
            }
        });

        decreaseHourButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                clockController.decreaseHour();
            }
        });

        increaseMinuteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                clockController.increaseMinute();
            }
        });

        decreaseMinuteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                clockController.decreaseMinute();
            }
        });

        // Создание панели с кнопками
        JPanel controlPanel = new JPanel();
        controlPanel.setLayout(new GridLayout(2, 2));
        controlPanel.add(increaseHourButton);
        controlPanel.add(decreaseHourButton);
        controlPanel.add(increaseMinuteButton);
        controlPanel.add(decreaseMinuteButton);

        // Добавление компонентов в окно
        add(clockPanel, BorderLayout.CENTER);
        add(controlPanel, BorderLayout.SOUTH);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            AnalogClock clock = new AnalogClock();
            clock.setVisible(true);
        });
    }
}