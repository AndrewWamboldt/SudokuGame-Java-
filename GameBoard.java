import java.awt.GridLayout;
import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.JPanel;

public class GameBoard extends JPanel {

	// TODO - Declare 2D array called board to hold NumPieces called board which is
	// 9x9
	public NumPiece[][] board = new NumPiece[9][9];

	/**
	 * Create a GameBoard based on the file passed in. The GameBoard is a JPanel!
	 * Set layout of GameBoard to be a grid layout, use 9x9. The GameBoard will
	 * display the actual NumPieces the user interacts with. The 2D instance
	 * variable is used for easier look ups. It is basically a copy of the
	 * GameBoard. Open file passed in from main and fill GameBoard and board with
	 * NumPieces. The file will contain all values to make the Sudoku game. 1) Each
	 * line is a row in the game. 2) All numbers are separated by a comma. 3) If a
	 * number is followed by a star symbol, it is to be displayed at the start of
	 * the game and can not be edited. 4) If it is just a number, it can be edited
	 * and displays a blank space. 5) See provided files for examples. 6) Assume the
	 * file passed in will always be correct, you do not need to verify the format.
	 * Make sure each NumPiece is displayed correctly. Use the methods I have
	 * provided in the NumPiece class to set values.
	 * 
	 * @param f
	 */
	public GameBoard(File f) {
		// TODO
		JPanel newfile = new JPanel();
		this.setLayout(new GridLayout(9, 9));
		int row = 0;

		String[] words;
		try (Scanner scr = new Scanner(Paths.get(f.getName()))) {

			while (scr.hasNextLine()) {
				String output = scr.nextLine();
				words = output.split(",", output.length());

				for (int i = 0; i < words.length; i++) {

					String answers = words[i];

					boolean canEdit = words[i].length() == 1;
					int value = Integer.parseInt(words[i].substring(0, 1));

					NumPiece piece = new NumPiece(row, i, value, canEdit);
					board[row][i] = piece;
					this.add(piece);
					System.out.println("  " + answers);
				}
				row++;
			}

			scr.close();
		} catch (IOException e) {
			System.out.println("Error opening " + f.getName());
		}
	}

	/**
	 * Verify if all numbers are correct. Must verify each individual piece is
	 * correct for its row, column, and block. By verifying each piece, we can
	 * change the color to show if it is incorrect for the row, the column, and the
	 * block.
	 * 
	 * @return true or false if all numbers are correct
	 */
	public boolean checkAnswers() {
		// TODO
		Boolean allAreValid = true;

//		if (validBlock() == false) {
//
//			allAreValid = false;
//		}

		for (int row = 0; row < board[0].length; row++) {
			// foundValues.clear();
			for (int col = 0; col < board.length; col++) {

				// validRow(board[row][col]);
				if (validateRowByBlock(getBlock(board, 0, 0, board.length), board[row][col]) == false) {

					allAreValid = false;
				}
				if (validateColByBlock(getBlock(board, 0, 0, board.length), board[row][col]) == false) {

					allAreValid = false;
				}
//				if (validBlock(board[row][col]) == false) {
//
//					allAreValid = false;
//				}

			}
		}
		return allAreValid;
	}

	/**
	 * Check if passed in NumPiece is valid for its row. For a row to be true: 1)
	 * All cells must be filled, meaning no blanks. If any blanks are found it is
	 * false. 2) No duplicates are allowed.
	 * 
	 * DO NOT check the users answer to the actual solution!!!!! If you do you will
	 * lose points.
	 * 
	 * @param np
	 * @return true if valid, false otherwise
	 */
//	private boolean validRow(NumPiece np) {
//
//		if (np.getSelectedValue() == null) {
//			np.changeColor();
//			return false;
//		}
//		for (int col = 0; col < board.length; col++) {
//			if (board[np.getRow()][col].getCol() != np.getCol()) {
//
//				if (board[np.getRow()][col].getSelectedValue() == np.getSelectedValue()) {
//					np.changeColor();
//					board[np.getRow()][col].changeColor();
//					return false;
//				}
//			}
//
//		}
//		return true;
//	}

	/**
	 * Check if passed in NumPiece is valid for its column. For a column to be true:
	 * 1) All cells must be filled, meaning no blanks. If any blanks are found it is
	 * false. 2) No duplicates are allowed.
	 * 
	 * DO NOT check the users answer to the actual solution!!!!! If you do you will
	 * lose points.
	 * 
	 * @param np
	 * @return true if valid, false otherwise
	 */
//	private boolean validCol(NumPiece np) {
//		// TODO
//		if (np.getSelectedValue() == null) {
//			np.changeColor();
//			return false;
//		}
//		for (int row = 0; row < board[0].length; row++) {
//			if (board[row][np.getCol()].getRow() != np.getRow()) {
//
//				if (board[row][np.getCol()].getSelectedValue() == np.getSelectedValue()) {
//					np.changeColor();
//					board[row][np.getCol()].changeColor();
//					return false;
//				}
//			}
//		}
//		return true;
//	}

	/**
	 * Check if passed in NumPiece is valid for its block. For a block to be true:
	 * 1) All cells must be filled, meaning no blanks. If any blanks are found it is
	 * false. 2) No duplicates are allowed.
	 * 
	 * DO NOT check the users answer to the actual solution!!!!! If you do you will
	 * lose points.
	 * 
	 * @param np
	 * @return true if valid, false otherwise
	 */
	private boolean validBlock() {
		// TODO
//		NumPiece[][] block = new NumPiece[3][3];
		Boolean allAreValid = true;
//		// validateRowByBlock(blocks, np);
//		block = getBlock(board, 0, 0, 3);
//		for (int row = 0; row < block.length; row++) {
//			for (int col = 0; col < block[0].length; col++) {
//
//				if (ValidateBySmallBlock(block, block[row][col]) == false) {
//					allAreValid = false;
//				}
//
//			}
//		}
		if (validateSmallBlock2(0, 0) == false) {
			allAreValid = true;
		}
		if (validateSmallBlock2(0, 3) == false) {
			allAreValid = true;
		}
		if (validateSmallBlock2(0, 6) == false) {
			allAreValid = true;
		}
		if (validateSmallBlock2(3, 0) == false) {
			allAreValid = true;
		}
		if (validateSmallBlock2(3, 3) == false) {
			allAreValid = true;
		}
		if (validateSmallBlock2(3, 6) == false) {
			allAreValid = true;
		}
		if (validateSmallBlock2(6, 0) == false) {
			allAreValid = true;
		}
		if (validateSmallBlock2(6, 3) == false) {
			allAreValid = true;
		}
		if (validateSmallBlock2(6, 6) == false) {
			allAreValid = true;
		}

//		if (ValidateBySmallBlock(getBlock(board, 0, 3, 3)) == false) {
//			allAreValid = false;
//		}
//
//		if (ValidateBySmallBlock(getBlock(board, 0, 6, 3)) == false) {
//			allAreValid = false;
//		}
//
//		if (ValidateBySmallBlock(getBlock(board, 3, 0, 3)) == false) {
//			allAreValid = false;
//		}
//
//		if (ValidateBySmallBlock(getBlock(board, 3, 3, 3)) == false) {
//			allAreValid = false;
//		}
//
//		if (ValidateBySmallBlock(getBlock(board, 3, 6, 3)) == false) {
//			allAreValid = false;
//		}
//
//		if (ValidateBySmallBlock(getBlock(board, 6, 0, 3)) == false) {
//			allAreValid = false;
//		}
//
//		if (ValidateBySmallBlock(getBlock(board, 6, 6, 3)) == false) {
//			allAreValid = false;
//		}
//
//		if (ValidateBySmallBlock(getBlock(board, 6, 6, 3)) == false) {
//			allAreValid = false;
//		}
		return allAreValid;
	}

	public boolean validateSmallBlock2(int rowOffset, int colOffset) {
		NumPiece[][] block = new NumPiece[3][3];
		Boolean allAreValid = true;
		// validateRowByBlock(blocks, np);
		block = getBlock(board, rowOffset, colOffset, 3);
		for (int row = 0; row < block.length; row++) {
			for (int col = 0; col < block[0].length; col++) {

				if (ValidateBySmallBlock(block, block[row][col]) == false) {
					allAreValid = false;
				}

			}
		}
		return allAreValid;
	}

	public boolean validateRowByBlock(NumPiece[][] block, NumPiece np) {
		int ColorCancel = 0;

		if (np.getSelectedValue() == null) {
			np.changeColor();
			return false;
		}
		for (int col = 0; col < block.length; col++) {
			if (block[np.getRow()][col].getCol() != np.getCol()) {

				if (block[np.getRow()][col].getSelectedValue() == np.getSelectedValue()) {
					np.changeColor();
//					block[np.getRow()][col].changeColor();
					++ColorCancel;
					return false;
				}
			}

		}
		return true;

	}

	public boolean validateColByBlock(NumPiece[][] block, NumPiece np) {
		if (np.getSelectedValue() == null) {
			np.changeColor();
			return false;
		}
		for (int row = 0; row < block[0].length; row++) {
			if (block[row][np.getCol()].getRow() != np.getRow()) {

				if (block[row][np.getCol()].getSelectedValue() == np.getSelectedValue()) {
					np.changeColor();
					// block[row][np.getCol()].changeColor();
					return false;
				}
			}
		}
		return true;
	}

	public boolean ValidateBySmallBlock(NumPiece[][] block, NumPiece np) {
		ArrayList<Integer> foundValues = new ArrayList<Integer>();
		Boolean isValid = true;
		for (int row = 0; row < block.length; row++) {
			for (int col = 0; col < block[0].length; col++) {
				System.out.print(" " + block[row][col].getSelectedValue());
				if (row != np.getRow() && col != np.getCol()) {
					if (block[row][col].getSelectedValue() == np.getSelectedValue()) {

						block[row][col].changeColor();
						return false;
						// isValid = false;
					}
				}
				foundValues.add(block[row][col].getSelectedValue());

//				if (block[np.getRow()][col].getSelectedValue() == np.getSelectedValue()) {
//					np.changeColor();
//					return false;
//				}

			}
		}
		return isValid;
	}

	public NumPiece[][] getBlock(NumPiece[][] block, int rowOffset, int colOffset, int length) {
		NumPiece[][] holder = new NumPiece[length][length];
		for (int row = 0; row < holder[0].length; row++) {
			for (int col = 0; col < holder.length; col++) {
				holder[row][col] = block[row + rowOffset][col + colOffset];
			}
		}
		return holder;
	}

	/**
	 * Clear all answers from the user and reset all background colors. Only cells
	 * that can be edited should experience any change.
	 */
	public void clear() {
		// TODO
		for (int row = 0; row < board[0].length; row++) {
			for (int col = 0; col < board.length; col++) {
				if (board[row][col].canEdit()) {
					(board[row][col]).resetNumber();
				}
			}
		}
	}

	/**
	 * Display all answers for each cell. Only cells that can be edited should
	 * experience any change.
	 */
	public void solve() {
		// TODO
		for (int row = 0; row < board[0].length; row++) {
			for (int col = 0; col < board.length; col++) {
				if (board[row][col].canEdit()) {
					(board[row][col]).solve();
				}
			}
		}
	}

}
