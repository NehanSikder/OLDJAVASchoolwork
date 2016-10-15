import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Main extends JFrame implements ActionListener {

	protected JButton twoPlayer = new JButton();
	protected JButton exit = new JButton();

	public Main() {
		super("TicTacToe");
		setSize(500, 500);
		setResizable(false);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setVisible(true);
		JPanel main = new JPanel();

		exit.setBackground(Color.red);
		exit.setText("EXIT");
		exit.setForeground(Color.white);
		exit.addActionListener(this);

		twoPlayer.setBackground(Color.red);
		twoPlayer.setText("TwoPlayer");
		twoPlayer.setForeground(Color.white);
		twoPlayer.addActionListener(this);

		main.add(twoPlayer);
		main.add(exit);

		main.setLayout(new GridLayout(2, 1));
		main.setBorder(BorderFactory.createLineBorder(Color.white));
		add(main);
	}

	public static void main(String[] args) {
		Main x = new Main();
	}

	public void actionPerformed(ActionEvent e) {

		if (e.getSource() == exit) {
			this.dispose();
		}
		if (e.getSource() == twoPlayer) {
			MainBoard x = new MainBoard();
			this.dispose();
		}

	}

}
