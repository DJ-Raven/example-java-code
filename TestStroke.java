package test;

import java.awt.BasicStroke;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.HeadlessException;
import java.awt.Point;
import java.awt.RenderingHints;
import java.awt.Stroke;
import javax.swing.JComponent;
import javax.swing.JFrame;

/**
 *
 * @author Raven
 */
public class TestStroke extends JFrame {

    public TestStroke() throws HeadlessException {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(new Dimension(600, 600));
        setLocationRelativeTo(null);
        PanelStroke panel = new PanelStroke();
        getContentPane().setLayout(new BorderLayout());
        getContentPane().add(panel);
    }

    public static void main(String[] args) {
        new TestStroke().setVisible(true);
    }

    class PanelStroke extends JComponent {

        @Override
        protected void paintComponent(Graphics grphcs) {
            Graphics2D g2 = (Graphics2D) grphcs.create();
            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            g2.setColor(new Color(41, 69, 158));
            Point points[] = new Point[]{new Point(0, 0), new Point(50, 50), new Point(100, 20), new Point(150, 100), new Point(200, 50)};
            float[] dash = {10.0f};
            Stroke s = new BasicStroke(2f, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND, 10.0f, dash, 0.0f);
            g2.setStroke(s);
            for (int i = 1; i < points.length; i++) {
                if (i % 2 == 0) {
                    g2.setStroke(new BasicStroke(2f));
                } else {
                    g2.setStroke(s);
                }
                Point start = points[i - 1];
                Point end = points[i];
                g2.drawLine(start.x, start.y, end.x, end.y);
            }
            g2.dispose();
            super.paintComponent(grphcs);
        }
    }
}
