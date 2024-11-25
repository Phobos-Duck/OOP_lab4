import javax.swing.*;
import java.awt.*;
import java.time.LocalTime;

public class ClockPanel extends JPanel {
    private LocalTime time;

    public ClockPanel() {
        this.time = LocalTime.now();
    }

    public void setTime(LocalTime time) {
        this.time = time;
        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        g.setColor(Color.WHITE);
        g.fillRect(0, 0, getWidth(), getHeight());

        int centerX = getWidth() / 2;
        int centerY = getHeight() / 2;
        int radius = Math.min(centerX, centerY) - 10;

        g.setColor(Color.BLACK);
        g.drawOval(centerX - radius, centerY - radius, 2 * radius, 2 * radius);

        drawClockHands(g, centerX, centerY, radius);
    }

    private void drawClockHands(Graphics g, int centerX, int centerY, int radius) {
        // Углы для стрелок
        int hour = time.getHour();
        int minute = time.getMinute();
        int second = time.getSecond();

        // Угол для часовой стрелки
        double hourAngle = Math.toRadians(360 / 12 * (hour % 12) + 360 / 12 * (minute / 60.0));
        // Угол для минутной стрелки
        double minuteAngle = Math.toRadians(360 / 60 * minute);
        // Угол для секундной стрелки
        double secondAngle = Math.toRadians(360 / 60 * second);

        // Отрисовка часовой стрелки
        drawHand(g, centerX, centerY, hourAngle, radius * 0.5, 8);

        // Отрисовка минутной стрелки
        drawHand(g, centerX, centerY, minuteAngle, radius * 0.75, 6);

        // Отрисовка секундной стрелки
        g.setColor(Color.RED);
        drawHand(g, centerX, centerY, secondAngle, radius * 0.9, 2);
    }

    private void drawHand(Graphics g, int x, int y, double angle, double length, int width) {
        int endX = (int) (x + length * Math.sin(angle));
        int endY = (int) (y - length * Math.cos(angle));

        Graphics2D g2d = (Graphics2D) g;
        g2d.setStroke(new BasicStroke(width));
        g2d.drawLine(x, y, endX, endY);
    }
}
