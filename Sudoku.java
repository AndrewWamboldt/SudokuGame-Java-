import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Sudoku extends JFrame {

	/**
	 * KEH
	 */
	private static final long serialVersionUID = 1L;
	// TODO - Declare instance variable
	JButton clear, solve, check;
	GameBoard gameBoard;

	/**
	 * Create a Sudoku game by passing in a File to read from. The Sudoku class is
	 * the main frame. The main frame should have a title. The main frame should be
	 * square dimensions, I used 700x700. You will need a gameboard object which is
	 * added to some part of the main frame. Buttons required are: 1)Check - If
	 * puzzle solved correctly use JOptionPane to display message
	 * 
	 * 2)Clear - Clear all answers given by the user
	 * 
	 * 3)Solve - Display the correct solution The buttons should also be added to
	 * the main frame, and they may need a panel to hold them. Add all action
	 * listeners so the buttons work! Make sure the program ends when the game is
	 * closed.
	 * 
	 * @param f file to open
	 */
	public Sudoku(File f) {
		// TODO
		this.setTitle("Sudoku");
		this.setSize(700, 700);

		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setLayout(new BorderLayout(2, 1));
		gameBoard = new GameBoard(f);

		this.add(gameBoard);
		createContents();

		clear.addActionListener(new ClearButtonClick());
		solve.addActionListener(new SolveButtonClick());
		check.addActionListener(new CheckButtonClick());

		setVisible(true);
	}

	private void createContents() {

		// Create a JPanel to add the label and text field to
		JPanel bottomPanel = new JPanel();
		clear = new JButton("Clear");
		bottomPanel.add(clear);

		solve = new JButton("Solve");
		bottomPanel.add(solve);

		check = new JButton("Check");
		bottomPanel.add(check);
		this.add(bottomPanel, BorderLayout.SOUTH);

	}

	private class ClearButtonClick implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {

			gameBoard.clear();

		}
	}

	private class SolveButtonClick implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {

			gameBoard.solve();

		}
	}

	private class CheckButtonClick implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {

			gameBoard.checkAnswers();

		}
	}

	// TODO - Declare any methods or nested classes to perform button actions.

	public static void main(String[] args) {
		File f = new File("Sudoku1.sud");
		new GameBoard(f);

		new Sudoku(f);

	}

}
