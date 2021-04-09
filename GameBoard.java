import java.awt.GridLayout;
import java.awt.Point;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;

import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class GameBoard extends JPanel {

	//TODO - Declare 2D array called board to hold NumPieces called board which is 9x9
	public NumPiece[][] board = new NumPiece[9][9];
	/**
	 * Create a GameBoard based on the file passed in.
	 * The GameBoard is a JPanel!
	 * Set layout of GameBoard to be a grid layout, use 9x9.
	 * The GameBoard will display the actual NumPieces the user interacts with.
	 * The 2D instance variable is used for easier look ups.  It is basically a copy of the GameBoard.
	 * Open file passed in from main and fill GameBoard and board with NumPieces.
	 * The file will contain all values to make the Sudoku game.
	 * 		1) Each line is a row in the game.
	 * 		2) All numbers are separated by a comma.
	 * 		3) If a number is followed by a star symbol, it is to be displayed at the start of the game
	 * 		   and can not be edited.
	 * 		4) If it is just a number, it can be edited and displays a blank space.
	 * 		5) See provided files for examples.
	 * 		6) Assume the file passed in will always be correct, you do not need to verify the format.
	 * Make sure each NumPiece is displayed correctly.
	 * Use the methods I have provided in the NumPiece class to set values.
	 * 
	 * @param f
	 */
	public GameBoard(File f) {
		//TODO
		JPanel newfile = new JPanel();
		this.setLayout(new GridLayout(9,9));
		
		String[] words;
		try (Scanner scr = new Scanner(Paths.get(f.getName()))) {
			NumPiece b = null;
			while (scr.hasNextLine()) {
				String output = scr.nextLine();
				words = output.split(" ", output.length());
				for(int i = 0; i < output.length(); i++) {
					board[i][i] = b;
					this.add(b);
				}
			}

			scr.close();
		} catch (IOException e) {
			System.out.println("Error opening " + f.getName());
		}
	}	
		
			
		
		
		
	
	
	/**
	 * Verify if all numbers are correct.
	 * Must verify each individual piece is correct for its row, column, and block.
	 * By verifying each piece, we can change the color to show if it is incorrect
	 * for the row, the column, and the block.
	 * 
	 * @return true or false if all numbers are correct
	 */
	public boolean checkAnswers() {
		//TODO
		return false;
	}
	
	/**
	 * Check if passed in NumPiece is valid for its row.
	 * For a row to be true:
	 * 		1) All cells must be filled, meaning no blanks.
	 * 		   If any blanks are found it is false.
	 * 		2) No duplicates are allowed.
	 * 
	 * DO NOT check the users answer to the actual solution!!!!!
	 * If you do you will lose points.
	 * 
	 * @param np
	 * @return true if valid, false otherwise
	 */
	private boolean validRow(NumPiece np) {
		//TODO
		return false;
	}
	
	/**
	 * Check if passed in NumPiece is valid for its column.
	 * For a column to be true:
	 * 		1) All cells must be filled, meaning no blanks.
	 * 		   If any blanks are found it is false.
	 * 		2) No duplicates are allowed.
	 * 
	 * DO NOT check the users answer to the actual solution!!!!!
	 * If you do you will lose points.
	 * 
	 * @param np
	 * @return true if valid, false otherwise
	 */
	private boolean validCol(NumPiece np) {
		//TODO
		return false;
	}
	
	/**
	 * Check if passed in NumPiece is valid for its block.
	 * For a block to be true:
	 * 		1) All cells must be filled, meaning no blanks.
	 * 		   If any blanks are found it is false.
	 * 		2) No duplicates are allowed.
	 * 
	 * DO NOT check the users answer to the actual solution!!!!!
	 * If you do you will lose points.
	 * 
	 * @param np
	 * @return true if valid, false otherwise
	 */
	private boolean validBlock(NumPiece np) {
		//TODO
		return false;
	}
	
	/**
	 * Clear all answers from the user and reset all background colors.
	 * Only cells that can be edited should experience any change.
	 */
	public void clear() {
		//TODO
	}

	/**
	 * Display all answers for each cell.
	 * Only cells that can be edited should experience any change.
	 */
	public void solve() {
		//TODO
	}

}
