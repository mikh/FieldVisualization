package control_structure;

import data_calculation.DataLoad;
import gui.GUI_main;

public class Control {
	public static void main(String[] args){
		System.out.println(String.format("Starting FieldVisualizer v.%d.%d", Defines.MAJOR_VERSION, Defines.MINOR_VERSION));
		GUI_main gui = new GUI_main();
		gui.display_2D_array(DataLoad.load_2D_int_file("values.txt", "\t"));
		System.out.println("Finished Operations. Terminating.");
	}
}
