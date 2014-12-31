package control_structure;

import gui.GUI_main;

public class Control {
	public static void main(String[] args){
		System.out.println(String.format("Starting FieldVisualizer v.%d.%d", Defines.MAJOR_VERSION, Defines.MINOR_VERSION));
		GUI_main gui = new GUI_main();
		System.out.println("Finished Operations. Terminating.");
	}
}
