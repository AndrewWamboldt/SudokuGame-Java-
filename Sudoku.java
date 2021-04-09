import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class Sudoku extends JFrame {

	/**
	 * KEH
	 */
	private static final long serialVersionUID = 1L;
	//TODO - Declare instance variable
	
	/**
	 * Create a Sudoku game by passing in a File to read from.
	 * The Sudoku class is the main frame.
	 * The main frame should have a title.
	 * The main frame should be square dimensions, I used 700x700.
	 * You will need a gameboard object which is added to some part of the main frame.
	 * Buttons required are:
	 * 		1)Check - If puzzle solved correctly use JOptionPane to display message
	 * 		2)Clear - Clear all answers given by the user
	 * 		3)Solve - Display the correct solution
	 * The buttons should also be added to the main frame, and they may need a panel to hold them.
	 * Add all action listeners so the buttons work!
	 * Make sure the program ends when the game is closed.
	 * 
	 * @param f file to open
	 */
	public Sudoku(File f) {
		//TODO
		this.setTitle("Sudoku");
		this.setSize(700,700);
		
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		GameBoard james = new GameBoard(f);
		this.add(james);
		setVisible(true);
	}
	
	//TODO - Declare any methods or nested classes to perform button actions.

	
	public static void main(String[] args) {
		File f = new File("Sudoku1.sud");
		new Sudoku(f);
	}
	
}
