package control_structure;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JComponent;

public class Defines {
	public static final int MAJOR_VERSION = 0;
	public static final int MINOR_VERSION = 0;
	
	/**** main_frame defines ****/
	public static final String JFRAME_NAME = String.format("Field Visualizer v%d.%d", MAJOR_VERSION, MINOR_VERSION);
	public static final Dimension JFRAME_INITIAL_SIZE = new Dimension(1000,1000);
	public static final JComponent JFRAME_RELATIVE_COMPONENT_POSITION = null;
	public static final int JFRAME_NUMBER_OF_ROWS = 100;
	public static final int JFRAME_NUMBER_OF_COLS = 100;
	public static final Color TILE_INITIAL_COLOR = Color.WHITE;
}
