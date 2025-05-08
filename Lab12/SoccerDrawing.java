import javax.swing.*;
import java.awt.*;

public class SoccerDrawing extends JPanel {

    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        // Sky background
        setBackground(new Color(135, 206, 235));

        // Sun
        g.setColor(Color.YELLOW);
        g.fillOval(280, 20, 60, 60);

        // Grass
        g.setColor(new Color(34, 139, 34));
        g.fillRect(0, 150, getWidth(), getHeight() - 150);

        // Tree
        g.setColor(new Color(139, 69, 19));
        g.fillRect(40, 100, 20, 60);
        g.setColor(Color.GREEN);
        g.fillOval(25, 70, 50, 50);

        // Soccer ball base
        int ballX = 165;
        int ballY = 195;
        int radius = 50;

        g.setColor(Color.WHITE);
        g.fillOval(ballX, ballY, radius, radius);
        g.setColor(Color.BLACK);
        g.drawOval(ballX, ballY, radius, radius);

        // Hex patches
        Graphics2D g2 = (Graphics2D) g;
        g2.setStroke(new BasicStroke(2));
        int cx = ballX + radius / 2;
        int cy = ballY + radius / 2;

        // Center + surrounding hex patches (tighter layout)
        drawHex(g2, cx, cy, 8); // center
        drawHex(g2, cx - 16, cy - 8, 6);
        drawHex(g2, cx + 16, cy - 8, 6);
        drawHex(g2, cx - 16, cy + 12, 6);
        drawHex(g2, cx + 16, cy + 12, 6);
        drawHex(g2, cx, cy + 20, 6);
    }

    // Hex drawing method
    private void drawHex(Graphics2D g2, int x, int y, int size) {
        int[] xPoints = new int[6];
        int[] yPoints = new int[6];
        for (int i = 0; i < 6; i++) {
            xPoints[i] = (int) (x + size * Math.cos(i * Math.PI / 3));
            yPoints[i] = (int) (y + size * Math.sin(i * Math.PI / 3));
        }
        g2.setColor(Color.BLACK);
        g2.fillPolygon(xPoints, yPoints, 6);
        g2.drawPolygon(xPoints, yPoints, 6);
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Soccer Drawing");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(420, 320);
        frame.add(new SoccerDrawing());
        frame.setVisible(true);
    }
}
