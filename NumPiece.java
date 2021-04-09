import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.plaf.basic.BasicComboBoxUI;

/**
 * A NumPiece is a cell on the GameBoard for Sudoku.
 * A NumPiece can be editable or not.
 * It uses a JComboBox to make sure only certain values can be selected by the player.
 */
public final class NumPiece extends JComboBox<Integer> {

	/**
	 * KEH
	 */
	private static final long serialVersionUID = 1L;
	private int r,c,solution;
	private boolean canEdit;
	
	Font myFont = new Font("Serif", Font.BOLD, 40);
	BasicComboBoxUI UI = new BasicComboBoxUI() {
		protected JButton createArrowButton() {
			return new JButton() {
				/**
				 * KEH
				 */
				private static final long serialVersionUID = 1L;

				public int getWidth() {
					return 0;
				}
			};
		}
	};

	/**
	 * Create a NumPiece which is added to the board.
	 * 
	 * @param r = row of NumPiece on GameBoard
	 * @param c = column of NumPiece on GameBoard
	 * @param solution = actual solution for NumPiece
	 * @param canEdit determines if this an editable or uneditable NumPiece
	 */
	public NumPiece(int r, int c, int solution, boolean canEdit) {
		super();
		setFont(myFont);
		this.r = r;
		this.c = c;
		this.solution = solution;
		this.canEdit = canEdit;

		setFont(myFont);
		for(int i = 1; i < 10; i++) {
			addItem(i);
		}
		
		if(canEdit) setSelectedItem(null);
		else setSelectedItem(solution);

		this.setEnabled(canEdit);
		
		setUI(UI);
		((JLabel)this.getRenderer()).setHorizontalAlignment(SwingConstants.CENTER);
		this.setBorder(BorderFactory.createLineBorder(Color.black));
		setVisible(true);
		this.addActionListener (new ActionListener () {
			@Override
			public void actionPerformed(ActionEvent e) {
				setBackground(null);
			}
		});
	}
	
	/**
	 * Return row of NumPiece in GameBoard.
	 * 
	 * @return r
	 */
	public int getRow() {
		return this.r;
	}
	
	/**
	 * Return column of NumPiece in GameBoard.
	 * 
	 * @return c
	 */
	public int getCol() {
		return this.c;
	}


	/**
	 * Used to set a number.  Number must be in the correct range of 1 to 9.
	 * @param i sets the number to be displayed
	 */
	public void setNumber(int i) {
		if(i <= 0 && i >= 10) return;
		this.setSelectedItem(i);
	}
	
	/**
	 * Tells GameBoard if NumPiece is editable or not.
	 * 
	 * @return true or false if can edit NumPiece.
	 */
	public boolean canEdit() {
		return canEdit;
	}

	/**
	 * Change color of NumPiece if not correct.
	 */
	public void changeColor() {
		Color c = this.getBackground();
		//Keeps all values in correct range.
		if(c.getRed()+5>=255 || c.getGreen()-70 < 0 || c.getBlue()-70 < 0) return;
		
		Color d = new Color(c.getRed()+5,c.getGreen()-70,c.getBlue()-70);
		this.setBackground(d);
	}
	
	/**
	 * Return value of selected piece.
	 * 
	 * @return Integer value of selected piece.
	 */
	public Integer getSelectedValue() {
		return (Integer) this.getSelectedItem();
	}

	/**
	 * Reset number to blank if NumPiece is editable.
	 */
	public void resetNumber() {
		if(canEdit) {
			this.setSelectedItem(null);
		}
	}
	
	/**
	 * Reset background to gray if NumPiece is editable.
	 */
	public void resetBackground() {
		if(canEdit) {
			this.setBackground(null);
		}
	}
	
	/**
	 * Display solution for NumPiece.
	 */
	public void solve() {
		this.setSelectedItem(solution);
	}
	
	@Override
	public String toString() {
		return "Value: " + this.getSelectedValue() + ", Row: " + this.r + ", Col: " + this.c;
	}
	
}



