package gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.JFrame;

import control_structure.Defines;

public class GUI_main {
	JFrame main_frame = null;
	
	public GUI_main(){
		/**** JFrame main_frame setup ****/
		main_frame = new JFrame(Defines.JFRAME_NAME);
		main_frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		main_frame.setSize(Defines.JFRAME_INITIAL_SIZE);
		main_frame.setMinimumSize(Defines.JFRAME_INITIAL_SIZE);
		main_frame.setPreferredSize(Defines.JFRAME_INITIAL_SIZE);
		main_frame.setLocationRelativeTo(Defines.JFRAME_RELATIVE_COMPONENT_POSITION);
		main_frame.setLayout(new GridLayout(Defines.JFRAME_NUMBER_OF_ROWS, Defines.JFRAME_NUMBER_OF_COLS));
		
		populate_main_frame(Defines.JFRAME_NUMBER_OF_ROWS, Defines.JFRAME_NUMBER_OF_COLS, new Dimension(Defines.JFRAME_INITIAL_SIZE.width/Defines.JFRAME_NUMBER_OF_ROWS, Defines.JFRAME_INITIAL_SIZE.height/Defines.JFRAME_NUMBER_OF_COLS), Defines.TILE_INITIAL_COLOR);
	
		/**** Display GUI ****/
		main_frame.setVisible(true);
	}
	
	private void populate_main_frame(int n_rows, int n_cols, Dimension size, Color color){
		for (int ii = 0; ii < n_rows; ii++){
			for(int jj = 0; jj < n_cols; jj++){
				main_frame.add(new Tile(ii*n_cols+jj, size, color), ii, jj);
			}
		}
	}
}
