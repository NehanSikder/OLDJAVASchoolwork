import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

public class GameOverAnimation extends JPanel implements ActionListener {
	Timer t1;
	int x = 1;
	float alpha = 1;
	String message = "";

	public GameOverAnimation() {
		t1 = new Timer(50, this);
		t1.setInitialDelay(200);
		t1.start();
	}

	public void paint(Graphics g) {
		super.paintComponent(g);
		Graphics2D graphics = (Graphics2D) g;

		Font f = new Font("Dialog", Font.BOLD, x);
		graphics.setFont(f);

		FontMetrics fm1 = graphics.getFontMetrics();
		// String message = "Game Over!!";

		int w = (int) getSize().getWidth();
		int h = (int) getSize().getHeight();

		int width = fm1.stringWidth(message);

		graphics.drawString(message, (w - width) / 2, h / 2);
	}

	public static void main(String[] args) {
		 JFrame frame1 = new JFrame("GameOverAnimation");
		 frame1.setBackground(Color.MAGENTA);
		 frame1.add(new GameOverAnimation());
		 frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		 frame1.setSize(500, 500);
		 frame1.setLocationRelativeTo(null);
		 frame1.setVisible(true);
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public void actionPerformed(ActionEvent e) {
			x += 1;
			alpha -= 0.0000001;
			repaint();
	}
}