import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Menu;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class MainBoard extends JFrame implements ActionListener {

	protected JButton[] buttons = new JButton[9];
	protected JButton restart = new JButton();
	protected JButton exit = new JButton();
	protected JButton menu = new JButton();
	protected TicTacTo x;
	protected boolean player1 = false;
	protected boolean player2 = false;
	protected int winner = 0;
	protected int button = 0;
	private boolean gameOver;

	public MainBoard() {
		super("TicTacToe");
		setVisible(true);
		setResizable(true);
		setSize(500, 500);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);

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

		menu.setBackground(Color.red);
		menu.setText("MENU");
		menu.setForeground(Color.white);
		menu.addActionListener(this);

		exit.setBackground(Color.red);
		exit.setText("EXIT");
		exit.setForeground(Color.white);
		exit.addActionListener(this);

		restart.setBackground(Color.red);
		restart.setText("RESTART");
		restart.setForeground(Color.white);
		restart.addActionListener(this);

		main.add(menu);
		main.add(restart);
		main.add(exit);

		main.setLayout(new GridLayout(4, 3));
		main.setBorder(BorderFactory.createLineBorder(Color.white));
		add(main);
	}

	public static void main(String[] args) {
		MainBoard main = new MainBoard();
	}

	public void check() {
		// System.out.println("beginning check");
		// check if player1 won
		if (this.buttons[0].getText() == "X" && this.buttons[1].getText() == "X" && this.buttons[2].getText() == "X") {
			this.player1 = true;
			this.gameOver = true;
		}
		if (this.buttons[3].getText() == "X" && this.buttons[4].getText() == "X" && this.buttons[5].getText() == "X") {
			this.player1 = true;
			this.gameOver = true;
		}
		if (this.buttons[6].getText() == "X" && this.buttons[7].getText() == "X" && this.buttons[8].getText() == "X") {
			this.player1 = true;
			this.gameOver = true;
		}
		if (this.buttons[0].getText() == "X" && this.buttons[3].getText() == "X" && this.buttons[6].getText() == "X") {
			this.player1 = true;
			this.gameOver = true;

		}
		if (this.buttons[1].getText() == "X" && this.buttons[4].getText() == "X" && this.buttons[7].getText() == "X") {
			this.player1 = true;
			this.gameOver = true;

		}
		if (this.buttons[2].getText() == "X" && this.buttons[5].getText() == "X" && this.buttons[8].getText() == "X") {
			this.player1 = true;
			this.gameOver = true;

		}
		if (this.buttons[0].getText() == "X" && this.buttons[4].getText() == "X" && this.buttons[8].getText() == "X") {
			this.player1 = true;
			this.gameOver = true;

		}
		if (this.buttons[2].getText() == "X" && this.buttons[4].getText() == "X" && this.buttons[6].getText() == "X") {
			this.player1 = true;
			this.gameOver = true;

		}
		// check if player2 won
		if (this.buttons[0].getText() == "O" && this.buttons[1].getText() == "O" && this.buttons[2].getText() == "O") {
			this.player2 = true;
			this.gameOver = true;

		}
		if (this.buttons[3].getText() == "O" && this.buttons[4].getText() == "O" && this.buttons[5].getText() == "O") {
			this.player2 = true;
			this.gameOver = true;

		}
		if (this.buttons[6].getText() == "O" && this.buttons[7].getText() == "O" && this.buttons[8].getText() == "O") {
			this.player2 = true;
			this.gameOver = true;

		}
		if (this.buttons[0].getText() == "O" && this.buttons[3].getText() == "O" && this.buttons[6].getText() == "O") {
			this.player2 = true;
			this.gameOver = true;

		}
		if (this.buttons[1].getText() == "O" && this.buttons[4].getText() == "O" && this.buttons[7].getText() == "O") {
			this.player2 = true;
			this.gameOver = true;

		}
		if (this.buttons[2].getText() == "O" && this.buttons[5].getText() == "O" && this.buttons[8].getText() == "O") {
			this.player2 = true;
			this.gameOver = true;

		}
		if (this.buttons[0].getText() == "O" && this.buttons[4].getText() == "O" && this.buttons[8].getText() == "O") {
			this.player2 = true;
			this.gameOver = true;

		}
		if (this.buttons[2].getText() == "O" && this.buttons[4].getText() == "O" && this.buttons[6].getText() == "O") {
			this.player2 = true;
			this.gameOver = true;

		}
		if (this.gameOver == false){
		int counter = 0;
		for (int i = 0; i < buttons.length; i++) {
			if (buttons[i].getText().equals("X") || buttons[i].getText().equals("O")) {
				counter += 1;
			}
		}
		if (counter == 9) {
			JFrame frame1 = new JFrame("GameOverAnimation");
			frame1.setBackground(Color.MAGENTA);
			GameOverAnimation gameOver = new GameOverAnimation();
			gameOver.setMessage("Tie!");
			frame1.add(gameOver);
			frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame1.setSize(500, 500);
			frame1.setLocationRelativeTo(null);
			frame1.setVisible(true);
			this.dispose();
		}
		}

		if (this.player1 == true || this.player2 == true) {
			JFrame frame1 = new JFrame("GameOverAnimation");
			frame1.setBackground(Color.MAGENTA);
			GameOverAnimation gameOver = new GameOverAnimation();
			if (this.player1) {
				gameOver.setMessage("Player 1 Wins!");
			}
			if (this.player2) {
				gameOver.setMessage("Player 2 Wins!");
			}
			frame1.add(gameOver);
			frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame1.setSize(500, 500);
			frame1.setLocationRelativeTo(null);
			frame1.setVisible(true);
			this.dispose();
		}

	}

	public void createGame(int i) {
		this.x = new TicTacTo();
		this.x.setMainBoard(this);
		for (int y = 0; y < 9; y++) {
			this.buttons[y].setEnabled(false);
		}
	}

	public int setWinner(int x) {
		for (int y = 0; y < 9; y++) {
			this.buttons[y].setEnabled(true);
		}
		this.winner = x;
		return x;
	}

	public void setXO(int button) {
		// System.out.println("setXO"+this.winner);
		if (this.winner == 1) {
			this.buttons[button].setText("X");
		}
		if (this.winner == 2) {
			this.buttons[button].setText("O");
		}
	}

	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource() == buttons[0]) {
			this.button = 0;
			createGame(0); // individual
			// wait
			check();
		}
		if (e.getSource() == buttons[1]) {
			this.button = 1;
			createGame(1);
			check();

		}
		if (e.getSource() == buttons[2]) {
			this.button = 2;
			createGame(2);
			check();
		}
		if (e.getSource() == buttons[3]) {
			this.button = 3;
			createGame(3);
			check();
		}
		if (e.getSource() == buttons[4]) {
			this.button = 4;
			createGame(4);
			check();
		}
		if (e.getSource() == buttons[5]) {
			this.button = 5;
			createGame(5);
			check();
		}
		if (e.getSource() == buttons[6]) {
			this.button = 6;
			createGame(6);
			check();
		}
		if (e.getSource() == buttons[7]) {
			this.button = 7;
			createGame(7);
			check();
		}
		if (e.getSource() == buttons[8]) {
			this.button = 8;
			createGame(8);
			check();
		}
		if (e.getSource() == restart) {
			if (this.x != null) {
				if (this.x.getVisible() == true) {
					this.x.dispose();
				}
			}
			this.dispose();
			MainBoard x = new MainBoard();
		}
		if (e.getSource() == exit) {
			if (this.x != null) {
				if (this.x.getVisible() == true) {
					this.x.dispose();
				}
			}
			this.dispose();
		}
		if (e.getSource() == menu) {
			Main x = new Main();
			this.dispose();
			if (this.x != null) {
				this.x.dispose();
			}
		}

	}
}
