import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class TicTacTo extends JFrame implements ActionListener {

	protected JButton[] buttons = new JButton[9];
	protected byte counter = 0;
	protected boolean player1Win;
	protected boolean player2Win;
	protected boolean visible;
	protected boolean tie;
	protected MainBoard main;
	private boolean gameWon;

	public TicTacTo() {
		super("TicTacToe");
		setVisible(true);
		setResizable(true);
		setSize(500, 500);
		setLocation(500, 0);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.visible = true;
		this.player1Win = false;
		this.player2Win = false;
		this.tie = false;

		// setting up JPanel
		JPanel main = new JPanel();
		// setting up buttons
		for (int i = 0; i < 9; i++) {
			buttons[i] = new JButton();
			buttons[i].setBackground(Color.BLACK);
			buttons[i].addActionListener(this);
			buttons[i].setForeground(Color.WHITE);
			buttons[i].setFont(new Font("Arial", Font.PLAIN, 40));
		}
		for (int i = 0; i < 9; i++) {
			main.add(buttons[i]);
		}

		main.setLayout(new GridLayout(3, 3));
		main.setBorder(BorderFactory.createLineBorder(Color.white));
		add(main);

	}

	public static void main(String[] args) {
		TicTacTo x = new TicTacTo();
	}

	public void setMainBoard(MainBoard m) {
		this.main = m;
	}

	public boolean getVisible() {
		return this.visible;
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == buttons[0]) {
			buttonXO(0);
			check();
		}
		if (e.getSource() == buttons[1]) {
			buttonXO(1);
			check();
		}
		if (e.getSource() == buttons[2]) {
			buttonXO(2);
			check();
		}
		if (e.getSource() == buttons[3]) {
			buttonXO(3);
			check();
		}
		if (e.getSource() == buttons[4]) {
			buttonXO(4);
			check();
		}
		if (e.getSource() == buttons[5]) {
			buttonXO(5);
			check();
		}
		if (e.getSource() == buttons[6]) {
			buttonXO(6);
			check();
		}
		if (e.getSource() == buttons[7]) {
			buttonXO(7);
			check();
		}
		if (e.getSource() == buttons[8]) {
			buttonXO(8);
			check();
		}

	}

	public void check() {
		// check if player1 won
		if (this.buttons[0].getText() == "X" && this.buttons[1].getText() == "X" && this.buttons[2].getText() == "X") {
			this.player1Win = true;
			this.gameWon = true;
			JOptionPane.showMessageDialog(null, "Player 1 picks", "TicTacNine", JOptionPane.INFORMATION_MESSAGE);

		}
		if (this.buttons[3].getText() == "X" && this.buttons[4].getText() == "X" && this.buttons[5].getText() == "X") {
			this.player1Win = true;
			this.gameWon = true;
			JOptionPane.showMessageDialog(null, "Player 1 picks", "TicTacNine", JOptionPane.INFORMATION_MESSAGE);


		}
		if (this.buttons[6].getText() == "X" && this.buttons[7].getText() == "X" && this.buttons[8].getText() == "X") {
			this.player1Win = true;
			this.gameWon = true;
			JOptionPane.showMessageDialog(null, "Player 1 picks", "TicTacNine", JOptionPane.INFORMATION_MESSAGE);


		}
		if (this.buttons[0].getText() == "X" && this.buttons[3].getText() == "X" && this.buttons[6].getText() == "X") {
			this.player1Win = true;
			this.gameWon = true;
			JOptionPane.showMessageDialog(null, "Player 1 picks", "TicTacNine", JOptionPane.INFORMATION_MESSAGE);


		}
		if (this.buttons[1].getText() == "X" && this.buttons[4].getText() == "X" && this.buttons[7].getText() == "X") {
			this.player1Win = true;
			this.gameWon = true;
			JOptionPane.showMessageDialog(null, "Player 1 picks", "TicTacNine", JOptionPane.INFORMATION_MESSAGE);


		}
		if (this.buttons[2].getText() == "X" && this.buttons[5].getText() == "X" && this.buttons[8].getText() == "X") {
			this.player1Win = true;
			this.gameWon = true;
			JOptionPane.showMessageDialog(null, "Player 1 picks", "TicTacNine", JOptionPane.INFORMATION_MESSAGE);

		}
		if (this.buttons[0].getText() == "X" && this.buttons[4].getText() == "X" && this.buttons[8].getText() == "X") {
			this.player1Win = true;
			this.gameWon = true;
			JOptionPane.showMessageDialog(null, "Player 1 picks", "TicTacNine", JOptionPane.INFORMATION_MESSAGE);

		}
		if (this.buttons[2].getText() == "X" && this.buttons[4].getText() == "X" && this.buttons[6].getText() == "X") {
			this.player1Win = true;
			this.gameWon = true;
			JOptionPane.showMessageDialog(null, "Player 1 picks", "TicTacNine", JOptionPane.INFORMATION_MESSAGE);

		}
		// check if player2 won
		if (this.buttons[0].getText() == "O" && this.buttons[1].getText() == "O" && this.buttons[2].getText() == "O") {
			this.player2Win = true;
			this.gameWon = true;
			JOptionPane.showMessageDialog(null, "Player 2 picks", "TicTacNine", JOptionPane.INFORMATION_MESSAGE);

		}
		if (this.buttons[3].getText() == "O" && this.buttons[4].getText() == "O" && this.buttons[5].getText() == "O") {
			this.player2Win = true;
			this.gameWon = true;
			JOptionPane.showMessageDialog(null, "Player 2 picks", "TicTacNine", JOptionPane.INFORMATION_MESSAGE);


		}
		if (this.buttons[6].getText() == "O" && this.buttons[7].getText() == "O" && this.buttons[8].getText() == "O") {
			this.player2Win = true;
			this.gameWon = true;
			JOptionPane.showMessageDialog(null, "Player 2 picks", "TicTacNine", JOptionPane.INFORMATION_MESSAGE);


		}
		if (this.buttons[0].getText() == "O" && this.buttons[3].getText() == "O" && this.buttons[6].getText() == "O") {
			this.player2Win = true;
			this.gameWon = true;
			JOptionPane.showMessageDialog(null, "Player 2 picks", "TicTacNine", JOptionPane.INFORMATION_MESSAGE);


		}
		if (this.buttons[1].getText() == "O" && this.buttons[4].getText() == "O" && this.buttons[7].getText() == "O") {
			this.player2Win = true;
			this.gameWon = true;
			JOptionPane.showMessageDialog(null, "Player 2 picks", "TicTacNine", JOptionPane.INFORMATION_MESSAGE);


		}
		if (this.buttons[2].getText() == "O" && this.buttons[5].getText() == "O" && this.buttons[8].getText() == "O") {
			this.player2Win = true;
			this.gameWon = true;
			JOptionPane.showMessageDialog(null, "Player 2 picks", "TicTacNine", JOptionPane.INFORMATION_MESSAGE);

		}
		if (this.buttons[0].getText() == "O" && this.buttons[4].getText() == "O" && this.buttons[8].getText() == "O") {
			this.player2Win = true;
			this.gameWon = true;
			JOptionPane.showMessageDialog(null, "Player 2 picks", "TicTacNine", JOptionPane.INFORMATION_MESSAGE);

		}
		if (this.buttons[2].getText() == "O" && this.buttons[4].getText() == "O" && this.buttons[6].getText() == "O") {
			this.player2Win = true;
			this.gameWon = true;
			JOptionPane.showMessageDialog(null, "Player 2 picks", "TicTacNine", JOptionPane.INFORMATION_MESSAGE);

		}
		if(this.gameWon == false){
			int counter = 0;
			for (int i = 0; i < buttons.length; i++) {
				if (buttons[i].getText().equals("X") || buttons[i].getText().equals("O")) {
					counter += 1;
				}
			}
			if (counter == 9) {
				Tie();
			}
		}
		if (this.player2Win) {
			this.main.setWinner(2);
			this.main.setXO(this.main.button);
			this.main.check();
			this.dispose();
		} else if (this.player1Win) {
			this.main.setWinner(1);
			this.main.setXO(this.main.button);
			this.main.check();
			this.dispose();
		}
	}

	public void Tie() {
		// System.out.println("THIS IS A TIE");
		Random rand = new Random();
		int answer = rand.nextInt(10) + 1;

		JOptionPane.showMessageDialog(null, "So we have a tie.....", "TicTacNine", JOptionPane.INFORMATION_MESSAGE);
		String player1 = (String) JOptionPane.showInputDialog(null, "Player 1, please choose a number between 1 and 10",
				"TicTacNine", JOptionPane.INFORMATION_MESSAGE, new ImageIcon(""), null, null);
		String player2 = (String) JOptionPane.showInputDialog(null,
				"Player 2, please choose a number between 1 and 10, different than player 1's choice", "TicTacNine",
				JOptionPane.INFORMATION_MESSAGE, new ImageIcon(""), null, null);

		while (player1.equals(player2)) {
			player2 = (String) JOptionPane.showInputDialog(null, "Please choose a different number between 1 and 10",
					"TicTacNine", JOptionPane.INFORMATION_MESSAGE, new ImageIcon(""), null, null);
		}

		int play1 = Integer.parseInt(player1);
		int play2 = Integer.parseInt(player2);

		if (play1 == answer) {
			JOptionPane.showMessageDialog(null, "Player 1  wins! The number was: " + answer, "TicTacNine",
					JOptionPane.INFORMATION_MESSAGE);
			this.player1Win = true;
			// this.main.winner = 1;
		} else if (play2 == answer) {
			JOptionPane.showMessageDialog(null, "Player 2 wins! The number was: " + answer, "TicTacNine",
					JOptionPane.INFORMATION_MESSAGE);
			this.player2Win = true;
			// this.main.winner = 2;
		}
		int abs1 = 0;
		int abs2 = 0;

		abs1 = Math.abs(play1 - answer);
		abs2 = Math.abs(play2 - answer);

		if (abs1 < abs2) {
			JOptionPane.showMessageDialog(null, "Player 1 wins! The number was: " + answer, "TicTacNine",
					JOptionPane.INFORMATION_MESSAGE);
			this.player1Win = true;
			// this.main.winner = 1;
		} else if (abs2 < abs1) {
			JOptionPane.showMessageDialog(null, "Player 2 wins! The number was: " + answer, "TicTacNine",
					JOptionPane.INFORMATION_MESSAGE);
			this.player2Win = true;
			// this.main.winner = 2;
		} else if (abs1 == abs2) {
			if (play1 > answer) {
				JOptionPane.showMessageDialog(null, "Player 2 wins! The number was: " + answer, "TicTacNine",
						JOptionPane.INFORMATION_MESSAGE);
				this.player2Win = true;
				// this.main.winner = 2;
			} else {
				JOptionPane.showMessageDialog(null, "Player 1 wins! The number was: " + answer, "TicTacNine",
						JOptionPane.INFORMATION_MESSAGE);
				this.player1Win = true;
				// this.main.winner = 1;
			}
		}

		// System.out.println(answer);

		if (this.player1Win == true || this.player2Win == true) {
			this.dispose();
		}
	}

	public boolean getPlayer1Win() {
		return player1Win;
	}

	public void setPlayer1Win(boolean player1Win) {
		this.player1Win = player1Win;
	}

	public boolean getPlayer2Win() {
		return player2Win;
	}

	public void setPlayer2Win(boolean player2Win) {
		this.player2Win = player2Win;
	}

	public void buttonXO(int i) {
		counter++;
		counter %= 2;
		if (counter == 1) {
			buttons[i].setText("X");
		} else if (counter == 0) {
			buttons[i].setText("O");
		}
	}

	public void close() {
		this.dispose();
	}

}
